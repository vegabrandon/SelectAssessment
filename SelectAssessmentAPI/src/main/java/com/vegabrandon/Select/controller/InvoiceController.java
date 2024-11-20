package com.vegabrandon.Select.controller;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionRequest;
import com.vegabrandon.Select.controller.model.InvoiceSubmissionResponse;
import com.vegabrandon.Select.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(value = "/Invoice")
    public ResponseEntity<InvoiceSubmissionResponse> addInvoice(@RequestBody InvoiceSubmissionRequest invoice) {
        return ResponseEntity.ok(invoiceService.addInvoice(invoice));
    }
}
