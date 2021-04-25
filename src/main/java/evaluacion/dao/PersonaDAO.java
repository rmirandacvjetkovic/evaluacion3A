package evaluacion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import evaluacion.conexion.Conexion;
import evaluacion.dto.PersonaDTO;

public class PersonaDAO {
	
	public static final String SQL = 
			
			"select \r\n" + 
			"	u.*,\r\n" + 
			"    p.*\r\n" + 
			"from\r\n" + 
			"	usuario u\r\n" + 
			"left join \r\n" + 
			"	persona p \r\n" + 
			"on\r\n" + 
			"	u.rut = p.rut\r\n" + 
			"where \r\n" + 
			"	username = ? and password = ?";
	
	public PersonaDTO findPersonaByUsernameAndPassword(String username, String password) throws Exception {
		Conexion cn = new Conexion();
		PersonaDTO persona = null;
		
		
		
		try {
			PreparedStatement ps = cn.conectar().prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				persona = new PersonaDTO();
				persona.setRut(rs.getNString("rut"));
				persona.setNombre(rs.getNString("nombre"));
				persona.setApellido(rs.getNString("apellido"));
				persona.setTelefono(rs.getNString("telefono"));
				persona.setFechaIngreso(rs.getDate("fecha_ingreso"));
			}
		} catch(Exception e) {
			throw e;
		}
		
		return persona;
	}
	
	public static void main(String args[]) throws Exception {
		PersonaDAO personaDAO = new PersonaDAO();
		PersonaDTO persona = personaDAO.findPersonaByUsernameAndPassword("pepe", "1234");
		System.out.println("Nombre: " + persona.getNombre() + "\r\nRUT: " + persona.getRut() + "\r\nFecha:" + persona.getFechaIngreso());
	}
}
