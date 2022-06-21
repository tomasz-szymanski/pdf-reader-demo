package com.szymaniaq.pdfreaderdemo.parser.invoice;

import com.szymaniaq.pdfreaderdemo.parser.BankAccountParser;
import com.szymaniaq.pdfreaderdemo.parser.SampleTestInvoiceContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
class BankAccountParserTest {

    @Autowired
    private SampleTestInvoiceContent content;

    @Autowired
    private BankAccountParser bankAccountParser;

    @Test
    void shouldParseBankAccountNumber() {
        //given
        String invoiceContent = content.get();
        //when
        String bankAccountNumber = bankAccountParser.parse(invoiceContent);
        //then
        assertThat(bankAccountNumber).isNotBlank();
        assertThat(bankAccountNumber).isEqualTo("57 1140 1629 1748 0000 8282 0732");
    }
}