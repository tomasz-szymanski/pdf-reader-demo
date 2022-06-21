package com.szymaniaq.pdfreaderdemo.parser;

import com.szymaniaq.pdfreaderdemo.service.PdfParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleTestInvoiceContent {
    @Autowired
    private PdfParserService pdfParserService;

    public String get() {
        return pdfParserService.parse("src/test/java/resources/sample_invoice.pdf");
    }


}
