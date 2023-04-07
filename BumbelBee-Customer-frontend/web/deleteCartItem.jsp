
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
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
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	 // TODO initialize WS operation arguments here
         Gson gson = new  Gson();
        JsonObject currentUser = gson.fromJson((String)session.getAttribute("user"),JsonObject.class);
        int customerId = currentUser.get("customerId").getAsInt();
	 
	int productId = Integer.parseInt(request.getParameter("pid"));
	port.deleteCartItem(customerId, productId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
