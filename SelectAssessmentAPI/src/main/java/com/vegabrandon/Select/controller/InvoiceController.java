package com.vegabrandon.Select.controller;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionRequest;
import com.vegabrandon.Select.controller.model.InvoiceEndpointResponse;
import com.vegabrandon.Select.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(value = "/Invoice")
    public ResponseEntity<InvoiceEndpointResponse> addInvoice(@RequestBody InvoiceSubmissionRequest invoice) {
        return ResponseEntity.ok(invoiceService.addInvoice(invoice));
    }

    @PutMapping(value = "/Invoice/{invoiceId}/approve")
    public ResponseEntity<InvoiceEndpointResponse> approveInvoice(@PathVariable String invoiceId) {
        return ResponseEntity.ok(invoiceService.approveInvoice(invoiceId));
    }
}
