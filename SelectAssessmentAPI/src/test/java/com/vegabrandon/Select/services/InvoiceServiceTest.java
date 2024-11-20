package com.vegabrandon.Select.services;

import com.vegabrandon.Select.controller.model.InvoiceSubmissionRequest;
import com.vegabrandon.Select.repository.InvoiceRepository;
import com.vegabrandon.Select.controller.model.InvoiceEndpointResponse;
import com.vegabrandon.Select.services.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


public class InvoiceServiceTest {
    @Mock
    private InvoiceRepository invoiceRepository;
    @Mock
    private SimpMessagingTemplate simpMessagingTemplate;

    @InjectMocks
    private InvoiceService invoiceService;

    private static final String MESSAGE_SUCCESS = "invoice submitted successfully";
    private static final String MESSAGE_APPROVED = "invoice approved successfully";

    @BeforeEach
    public void before() {
        openMocks(this);
    }

    @Test
    public void testAddInvoice() {
        List<Invoice> invoices = List.of(getTestInvoice());
        when(invoiceRepository.getAllInvoicesPending()).thenReturn(invoices);
        InvoiceEndpointResponse response = invoiceService.addInvoice(new InvoiceSubmissionRequest());
        verify(simpMessagingTemplate, times(1)).convertAndSend("/topic/invoices", invoices);
        assertNotNull(response);
        assertEquals(MESSAGE_SUCCESS, response.getMessage());
    }

    @Test
    public void testApproveInvoice() {
        InvoiceEndpointResponse response = invoiceService.approveInvoice("");
        assertEquals(MESSAGE_APPROVED, response.getMessage());
    }

    private Invoice getTestInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoice_number("12345");
        invoice.setInvoice_date("2019-08-17");
        invoice.setCurrency("USD");
        invoice.setDue_date("2019-09-17");
        invoice.setVendor_name("Acme Trucking Inc.");
        invoice.setRemittance_address("123 ABC St. Charlotte, NC 28209");
        invoice.setStatus("pending");
        return invoice;
    }
}
