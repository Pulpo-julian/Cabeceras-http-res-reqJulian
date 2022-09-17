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
@WebServlet({"/producto-controller.xls", "/productos.html"})
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
		
		response.setContentType("text/html; charset=UTF-8");
		
		//obtengo la ruta del servlet al que se hizo peticion
		String servletPath = request.getServletPath();
		
		boolean esXls = servletPath.endsWith(".xls");
		
		if(esXls) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=productosTabla.xls");
		}
		
		
		try(PrintWriter out = response.getWriter()) {		
			
			
			if(!esXls) {	
			
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("	<head>");
				out.println("		<meta charset=\"UTF-8\"/>");
				out.println("		<title>Listado deproductos</title>");
				out.println("	</head>");
				out.println("	<body>");
				
				out.println("		<h1>Listado de Productos!!</h1>");
				
				out.println("		<p><a href=\"" + request.getContextPath().concat("/producto-controller.xls") + "\">Descargar Excel</a></p>");
			
			}
			
			//tabla de productos
			out.println("		<table>");
			
			//con tr creamos una fila table row
			out.println("			<tr>");
			
			//aqui creamos cada columna la cabecera de la tabla th table head
			out.println("				<th>id</th>");
			out.println("				<th>Nombre</th>");
			out.println("				<th>Tipo</th>");
			out.println("				<th>Precio</th>");
			
			out.println("			</tr>");
			
			//recorro cada elemento de la lista productos
			listaProductos.forEach(p -> {
				
				out.println("		</tr>");
				
				//aqui se imprimen los datos de cada producto
				out.println("			<td>" + p.getId() + "</td>");
				out.println("			<td>" + p.getNombre() + "</td>");
				out.println("			<td>" + p.getTipo() + "</td>");
				out.println("			<td>" + p.getPrecio() + "</td>");
				
				out.println("		<tr>");
				
			});
			
			out.println("		</table>");
			
			if(!esXls) {
				
				out.println("	</body>");
				out.println("</html>");
			
			}
			
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
