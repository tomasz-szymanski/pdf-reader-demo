package com.szymaniaq.pdfreaderdemo.parser;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.szymaniaq.pdfreaderdemo.parser.ParserType.*;

public enum InvoiceIssuer {
    ORANGE(List.of(
            new ParserInstance(INVOICE_NUMBER, "\\w\\d{10}\\/\\d{3}\\/\\d{2}"),
            new ParserInstance(ACCOUNT_NUMBER, "\\d{2} (\\d{4}\\s?){6}"),
            new ParserInstance(AMOUNT, "\\d+\\,\\d{2}", "Opłata za bieżący okres "),
            new ParserInstance(DUE_DATE, "\\d+\\.\\d{2}\\.\\d{4}", "Zapłać do: "),
            new ParserInstance(TITLE, "[\\w|\\/]+", "Tytuł przelewu: ")

    ));

    private final List<ParserInstance> parsers;

    InvoiceIssuer(List<ParserInstance> parsers) {
        this.parsers = parsers;
    }

    public Pattern getPattern(ParserType parserType) {
        return filterParserByType(parserType).map(ParserInstance::pattern).findFirst().orElseThrow();
    }

    public String getPrefixToStrip(ParserType parserType) {
        return filterParserByType(parserType).map(ParserInstance::prefixToString).findFirst().orElseThrow();
    }

    private Stream<ParserInstance> filterParserByType(ParserType parserType) {
        return parsers.stream().filter(p -> parserType == p.parserType());
    }
}
