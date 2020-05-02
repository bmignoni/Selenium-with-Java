package org.testerbarbara.reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static javax.mail.Session.getDefaultInstance;

public class BaseClass {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void takeScreenShot(WebDriver driver, String fileWithPath) throws IOException {
        TakesScreenshot scrShot = (TakesScreenshot)driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);

        FileUtils.copyFile(srcFile,destFile);
    }

    public static void sendPdfReportByEmail (String from, String pass, String to, String subject, String body){

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "465"); //25, 465, 587 estos son los puertos con los que podemos accesar, hay que encontrar cual es.
        props.put("mail.smtp.auth", "true");

        Session session = getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try{
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            BodyPart objMessageBodyPart = new MimeBodyPart();
            objMessageBodyPart.setText(body);
            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(objMessageBodyPart);
            objMessageBodyPart = new MimeBodyPart();

            String fileName = System.getProperty("user.dir") + "\\SeleniumBasic.pdf";
            DataSource source = new FileDataSource(fileName);
            objMessageBodyPart.setDataHandler(new DataHandler(source));
            objMessageBodyPart.setFileName(fileName);
            multiPart.addBodyPart(objMessageBodyPart);
            message.setContent(multiPart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (AddressException e) {
            System.err.println("Problems with email address: " + e.getMessage());
        } catch (MessagingException e) {
            System.err.println("Could not connect to SMTP host, review your host and port " + e.getMessage());
            // la consola tira el siguiente error:
            // review your host and port Could not connect to SMTP host: smtp.gmail.com, port: 465, response: -1
        }
    }
}
