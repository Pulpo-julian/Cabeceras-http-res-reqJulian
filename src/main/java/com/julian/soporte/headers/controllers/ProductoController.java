package com.julian.soporte.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import com.julian.soporte.headers.models.Producto;
import com.julian.soporte.headers.service.ProductoService;
import com.julian.soporte.headers.service.ProductoServiceImpl;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/producto-controller")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductoService productoService = new ProductoServiceImpl();
		List<Producto> listaProductos = productoService.listar();
		
		
		try(PrintWriter out = response.getWriter()) {		
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset=\"UTF-8\">");
			out.println("		<title>Listado deproductos</title>");
			out.println("	</head>");
			out.println("	<body>");
			
			out.println("		<h1>Listado de Productos!!</h1>");
			
			out.println("	</body>");
			out.println("</html>");
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		//doGet(request, response);
	}

}
