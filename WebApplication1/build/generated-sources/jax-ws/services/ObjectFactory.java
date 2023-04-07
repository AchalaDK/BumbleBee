
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllLoans_QNAME = new QName("http://Services/", "getAllLoans");
    private final static QName _GetAllLoansResponse_QNAME = new QName("http://Services/", "getAllLoansResponse");
    private final static QName _GetAllProducts_QNAME = new QName("http://Services/", "getAllProducts");
    private final static QName _GetAllProductsJson_QNAME = new QName("http://Services/", "getAllProductsJson");
    private final static QName _GetAllProductsJsonResponse_QNAME = new QName("http://Services/", "getAllProductsJsonResponse");
    private final static QName _GetAllProductsResponse_QNAME = new QName("http://Services/", "getAllProductsResponse");
    private final static QName _GetLoan_QNAME = new QName("http://Services/", "getLoan");
    private final static QName _GetLoanResponse_QNAME = new QName("http://Services/", "getLoanResponse");
    private final static QName _GetPaidInstallments_QNAME = new QName("http://Services/", "getPaidInstallments");
    private final static QName _GetPaidInstallmentsResponse_QNAME = new QName("http://Services/", "getPaidInstallmentsResponse");
    private final static QName _GetUnpaidLoans_QNAME = new QName("http://Services/", "getUnpaidLoans");
    private final static QName _GetUnpaidLoansResponse_QNAME = new QName("http://Services/", "getUnpaidLoansResponse");
    private final static QName _LoginCustomer_QNAME = new QName("http://Services/", "loginCustomer");
    private final static QName _LoginCustomerResponse_QNAME = new QName("http://Services/", "loginCustomerResponse");
    private final static QName _PayLoan_QNAME = new QName("http://Services/", "payLoan");
    private final static QName _UpdateInformation_QNAME = new QName("http://Services/", "updateInformation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllLoans }
     * 
     */
    public GetAllLoans createGetAllLoans() {
        return new GetAllLoans();
    }

    /**
     * Create an instance of {@link GetAllLoansResponse }
     * 
     */
    public GetAllLoansResponse createGetAllLoansResponse() {
        return new GetAllLoansResponse();
    }

    /**
     * Create an instance of {@link GetAllProducts }
     * 
     */
    public GetAllProducts createGetAllProducts() {
        return new GetAllProducts();
    }

    /**
     * Create an instance of {@link GetAllProductsJson }
     * 
     */
    public GetAllProductsJson createGetAllProductsJson() {
        return new GetAllProductsJson();
    }

    /**
     * Create an instance of {@link GetAllProductsJsonResponse }
     * 
     */
    public GetAllProductsJsonResponse createGetAllProductsJsonResponse() {
        return new GetAllProductsJsonResponse();
    }

    /**
     * Create an instance of {@link GetAllProductsResponse }
     * 
     */
    public GetAllProductsResponse createGetAllProductsResponse() {
        return new GetAllProductsResponse();
    }

    /**
     * Create an instance of {@link GetLoan }
     * 
     */
    public GetLoan createGetLoan() {
        return new GetLoan();
    }

    /**
     * Create an instance of {@link GetLoanResponse }
     * 
     */
    public GetLoanResponse createGetLoanResponse() {
        return new GetLoanResponse();
    }

    /**
     * Create an instance of {@link GetPaidInstallments }
     * 
     */
    public GetPaidInstallments createGetPaidInstallments() {
        return new GetPaidInstallments();
    }

    /**
     * Create an instance of {@link GetPaidInstallmentsResponse }
     * 
     */
    public GetPaidInstallmentsResponse createGetPaidInstallmentsResponse() {
        return new GetPaidInstallmentsResponse();
    }

    /**
     * Create an instance of {@link GetUnpaidLoans }
     * 
     */
    public GetUnpaidLoans createGetUnpaidLoans() {
        return new GetUnpaidLoans();
    }

    /**
     * Create an instance of {@link GetUnpaidLoansResponse }
     * 
     */
    public GetUnpaidLoansResponse createGetUnpaidLoansResponse() {
        return new GetUnpaidLoansResponse();
    }

    /**
     * Create an instance of {@link LoginCustomer }
     * 
     */
    public LoginCustomer createLoginCustomer() {
        return new LoginCustomer();
    }

    /**
     * Create an instance of {@link LoginCustomerResponse }
     * 
     */
    public LoginCustomerResponse createLoginCustomerResponse() {
        return new LoginCustomerResponse();
    }

    /**
     * Create an instance of {@link PayLoan }
     * 
     */
    public PayLoan createPayLoan() {
        return new PayLoan();
    }

    /**
     * Create an instance of {@link UpdateInformation }
     * 
     */
    public UpdateInformation createUpdateInformation() {
        return new UpdateInformation();
    }

    /**
     * Create an instance of {@link Loan }
     * 
     */
    public Loan createLoan() {
        return new Loan();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLoans }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllLoans }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getAllLoans")
    public JAXBElement<GetAllLoans> createGetAllLoans(GetAllLoans value) {
        return new JAXBElement<GetAllLoans>(_GetAllLoans_QNAME, GetAllLoans.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLoansResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllLoansResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getAllLoansResponse")
    public JAXBElement<GetAllLoansResponse> createGetAllLoansResponse(GetAllLoansResponse value) {
        return new JAXBElement<GetAllLoansResponse>(_GetAllLoansResponse_QNAME, GetAllLoansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducts }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllProducts }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getAllProducts")
    public JAXBElement<GetAllProducts> createGetAllProducts(GetAllProducts value) {
        return new JAXBElement<GetAllProducts>(_GetAllProducts_QNAME, GetAllProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsJson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllProductsJson }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getAllProductsJson")
    public JAXBElement<GetAllProductsJson> createGetAllProductsJson(GetAllProductsJson value) {
        return new JAXBElement<GetAllProductsJson>(_GetAllProductsJson_QNAME, GetAllProductsJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsJsonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllProductsJsonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getAllProductsJsonResponse")
    public JAXBElement<GetAllProductsJsonResponse> createGetAllProductsJsonResponse(GetAllProductsJsonResponse value) {
        return new JAXBElement<GetAllProductsJsonResponse>(_GetAllProductsJsonResponse_QNAME, GetAllProductsJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllProductsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getAllProductsResponse")
    public JAXBElement<GetAllProductsResponse> createGetAllProductsResponse(GetAllProductsResponse value) {
        return new JAXBElement<GetAllProductsResponse>(_GetAllProductsResponse_QNAME, GetAllProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoan }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetLoan }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getLoan")
    public JAXBElement<GetLoan> createGetLoan(GetLoan value) {
        return new JAXBElement<GetLoan>(_GetLoan_QNAME, GetLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoanResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetLoanResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getLoanResponse")
    public JAXBElement<GetLoanResponse> createGetLoanResponse(GetLoanResponse value) {
        return new JAXBElement<GetLoanResponse>(_GetLoanResponse_QNAME, GetLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaidInstallments }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPaidInstallments }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getPaidInstallments")
    public JAXBElement<GetPaidInstallments> createGetPaidInstallments(GetPaidInstallments value) {
        return new JAXBElement<GetPaidInstallments>(_GetPaidInstallments_QNAME, GetPaidInstallments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaidInstallmentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPaidInstallmentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getPaidInstallmentsResponse")
    public JAXBElement<GetPaidInstallmentsResponse> createGetPaidInstallmentsResponse(GetPaidInstallmentsResponse value) {
        return new JAXBElement<GetPaidInstallmentsResponse>(_GetPaidInstallmentsResponse_QNAME, GetPaidInstallmentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnpaidLoans }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUnpaidLoans }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getUnpaidLoans")
    public JAXBElement<GetUnpaidLoans> createGetUnpaidLoans(GetUnpaidLoans value) {
        return new JAXBElement<GetUnpaidLoans>(_GetUnpaidLoans_QNAME, GetUnpaidLoans.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnpaidLoansResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUnpaidLoansResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getUnpaidLoansResponse")
    public JAXBElement<GetUnpaidLoansResponse> createGetUnpaidLoansResponse(GetUnpaidLoansResponse value) {
        return new JAXBElement<GetUnpaidLoansResponse>(_GetUnpaidLoansResponse_QNAME, GetUnpaidLoansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "loginCustomer")
    public JAXBElement<LoginCustomer> createLoginCustomer(LoginCustomer value) {
        return new JAXBElement<LoginCustomer>(_LoginCustomer_QNAME, LoginCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "loginCustomerResponse")
    public JAXBElement<LoginCustomerResponse> createLoginCustomerResponse(LoginCustomerResponse value) {
        return new JAXBElement<LoginCustomerResponse>(_LoginCustomerResponse_QNAME, LoginCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayLoan }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayLoan }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "payLoan")
    public JAXBElement<PayLoan> createPayLoan(PayLoan value) {
        return new JAXBElement<PayLoan>(_PayLoan_QNAME, PayLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateInformation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateInformation }{@code >}
     */
    @XmlElementDecl(namespace = "http://Services/", name = "updateInformation")
    public JAXBElement<UpdateInformation> createUpdateInformation(UpdateInformation value) {
        return new JAXBElement<UpdateInformation>(_UpdateInformation_QNAME, UpdateInformation.class, null, value);
    }

}
