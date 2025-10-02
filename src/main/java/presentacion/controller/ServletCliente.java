package presentacion.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Usuario;

import javax.servlet.RequestDispatcher;

import negocioimpl.ClienteNegImpl;
import negocioimpl.UsuarioNegImpl;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnLogin")!=null)
		{
			UsuarioNegImpl un = new UsuarioNegImpl();
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			boolean ingreso = un.login(username, password);
			if (ingreso == true)
			{
				request.getSession().setAttribute("usuario", username);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/NuevoCliente.jsp");
				dispatcher.forward(request, response);
			} else
			{
				request.setAttribute("ingreso", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
