package com.vegabrandon.Select.services;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionRequest;
import com.vegabrandon.Select.controller.model.InvoiceEndpointResponse;
import com.vegabrandon.Select.repository.InvoiceRepository;
import com.vegabrandon.Select.services.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, SimpMessagingTemplate simpMessagingTemplate) {
        this.invoiceRepository = invoiceRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public InvoiceEndpointResponse addInvoice(InvoiceSubmissionRequest invoice) {
        this.invoiceRepository.addInvoice(mapInvoiceSubmissionRequestToInvoice(invoice));
        sendAllInvoicesMessage();
        return new InvoiceEndpointResponse("invoice submitted successfully");
    }

    public void sendAllInvoicesMessage() {
        simpMessagingTemplate.convertAndSend("/topic/invoices", getAllInvoicesPending());
    }

    public List<Invoice> getAllInvoicesPending() {
        return this.invoiceRepository.getAllInvoicesPending();
    }

    public InvoiceEndpointResponse approveInvoice(String invoiceId) {
        this.invoiceRepository.approveInvoice(invoiceId);
        sendAllInvoicesMessage();
        return new InvoiceEndpointResponse("invoice approved successfully");
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
