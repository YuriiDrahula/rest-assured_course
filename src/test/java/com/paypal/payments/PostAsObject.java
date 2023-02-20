package com.paypal.payments;

import com.paypal.pojo.*;
import com.testbase.PayPalBaseClass;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostAsObject extends PayPalBaseClass {

    static String paymentId;


    @Test
    @Order(1)
    public void createPayment(){

        //Create Details object
        Details details = new Details();
        details.setSubtotal("30.00");
        details.setTax("0.07");
        details.setShipping("0.03");
        details.setHandling_fee("1.00");
        details.setShipping_discount("-1.00");
        details.setInsurance("0.01");

        //Create Amount object
        Amount amount = new Amount();
        amount.setTotal("30.11");
        amount.setCurrency("USD");
        amount.setDetails(details);

        //Create Payment_Options object
        Payment_Options payment_options = new Payment_Options();
        payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");

        //Set Shipping_address
        ShippingAddress shipping_address = new ShippingAddress();
        shipping_address.setRecipient_name("Brian Robinson");
        shipping_address.setLine1("4th Floor");
        shipping_address.setLine2("Unit #34");
        shipping_address.setCity("San Jose");
        shipping_address.setCountry_code("US");
        shipping_address.setPostal_code("95131");
        shipping_address.setPhone("011862212345678");
        shipping_address.setState("CA");

        //Set items
        Item item1 = new Item();
        item1.setName("hat");
        item1.setDescription("Brown hat.");
        item1.setQuantity("5");
        item1.setPrice("3");
        item1.setTax("0.01");
        item1.setSku("1");
        item1.setCurrency("USD");

        Item item2 = new Item();
        item2.setName("handbag");
        item2.setDescription("Black handbag.");
        item2.setQuantity("1");
        item2.setPrice("15");
        item2.setTax("0.02");
        item2.setSku("product34");
        item2.setCurrency("USD");

        //Create list with items
        ArrayList<Object> itemsList = new ArrayList<>();
        itemsList.add(item1);
        itemsList.add(item2);

        //Set the Item_List object
        Item_List item_list = new Item_List();
        item_list.setItems(itemsList);
        item_list.setShipping_address(shipping_address);

        //Create Redirect_Urls object
        Redirect_Urls redirect_urls = new Redirect_Urls();
        redirect_urls.setReturn_url("https://example.com/return");
        redirect_urls.setCancel_url("https://example.com/cancel");

        //Create Payment object
        Transactions transaction = new Transactions();
        transaction.setAmount(amount);
        transaction.setDescription("The payment transaction description.");
        transaction.setCustom("EBAY_EMS_90048630024435");
        transaction.setInvoice_number("48787589673");
        transaction.setPayment_options(payment_options);
        transaction.setSoft_descriptor("ECHI5786786");
        transaction.setItem_list(item_list);

        //Create Payer Object
        Payer payer = new Payer();
        payer.setPayment_method("paypal");

        //Create Transactions List
        ArrayList<Transactions> transactions = new ArrayList<>();
        transactions.add(transaction);

        //Create Payment object
        PaymentObj postPayment = new PaymentObj();
        postPayment.setIntent("sale");
        postPayment.setPayer(payer);
        postPayment.setTransactions(transactions);
        postPayment.setNote_to_payer("Contact us for any questions on your order.");
        postPayment.setRedirect_urls(redirect_urls);



        paymentId = rs.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken)
                .when()
                .body(postPayment)
                .post("/payments/payment")
                .then()
                .log().all()
                .extract().path("id");

    }

    @Test
    @Order(2)
    public void getPaymentDetails(){
        rs.given()
                .auth().oauth2(accessToken)
                .when()
                .get("/payments/payment/" + paymentId)
                .then()
                .log().all();
    }
}
