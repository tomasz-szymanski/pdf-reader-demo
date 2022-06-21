package com.szymaniaq.pdfreaderdemo.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class PdfParserService {
    public String parse(String pathToFile) {
        File file = Paths.get(pathToFile).toFile();
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
