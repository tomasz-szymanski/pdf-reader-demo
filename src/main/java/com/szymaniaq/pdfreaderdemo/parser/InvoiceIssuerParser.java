package com.szymaniaq.pdfreaderdemo.parser;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class InvoiceIssuerParser {
    public String parse(InvoiceIssuer issuer, String text, ParserType parserType) {
        return parse(text, issuer.getPattern(parserType), issuer.getPrefixToStrip(parserType));
    }
    private String parse(String text, Pattern pattern, String prefixToStrip) {
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            String group = matcher.group(0);
            return Optional.ofNullable(group)
                    .map(el -> el.replace("\r", "").strip())
                    .map(el -> el.replace(prefixToStrip, ""))
                    .orElse("");
        }
        return "";
    }

}
