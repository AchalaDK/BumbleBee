
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="Styles.css">
</head>
<body>
  <header>
      <%
    try {
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	 
	java.lang.String email = request.getParameter("email");
	java.lang.String password = request.getParameter("password");
	
	boolean result = port.loginCustomer(email, password);
        if(result){
            String user = port.getLoggedPerson();
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else{
            
        }
    } catch (Exception ex) {
	
    }
    %>
		<nav>
			<div class="logo">
				<h1>BumbleBee</h1>
			</div>
			<div class="nav-links">
				<a href="index.jsp">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
				
			</div>
			<div class="user-profile">
				
				<a href="user.html">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>
	</header>

  <div class="login-container">
    <h2>Login to Your Account</h2>
    <form action="login.jsp" method="post">
      <label for="email">Email Address</label>
      <input type="email" id="email" name="email" placeholder="Enter your email address">
  
      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password">
  
      <button type="submit" class="login-button">Login</button>
    </form>
    <div class="signup-link">
      Don't have an account? <a href="register.jsp">Sign up now</a>
    </div>
  </div>
  
    

    
</body>
</html>