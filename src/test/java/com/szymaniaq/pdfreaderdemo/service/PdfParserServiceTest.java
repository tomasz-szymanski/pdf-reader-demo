package com.szymaniaq.pdfreaderdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PdfParserServiceTest {
    private static final String PATH_TO_FILE = "src/test/java/resources/sample_invoice.pdf";
    @Autowired
    private PdfParserService pdfParserService;

    @Test
    void shouldParseFile() {
        //given
        File file = Paths.get(PATH_TO_FILE).toFile();
        //when
        String invoiceText = pdfParserService.parse(file);
        //then
        assertThat(invoiceText).isNotBlank();
    }

}