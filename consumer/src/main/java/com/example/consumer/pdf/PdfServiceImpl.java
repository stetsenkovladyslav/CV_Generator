package com.example.consumer.pdf;


import com.example.data.Person;
import com.example.data.aws.service.AwsFileService;
import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Service
public class PdfServiceImpl implements PdfService {

    private static final String FILE_FORMAT = ".pdf";

    private final AwsFileService awsFileService;


    @Override
    public void generatePdf(Person person) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        String html = parseThymeleafTemplate(person);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        awsFileService.upload(person.getId().concat(FILE_FORMAT), inputStream);
        outputStream.close();
        inputStream.close();
    }

    private String parseThymeleafTemplate(Person person) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("people", person);

        return templateEngine.process("cv", context);
    }

}
