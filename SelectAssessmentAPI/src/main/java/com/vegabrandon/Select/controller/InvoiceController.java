package com.vegabrandon.Select.controller;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {
    @PostMapping(value = "/Invoice")
    public ResponseEntity<InvoiceSubmissionResponse> addInvoice() {
        return ResponseEntity.ok(null);
    }
}
