
package services;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerWebService", targetNamespace = "http://Services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerWebService {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLoggedPerson", targetNamespace = "http://Services/", className = "services.GetLoggedPerson")
    @ResponseWrapper(localName = "getLoggedPersonResponse", targetNamespace = "http://Services/", className = "services.GetLoggedPersonResponse")
    @Action(input = "http://Services/CustomerWebService/getLoggedPersonRequest", output = "http://Services/CustomerWebService/getLoggedPersonResponse")
    public String getLoggedPerson();

    /**
     * 
     * @param customerId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getcart", targetNamespace = "http://Services/", className = "services.Getcart")
    @ResponseWrapper(localName = "getcartResponse", targetNamespace = "http://Services/", className = "services.GetcartResponse")
    @Action(input = "http://Services/CustomerWebService/getcartRequest", output = "http://Services/CustomerWebService/getcartResponse")
    public String getcart(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId);

    /**
     * 
     * @param productId
     * @param customerId
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "deleteCartItem", targetNamespace = "http://Services/", className = "services.DeleteCartItem")
    @Action(input = "http://Services/CustomerWebService/deleteCartItem")
    public void deleteCartItem(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId,
        @WebParam(name = "productId", targetNamespace = "")
        int productId);

    /**
     * 
     * @param fulName
     * @param password
     * @param dob
     * @param name
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "updateInformation", targetNamespace = "http://Services/", className = "services.UpdateInformation")
    @Action(input = "http://Services/CustomerWebService/updateInformation")
    public void updateInformation(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "fulName", targetNamespace = "")
        String fulName,
        @WebParam(name = "dob", targetNamespace = "")
        String dob,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @return
     *     returns java.util.List<services.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProducts", targetNamespace = "http://Services/", className = "services.GetAllProducts")
    @ResponseWrapper(localName = "getAllProductsResponse", targetNamespace = "http://Services/", className = "services.GetAllProductsResponse")
    @Action(input = "http://Services/CustomerWebService/getAllProductsRequest", output = "http://Services/CustomerWebService/getAllProductsResponse")
    public List<Product> getAllProducts();

    /**
     * 
     * @param productId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductById", targetNamespace = "http://Services/", className = "services.GetProductById")
    @ResponseWrapper(localName = "getProductByIdResponse", targetNamespace = "http://Services/", className = "services.GetProductByIdResponse")
    @Action(input = "http://Services/CustomerWebService/getProductByIdRequest", output = "http://Services/CustomerWebService/getProductByIdResponse")
    public String getProductById(
        @WebParam(name = "productId", targetNamespace = "")
        int productId);

    /**
     * 
     * @param customerId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllLoans", targetNamespace = "http://Services/", className = "services.GetAllLoans")
    @ResponseWrapper(localName = "getAllLoansResponse", targetNamespace = "http://Services/", className = "services.GetAllLoansResponse")
    @Action(input = "http://Services/CustomerWebService/getAllLoansRequest", output = "http://Services/CustomerWebService/getAllLoansResponse")
    public String getAllLoans(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUnpaidLoans", targetNamespace = "http://Services/", className = "services.GetUnpaidLoans")
    @ResponseWrapper(localName = "getUnpaidLoansResponse", targetNamespace = "http://Services/", className = "services.GetUnpaidLoansResponse")
    @Action(input = "http://Services/CustomerWebService/getUnpaidLoansRequest", output = "http://Services/CustomerWebService/getUnpaidLoansResponse")
    public String getUnpaidLoans();

    /**
     * 
     * @param productId
     * @param cuustomerId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "placeLoan", targetNamespace = "http://Services/", className = "services.PlaceLoan")
    @ResponseWrapper(localName = "placeLoanResponse", targetNamespace = "http://Services/", className = "services.PlaceLoanResponse")
    @Action(input = "http://Services/CustomerWebService/placeLoanRequest", output = "http://Services/CustomerWebService/placeLoanResponse")
    public boolean placeLoan(
        @WebParam(name = "cuustomerId", targetNamespace = "")
        int cuustomerId,
        @WebParam(name = "productId", targetNamespace = "")
        int productId);

    /**
     * 
     * @param loanId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPaidInstallments", targetNamespace = "http://Services/", className = "services.GetPaidInstallments")
    @ResponseWrapper(localName = "getPaidInstallmentsResponse", targetNamespace = "http://Services/", className = "services.GetPaidInstallmentsResponse")
    @Action(input = "http://Services/CustomerWebService/getPaidInstallmentsRequest", output = "http://Services/CustomerWebService/getPaidInstallmentsResponse")
    public int getPaidInstallments(
        @WebParam(name = "loanId", targetNamespace = "")
        int loanId);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProductsJson", targetNamespace = "http://Services/", className = "services.GetAllProductsJson")
    @ResponseWrapper(localName = "getAllProductsJsonResponse", targetNamespace = "http://Services/", className = "services.GetAllProductsJsonResponse")
    @Action(input = "http://Services/CustomerWebService/getAllProductsJsonRequest", output = "http://Services/CustomerWebService/getAllProductsJsonResponse")
    public String getAllProductsJson();

    /**
     * 
     * @param password
     * @param email
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loginCustomer", targetNamespace = "http://Services/", className = "services.LoginCustomer")
    @ResponseWrapper(localName = "loginCustomerResponse", targetNamespace = "http://Services/", className = "services.LoginCustomerResponse")
    @Action(input = "http://Services/CustomerWebService/loginCustomerRequest", output = "http://Services/CustomerWebService/loginCustomerResponse")
    public boolean loginCustomer(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param productId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLoan", targetNamespace = "http://Services/", className = "services.GetLoan")
    @ResponseWrapper(localName = "getLoanResponse", targetNamespace = "http://Services/", className = "services.GetLoanResponse")
    @Action(input = "http://Services/CustomerWebService/getLoanRequest", output = "http://Services/CustomerWebService/getLoanResponse")
    public boolean getLoan(
        @WebParam(name = "productId", targetNamespace = "")
        int productId);

    /**
     * 
     * @param loanId
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "payLoan", targetNamespace = "http://Services/", className = "services.PayLoan")
    @Action(input = "http://Services/CustomerWebService/payLoan")
    public void payLoan(
        @WebParam(name = "loanId", targetNamespace = "")
        int loanId);

    /**
     * 
     * @param productId
     * @param qty
     * @param customerId
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "addCartItem", targetNamespace = "http://Services/", className = "services.AddCartItem")
    @Action(input = "http://Services/CustomerWebService/addCartItem")
    public void addCartItem(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId,
        @WebParam(name = "productId", targetNamespace = "")
        int productId,
        @WebParam(name = "qty", targetNamespace = "")
        int qty);

    /**
     * 
     * @param password
     * @param dob
     * @param name
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registerCustomer", targetNamespace = "http://Services/", className = "services.RegisterCustomer")
    @ResponseWrapper(localName = "registerCustomerResponse", targetNamespace = "http://Services/", className = "services.RegisterCustomerResponse")
    @Action(input = "http://Services/CustomerWebService/registerCustomerRequest", output = "http://Services/CustomerWebService/registerCustomerResponse")
    public String registerCustomer(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "dob", targetNamespace = "")
        String dob,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param total
     * @param customerId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkEligibility", targetNamespace = "http://Services/", className = "services.CheckEligibility")
    @ResponseWrapper(localName = "checkEligibilityResponse", targetNamespace = "http://Services/", className = "services.CheckEligibilityResponse")
    @Action(input = "http://Services/CustomerWebService/checkEligibilityRequest", output = "http://Services/CustomerWebService/checkEligibilityResponse")
    public int checkEligibility(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId,
        @WebParam(name = "total", targetNamespace = "")
        double total);

}
