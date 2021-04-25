package evaluacion.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import evaluacion.dao.PersonaDAO;
import evaluacion.dto.PersonaDTO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("username");
        String password = request.getParameter("password");
        
        PersonaDAO personaDAO = new PersonaDAO();
        PersonaDTO persona = null;
        
        try {
			 persona = personaDAO.findPersonaByUsernameAndPassword(user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if(persona != null) {
        	response.getWriter().append("<html>    \r\n" + 
        			"<head>\r\n" + 
        			"	<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6' crossorigin='anonymous'>\r\n" + 
        			"</head>\r\n" + 
        			"<body>  \r\n" + 
        			"	<div class='container'>\r\n" + 
        			"		<div class='row row justify-content-md-center mt-3'>\r\n" + 
        			"			<div class='col-lg-6'>\r\n" + 
        			"				<div class='card'>\r\n" +
        			"				<div class='card-body'>\r\n" +
        			"				<h2><strong>Información usuario</strong></h2>  \r\n" + 
        			"				<dl>   <dt>RUT</dt>  \r\n" + 
        			"					<dd>"+persona.getRut()+"</dd>   </dl>  \r\n" + 
        			"				<dl>   <dt>Nombre</dt>  \r\n" + 
        			"					<dd>"+persona.getNombre()+"</dd>   </dl>  \r\n" + 
        			"				<dl>   <dt>Apellido</dt>  \r\n" + 
        			"					<dd>"+persona.getApellido()+"</dd>   </dl>  \r\n" + 
        			"				<dl>   <dt>Teléfono</dt>  \r\n" + 
        			"					<dd>"+persona.getTelefono()+"</dd>   </dl>    \r\n" + 
        			"				<dl>   <dt>Fecha ingreso</dt>  \r\n" + 
        			"					<dd>"+persona.getFechaIngreso()+"</dd>   </dl>  \r\n" + 
        			"				<a href='./index.jsp'>Volver</a>  \r\n" + 
        			"				</div>\r\n" +
        			"				</div>\r\n" +
        			"			</div>\r\n" + 
        			"		</div>\r\n" + 
        			"	</div>\r\n" + 
        			"   \r\n" + 
        			"</body>    \r\n" + 
        			"\r\n" + 
        			"</html>");
        } else {
        	response.sendRedirect("./error.jsp");
        }
	}

}
