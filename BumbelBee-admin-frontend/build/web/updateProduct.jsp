<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="Styles.css">
   <script type="text/javascript" src="js/index.js"></script>
</head>
    <%
    int id =  Integer.parseInt(request.getParameter("id"));
    String data = null;
    try {
	services.AdminService_Service service = new services.AdminService_Service();
	services.AdminService port = service.getAdminServicePort();
	data = port.getProductById(id);	
    } catch (Exception ex) {
	
    }
    %>
<body>
  <header>
		<nav>
			<div class="logo">
				<h1>BumbleBee Admin</h1>
			</div>
			<div class="nav-links">
				<a href="#">Home</a>
				<a href="#">Shop</a>
				<a href="#">About</a>
				<a href="#">Contact</a>
			</div>
			<div class="user-profile">
				
				<a href="#">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>
	</header>

  <!-- Admin Dashboard -->
  <div class="dashboard">
    <div class="sidebar">
     
      <h2>Menu</h2>
      <hr>
      <ul>
        <li><a href="dashboard.jsp" ><i class="fas fa-users"></i>Customers</a></li>
        <li><a href="products.jsp" class="active"><i class="fas fa-boxes"></i>Products</a></li>
      </ul>
    </div>
    <div class="main-content">

        <!-- <div class="main-content__card__header">
          <h3 class="main-content__card__title">Customers</h3>
        </div> -->
        <div class="main-content__card__body">
          <!-- product management content goes here -->
          <div class="main-content__card">
            <div class="main-content__card__title">
              Update Product
            </div>
              <form class="main-content__form" action="updateProduct.jsp" method="post">
              <div class="main-content__form-group">
                <label for="name">Product Name</label>
                <input type="text" id="name" name="name" placeholder="Product Name" required>
              </div>
              <div class="main-content__form-group">
                <label for="price">Price</label>
                <input type="number" id="priceInput" name="price" placeholder="Price" required>
              </div>
              <div class="main-content__form-group">
                <label for="installment-price">Count</label>
                <input type="number" id="count" name="count" placeholder="Product count" required>
              </div>
              <div class="main-content__form-group">
                <label for="image">Product Image</label>
                <div class="main-content__form-image">
                  <img src="/images/dhiva-krishna-YApS6TjKJ9c-unsplash.jpg" alt="Product Image">
                  <input type="file" id="image" name="image" accept="image/*">
                </div>
              </div>
              <div class="main-content__card__form__buttons">
                <button class="main-content__card__form__button main-content__card__form__button--update">Update</button>
                <button class="main-content__card__form__button main-content__card__form__button--cancel">Cancel</button>
              </div>
                  <input type="hidden" value='<%=id %>' name="id" >
            </form>
          </div>
          
        </div>

    </div>
  </div>
  </div>
    
    <%-- start web service invocation --%>
    <%
    if(request.getParameter("name")!= null){
        try {
            %><script>alert("sadfads")</script><%
            services.AdminService_Service service = new services.AdminService_Service();
            services.AdminService port = service.getAdminServicePort();
             // TODO initialize WS operation arguments here
            java.lang.String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int count = Integer.parseInt(request.getParameter("count"));
            port.updateProduct(id, name, price, count);
            RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
           dispatcher.forward(request, response); 
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    
    %>
    <script>loadUpdateFields(<%=data %>)</script>
</body>
</html>
