package com.zkx.crawler_demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zkx on 2017/3/19.
 */
public class PdfHandler {
    public static void main(String[] args) {
        try {
            PDDocument document = PDDocument.load(new File("C:\\Users\\zkx\\Desktop\\1203174839.pdf"));
            int num = document.getNumberOfPages();
            BufferedWriter writer = new BufferedWriter(new FileWriter("wangfujing.txt"));
            PDFTextStripper stripper = new PDFTextStripper();

            stripper.setSortByPosition(false);
            stripper.setStartPage(1);
            stripper.setEndPage(num);
            stripper.writeText(document, writer);
            document.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
