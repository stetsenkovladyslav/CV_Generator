package aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AwsConfig {

    private final String bucketName;

    public AwsConfig(@Value("${aws.s3-bucket}") String bucketName) {
        this.bucketName = bucketName;
    }

    @Bean
    public AwsFileService awsFileService(@Autowired AmazonS3 localstackClient, @Value("${aws.s3-bucket}") String bucketName) {
        return new AwsFileServiceImpl(localstackClient, bucketName);
    }

    @Bean
    @Profile("dev")
    public AmazonS3 localstackClient(@Value("${aws.localstack.hostname}") String hostName) {
        AmazonS3 localstackClient = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(hostName, "us-west-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("accesskey", "secretkey")))
                .withPathStyleAccessEnabled(true)
                .build();
        if (!localstackClient.doesBucketExistV2(bucketName)) {
            localstackClient.createBucket(bucketName);
        }

        return localstackClient;
    }
}