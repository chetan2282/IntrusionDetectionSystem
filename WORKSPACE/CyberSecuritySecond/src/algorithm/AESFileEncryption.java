package algorithm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class AESFileEncryption {

	
	public void fileEncrypt(File path) throws Exception{
		System.out.println("in eeeeeeeeeecrypt");
		 FileReader file = new FileReader (path);
		    BufferedReader reader = new BufferedReader(file);
System.out.println("1");
		    String text = "";
		    String line = reader.readLine();
		    while(line !=null)
		    {
		        text +=line; 
		        line = reader.readLine();
		    }
		    System.out.println("2");
		    AESAlgorithm tes = new AESAlgorithm();
		    String test = tes.encrypt(text,"mySalt");
		    System.out.println("Encrypted : " + test);
		    
		    System.out.println("3");
		    
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(test);
			bw.close();

		    
			System.out.println("4");
		
		
		
	}
	
	public void fileDecrypt(File path,String seckey) throws Exception{
		
		FileReader file = new FileReader (path);
	    BufferedReader reader = new BufferedReader(file);
	    System.out.println("in ddddddddddecrypt");
	    String text = "";
	    String line = reader.readLine();
	    while(line !=null)
	    {
	        text +=line; 
	        line = reader.readLine();
	    }
	    System.out.println("1");
	    
	    AESAlgorithm tes = new AESAlgorithm();
	    String test = tes.decrypt(text,"kirankirankirana");
	   // String test = tes.decrypt(text,"mySalt");
	    System.out.println("Decrypted : " + test);
	    
	    System.out.println("2");
	    
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(test);
		bw.close();
		reader.close();

		
		System.out.println("3");
		
	}
	public static void main(String[] args) throws Exception{
		
		AESFileEncryption en = new AESFileEncryption();
		File file = new File("C://apache-tomcat-7.0.42//tmpfiles//file.txt");
		//en.fileDecrypt(file);
	}
	
	
}
