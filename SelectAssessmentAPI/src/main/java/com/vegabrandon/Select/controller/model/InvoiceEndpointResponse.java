package com.vegabrandon.Select.controller.model;

public class InvoiceEndpointResponse {
    private String message;

    public InvoiceEndpointResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
