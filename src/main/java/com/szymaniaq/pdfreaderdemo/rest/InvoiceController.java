package com.szymaniaq.pdfreaderdemo.rest;

import com.szymaniaq.pdfreaderdemo.invoice.Invoice;
import com.szymaniaq.pdfreaderdemo.service.InvoiceParserService;
import com.szymaniaq.pdfreaderdemo.service.PdfParserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
    private static final String PATH_TO_INVOICE = "src/test/java/resources/sample_invoice.pdf";
    private final InvoiceParserService invoiceParserService;
    private final PdfParserService pdfParserService;

    public InvoiceController(InvoiceParserService invoiceParserService, PdfParserService pdfParserService) {
        this.invoiceParserService = invoiceParserService;
        this.pdfParserService = pdfParserService;
    }

    @GetMapping("/invoice")
    public Invoice getInvoice() {
        String invoiceContent = pdfParserService.parse(PATH_TO_INVOICE);
        return invoiceParserService.getInvoice(invoiceContent);
    };

}
