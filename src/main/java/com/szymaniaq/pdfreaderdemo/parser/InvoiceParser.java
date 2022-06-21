package com.szymaniaq.pdfreaderdemo.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class InvoiceParser {
    abstract Pattern getPattern();
    
    public String parse(String text) {
        Matcher matcher = getPattern().matcher(text);
        if(matcher.find()){
            String group = matcher.group(0);
            return Optional.ofNullable(group).map(el -> el.replace("\r", "").strip()).orElse("");
        };
        return "";
    }

    public List<String> parseAll(String text) {
        Matcher matcher = getPattern().matcher(text);
        List<String> groups = new ArrayList<>();
        while (matcher.find()) {
            groups.add(matcher.group(0));
        }
        return groups;
    }
}
