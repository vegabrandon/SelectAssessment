package com.vegabrandon.Select.services.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "INVOICES")
public class Invoice {
    private String invoice_number;
    private String total;
    private String currency;
    private String invoice_date;
    private String due_date;
    private String vendor_name;
    private String remittance_address;
    private String status;

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getRemittance_address() {
        return remittance_address;
    }

    public void setRemittance_address(String remittance_address) {
        this.remittance_address = remittance_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
