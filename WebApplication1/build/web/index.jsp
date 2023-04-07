<%-- 
    Document   : index
    Created on : Apr 5, 2023, 12:50:17 PM
    Author     : Dilshan GAM
--%>

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
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	// TODO process result here
	java.lang.String result = port.getAllProductsJson();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
