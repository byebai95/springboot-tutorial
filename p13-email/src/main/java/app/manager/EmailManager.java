package app.manager;

import app.model.ToEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author: bai
 * @Date: 2021/12/2 14:29
 */
@Slf4j
@Component
public class EmailManager {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 普文文本邮件
     * @param toEmail
     * @return
     */
    public String sendSimpleEmail(ToEmail toEmail){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(toEmail.getTos());
        msg.setSubject(toEmail.getSubject());
        msg.setText(toEmail.getContent());
        try{
            mailSender.send(msg);
        }catch (Exception e){
            e.printStackTrace();
            log.info("发送失败");
            return "failure";
        }
        log.info("发送成功");
        return "success";
    }


    /**
     * h5 文本邮件
     * @param toEmail
     * @return
     */
    public String sendHtmlEmail(ToEmail toEmail){
        MimeMessage  message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(toEmail.getTos());
            helper.setSubject(toEmail.getSubject());
            helper.setText(toEmail.getContent(), true);
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            log.info("发送失败");
            return "failure";
        }
        log.info("发送成功");
        return "success";
    }



    public String sendStaticEmail(ToEmail toEmail){
        MimeMessage  message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(toEmail.getTos());
            helper.setSubject(toEmail.getSubject());
            // true 表示包含附件
            String content =  "<html><body><img width='250px' src=\'http://pics5.baidu.com/feed/f11f3a292df5e0fe6e510156bd5a37af5fdf72da.jpeg?token=ebccafcaeb5d8c206bcbc84f2e121f28\'>" + toEmail.getContent()
                    + "</body></html>";
            helper.setText(content, true);
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            log.info("发送失败");
            return "failure";
        }
        log.info("发送成功");
        return "success";
    }

    public String sendAttachEmail(ToEmail toEmail,MultipartFile multipartFile){
        MimeMessage  message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toEmail.getTos());
            helper.setSubject(toEmail.getSubject());
            helper.setText(toEmail.getContent(), true);

            File multipartFileToFile = MultipartFileToFile(multipartFile);
            FileSystemResource file = new FileSystemResource(multipartFileToFile);
            String filename = file.getFilename();

            helper.addAttachment(filename, file);
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            log.info("发送失败");
            return "failure";
        }
        log.info("发送成功");
        return "success";
    }



    private File MultipartFileToFile(MultipartFile multiFile) {
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码

        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
