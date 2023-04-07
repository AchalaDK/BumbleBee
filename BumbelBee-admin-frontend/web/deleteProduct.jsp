<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
        
	services.AdminService_Service service = new services.AdminService_Service();
	services.AdminService port = service.getAdminServicePort();
	 // TODO initialize WS operation arguments here
	int productId = Integer.parseInt(request.getParameter("id"));
	boolean b = port.deleteProductById(productId);
        
        if(!b){
            %><script>alert("The  product cannot be deleted there are ongoing loans")</script><%
                RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp?failedDelete=true");
           dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
           dispatcher.forward(request, response);
         
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
