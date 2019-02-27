package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
 * Servlet implementation class Feature
 */
@WebServlet("/Feature")
public class Feature extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			
			try{
				Connection con = DbConnection.getConnection();
				
				PreparedStatement ps1 = con.prepareStatement("DELETE FROM `features_selection`");
				int rs2 =  ps1.executeUpdate();

				PreparedStatement ps =  con.prepareStatement("select * from instance");
				
				int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c10=0,c11=0,c12=0;
				int c13=0,c14=0,c15=0,c16=0,c17=0,c18=0,c19=0,c20=0,c21=0,c22=0,c23=0;
				int c24=0,c25=0,c26=0,c27=0,c28=0,c29=0,c30=0,c31=0,c32=0,c33=0,c34=0,c35=0,c36=0,c37=0;
				int c38=0,c39=0,c40=0,c41=0,c42=0,c43=0,c44=0,c45=0;
				
				String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "";
				String j = "", k = "", l = "", m = "", n = "", o = "", p = "", q = "", r = ""; 
				String s = "", t = "", u = "", v = "", w = "", x = "", y = "", z = "";
				String aa = "", ab = "", ac = "", ad = "", ae = "", af = "", ag = "", ah = "", ai = "";
				String aj = "", ak = "", al = "", am = "", an = "", ao = "", ap = "", aq = "";
				
				String val = "0";
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					a = rs.getString("a");
					if(a.equalsIgnoreCase(val)){
						c1++;
					}
					b = rs.getString("b");
					if(b.equalsIgnoreCase(val)){
						c2++;
					}
					c = rs.getString("c");
					if(c.equalsIgnoreCase(val)){
						c3++;
					}
					d = rs.getString("d");
					if(d.equalsIgnoreCase(val)){
						c4++;
					}
					e = rs.getString("e");
					if(e.equalsIgnoreCase(val)){
						c5++;
					}
					f = rs.getString("f");
					if(f.equalsIgnoreCase(val)){
						c6++;
					}
					g = rs.getString("g");
					if(g.equalsIgnoreCase(val)){
						c7++;
					}
					h = rs.getString("h");
					if(h.equalsIgnoreCase(val)){
						c8++;
					}
					i = rs.getString("i");
					if(i.equalsIgnoreCase(val)){
						c9++;
					}
					j = rs.getString("j");
					if(j.equalsIgnoreCase(val)){
						c10++;
					}
					k = rs.getString("k");
					if(k.equalsIgnoreCase(val)){
						c11++;
					}
					l = rs.getString("l");
					if(l.equalsIgnoreCase(val)){
						c12++;
					}
					m = rs.getString("m");
					if(m.equalsIgnoreCase(val)){
						c13++;
					}
					n = rs.getString("n");
					if(n.equalsIgnoreCase(val)){
						c14++;
					}
					o = rs.getString("o");
					if(o.equalsIgnoreCase(val)){
						c15++;
					}
					p = rs.getString("p");
					if(p.equalsIgnoreCase(val)){
						c16++;
					}
					q = rs.getString("q");
					if(q.equalsIgnoreCase(val)){
						c17++;
					}
					r = rs.getString("r");
					if(r.equalsIgnoreCase(val)){
						c18++;
					}
					s = rs.getString("s");
					if(s.equalsIgnoreCase(val)){
						c19++;
					}
					t = rs.getString("t");
					if(t.equalsIgnoreCase(val)){
						c20++;
					}
					u = rs.getString("u");
					if(u.equalsIgnoreCase(val)){
						c21++;
					}
					v = rs.getString("v");
					if(v.equalsIgnoreCase(val)){
						c22++;
					}
					w = rs.getString("w");
					if(w.equalsIgnoreCase(val)){
						c23++;
					}
					x = rs.getString("x");
					if(x.equalsIgnoreCase(val)){
						c24++;
					}
					y = rs.getString("y");
					if(y.equalsIgnoreCase(val)){
						c25++;
					}
					z = rs.getString("z");
					if(z.equalsIgnoreCase(val)){
						c26++;
					}
					aa = rs.getString("aa");
					if(aa.equalsIgnoreCase(val)){
						c27++;
					}
					ab = rs.getString("bb");
					if(ab.equalsIgnoreCase(val)){
						c28++;
					}
					ac = rs.getString("cc");
					if(ac.equalsIgnoreCase(val)){
						c29++;
					}
					ad = rs.getString("dd");
					if(ad.equalsIgnoreCase(val)){
						c30++;
					}
					ae = rs.getString("ee");
					if(ae.equalsIgnoreCase(val)){
						c31++;
					}
					af = rs.getString("ff");
					if(af.equalsIgnoreCase(val)){
						c32++;
					}
					ag = rs.getString("gg");
					if(ag.equalsIgnoreCase(val)){
						c33++;
					}
					ah = rs.getString("hh");
					if(ah.equalsIgnoreCase(val)){
						c34++;
					}
					ai = rs.getString("ii");
					if(ai.equalsIgnoreCase(val)){
						c35++;
					}
					aj = rs.getString("jj");
					if(aj.equalsIgnoreCase(val)){
						c36++;
					}
					ak = rs.getString("kk");
					if(ak.equalsIgnoreCase(val)){
						c37++;
					}
					al = rs.getString("ll");
					if(al.equalsIgnoreCase(val)){
						c38++;
					}
					
					am = rs.getString("mm");
					if(am.equalsIgnoreCase(val)){
						c39++;
					}
					an = rs.getString("nn");
					if(an.equalsIgnoreCase(val)){
						c40++;
					}
					ao = rs.getString("oo");
					if(ao.equalsIgnoreCase(val)){
						c41++;
					}
					ap = rs.getString("pp");
					if(ap.equalsIgnoreCase(val)){
						c42++;
					}
					aq = rs.getString("qq");
					if(aq.equalsIgnoreCase(val)){
						c43++;
					}

					
//					PreparedStatement ps2 = con.prepareStatement("insert into features_selection");
					
		
					PreparedStatement psi = con.prepareStatement("INSERT INTO "
	+ "`features_selection` (`a`, `b` ,`c` ,`d` ,`e` ,`f` ,`l` ,`w` ,`x`,`y`,`aa`,`ab`,`ac`,`ad`,`ae`,`af`,`ag` ,`ah` ,`ai` ,`aj` ,`ak`,`al`,`am`,`an`,`ao`,`ap`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
											psi.setString(1, a);
											psi.setString(2, b);
											psi.setString(3, c);
											psi.setString(4, d);
											psi.setString(5, e);
											psi.setString(6, f);
											psi.setString(7, l);
											psi.setString(8, w);
											psi.setString(9, x);
											psi.setString(10, y);
											psi.setString(11, ab);
											psi.setString(12, ab);
											psi.setString(13, ac);
											psi.setString(14, ad);
											psi.setString(15, ae);
											psi.setString(16, af);
											psi.setString(17, ag);
											psi.setString(18, ah);
											psi.setString(19, aj);
											psi.setString(20, ak);
											psi.setString(21, al);
											psi.setString(22, am);
											psi.setString(23, an);
											psi.setString(24, ao);
											psi.setString(25, ap);
											psi.setString(26, aq);										
											int rr = psi.executeUpdate();
											

					////// end of insertion
				
				}
				
				System.out.println("a : "+c1);
				System.out.println("b : "+c2);
				System.out.println("c : "+c3);
				System.out.println("d : "+c4);
				System.out.println("e : "+c5);
				System.out.println("f : "+c6);
				System.out.println("g : "+c7);
				System.out.println("h : "+c8);
				System.out.println("i : "+c9);
				System.out.println("j : "+c10);
				System.out.println("k : "+c11);
				System.out.println("l : "+c12);
				System.out.println("m : "+c13);
				System.out.println("n : "+c14);
				System.out.println("o : "+c15);
				System.out.println("p : "+c16);
				System.out.println("q : "+c17);
				System.out.println("r : "+c18);
				System.out.println("s : "+c19);
				System.out.println("t : "+c20);
				System.out.println("u : "+c21);
				System.out.println("v : "+c22);
				System.out.println("w : "+c23);
				System.out.println("x : "+c24);
				System.out.println("y : "+c25);
				System.out.println("z : "+c26);
				System.out.println("aa : "+c27);
				System.out.println("ab : "+c28);
				System.out.println("ac : "+c29);
				System.out.println("ad : "+c30);
				System.out.println("ae : "+c31);
				System.out.println("af : "+c32);
				System.out.println("ag : "+c33);
				System.out.println("ah : "+c34);
				System.out.println("ai : "+c35);
				System.out.println("aj : "+c36);
				System.out.println("ak : "+c37);
				System.out.println("al : "+c38);
				System.out.println("am : "+c39);
				System.out.println("an : "+c40);
				System.out.println("ao : "+c41);
				System.out.println("ap : "+c42);
				System.out.println("aq : "+c43);
				
				//////////insertion
				
				
				

				
				
				response.sendRedirect("featuers.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
			

				
			
		}
		System.out.println("in servlet");
		// ReadXLS.readxls();

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
