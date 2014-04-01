import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
	
    private static String USER_NAME = "sliwhu";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Hlyt&llbj529"; // GMail password
    private static String RECIPIENT = "kmhdtkxahyebx@tumblr.com";
	
	private static void sendfile(String title) throws FileNotFoundException, IOException{
		String body;
		String prefix="D:\\u\\1215272451\\";
		String filename=prefix+title;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			body = sb.toString();
		}
		String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = title.replace("nbsp", " ").replace(".txt", "");
//        System.out.println(subject);
        sendFromGMail(from, pass, to, subject, body);
	}

	   private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }
	
	public static void main(String[] args) throws FileNotFoundException,
			IOException, InterruptedException {
		final File folder = new File("D:\\u\\1215272451");
			File[] files=folder.listFiles();
			Arrays.sort(files, new Comparator<File>(){
			    public int compare(File f1, File f2)
			    {
			        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
			    } });
			for(int i=files.length-2; i<files.length; i++){
				sendfile(files[i].getName());
				System.out.println("post: "+files[i].getName());
				Thread.sleep(60000);
			}
	}

}