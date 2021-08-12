package aws;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service

public class AwsFileServiceImpl implements AwsFileService {

    private final AmazonS3 localstackClient;
    private final String bucketName;


    public AwsFileServiceImpl(AmazonS3 localstackClient,
                              @Value("${aws.s3-bucket}") String bucketName) {
        this.localstackClient = localstackClient;
        this.bucketName = bucketName;

    }

    @Override
    public void upload(String fileName, InputStream inputStream) {
        localstackClient.putObject(bucketName, fileName, inputStream, null);
    }

    @Override
    public boolean doesObjectExist(String fileName) {
        return localstackClient.doesObjectExist(bucketName, fileName);
    }

    @Override
    public InputStreamResource download(String fileName) {
        return new InputStreamResource(localstackClient.getObject(bucketName, fileName).getObjectContent());
    }

    @Override
    public void delete(String fileName) {
        localstackClient.deleteObject(bucketName, fileName);
    }
}