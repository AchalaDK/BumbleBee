
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product</title>
  <link rel="stylesheet" href="Styles.css">
  <script type="text/javascript" src="js/index.js"></script>
  <%
    String result = null;
    int id = 500;
    int  customerId = 500;
    if(request.getParameter("id")!=null){
         id = Integer.parseInt(request.getParameter("id"));
    
    
        try {
            services.CustomerWebService_Service service = new services.CustomerWebService_Service();
            services.CustomerWebService port = service.getCustomerWebServicePort();
            result = port.getProductById(id); 
            Gson gson = new  Gson();
            JsonObject currentUser = gson.fromJson((String)session.getAttribute("user"),JsonObject.class);
            customerId = currentUser.get("customerId").getAsInt();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    
    %>
</head>
<body>
  <header>
      <script>let product = <%=result%></script>
		<nav>
			<div class="logo">
				<h1>BumbleBee</h1>
			</div>
			<div class="nav-links">
				<a href="index.jsp">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
				<a href="dashboard.jsp" id='dash-link'>dashboard</a>
			</div>
			<div class="user-profile" id='user-profile'>				
				<a href="login.jsp">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>
	</header>

  <div class="card-detail-container">
    <div class="card-image">
      <img src="http://localhost:8080/BumbelBee-Customer-frontend/PictureGetter?url=C:/BumbelBeeData/items/<%=id%>.jpg" alt="Card Image">
    </div>
    <div class="card-details" >
        <div id='detail-holder'>
      <h2>Card Name</h2>
      <p class="card-price">$99.99</p>
      <p class="card-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan consequat leo, vel pulvinar tortor convallis a. Vestibulum fermentum ligula enim, vel venenatis velit tristique ac.</p>
      <p class="card-installments">12 installments of $8.33</p>
       </div>
        
      <a href="invoice.jsp?id=<%=id%>&customerId=<%=customerId%>"><button class="buy-now-button">Buy Now</button></a>
    </div>
    
  </div>
  
  

      <script>loadCard(<%=result %>)
      setLoginStatus('<%=session.getAttribute("user")%>')</script>
</body>
</html>
