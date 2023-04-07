
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>

  <link rel="stylesheet" href="Styles.css">

</head>
<body>
  <header>
		<nav>
			<div class="logo">
				<h1>BumbleBee</h1>
			</div>
			<div class="nav-links">
				<a href="index.html">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
				<a href="#">Contact</a>
			</div>
			<div class="user-profile">
				
				<a href="login.html">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>
	</header>

  <div class="register-container">
    <h2>Create Your Account</h2>
    <form action="register.jsp" method="post">
      <label for="fullname">Full Name</label>
      <input type="text" id="fullname" name="fullname" placeholder="Enter your full name">
  
      <label for="email">Email Address</label>
      <input type="email" id="email" name="email" placeholder="Enter your email address">

      <label for="dateofbirth">Date Of Birth</label>
      <input type="date" id="dateofbirth" name="dateofbirth" placeholder="Enter your birthday">
  
      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password">
  
      <label for="confirmpassword">Confirm Password</label>
      <input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm your password">
  
      <button type="submit" class="register-button">Register</button>
    </form>
    <div class="login-link">
      Already have an account? <a href="login.html">Login now</a>
    </div>
  </div>
  
    <%-- start web service invocation --%><hr/>
    <%
    try {
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String email = request.getParameter("email");
	java.lang.String name = request.getParameter("name");
	java.lang.String fulName = request.getParameter("fullname");
	java.lang.String dob = request.getParameter("dateofbirth");
	java.lang.String password = request.getParameter("password");
        java.lang.String repassword = request.getParameter("confirmpassword");
        if(!(repassword.equals(password))){
           %><script>alert('please check the given passwords<%=fulName%>')</script><%
        }else{
        
            java.lang.String user = port.registerCustomer(email, fulName, dob, password);
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        

        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>
