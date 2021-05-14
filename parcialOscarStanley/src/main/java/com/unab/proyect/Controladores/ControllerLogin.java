package com.unab.proyect.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unab.proyect.DAO.clsLoguin;
import com.unab.proyect.Entidades.*;

/**
 * Servlet implementation class ControllerLogin
 */
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		Usuario log = new Usuario();

		log.setNombre(user);
		log.setPass(pass);

	clsLoguin cls = new clsLoguin();

	boolean resultado = cls.Login(log);

	if (resultado == true) {
		int id = cls.id;
		session.setAttribute("usuario", id);
		
			response.sendRedirect("Consulta.jsp");
	
	} else {
		response.sendRedirect("Index.jsp");

	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
