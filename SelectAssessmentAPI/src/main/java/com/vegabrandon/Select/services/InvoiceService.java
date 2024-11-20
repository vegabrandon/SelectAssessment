package com.vegabrandon.Select.services;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionRequest;
import com.vegabrandon.Select.controller.model.InvoiceSubmissionResponse;
import com.vegabrandon.Select.repository.InvoiceRepository;
import com.vegabrandon.Select.services.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public InvoiceSubmissionResponse addInvoice(InvoiceSubmissionRequest invoice) {
        this.invoiceRepository.addInvoice(mapInvoiceSubmissionRequestToInvoice(invoice));
        InvoiceSubmissionResponse response = new InvoiceSubmissionResponse();
        response.setMessage("invoice submitted successfully");
        return response;
    }

    private Invoice mapInvoiceSubmissionRequestToInvoice(InvoiceSubmissionRequest invoice) {
        Invoice mappedInvoice = new Invoice();
        mappedInvoice.setInvoice_date(invoice.getInvoice_date());
        mappedInvoice.setInvoice_number(invoice.getInvoice_number());
        mappedInvoice.setCurrency(invoice.getCurrency());
        mappedInvoice.setStatus("pending");
        mappedInvoice.setTotal(invoice.getTotal());
        mappedInvoice.setDue_date(invoice.getDue_date());
        mappedInvoice.setVendor_name(invoice.getVendor_name());
        mappedInvoice.setRemittance_address(invoice.getRemittance_address());
        return mappedInvoice;
    }
}
