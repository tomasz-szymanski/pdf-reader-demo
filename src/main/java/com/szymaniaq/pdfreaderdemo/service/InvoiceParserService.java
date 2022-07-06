package com.szymaniaq.pdfreaderdemo.service;

import com.szymaniaq.pdfreaderdemo.invoice.Invoice;
import com.szymaniaq.pdfreaderdemo.parser.InvoiceIssuer;
import com.szymaniaq.pdfreaderdemo.parser.InvoiceIssuerParser;
import com.szymaniaq.pdfreaderdemo.parser.ParserType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class InvoiceParserService {

    private final InvoiceIssuerParser parser;

    public InvoiceParserService(InvoiceIssuerParser parser) {
        this.parser = parser;
    }
    public Invoice getInvoice(InvoiceIssuer issuer, String invoiceContent) {
        String invoiceNumber = parser.parse(issuer, invoiceContent, ParserType.INVOICE_NUMBER);
        String accountNumber = parser.parse(issuer, invoiceContent, ParserType.ACCOUNT_NUMBER);
        String amount = parser.parse(issuer, invoiceContent, ParserType.AMOUNT);
        String dueDate = parser.parse(issuer, invoiceContent, ParserType.DUE_DATE);
        String title = parser.parse(issuer, invoiceContent, ParserType.TITLE);
        return new Invoice(
                invoiceNumber,
                accountNumber,
                amount,
                LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                title);
    }
}
