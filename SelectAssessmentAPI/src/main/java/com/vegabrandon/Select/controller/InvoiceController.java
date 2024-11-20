package com.vegabrandon.Select.controller;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionRequest;
import com.vegabrandon.Select.controller.model.InvoiceSubmissionResponse;
import com.vegabrandon.Select.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, SimpMessagingTemplate simpMessagingTemplate) {
        this.invoiceService = invoiceService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping(value = "/Invoice")
    public ResponseEntity<InvoiceSubmissionResponse> addInvoice(@RequestBody InvoiceSubmissionRequest invoice) {
        InvoiceSubmissionResponse response = invoiceService.addInvoice(invoice);
        simpMessagingTemplate.convertAndSend("/topic/invoices", invoiceService.getAllInvoicesPending());
        return ResponseEntity.ok(invoiceService.addInvoice(invoice));
    }
}
