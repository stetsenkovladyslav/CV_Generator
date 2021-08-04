package com.example.consumer.pdf;

import com.example.data.Person;
import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface PdfService {

    void generatePdf(Person person) throws IOException, DocumentException;

}
