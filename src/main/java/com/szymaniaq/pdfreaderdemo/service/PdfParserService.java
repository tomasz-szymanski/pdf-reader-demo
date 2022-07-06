package com.szymaniaq.pdfreaderdemo.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PdfParserService {
    public String parse(File file) {
        if(file.canRead())  {
            try (PDDocument document = PDDocument.load(file)) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                return tStripper.getText(document);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }

}
