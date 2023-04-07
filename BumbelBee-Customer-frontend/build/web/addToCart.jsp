
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
    if(session.getAttribute("user")!=null){
        try {
            services.CustomerWebService_Service service = new services.CustomerWebService_Service();
            services.CustomerWebService port = service.getCustomerWebServicePort();
            Gson gson = new  Gson();
            JsonObject currentUser = gson.fromJson((String)session.getAttribute("user"),JsonObject.class);
         
            int customerId = currentUser.get("customerId").getAsInt();;
            int productId = Integer.parseInt(request.getParameter("pid"));  
            int qty = Integer.parseInt(request.getParameter("qty"));
            port.addCartItem(customerId, productId, qty);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
	// TODO handle custom exceptions here
        }
    }else{
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
    
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
