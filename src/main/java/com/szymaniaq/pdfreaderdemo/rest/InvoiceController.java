package com.szymaniaq.pdfreaderdemo.rest;

import com.szymaniaq.pdfreaderdemo.invoice.Invoice;
import com.szymaniaq.pdfreaderdemo.parser.InvoiceIssuer;
import com.szymaniaq.pdfreaderdemo.service.InvoiceParserService;
import com.szymaniaq.pdfreaderdemo.service.PdfParserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Paths;

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
        File file = Paths.get(PATH_TO_INVOICE).toFile();
        String invoiceContent = pdfParserService.parse(file);
        return invoiceParserService.getInvoice(InvoiceIssuer.ORANGE, invoiceContent);
    }

}
