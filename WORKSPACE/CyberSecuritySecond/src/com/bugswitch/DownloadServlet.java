package com.bugswitch;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DbConnection;

import algorithm.AESAlgorithm;
import algorithm.RandomString;


public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 Connection con=null;


	 private static final int BUFFER_SIZE = 4096;

	 //private final String UPLOAD_DIRECTORY = "E:\\Project_SRCCode\\Malicius_Destination\\WebContent\\DownloadedFiles\\";
	 private final String UPLOAD_DIRECTORY = "D:\\DownloadedFiles\\";
    public DownloadServlet() {
        super();
        
    }

	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("fileId");
		PrintWriter out=response.getWriter();
		System.out.println("id = "+id);

	 
	        RandomString rand =  new RandomString();
	        String salt =  rand.generateRandomString();
	        
	        AESAlgorithm aes =  new AESAlgorithm();
	        
	 
	        try {
	        	HttpSession session =request.getSession();
	        	
	            Connection conn = DbConnection.getConnection();
	 
	            String sql = "SELECT * FROM destination_files where id=?";
	            PreparedStatement statement = conn.prepareStatement(sql);
	           statement.setString(1, id);
	 
	            ResultSet result = statement.executeQuery();
	            if(result.next()) {
	            
	            	
	                //Blob blob = result.getBlob("data");
	            	
	            	String data = result.getString("data");
	            	System.out.println("data : "+data);
	            	String decrptd = aes.decrypt(data, salt);
	            	
	                String name=result.getString("filename");
	                
	                
	                System.out.println("decrptedddd : "+decrptd);
	                
	               /* session.setAttribute("filename", name);
	                AESFileDecryption.filedecrypt(s1, i1, o1,request);*/
	               
	               
	                
	                //----
	                
	                PrintWriter pw = new PrintWriter("D://"+name);
	                
	                pw.write(decrptd);
	                
	                pw.close();
	          
	              
	                out.println("<html>");
					out.println("<body>");
					out.println("<center>");				
					out.println("<h1 style='color:red;'>File Download Succesfully</h1>");
					out.println("<a href=home.jsp><h2>Back</h2></a>");
					out.println("<center>");
					out.println("</body>");
					out.println("</html>");
	            }
	            conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
