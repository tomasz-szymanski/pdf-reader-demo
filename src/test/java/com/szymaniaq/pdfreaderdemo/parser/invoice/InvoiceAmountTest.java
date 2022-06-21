package com.szymaniaq.pdfreaderdemo.parser.invoice;

import com.szymaniaq.pdfreaderdemo.parser.InvoiceAmountParser;
import com.szymaniaq.pdfreaderdemo.parser.SampleTestInvoiceContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InvoiceAmountTest {

    @Autowired
    private SampleTestInvoiceContent content;

    @Autowired
    private InvoiceAmountParser invoiceAmountParser;

    @Test
    void shouldParseInvoiceNumber() {
        //given
        String invoiceText = content.get();
        assertThat(invoiceText).isNotEmpty();
        //when
        String amount = invoiceAmountParser.parse(invoiceText);
        //then
        assertThat(amount).isNotEmpty();
        assertThat(amount).isEqualTo("69,83");
    }
}