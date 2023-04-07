

<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="jdk.nashorn.api.scripting.JSObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Profile</title>
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
				<a href="#" id="dash-link">Dashboard</a>
			</div>
			<div class="user-profile" id="user-profile">
				
				<a href="#">
					<img src="/images/user.jpg" alt="User Profile" />
				</a>
			</div>
		</nav>
	</header>

  <!-- User Dashboard -->
  <div class="dashboard">
    <div class="sidebar">
     
      <h2>Menu</h2>
      <hr>
      <ul>
        <li><a href="loans.html" class="active"><i class="fas fa-users"></i>Loans</a></li>
        <li><a href="logout.jsp" ><i class="fas fa-boxes"></i>Log Out</a></li>
      </ul>
    </div>
    <div class="main-content">

          <!-- Account management content goes here -->
          <div class="main-content__card">
            <div class="main-content__card__title">
              Your Loans
            </div>
              <div id="loan-table-holder">
            <table class="customer-details">
              <thead>
                <tr>
                  <th>Loan No.</th>
                  <th>Date</th>
                  <th>Toal due payment</th>
                  <th>Paid amount</th>
                  <th>Total installment</th>
                  <th>Paid installment</th>
                  <th>Actions</th>

                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>00115544</td>
                  <td>04.05.2023</td>
                  <td>2500</td>
                  <td>32000</td>
                  <td>12</td>
                  <td>6</td>
                  <td>
                    <button class="btn-edit">Pay</button>
                  </td>
                </tr>
                <tr>
                  <td>00115544</td>
                  <td>04.05.2023</td>
                  <td>2500</td>
                  <td>32000</td>
                  <td>12</td>
                  <td>6</td>
                  <td>
                    <button class="btn-edit">Pay</button>
                  </td>
                </tr>
                <tr>
                  <td>00115544</td>
                  <td>04.05.2023</td>
                  <td>2500</td>
                  <td>32000</td>
                  <td>12</td>
                  <td>6</td>
                  <td>
                    <button class="btn-edit">Pay</button>
                  </td>
                </tr>
              </tbody>
            </table>
            </div>
          </div>
    </div>
  </div>
  </div> 
  <script>setLoginStatus('<%=session.getAttribute("user")%>')</script>
    
    <%-- start web service invocation --%><hr/>
    <%
    try {
	services.CustomerWebService_Service service = new services.CustomerWebService_Service();
	services.CustomerWebService port = service.getCustomerWebServicePort();
	// TODO process result here
        Gson gson = new  Gson();
        JsonObject currentUser = gson.fromJson((String)session.getAttribute("user"),JsonObject.class);
        int id = currentUser.get("customerId").getAsInt();
	java.lang.String result = port.getAllLoans(id);
	%>
        <script>
            renderLoanData('<%=result%>')</script>
    <%
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
</html>