package com.szymaniaq.pdfreaderdemo.service;

import com.szymaniaq.pdfreaderdemo.invoice.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InvoiceParserServiceTest {
    private static final String INVOICE_PATH = "src/test/java/resources/sample_invoice.pdf";
    @Autowired
    private InvoiceParserService invoiceParserService;
    @Autowired
    private PdfParserService pdfParserService;

    @Test
    void shouldProvideNotEmptyInvoice() {
        //given
        String invoiceContent = pdfParserService.parse(INVOICE_PATH);
        //when
        Invoice invoice = invoiceParserService.getInvoice(invoiceContent);
        //then
        assertThat(invoice).isNotNull();
        assertThat(invoice.invoiceNumber()).isNotBlank();
        assertThat(invoice.invoiceNumber()).isEqualTo("F0082820732/006/22");

        assertThat(invoice.accountNumber()).isNotBlank();
        assertThat(invoice.accountNumber()).isEqualTo("57 1140 1629 1748 0000 8282 0732");

        assertThat(invoice.amount()).isNotBlank();
        assertThat(invoice.amount()).isEqualTo("69,83");


    }
}