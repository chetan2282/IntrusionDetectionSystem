package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import algorithm.ReadFile;

import com.util.DbConnection;

import java.lang.*;

/**
 * Servlet implementation class Filter
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> arr = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Filter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void detect(String username, String receiver, String filename,
			String data, String signature) {

		System.out.println("in detect");
		System.out.println(filename + " " + data + " " + signature);
		try {

			Connection con = DbConnection.getConnection();
			PreparedStatement ps1 = con
					.prepareStatement("select * from anamaly_list");
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) {
				//System.out.println("anamaly +" + rs1.getString("anamaly"));
				arr.add(rs1.getString("anamaly"));
			}
			
			String check[] = new String[arr.size()];
		
			for (int k = 0; k < arr.size(); k++) {
				check[k] = arr.get(k);
				// System.out.println("check {} " + check[k]);
			
			
			}
			
			
			 
		
			PrintWriter pw = new PrintWriter("D://building//IDS//" + filename);

			pw.write(data);

			pw.close();

			Scanner fip = new Scanner(
					new File("D://building//IDS//" + filename));

			int f1 = 0, ff1 = 0;
			
			String level = "";

			while (fip.hasNext()) {
				String s1 = fip.next();
				s1 = s1.toLowerCase();

				for (int i = 0; i < check.length; i++) {
					//System.out.println("checking for : "+check[i]);
					if (s1.equals(check[i])) {
						f1 = 0;
						ff1 = 1;
						System.out.println("Detected :" + s1 + " in "+filename);
						
						PreparedStatement plevel = con.prepareStatement("select * from anamaly_list where anamaly='"+s1+"'");
						ResultSet rslevel = plevel.executeQuery();
						while(rslevel.next()){
						level = rslevel.getString("status");	
						}
						System.out.println("level : "+level);
						
						PreparedStatement psf1 = con
								.prepareStatement("insert into detected (username,receiver,filename,anamaly,signature,level) values(?,?,?,?,?,?)");
						psf1.setString(1, username);
						psf1.setString(2, receiver);
						psf1.setString(3, filename);
						psf1.setString(4, s1);
						psf1.setString(5, signature);
						psf1.setString(6, level);
						int r1 = psf1.executeUpdate();

						PreparedStatement psign = con.prepareStatement("select * from malicious_signatures where signature = '"+signature+"'");
						ResultSet rss = psign.executeQuery();
						int l = 0;
						while(rss.next()){
							l++;
						}
				
						if(l==0){
						PreparedStatement psign1 = con
								.prepareStatement("insert into malicious_signatures (signature) values ('"
										+ signature + "')");

						int rsign1 = psign1.executeUpdate();
						}
						
						break;
					}
				}

			}
			if (ff1 == 0) {
				// String filedata1 = rs.getString("data1");
				
				RandomString rand =  new RandomString();
				String salt = rand.generateRandomString();
				
				AESAlgorithm aes = new AESAlgorithm();
				String encrptdata = aes.encrypt(data, salt);
				PreparedStatement psf11 = con.prepareStatement("insert into destination_files (username,receiver,filename,data,signature) values('"
								+ username
								+ "','"
								+ receiver
								+ "','"
								+ filename
								+ "','"
								+ encrptdata
								+ "','"
								+ signature
								+ "')");

				int r11 = psf11.executeUpdate();

			}
			fip.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			// // call for signature detection

			Signature_detection sd = new Signature_detection();
			sd.doPost(request, response);
			// // end

			Connection con = DbConnection.getConnection();

			PreparedStatement psde = con
					.prepareStatement("delete from destination_files");

			int del = psde.executeUpdate();

			PreparedStatement psde1 = con
					.prepareStatement("delete from detected");

			int del1 = psde1.executeUpdate();

			PreparedStatement ps = con.prepareStatement("select * from files");

			ResultSet rs = ps.executeQuery();

			int f1 = 1, f2 = 1, f3 = 1, f4 = 1;
			int ff1 = 0, ff2 = 0, ff3 = 0, ff4 = 0;
			String filename1 = "", filename2 = "", filename3 = "", filename4 = "";
			String sign1 = "", sign2 = "", sign3 = "", sign4 = "";
			String username = "", receiver = "";
			String data1 = "", data2 = "", data3 = "", data4 = "";
			String d1 = "", d2 = "", d3 = "", d4 = "";
			while (rs.next()) {
				filename1 = rs.getString("file1");
				filename2 = rs.getString("file2");
				filename3 = rs.getString("file3");
				filename4 = rs.getString("file4");

				sign1 = rs.getString("signature1");
				sign2 = rs.getString("signature2");
				sign3 = rs.getString("signature3");
				sign4 = rs.getString("signature4");

				d1 = rs.getString("encrypt1");
				d2 = rs.getString("encrypt2");
				d3 = rs.getString("encrypt3");
				d4 = rs.getString("encrypt4");

			/*	System.out.println("d1 : "+d1);
				System.out.println("d2 : "+d2);
				System.out.println("d3 : "+d3);
				System.out.println("d4 : "+d4);
*/				

				RandomString rand = new RandomString();
				String salt = rand.generateRandomString();
				
				AESAlgorithm aes = new AESAlgorithm();
				
				data1 = aes.decrypt(d1, salt);
				data2 = aes.decrypt(d2, salt);
				data3 = aes.decrypt(d3, salt);
				data4 = aes.decrypt(d4, salt);
				
				
				/*System.out.println("data1 : "+data1);
				System.out.println("data2 : "+data2);
				System.out.println("data3 : "+data3);
				System.out.println("data4 : "+data4);*/
				
				/*
				 * System.out.println(filename1+" "+sign1+" "+filename2+" "+sign2
				 * +" "+filename3+" "+sign3+" "+sign4+" "+filename4+" "+sign4);
				 * 
				 * System.out.println("data1 "+data1);
				 * System.out.println("data2 "+data2);
				 * System.out.println("data3 "+data3);
				 * System.out.println("data4 "+data4);
				 */

				username = rs.getString("username");
				receiver = rs.getString("receiver");

				detect(username, receiver, filename1, data1, sign1);
				detect(username, receiver, filename2, data2, sign2);
				detect(username, receiver, filename3, data3, sign3);
				detect(username, receiver, filename4, data4, sign4);

			}

			// // abnormal behavior of malicious file

			PreparedStatement ps3 = con
					.prepareStatement("select * from destination_files order by rand() limit 1"); // select
																									// a
																									// file
																									// randomly
																									// form
																									// nnormal
																									// files
			String affect = "";
			ResultSet rs3 = ps3.executeQuery();
			while (rs3.next()) {
				affect = rs3.getString("filename");
				System.out
						.println("the file has been selected for abnormal behavior "
								+ affect);
			}

			try {
				String path = "D://building//" + affect + "+_changed.txt";
				BufferedWriter writer = new BufferedWriter(new FileWriter(path));
				PreparedStatement psinc = con
						.prepareStatement("select file from malicious order by rand() limit 1");
				ResultSet rsinc = psinc.executeQuery();
				if (rsinc.next()) {
					String a = rsinc.getString("file");
					writer.write(a);
					writer.close();
				}

				// /

			} catch (IOException e) {

				e.printStackTrace();
			}
			

			response.sendRedirect("singature_detection.jsp?filtered="+affect);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
