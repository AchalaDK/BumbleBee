

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String data = null;
    try {
	services.AdminService_Service service = new services.AdminService_Service();
	services.AdminService port = service.getAdminServicePort();
	data = port.getCustomerById(id);	
    } catch (Exception ex) {
	
    }
%>
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
				<h1>BumbleBee</h1>
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
        <li><a href="dashboard.jsp" class="active"><i class="fas fa-users"></i>Customers</a></li>
        <li><a href="products.jsp"><i class="fas fa-boxes"></i>Products</a></li>
      </ul>
    </div>
    <div class="main-content">

        <!-- <div class="main-content__card__header">
          <h3 class="main-content__card__title">Customers</h3>
        </div> -->
        <div class="main-content__card__body">
          <!-- Customer management content goes here -->
          <div class="main-content__card">
            <h2 class="main-content__card__title">Update Customer</h2>
            <form class="main-content__card__form" action='editCustomer.jsp' method='get'>
              <div class="main-content__card__form__group">
                <label for="customer-name">Name:</label>
                <input type="text" id="customer-name" name="customer-name">
              </div>
              <div class="main-content__card__form__group">
                <label for="debt-limit">Debt Limit:</label>
                <input type="number" id="debt-limit" name="debt-limit">
              </div>
                <input type='hidden' name='id' value=<%=id%>>
                        
              
              <div class="main-content__card__form__buttons">
                <button class="main-content__card__form__button main-content__card__form__button--update">Update</button>
                <a href='dashboard.jsp'><button class="main-content__card__form__button main-content__card__form__button--cancel">Cancel</button></a>
              </div>
            </form>
          </div>
        </div>
    </div>
  </div>
  
  </div>
  <script>loadCustomerUpdateFields(<%=data%>)</script>
    <%-- start web service invocation --%><hr/>
    <%
    if(request.getParameter("customer-name")!= null){
    
        
        try {
            services.AdminService_Service service = new services.AdminService_Service();
            services.AdminService port = service.getAdminServicePort();
             // TODO initialize WS operation arguments here
            java.lang.String name = request.getParameter("customer-name");
            java.lang.String fulName = request.getParameter("customer-name");            
            int customerId = id;
            double maxLoan = Double.parseDouble(request.getParameter("debt-limit"));
            port.updateInformation(name, fulName, "", "", customerId, maxLoan);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response); 
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>
