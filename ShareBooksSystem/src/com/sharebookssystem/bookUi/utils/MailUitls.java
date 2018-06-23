package com.sharebookssystem.bookUi.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author Zhouzhou
 * @date 2016-1-1
 * @time 上午08:52:47
 */
public class MailUitls {
    public static void sendMail(String to,String code){

        /**
         * 1.获取session
         * 2.创建一个代码邮件的对象message
         * 3.发送邮件Transport
         */
        /**
         * 1.获得连接对象
         */
        Properties props=new Properties();
        props.setProperty("mail.host","localhost");
        props.setProperty("mail.transport.protocol", "smtp");
        String server = "smtp.163.com";
        String username = "yuanpeng_coder@163.com";
        String password = "yixuan0924";
        Session session=Session.getDefaultInstance(props, new Authenticator(){

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication("yuanpeng_coder@163.com","yixuan0924");
            }

        });
        //2.创建邮件发送对象
        Message message=new MimeMessage(session);
        //3.设置发件人
        try {
            message.setFrom(new InternetAddress("yuanpeng_coder@163.com"));
            //设置收件人
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            //标题
            message.setSubject("来自HIMB的信息");
            message.setContent("  "+code+"", "text/html;charset=UTF-8");
            // 3.发送邮件:
            Transport transport = session.getTransport();
            transport.connect(server, username, password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();

        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        sendMail("aaa@azz.com","你的激活码是azz19931016");
    }
}