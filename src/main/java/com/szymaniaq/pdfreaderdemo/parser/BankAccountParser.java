package com.szymaniaq.pdfreaderdemo.parser;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class BankAccountParser extends InvoiceParser {

    private final Pattern NRB_ACCOUNT_PATTERN = Pattern.compile("\\d{2} (\\d{4}\\s?){6}");
    @Override
    Pattern getPattern() {
        return NRB_ACCOUNT_PATTERN;
    }
}
