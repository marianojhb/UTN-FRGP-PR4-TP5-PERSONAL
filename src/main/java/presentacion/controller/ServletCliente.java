package presentacion.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Usuario;

import javax.servlet.RequestDispatcher;

import negocio.ClienteNeg;
import negocio.UsuarioNeg;
import negocioimpl.ClienteNegImpl;
import negocioimpl.UsuarioNegImpl;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if( request.getParameter("Param").matches("logout") )
		{
			request.getSession().removeAttribute("username");
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		else if ( request.getParameter("Param").matches("nuevocliente") )
		{
			RequestDispatcher rd = request.getRequestDispatcher("/NuevoCliente.jsp");
			rd.forward(request, response);
		}
		else if ( request.getParameter("Param").matches("listadoclientes") )
		{
			ClienteNeg cn = new ClienteNegImpl();
			List<Cliente> clientes = cn.obtenerTodos();
			request.setAttribute("clientes", clientes);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientes.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnLogin")!=null)
		{
			UsuarioNeg un = new UsuarioNegImpl();
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			boolean ingreso = un.login(username, password);
			if (ingreso == true)
			{
				request.getSession().setAttribute("username", username);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/NuevoCliente.jsp");
				dispatcher.forward(request, response);
			} else
			{
				request.setAttribute("ingreso", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if ( request.getParameter("submitNuevoCliente") != null )
		{
			int filas = -1;
			ClienteNeg cn = new ClienteNegImpl();
			Cliente cliente = new Cliente();
			cliente.setDni(request.getParameter("txtDni"));
			cliente.setCuil(request.getParameter("txtCuil"));
			cliente.setNombre(request.getParameter("txtNombre"));
			cliente.setApellido(request.getParameter("txtApellido"));
			cliente.setSexo(request.getParameter("cbSexo"));
			cliente.setFecha_nacimiento(request.getParameter("txtFecha_nacimiento"));
			cliente.setDireccion(request.getParameter("txtDireccion"));
			cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
			cliente.setLocalidad(request.getParameter("txtLocalidad"));
			cliente.setProvincia(request.getParameter("txtProvincia"));
			cliente.setCorreo_electronico(request.getParameter("txtCorreo_electronico"));
			cliente.setTelefono(request.getParameter("txtTelefono"));
			filas = cn.agregarUno(cliente);

			request.setAttribute("resultadoNuevoCliente", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/NuevoCliente.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
