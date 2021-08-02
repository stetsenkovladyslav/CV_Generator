package com.example.consumer.pdf;

import com.example.data.Person;
import com.lowagie.text.DocumentException;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;

public interface PdfService {

    void generatePdf(Person person) throws IOException, DocumentException;

}
