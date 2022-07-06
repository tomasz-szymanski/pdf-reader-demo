package com.szymaniaq.pdfreaderdemo.parser;

import java.util.regex.Pattern;

public record ParserInstance(ParserType parserType, Pattern pattern, String prefixToString) {

    public ParserInstance(ParserType parserType, String pattern) {
        this(parserType, pattern, "");
    }

    public ParserInstance(ParserType parserType, String pattern, String prefixToStrip) {
        this(parserType, Pattern.compile(prefixToStrip + pattern), prefixToStrip);
    }

}
