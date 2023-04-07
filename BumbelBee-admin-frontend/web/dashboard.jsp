
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<% if( session.getAttribute("isLogged")== null){
    session.setAttribute("isLogged", new Boolean(false));
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response); 
    }else{
        if(!(Boolean)session.getAttribute("isLogged")){
           RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
           dispatcher.forward(request, response); 
        }
    }%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
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
				<a href="#">Home</a>
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
        <li><a href="dashboard.html" class="active"><i class="fas fa-users"></i>Customers</a></li>
        <li><a href="products.jsp"><i class="fas fa-boxes"></i>Products</a></li>
      </ul>
    </div>
    <div class="main-content">
      <div class="main-content__card">
        <div class="main-content__card__header">
          <h3 class="main-content__card__title">Customers</h3>
        </div>
        <div class="main-content__card__body">
          <!-- Customer management content goes here -->
          <div id="customer-table-holder">
          <table class="customer-details">
            <thead>
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Limit</th>
                <th>Total debt</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>John Doe</td>
                <td>johndoe@example.com</td>
                <td>55000</td>
                <td>150245</td>
                <td>
                  <button class="btn-edit">Edit</button>
                  <a href="customerDetails.html">
                  <button class="btn-view">View</button>
                </a>
                </td>
              </tr>
              <tr>
                <td>Jane Smith</td>
                <td>janesmith@example.com</td>
                <td>55000</td>
                <td>150245</td>
                <td>
                  <button class="btn-edit">Edit</button>
                  <button class="btn-view">View</button>
                </td>
              </tr>
              <tr>
                <td>Bob Johnson</td>
                <td>bjohnson@example.com</td>
                <td>55000</td>
                <td>150245</td>
                <td>
                  <button class="btn-edit">Edit</button>
                  <button class="btn-view">View</button>
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
	
	java.lang.String result = port.getAllCustomers();
	%>
        
        <script>
            renderCustomerData('<%=result%>')
        </script>
    <%
    } catch (Exception ex) {
	
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>
