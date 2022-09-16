package com.julian.soporte.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class CabecerasRequest
 */
@WebServlet("/cabeceras-request")
public class CabecerasRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CabecerasRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		
		String metodoHttp = request.getMethod();
		String requestUri = request.getRequestURI();
		String requestUrl = request.getRequestURL().toString();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String ip = request.getLocalAddr();
		String port = Integer.toString(request.getLocalPort());
		String scheme = request.getScheme();
		String host = request.getHeader("host");
		
		
		
		try(PrintWriter out = response.getWriter()) {		
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset=\"UTF-8\">");
			out.println("		<title>Cabeceras HTTP Request</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<h1>Cabeceras HTTP Request!</h1>");
			out.println("		<ul>");
			out.println("			<li>Metodo Http: " + metodoHttp + "</li>");
			out.println("			<li>Request URI: " + requestUri + "</li>");
			out.println("			<li>Request URL: " + requestUrl + "</li>");
			out.println("			<li>Context Path: " + contextPath + "</li>");
			out.println("			<li>Servlet Path: " + servletPath + "</li>");
			out.println("			<li>IP: " + ip + "</li>");
			out.println("			<li>Port: " + port + "</li>");
			out.println("			<li>Scheme: " + scheme + "</li>");
			out.println("			<li>Host: " + host + "</li>");
			
			Enumeration<String> headerNames = request.getHeaderNames();
			
			while(headerNames.hasMoreElements()) {
				String nombre = headerNames.nextElement();
				out.println("<li>" + nombre + ": " + request.getHeader(nombre) + "</li>");
			}
			
			out.println("		</ul>");
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
