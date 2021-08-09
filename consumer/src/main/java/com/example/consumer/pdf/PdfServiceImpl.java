package com.example.consumer.pdf;


import com.example.consumer.service.AwsFileService;
import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import model.Person;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Service
public class PdfServiceImpl implements PdfService {

    private final AwsFileService awsFileService;
    private final SpringTemplateEngine templateEngine;

    @Override
    public void generatePdf(Person person) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        String html = parseThymeleafTemplate(person);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        awsFileService.upload(person.getId().concat(".pdf"), inputStream);
        outputStream.close();
        inputStream.close();
    }

    private String parseThymeleafTemplate(Person person) {
        Context context = new Context();
        context.setVariable("people", person);

        return templateEngine.process("cv", context);
    }

}
