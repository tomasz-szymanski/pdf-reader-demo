package com.szymaniaq.pdfreaderdemo.parser;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class InvoiceAmountParser extends InvoiceParser {
    private final String PREFIX_TO_STRIP = "Opłata za bieżący okres ";
    private final Pattern INVOICE_AMOUNT_PATTERN = Pattern.compile(PREFIX_TO_STRIP + "\\d+\\,\\d{2}");
    @Override
    public Pattern getPattern() {
        return INVOICE_AMOUNT_PATTERN;
    }

    @Override
    public String parse(String text) {
        String amount = super.parse(text);
        return amount.replace(PREFIX_TO_STRIP, "");
    }

}
