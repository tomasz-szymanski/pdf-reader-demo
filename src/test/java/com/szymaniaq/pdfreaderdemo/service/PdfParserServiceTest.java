package com.szymaniaq.pdfreaderdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PdfParserServiceTest {
    @Autowired
    private PdfParserService pdfParserService;

    @Test
    void shouldReadDocument() {
        String invoiceText = pdfParserService.parse("src/test/java/resources/sample_invoice.pdf");
        assertThat(invoiceText).isNotBlank();
    }

}