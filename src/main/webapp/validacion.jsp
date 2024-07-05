
<%
	if ( session.getAttribute("Objusuario") == null){
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
%>

