package com.szymaniaq.pdfreaderdemo.service;

import com.szymaniaq.pdfreaderdemo.invoice.Invoice;
import com.szymaniaq.pdfreaderdemo.parser.BankAccountParser;
import com.szymaniaq.pdfreaderdemo.parser.InvoiceAmountParser;
import com.szymaniaq.pdfreaderdemo.parser.InvoiceNumberParser;
import org.springframework.stereotype.Service;

@Service
public class InvoiceParserService {
    private BankAccountParser bankAccountParser;
    private InvoiceNumberParser invoiceNumberParser;
    private InvoiceAmountParser invoiceAmountParser;

    public InvoiceParserService(BankAccountParser bankAccountParser, InvoiceNumberParser invoiceNumberParser, InvoiceAmountParser invoiceAmountParser) {

        this.bankAccountParser = bankAccountParser;
        this.invoiceNumberParser = invoiceNumberParser;
        this.invoiceAmountParser = invoiceAmountParser;
    }

    public Invoice getInvoice(String invoiceContent) {
        String invoiceNumber = invoiceNumberParser.parse(invoiceContent);
        String accountNumber = bankAccountParser.parse(invoiceContent);
        String amount = invoiceAmountParser.parse(invoiceContent);
        return new Invoice(invoiceNumber, accountNumber, amount);
    }
}
