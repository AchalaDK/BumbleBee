

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
				
				<a href="login.jsp">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>

	</header>

  <div class="containers">
    <div class="invoice">
      <h2 class="invoice__title">Invoice</h2>
      <div class="invoice__details">
        <p><strong>Customer:</strong> John Doe</p>
        <p><strong>Product:</strong> iPhone 13 Pro Max</p>
        <p><strong>Price:</strong> $1,099</p>
        <p><strong>Payment Method:</strong> Credit Card</p>
      </div>
      <hr>
      <p class="invoice__total"><strong>Total:</strong> $1,099</p>
      <button class="invoice__button">Download PDF</button>
    </div>
    <div class="thank-you">
      <h2 class="thank-you__title">Thank You!</h2>
      <p class="thank-you__message">Your order has been successfully processed.</p>
      <a href="index.jsp" ><button class="thank-you__button">Continue Shopping</button></a>
    </div>
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
    <%
    try {
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	 // TODO initialize WS operation arguments here
	int productId = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("customerId"));
	// TODO process result here
	boolean result = port.placeLoan(userId, productId);
	if(!result){
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

