package com.nicky.practice.others;

/*****************************************************
* 
copy form Baidu and Modified.
* @modify Nicky- Qianlei
* 
* ��������ʾ��ʹ��javamail����html��ʽ�ʼ���
* 
* �ֱ��Է��ʹ���Ͳ����������ʽ��ʾ
* 
* ͬʱʵ��������˷��ʼ�
*****************************************************/
public class SendMail{
//    @SuppressWarnings("static-access")
//public void SendMail2(String title, String attachment){
//        // ������ԣ������Session���� 
//        Properties props = new Properties();
//        Session sendsession;
//        Transport transport;
//        MimeMessage message = null;
//        BodyPart messageBodyPart = new MimeBodyPart();
//        Multipart multipart = new MimeMultipart();
//        String from = "nicky_qianlei@163.com";
//        String to[]={"nicky_qianlei@163.com"};
//        String cc[] = {""};
//        String bcc[] = {""};
//        String s = "<font style=\"BACKGROUND-COLOR: #666699\" color=\"#ff0000\" size=\"5\">���Ը�ʽ�����ݲ���<a href=\"\">��ʽ������</a>���Ը�<em>ʽ��</em>����</font>";
//        String content = "<div>Rule Name : </div><div>Rule Description : <div><table border = \"1\" cellpadding = \"10\" cellspacing = \"0\" style = \"border-collapse: collapse;\"><tr><th>zero count</th><th>14 days average</th><th>change</th></tr><tbody><tr><td>15.00</td><td>20.00</td><td>-10%</td></tr></tbody></table>";
//        
//        try{
//            sendsession = Session.getInstance(props, null);
//            //��������д��SMTP�������ĵ�ַ
//            props.put("mail.smtp.host", "smtp.163.com");
//            //����SMTP��������ҪȨ����֤
//            props.put("mail.smtp.auth", "true");
//            //�����������
//            sendsession.setDebug(true);
//            //���Session���Message����
//            message = new MimeMessage(sendsession);
//            //���÷����˵�ַ
//            message.setFrom(new InternetAddress(from));
//            //���������˵�ַ
//            String toList = getMailList(to);
//            InternetAddress[] iaToList = new InternetAddress().parse(toList);
//            message.setRecipients(Message.RecipientType.TO,iaToList);
//            if (cc != null){
//                String ccList = this.getMailList(cc);
//                    InternetAddress[] iaCCList = new InternetAddress().parse(ccList);
//                message.setRecipients(Message.RecipientType.CC,iaCCList);
//                 }
//            if (bcc != null){
//                String bccList = this.getMailList(bcc);
//                    InternetAddress[] iaBCCList = new InternetAddress().parse(bccList);
//                message.setRecipients(Message.RecipientType.BCC,iaBCCList);
//                 }
//            //����e-mail���� 
//            message.setSubject(title);
//            //����e-mail����ʱ��
//            message.setSentDate(new Date());
//            //����e-mail����
////          message.setText(content);
//            //������һ���֣��ı�����
//            messageBodyPart.setContent(content, "text/html;charset=gbk");//��BodyPart�����������ݺ͸�ʽ/���뷽ʽ    
//            multipart.addBodyPart(messageBodyPart);
//            if (!attachment.equals("")){
//                // �����ڶ����֣�����     
//                messageBodyPart = new MimeBodyPart();
//                // ��ø���
//                DataSource source = new FileDataSource(attachment);
//                //���ø�������ݴ�����
//                messageBodyPart.setDataHandler(new DataHandler(source));
//                // ���ø����ļ���
//                messageBodyPart.setFileName(attachment);
//                // ����ڶ�����
//                multipart.addBodyPart(messageBodyPart);
//            }
//            // ���ಿ�����ݷŵ�e-mail��
//            message.setContent(multipart);
//            //�������e-mail���޸�
//            message.saveChanges();
//            //���Session���Transport����
//            transport = sendsession.getTransport("smtp");
//            //���ӵ�SMTP������
//            transport.connect("smtp.163.com", "nicky_qianlei", "");
//            //����e-mail
//            transport.sendMessage(message, message.getAllRecipients());
//            //�ر�Transport����
//            transport.close();
//        } catch (MessagingException m){
//            System.out.println(m.toString());
//        } catch (Exception e){
//            e.printStackTrace();
//        } 
//    }
//    
//    //��ȡ�ռ��˵�ַ
//    public String getMailList(String[] mailArray){
//         
//        StringBuffer toList = new StringBuffer();
//        int length = mailArray.length;
//        if(mailArray!=null && length <2){
//             toList.append(mailArray[0]);
//        }else{
//             for(int i=0;i<length;i++){
//                     toList.append(mailArray[i]);
//                     if(i!=(length-1)){
//                         toList.append(",");
//                     }
//             }
//         }
//     return toList.toString();
//    }
//    public static void main(String args[]){
//     SendMail m = new SendMail();
////      m.SendMail2("Test", "D:\\tts.txt");
//        m.SendMail2("Test", "");
//        System.out.println("finished.");
//    }
}