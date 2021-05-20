package com.joinit.controller;

import com.joinit.mailsender.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
@RequestMapping(path = "/email")
public class MailSenderController {

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping(path = "/send")
    public void sendEmailPDF(@Param("to") String to, @Param("appliedEmail") String appliedEmail, @Param("firsAndLastName") String firsAndLastName,
                             @Param("introduction") String introduction, @Param("companyName") String companyName,
                             @Param("localization") String localization, @Param("positionName") String positionName,
                             @RequestParam("pdfFile") MultipartFile email) throws IOException, MessagingException {

        Path currentRelativePath = Paths.get("");
        String workingDirectory = currentRelativePath.toAbsolutePath().toString();

        //String filePath = "D:\\Projects\\JoinIt\\PDF\\cv.pdf";
        String filePath = workingDirectory + "\\cv.pdf";

        try (FileOutputStream stream = new FileOutputStream(filePath)) {
            stream.write(email.getBytes());
        }

        emailService.sendMessageWithAttachment(to, firsAndLastName + " applied for " + positionName,"Hello, "+ "\n\n" + firsAndLastName +
                " have just applied for " + positionName +" in your company through our JoinIt website." + "\n\n" +
                "You can find his/her CV in attachment." + "\n\n" +
                "Below you can find candidate's introduction." + "\n\n" +
                firsAndLastName + " introduction:" + "\n" + introduction + "\n\n" +
                "Thank you for using our website!" + "\n\n" +
                "Best Regards," + "\n" + "JoinIt Team", filePath);

        emailService.sendMessageWithAttachment(appliedEmail, "You applied for " + positionName, "Hi " + firsAndLastName + "," +
                "\n\n" + "You've just applied for " + positionName + " in " + localization + " on JoinIt to " + companyName
                + "\n\n" + "We keep our fingers crossed for you!" + "\n\n" + "Best Regards," + "\n" + "JoinIt Team", filePath);

        Path path = Paths.get(filePath);
        Files.delete(path);
    }
}