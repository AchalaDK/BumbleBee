
function parseJson(jsonString){
    return JSON.parse(jsonString);
}
function renderCards(data) {
  const container = document.getElementById("products-container");
  console.log(data)
  container.innerHTML = "";

  // Loop through the data array and render each item as a card
  data.forEach((item) => {
    let cardHtml = `<div class="product-card">
				<div class="card-image-box">
				<div class="product-image">
					<a href="cardDetail.jsp?id=${item.productId}">
					<img src='http://localhost:8080/BumbelBee-Customer-frontend/PictureGetter?url=C:/BumbelBeeData/items/${item.productId}.jpg' alt="Product Image">
				</a>
				</div>
				</div>
				<div class="product-details">
                                    <h3 class="product-name"> ${item.name}</h3>
					
					<div class="product-price">${item.price.toFixed(2)}</div>
					<a href='addToCart.jsp?pid=${item.productId}&qty=1'><button class="product-button">Add to Cart</button></a>
				</div>
			</div>"`
    container.innerHTML += cardHtml;
  }); 
}
function setLoginStatus(data){
    
    let userCard = document.getElementById("user-profile")
    let dashLink = document.getElementById("dash-link")
    
    if(data != 'null'){
        let user = parseJson(data);
        userCard.innerHTML = `
            <a href="login.jsp">
            <img src="/images/user.jpg" alt="${user.name}" />
            </a>`
    }else{
        
        userCard.innerHTML = `<a href="login.jsp">login</a>`
        
        dashLink.style.display = "none"
    }
    
}
function loadCard(data){
    let container = document.getElementById("detail-holder")
    
    let content = `<h2>${data.name}</h2>
      <p class="card-price">${data.price.toFixed(2)}</p>      
      <p class="card-installments">3 installments of ${(data.price/3).toFixed(2)}</p>`;
    container.innerHTML = content;
}
function renderLoanData(stringValues) {
   
    let data = parseJson(stringValues)
    
  const container = document.getElementById("loan-table-holder");
  
  
  container.innerHTML = "";
  let table = `<table class="customer-details">
              <thead>
                <tr>
                  <th>Loan No.</th>
                  <th>Date</th>
                  <th>Toal payment</th>                  
                  <th>Total installments</th>   
             </tr>
              </thead>
              <tbody>`

  data.forEach((item) => {
    let cardHtml = `<tr>
                  <td>${item.loanId}</td>
                  <td>${item.date.year}-${item.date.month}-${item.date.day}</td>
                  <td>${item.amount.toFixed(2)}</td>                  
                  <td>3</td>                    
                </tr>`
        console.log(item.customerId)
    table += cardHtml;
  }); 
  table +=  `</tbody></table>`
  container.innerHTML = table
}
function loadCart(data){
    let total = 0
    console.log(data)
    let container = document.getElementById("cart-container");
    let cart = data;
    let content = `<table>
      <thead>
        <tr>
          <th>Item name</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>Total</th>
          <th>Remove</th>
        </tr>
      </thead>
      <tbody>`;
    cart.forEach((item)=>{
        total += ((item.product.price) * (item.qty))
        let link = `href='addToCart.jsp?pid=${item.product.productId}&qty=-1'`
        if(item.qty == 0){
            link = ""
        }
        let tableRow = `<tr>
          <td class="cart-item-name">${item.product.name}</td>
          <td class="cart-item-price">${item.product.price.toFixed(2)}
</td>
          <td>
            <div class="quantity-selector">
              <a ${link}><button class="minus-button">-</button></a>
              <span>${item.qty}</span>
              <a href='addToCart.jsp?pid=${item.product.productId}&qty=1'><button class="plus-button">+</button></a>
            </div>
          </td>
          <td class="cart-item-total">${(item.product.price) * (item.qty)}</td>
          <td><a href='deleteCartItem.jsp?pid=${item.product.productId}'><button class="remove-button">Remove</i></button></a></td>
        </tr>`
        content +=tableRow
        
    });
    content += "</tbody></table>"
    container.innerHTML = content
    document.getElementById("total-card").innerHTML = "Total : "+total.toFixed(2)
    document.getElementById("total").value = total;
}