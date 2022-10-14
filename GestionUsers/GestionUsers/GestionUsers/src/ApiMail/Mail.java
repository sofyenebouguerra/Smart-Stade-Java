/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.net.Authenticator;
import java.net.PasswordAuthentication;


/**
 *
 * @author hajje
 */
public class Mail {
    public String sendMail(String Email,String Password, int x) throws Exception {
       String Msg ;
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
            //Enable authentication
        properties.put("mail.smtp.auth", "true");
            //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
            //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
            //Set smtp port
        properties.put("mail.smtp.port", "587");
                    //Your gmail address
  final  String Username = Email;
final String password = Password;

            //Create a session with account credentials
        
            
                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                    @Override
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new javax.mail.PasswordAuthentication(Username, password);
                        }
                    }); 
                      try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(Email));
            message.setSubject("Notification de connexion");
            String htmlCode = "<p>Bonjour, votre compte est ajouter./n Cordialement</p>";
            message.setContent(htmlCode, "text/html");
            Transport.send(message);
        }catch (Exception ex) {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        Msg="true";
        return Msg;
      
    }
    
}
