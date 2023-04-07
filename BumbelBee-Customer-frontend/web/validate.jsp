<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>BumbleBee</title>
	<link rel="stylesheet" href="Styles.css">
</head>
<body>
	<header>
		<nav>
			<div class="logo">
				<h1>BumbleBee</h1>
			</div>
			<div class="nav-links">
				<a href="index.jsp">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
				<a href="dashboard.jsp">Dashboard</a>
			</div>
			<div class="user-profile">
				
				<a href="login.html">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>

	</header>
    

  <div class="container">
      <%
    try {
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	 // TODO initialize WS operation arguments here
         Gson gson = new  Gson();
        JsonObject currentUser = gson.fromJson((String)session.getAttribute("user"),JsonObject.class);
        int customerId = currentUser.get("customerId").getAsInt();
	 
	double total = Double.parseDouble(request.getParameter("total"));
	int result = port.checkEligibility(customerId, total);
        if(result == 0){
        %><div class="box green">
      <p class="alert">Alert Message</p>
      <h2>Congratulations</h2>
      <p>You can order you whole cart  for credit</p>
    </div><%
        }else if(result == 1){
        %><div class="box green">
      <p class="alert">Alert Message</p>
      <h2>Credit range not enough</h2>
      <p>Please  reduce some   items from your car and try, or contact admin</p>
    </div><%
        }else if(result == 2){
        %><div class="box blue">
      <p class="alert">Alert Message</p>
      <h2>Age is not valid</h2>
      <p>Your age  is not matching with the requirements</p>
    </div>
  </div><%
        }
    } catch (Exception ex) {
	
    }
%>
    </div>
  
     
<section class="newsletter">
    <div class="container">
        <h2>Subscribe to our newsletter</h2>
        <form>
            <input type="email" placeholder="Enter your email">
            <button type="submit">Subscribe</button>
        </form>
    </div>
</section>



	
    <%-- start web service invocation --%><hr/>
    
    <%-- end web service invocation --%><hr/>
</body>
</html>

