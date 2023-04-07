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
        <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
    <%
        if(session.getAttribute("user")==null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    
    %>
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

  <div class="cart-container" id="cart-container">
    <table>
      <thead>
        <tr>
          <th>Item name</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>Total</th>
          <th>Remove</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td class="cart-item-name">Product A</td>
          <td class="cart-item-price">$50</td>
          <td>
            <div class="quantity-selector">
              <button class="minus-button">-</button>
              <input type="number" min="1" value="1">
              <button class="plus-button">+</button>
            </div>
          </td>
          <td class="cart-item-total">$50</td>
          <td><button class="remove-button">Remove</i></button></td>
        </tr>
        <tr>
          <td class="cart-item-name">Product B</td>
          <td class="cart-item-price">$25</td>
          <td>
            <div class="quantity-selector">
              <button class="minus-button">-</button>
              <input type="number" min="1" value="1">
              <button class="plus-button">+</button>
            </div>
          </td>
          <td class="cart-item-total">$25</td>
          <td><button class="remove-button">Remove</button></td>
        </tr>
      </tbody>
    </table>
      </div>
    <div class="cart-actions">
        <span id="total-card" style="margin-left: auto; font-size: 40px"></span>
    </div>
        <center>
        <form action="validate.jsp" method="get">
            <input type="hidden"  id="total" name="total" value="0"><button style="margin-left: auto;background-color: green">Check Eligibility</button></form>
        </center>
  

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
    <%
    try {
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	 // TODO initialize WS operation arguments here
        Gson gson = new  Gson();
        JsonObject currentUser = gson.fromJson((String)session.getAttribute("user"),JsonObject.class);
        int customerId = currentUser.get("customerId").getAsInt();	
	// TODO process result here
	java.lang.String result = port.getcart(customerId);
    %><script>loadCart(<%=result%>)</script><%
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>

