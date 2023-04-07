function parseJson(jsonString){
    return JSON.parse(jsonString);
}

function renderCustomerData(stringValues) {
    let data = parseJson(stringValues)
    
  const container = document.getElementById("customer-table-holder");
  console.log(data)
  
  container.innerHTML = "";
  let table = `<table class="customer-details">
            <thead>
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Limit</th>
                <th>Total debt</th>
                <th>date of birth</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>`

  data.forEach((item) => {
    let cardHtml = `<tr>
                <td>${item.name}</td>
                <td>${item.email}</td>
                <td>${item.maxLoan.toFixed(2)}</td>
                <td>${item.currentLoan.toFixed(2)}</td>
                <td>${item.dob.year}-${item.dob.month}-${item.dob.day}</td>
                <td>
                  <a href=editCustomer.jsp?id=${item.customerId}><button class="btn-edit">Edit</button></a>
                  <a href="customerDetzails.html">                 
                </a>
                </td>
              </tr>`
        console.log(item.customerId)
    table += cardHtml;
  }); 
  table +=  `</tbody></table>`
  container.innerHTML = table
}
function renderProductData(stringValues) {
    let data = parseJson(stringValues)
    
  const container = document.getElementById("produdct-table-holder");
  console.log(data)
  
  container.innerHTML = "";
  let table = `<table class="customer-details">
            <thead>
              <tr>
                <th>Name</th>                
                <th>Total price</th>
                <th>Installments</th>
                <th>Price per installment</th>
                <th>remaining</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>`

  data.forEach((item) => {
    let cardHtml = `<tr>
                <td>${item.name}</td>                
                <td>${item.price.toFixed(2)}</td>
                <td>3</td>
                <td>${(item.price/3).toFixed(2)}</td>
                <td>${item.count}</td>
                <td>
                  <a href='updateProduct.jsp?id=${item.productId}'><button class="btn-edit">Edit</button></a>
                  <a href='deleteProduct.jsp?id=${item.productId}'><button class="btn-delete">DELETE</button></a>
          
                </td>
              </tr>`
    table += cardHtml;
  }); 
  table +=  `</tbody></table>`
  container.innerHTML = table
}
function setLoginStatus(data){
    
    let userCard = document.getElementById("user-profile")
    
    if(data != null){
        let user = parseJson(data);
        userCard.innerHTML = `
            <a href="login.jsp">
            <img src="/images/user.jpg" alt="${user.name}" />
            </a>
        `
    }else{
        userCard.innerHTML = `<a href="login.jsp"> login </a>`
    }
    
}
function loadUpdateFields(data){
    console.log(data)
    let nameInput = document.getElementById("name")
    let priceInput = document.getElementById("priceInput")
    let countInput = document.getElementById("count")
    
    nameInput.value = data.name    
    countInput.value = data.count
    priceInput.value = data.price
}
function loadCustomerUpdateFields(data){    
    console.log(data)
    let nameInput = document.getElementById("customer-name")
    let limitInput = document.getElementById("debt-limit")
    console.log(nameInput == null)
    console.log(limitInput == null)
    
    nameInput.value = data.name    
    limitInput.value = data.maxLoan
    
}
function imageUpload(){
    let form = document.getElementById("image-form")
    form.submit()
}



