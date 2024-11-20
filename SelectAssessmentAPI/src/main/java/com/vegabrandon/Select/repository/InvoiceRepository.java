package com.vegabrandon.Select.repository;

import com.vegabrandon.Select.services.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepository {
    private final MongoTemplate mongoTemplate;
    private static final String STATUS = "status";
    private static final String PENDING = "pending";
    private static final String APPROVED = "Approved";
    private static final String ID = "_id";

    @Autowired
    public InvoiceRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void addInvoice(Invoice invoice) {
        this.mongoTemplate.save(invoice);
    }

    public List<Invoice> getAllInvoicesPending() {
        Query query = new Query();
        query.addCriteria(Criteria.where(STATUS).is(PENDING));
        return this.mongoTemplate.find(query, Invoice.class);
    }

    public void approveInvoice(String invoiceId) {
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(invoiceId));
        Update update = new Update();
        update.set(STATUS, APPROVED);

        mongoTemplate.updateFirst(query, update, Invoice.class);
    }
}
