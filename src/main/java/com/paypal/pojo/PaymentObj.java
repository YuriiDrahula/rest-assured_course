package com.paypal.pojo;

import java.util.ArrayList;

public class PaymentObj {

    private String intent;
    private Payer payer;
    private ArrayList<Transactions> transactions;
    private String note_to_payer;
    private Redirect_Urls redirect_urls;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }

    public String getNote_to_payer() {
        return note_to_payer;
    }

    public void setNote_to_payer(String note_to_payer) {
        this.note_to_payer = note_to_payer;
    }

    public Redirect_Urls getRedirect_urls() {
        return redirect_urls;
    }

    public void setRedirect_urls(Redirect_Urls redirect_urls) {
        this.redirect_urls = redirect_urls;
    }


}
