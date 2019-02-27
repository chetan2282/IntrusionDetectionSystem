package com.bugswitch;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import algorithm.AESAlgorithm;
import algorithm.AESFileEncryption;
import algorithm.RandomString;

import com.util.DbConnection;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SentFiles
 */
@WebServlet("/SentFiles")
public class SentFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection con = null;
	final String UPLOAD_DIRECTORY = "D:\\building\\";
	static int i = 0;

	public void init(ServletConfig config) throws ServletException {
		try {
			con = DbConnection.getConnection();

		} catch (Exception e) {

			System.out.println("Exception in DB" + e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in do post");

		ArrayList<String> arr=new ArrayList<>();
		HttpSession session=request.getSession();
		String hid=(String)session.getAttribute("hid");
		
		
		if (ServletFileUpload.isMultipartContent(request)) 
		{
			System.out.println("1");
			
			
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
									
					System.out.println("ABCD");
					String FileName = "";
					String FileExtention = "";
					long FileSize = 0;
					int i=0;
					
					
					

					for (FileItem item1 : multiparts) 
					{
						if (!item1.isFormField()) 
						{

							System.out.println("4");
							String name = new File(item1.getName()).getName();
							item1.write(new File(UPLOAD_DIRECTORY + File.separator + name));
							FileName = item1.getName();
							FileExtention = item1.getContentType();
							FileSize = item1.getSize();
							arr.add(FileName);
							
						}
					}

					int iop=0;
					String f1="",f2="",f3="",f4="";
					for(String s:arr)
					{
						iop=iop+1;
						
						if(iop==1)
						{
							f1=s;
						}
						if(iop==2)
						{
							f2=s;
						}
						if(iop==3)
						{
							f3=s;
						}
						if(iop==4)
						{
							f4=s;
						}
						
					}
					
					String receiver = "",signature1="",signature2="",signature3="",signature4="";
					
					for (FileItem item : multiparts) 
					{
						if ((item.getFieldName()).equals("receiver")) 
						{
							receiver = (String) item.getString();
						}
					}
					for (FileItem item : multiparts) 
					{
						if ((item.getFieldName()).equals("signature1")) 
						{
							signature1 = (String) item.getString();
						}
					}
					for (FileItem item : multiparts) 
					{
						if ((item.getFieldName()).equals("signature2")) 
						{
							signature2 = (String) item.getString();
						}
					}
					for (FileItem item : multiparts) 
					{
						if ((item.getFieldName()).equals("signature3")) 
						{
							signature3 = (String) item.getString();
						}
					}
					
					for (FileItem item : multiparts) 
					{
						if ((item.getFieldName()).equals("signature4")) 
						{
							signature4 = (String) item.getString();
						}
					}
					System.out.println(signature1+" "+signature2+" "+signature3+" "+signature4);
					
					
						 BufferedReader br1 = new BufferedReader(new FileReader("D://building//"+f1));
					     BufferedReader br2 = new BufferedReader(new FileReader("D://building//"+f2));
					     BufferedReader br3 = new BufferedReader(new FileReader("D://building//"+f3));
					     BufferedReader br4 = new BufferedReader(new FileReader("D://building//"+f4));

			                   StringBuilder sb1 = new StringBuilder();
			                   StringBuilder sb2 = new StringBuilder();
			                   StringBuilder sb3 = new StringBuilder();
			                   StringBuilder sb4 = new StringBuilder();
			                   
			                   String line1 = br1.readLine();
			                   String line2 = br2.readLine();
			                   String line3 = br3.readLine();
			                   String line4 = br4.readLine();

			                   while (line1 != null) {
			                       sb1.append(line1);
			                       sb1.append(System.lineSeparator());
			                       line1 = br1.readLine();
			                   }

			                   while (line2 != null) {
			                       sb2.append(line2);
			                       sb2.append(System.lineSeparator());
			                       line2 = br2.readLine();
			                   }

			                   while (line3 != null) {
			                       sb3.append(line3);
			                       sb3.append(System.lineSeparator());
			                       line3 = br3.readLine();
			                   }

			                   while (line4 != null) {
			                       sb4.append(line4);
			                       sb4.append(System.lineSeparator());
			                       line4 = br4.readLine();
			                   }

			               br1.close();
			               br2.close();
			               br3.close();
			               br4.close();

			        ////applying AES to each file
			               
		           	RandomString RS = new RandomString();
		           	String RND = RS.generateRandomString();
		           	System.out.println("key : "+RND);
					AESAlgorithm aa = new AESAlgorithm();
					
					String d1 = sb1.toString();
					String encdata1 = aa.encrypt(d1, RND);
					
					String d2 = sb2.toString();
					String encdata2 = aa.encrypt(d2, RND);
					
					String d3 = sb3.toString();
					String encdata3 = aa.encrypt(d3, RND);
					
					String d4 = sb4.toString();
					String encdata4 = aa.encrypt(d4, RND);
					
					
					System.out.println("f1 "+f1);
					System.out.println("f2 "+f2);
					System.out.println("f3 "+f3);
					System.out.println("f4 "+f4);
					String username = (String)session.getAttribute("username");
					PreparedStatement ps=con.prepareStatement("INSERT INTO `files` (`username`, `file1`, `data1`, `file2`, `data2`, `file3`, `data3`, `file4`, `data4`, `receiver`,`signature1`,`signature2`,`signature3`,`signature4`,`encrypt1`,`encrypt2`,`encrypt3`,`encrypt4`) VALUES ('"+username+"','"+f1+"','"+sb1+"' , '"+f2+"','"+sb2+"', '"+f3+"','"+sb3+"','"+f4+"','"+sb4+"', '"+receiver+"','"+signature1+"','"+signature2+"','"+signature3+"','"+signature4+"','"+encdata1+"','"+encdata2+"','"+encdata3+"','"+encdata4+"')");
					
//					PreparedStatement ps = con.prepareStatement("INSERT INTO `files`(`username`, `receiver`, `file1`, `data1`, `signature1`, `file2`, `data2`, `signature2`, `file3`, `data3`, `signature3`, `file4`, `data4`, `signature4`) VALUES ('"+username+"','"+receiver+"','"+f1+"','"+sb1+"','"+signature1+"','"+f2+"','"+sb2+"','"+signature2+"','"+f3+"','"+sb3+"','"+signature3+"','"+f4+"','"+sb4+"','"+signature4+"')");
					
	//				PreparedStatement ps = con.prepareStatement("insert into files (username,receiver,file1,file2,file3,file4,data1) values ('"+username+"','"+receiver+"','"+f1+"','"+f2+"','"+f3+"','"+f4+"','"+sb1+"')");
					
					int rr=ps.executeUpdate();
					if(rr>0)
					{
						System.out.println("Data Insert Done");
						response.sendRedirect("upload.jsp?insert");
						
						
					}
					else
					{
						System.out.println("Data Insert Failed");
						
						response.sendRedirect("upload.jsp?insert=fail");
					}
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Occures "+e);	
			}
		}
		else {
			System.out.println("2");
		}
	}

}
