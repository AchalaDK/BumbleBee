
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<% if( session.getAttribute("isLogged")== null){
    session.setAttribute("isLogged", new Boolean(false));
    }else{
        if((Boolean)session.getAttribute("isLogged")){
           RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
           dispatcher.forward(request, response); 
        }
    }%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="Styles.css">
  <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
  <header>
		<nav>
			<div class="logo">
				<h1>BumbleBee Admin</h1>
			</div>
                    
			<div class="nav-links">
				<a href="index.html">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
				<a href="#">Contact</a>
			</div>
                    
		</nav>
	</header>

  <div class="login-container">
    <h2>Login to Your Account</h2>
    <form action="index.jsp" method="post">
      <label for="username">Username</label>
      <input type="text" id="email" name="username" placeholder="Enter your email address">
  
      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password">
  
      <button type="submit" class="login-button">Login</button>
    </form>    
  </div>
  
    

    <%-- start web service invocation --%><hr/>
    <%    
    try {
	services.AdminService_Service service = new services.AdminService_Service();
	services.AdminService port = service.getAdminServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String username = request.getParameter("username");
	java.lang.String password = request.getParameter("password");
	boolean user = port.loginAdmin(username, password);
	session.setAttribute("isLogged", new Boolean(user));
        if(user){
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>