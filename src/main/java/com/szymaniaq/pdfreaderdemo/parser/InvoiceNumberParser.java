package com.szymaniaq.pdfreaderdemo.parser;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class InvoiceNumberParser extends InvoiceParser {

    private final Pattern INVOICE_NUMBER_PATTERN = Pattern.compile("\\w\\d{10}\\/\\d{3}\\/\\d{2}");
    @Override
    public Pattern getPattern() {
        return INVOICE_NUMBER_PATTERN;
    }
}
