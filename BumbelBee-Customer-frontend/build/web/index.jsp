

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
    
    
    
    
    
	<header>
		<nav>
			<div class="logo">
				<h1>BumbleBee</h1>
			</div>
			<div class="nav-links">
				<a href="index.html">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
                                <a href="dashboard.jsp" id="dash-link">Dashboard</a>
			</div>
                    
			<div class="user-profile" id="user-profile">
				<% %>
				
			</div>
		</nav>

	</header>
		<!-- Cards -->
		<div class="products-container" id="products-container">
                    
                        <div class="product-card">
				<div class="card-image-box">
				<div class="product-image">
					<a href="cardDetails.html">
					<img src="/images/kenny-eliason-GJxi6_Oz8n4-unsplash.jpg" alt="Product Image">
				</a>
				</div>
				</div>
				<div class="product-details">
                                    <h3 class="product-name"> here</h3>
					<p class="product-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel placerat nulla. Proin nec sapien urna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque vel ullamcorper mauris.</p>
					<div class="product-price">$29.99</div>
					<button class="product-button">Add to Cart</button>
				</div>
			</div>
                       
			
		</div>
		
		

		<!-- hero section  -->
		
		<section class="features">
			<center>
			<div class="container">
					<div class="feature">
							<i class="fas fa-shipping-fast"></i>
							<h3>Fast Shipping</h3>
							<p>We offer fast and reliable shipping to all our customers.</p>
					</div>
					<div class="feature">
							<i class="fas fa-money-bill-wave"></i>
							<h3>Money-Back Guarantee</h3>
							<p>If you're not satisfied with your purchase, we offer a money-back guarantee.</p>
					</div>
					<div class="feature">
							<i class="fas fa-customer-service"></i>
							<h3>24/7 Customer Support</h3>
							<p>Our customer support team is available 24/7 to help you with any questions or concerns.</p>
					</div>
			</div>
		</center>
	</section>	

	<section class="newsletter">
    <div class="container">
        <h2>Subscribe to our newsletter</h2>
        <form>
            <input type="email" placeholder="Enter your email">
            <button type="submit">Subscribe</button>
        </form>
    </div>
</section>
    <%
    java.lang.String result = null;
    try {        
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	// TODO process result here
	result = port.getAllProductsJson();
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <script>renderCards(parseJson('<%=result%>'))</script>
    
   
    

         <script>setLoginStatus('<%=session.getAttribute("user")%>')</script>
    
   
</body>
</html>

