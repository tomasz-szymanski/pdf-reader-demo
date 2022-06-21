package com.szymaniaq.pdfreaderdemo.parser.invoice;

import com.szymaniaq.pdfreaderdemo.parser.InvoiceNumberParser;
import com.szymaniaq.pdfreaderdemo.parser.SampleTestInvoiceContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InvoiceParserTest {

    @Autowired
    private SampleTestInvoiceContent content;

    @Autowired
    private InvoiceNumberParser invoiceNumberParser;

    @Test
    void shouldParseInvoiceNumber() {
        //given
        String invoiceText = content.get();
        assertThat(invoiceText).isNotEmpty();
        //when
        String invoiceNumber = invoiceNumberParser.parse(invoiceText);
        //then
        assertThat(invoiceNumber).isNotBlank();
        assertThat(invoiceNumber).isEqualTo("F0082820732/006/22");
    }
}