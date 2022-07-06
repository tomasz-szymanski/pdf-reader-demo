package com.szymaniaq.pdfreaderdemo.service;

import com.szymaniaq.pdfreaderdemo.invoice.Invoice;
import com.szymaniaq.pdfreaderdemo.parser.InvoiceIssuer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InvoiceParserServiceTest {
    private static final String INVOICE_PATH = "src/test/java/resources/sample_invoice.pdf";
    @Autowired
    private InvoiceParserService invoiceParserService;
    @Autowired
    private PdfParserService pdfParserService;

    @Test
    void shouldParseInvoiceForOrange() {
        //given
        File file = Paths.get(INVOICE_PATH).toFile();
        String invoiceContent = pdfParserService.parse(file);
        //when
        Invoice invoice = invoiceParserService.getInvoice(InvoiceIssuer.ORANGE, invoiceContent);
        //then
        assertThat(invoice).isNotNull();
        assertThat(invoice.invoiceNumber()).isNotBlank();
        assertThat(invoice.invoiceNumber()).isEqualTo("F0082820732/006/22");

        assertThat(invoice.accountNumber()).isNotBlank();
        assertThat(invoice.accountNumber()).isEqualTo("57 1140 1629 1748 0000 8282 0732");

        assertThat(invoice.amount()).isNotBlank();
        assertThat(invoice.amount()).isEqualTo("69,83");

        assertThat(invoice.dueDate()).isNotNull();
        assertThat(invoice.dueDate()).isEqualTo(LocalDate.of(2022, 6, 15));

        assertThat(invoice.title()).isNotBlank();
        assertThat(invoice.title()).isEqualTo("F0082820732/006/22");

    }
}