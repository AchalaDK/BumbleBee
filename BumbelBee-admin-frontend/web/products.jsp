<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<% if( session.getAttribute("isLogged")== null){
    session.setAttribute("isLogged", new Boolean(false));
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response); 
    }else{
        if(!(Boolean)session.getAttribute("isLogged")){
           RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
           dispatcher.forward(request, response); 
        }
    }
    if(request.getParameter("failedDelete")!=null){
        
    %><script>alert("Deletion failed. There are ongoing loans for the product")</script><%
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Products</title>
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
				<a href="#">Contact</a>
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
      <div class="main-content__card">
        <div class="main-content__card__header">
          <h3 class="main-content__card__title">Products</h3>
        </div>
        <!-- add a product button -->
        <div class="main-content__card__body">
            <a href="addProduct.jsp">
          <button class="add-product-btn">Add a product</button>
          </a>
        </div>
        <div class="main-content__card__body">
          <!-- Customer management content goes here -->
          <div id="produdct-table-holder">
          <table class="customer-details">
            <thead>
              <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Total price</th>
                <th>Installments</th>
                <th>Price per installment</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Computer</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam necessitatibus, pariatur eaque nihil quae, </td>
                <td>25125</td>
                <td>12</td>
                <td>5250</td>
                <td>
                  <button class="btn-edit">Edit</button>
                  <button class="btn-delete">DELETE</button>
          
                </td>
              </tr>
              <tr>
                <td>Computer</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam necessitatibus, pariatur eaque nihil quae, </td>
                <td>25125</td>
                <td>12</td>
                <td>5250</td>
                <td>
                  <button class="btn-edit">Edit</button>
                  <button class="btn-delete">DELETE</button>
                </td>
              </tr>
              <tr>
                <td>Computer</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam necessitatibus, pariatur eaque nihil quae, </td>
                <td>25125</td>
                <td>12</td>
                <td>5250</td>
                <td>
                  <button class="btn-edit">Edit</button>
                  <button class="btn-delete">DELETE</button>
                </td>
              </tr>
            </tbody>
          </table>
          </div>
        </div>
      </div>
    </div>
  </div>
  


  </div>
  <%-- start web service invocation --%><hr/>
    <%
    try {
    
	services.AdminService_Service service = new services.AdminService_Service();
	services.AdminService port = service.getAdminServicePort();
	// TODO process result here
	java.lang.String result = port.getAllProductsJson();
	%>
        <script>
            renderProductData('<%=result%>')            
        </script>
        
    <%
    } catch (Exception ex) {
	
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>
