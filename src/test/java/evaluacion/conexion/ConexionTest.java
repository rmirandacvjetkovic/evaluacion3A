package evaluacion.conexion;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConexionTest {

	public ConexionTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public static void setUpClass() {
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDOwn() {
		
	}
	
	@Test
	public void conectar() {
		System.out.println("Test Conexion");
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		try {
			cn = conexion.conectar();
			assertNotNull("Conexión Fallida", cn);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
			
	}

}
