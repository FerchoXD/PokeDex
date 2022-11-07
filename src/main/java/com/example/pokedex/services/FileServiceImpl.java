package com.example.pokedex.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.pokedex.entities.Trainer;
import com.example.pokedex.services.interfaces.IFileService;
import com.example.pokedex.services.interfaces.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private ITrainerService TrainerService;

    private AmazonS3 s3client;

    private String ENDPOINT_URL = "s3.us-east-2.amazonaws.com";

    private String BUCKET_NAME = "bucket-pokedex";

    private String ACCESS_KEY = "AKIA2KYSLO7KIXRKU37Q";

    private String SECRET_KEY = "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";

    @Override
    public String upload(MultipartFile multipartFile,Long idTrainer) {
        String fileUrl = "";

        try {
            File file = convertMultiPartToFile(multipartFile);

            String fileName = generateFileName(multipartFile);

            fileUrl = "https://" + BUCKET_NAME + "." + ENDPOINT_URL + "/" +fileName;

            uploadFileToS3Bucket(fileName, file);

            file.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        updateTrainerImage(fileUrl,idTrainer);

        return fileUrl;
    }

    private void updateTrainerImage(String ImageUrl,Long idTrainer){
        Trainer trainer = TrainerService.FindOneAndEnsurePicture(idTrainer);
        trainer.setImage(ImageUrl);
        TrainerService.save(trainer);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileToS3Bucket(String fileName, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        s3client.putObject(putObjectRequest);
    }

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();
    }
}
