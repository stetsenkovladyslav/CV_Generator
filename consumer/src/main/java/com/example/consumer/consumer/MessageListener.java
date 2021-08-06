package com.example.consumer.consumer;


import com.example.consumer.pdf.PdfService;
import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class MessageListener {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    private final PdfService pdfService;

    @KafkaListener(topics = "pdf", groupId = "consumer")
    public void listenPdfEvents(Person person) throws IOException, DocumentException {
        log.info("You have a new file: " + person);
        pdfService.generatePdf(person);
    }

}