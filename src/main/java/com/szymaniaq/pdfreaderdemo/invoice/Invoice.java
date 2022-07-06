package com.szymaniaq.pdfreaderdemo.invoice;


import java.time.LocalDate;

public record Invoice (String invoiceNumber, String accountNumber, String amount, LocalDate dueDate, String title){

    public Invoice(String invoiceNumber, String accountNumber, String amount) {
        this(invoiceNumber, accountNumber, amount, null, "");
    }
}

