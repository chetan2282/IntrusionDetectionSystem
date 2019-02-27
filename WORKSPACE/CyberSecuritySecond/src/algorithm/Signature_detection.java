package algorithm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

/**
 * Servlet implementation class Signature_detection
 */
@WebServlet("/Signature_detection")
public class Signature_detection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signature_detection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			Connection con = DbConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from destination_files");
			
			ResultSet rs = ps.executeQuery();
			String fname = "";
			String sign ="";
			int ff= 0;
			String username ="", receiver ="", anamaly = "not found";
			while(rs.next()){
				sign = rs.getString("signature");
				username = rs.getString("username");
				receiver = rs.getString("receiver");
				PreparedStatement ps1 = con.prepareStatement("select * from malicious_signatures where signature = '"+sign+"'");
				
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{
					ff++;
					fname = rs.getString("filename");
					System.out.println("malicioius signature detection : "+sign+" "+fname);
					
					PreparedStatement psdelete = con.prepareStatement("delete from destination_files where filename = '"+fname+"'");
					int del = psdelete.executeUpdate();
					System.out.println("dekee");
					PreparedStatement psisrt = con.prepareStatement("insert into detected (filename,username,receiver,anamaly) values('"+fname+"','"+username+"','"+receiver+"','"+anamaly+"')");
					int de = psisrt.executeUpdate();
					System.out.println("dekeelllllll");
					
						
					
					break;
				}
			}
			if(ff==0){
				System.out.println("not");
			}
			
			response.sendRedirect("singature_detection.jsp?signature");
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

try{
			
			Connection con = DbConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from destination_files");
			
			ResultSet rs = ps.executeQuery();
		
			String sign ="";
			int ff= 0;
			while(rs.next()){
				sign = rs.getString("signature");
				
				PreparedStatement ps1 = con.prepareStatement("select * from malicious_signatures where signature = '"+sign+"'");
				
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{
					ff++;
				
					System.out.println("malicioius signature detection : "+sign);
					break;
				}
			}
			if(ff==0){
				System.out.println("not");
			}
			
//			response.sendRedirect("singature_detection.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	
	
	}

}
