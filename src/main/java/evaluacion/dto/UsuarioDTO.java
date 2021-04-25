package evaluacion.dto;

public class UsuarioDTO {
	private String rut;
	private String username;
	private String password;
	
	public UsuarioDTO() {
		super();
	}
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
