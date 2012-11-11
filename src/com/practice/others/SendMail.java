package com.practice.others;

/*****************************************************
* 
copy form Baidu and Modified.
* @modify Nicky- Qianlei
* 
* 该例子演示了使用javamail发送html格式邮件，
* 
* 分别以发送带附件和不带附件两种形式演示
* 
* 同时实现了向多人发邮件
*****************************************************/
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendMail{
    @SuppressWarnings("static-access")
public void SendMail2(String title, String attachment){
        // 获得属性，并生成Session对象 
        Properties props = new Properties();
        Session sendsession;
        Transport transport;
        MimeMessage message = null;
        BodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        String from = "nicky_qianlei@163.com";
        String to[]={"nicky_qianlei@163.com"};
        String cc[] = {""};
        String bcc[] = {""};
        String s = "<font style=\"BACKGROUND-COLOR: #666699\" color=\"#ff0000\" size=\"5\">测试格式化内容测试<a href=\"\">格式化内容</a>测试格<em>式化</em>内容</font>";
        String content = "<div>Rule Name : </div><div>Rule Description : <div><table border = \"1\" cellpadding = \"10\" cellspacing = \"0\" style = \"border-collapse: collapse;\"><tr><th>zero count</th><th>14 days average</th><th>change</th></tr><tbody><tr><td>15.00</td><td>20.00</td><td>-10%</td></tr></tbody></table>";
        
        try{
            sendsession = Session.getInstance(props, null);
            //向属性中写入SMTP服务器的地址
            props.put("mail.smtp.host", "smtp.163.com");
            //设置SMTP服务器需要权限认证
            props.put("mail.smtp.auth", "true");
            //设置输出调试
            sendsession.setDebug(true);
            //根据Session生成Message对象
            message = new MimeMessage(sendsession);
            //设置发信人地址
            message.setFrom(new InternetAddress(from));
            //设置收信人地址
            String toList = getMailList(to);
            InternetAddress[] iaToList = new InternetAddress().parse(toList);
            message.setRecipients(Message.RecipientType.TO,iaToList);
            if (cc != null){
                String ccList = this.getMailList(cc);
                    InternetAddress[] iaCCList = new InternetAddress().parse(ccList);
                message.setRecipients(Message.RecipientType.CC,iaCCList);
                 }
            if (bcc != null){
                String bccList = this.getMailList(bcc);
                    InternetAddress[] iaBCCList = new InternetAddress().parse(bccList);
                message.setRecipients(Message.RecipientType.BCC,iaBCCList);
                 }
            //设置e-mail标题 
            message.setSubject(title);
            //设置e-mail发送时间
            message.setSentDate(new Date());
            //设置e-mail内容
//          message.setText(content);
            //建立第一部分：文本正文
            messageBodyPart.setContent(content, "text/html;charset=gbk");//给BodyPart对象设置内容和格式/编码方式    
            multipart.addBodyPart(messageBodyPart);
            if (!attachment.equals("")){
                // 建立第二部分：附件     
                messageBodyPart = new MimeBodyPart();
                // 获得附件
                DataSource source = new FileDataSource(attachment);
                //设置附件的数据处理器
                messageBodyPart.setDataHandler(new DataHandler(source));
                // 设置附件文件名
                messageBodyPart.setFileName(attachment);
                // 加入第二部分
                multipart.addBodyPart(messageBodyPart);
            }
            // 将多部分内容放到e-mail中
            message.setContent(multipart);
            //保存对于e-mail的修改
            message.saveChanges();
            //根据Session生成Transport对象
            transport = sendsession.getTransport("smtp");
            //连接到SMTP服务器
            transport.connect("smtp.163.com", "nicky_qianlei", "");
            //发送e-mail
            transport.sendMessage(message, message.getAllRecipients());
            //关闭Transport连接
            transport.close();
        } catch (MessagingException m){
            System.out.println(m.toString());
        } catch (Exception e){
            e.printStackTrace();
        } 
    }
    
    //获取收件人地址
    public String getMailList(String[] mailArray){
         
        StringBuffer toList = new StringBuffer();
        int length = mailArray.length;
        if(mailArray!=null && length <2){
             toList.append(mailArray[0]);
        }else{
             for(int i=0;i<length;i++){
                     toList.append(mailArray[i]);
                     if(i!=(length-1)){
                         toList.append(",");
                     }
             }
         }
     return toList.toString();
    }
    public static void main(String args[]){
     SendMail m = new SendMail();
//      m.SendMail2("Test", "D:\\tts.txt");
        m.SendMail2("Test", "");
        System.out.println("finished.");
    }
}