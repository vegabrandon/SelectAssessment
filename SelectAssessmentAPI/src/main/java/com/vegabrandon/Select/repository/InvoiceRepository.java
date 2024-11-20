package com.vegabrandon.Select.repository;

import com.vegabrandon.Select.services.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public InvoiceRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void addInvoice(Invoice invoice) {
        this.mongoTemplate.save(invoice);
    }
}
