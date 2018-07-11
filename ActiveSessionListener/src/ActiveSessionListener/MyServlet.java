package ActiveSessionListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import ActiveSessionListener.MyActiveSessionListener;

//import SampleServletContextListener.SampleClass;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   static HashMap<String,SampleClass> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(){
    	map = (HashMap) getServletConfig().getServletContext().getAttribute("maps");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				response.setContentType("text/html");
				 PrintWriter out = response.getWriter();
				 String uname=request.getParameter("uname");
				
				   
				   String pass=request.getParameter("pass");
				
				  if(pass!=null && pass.equals("1234")){
					  
					  HttpSession session = request.getSession();
					session.setAttribute("uname", uname);
					 
					  
					  //session.setMaxInactiveInterval(30);
				
				  
			 
				   ServletContext ctx=getServletContext();  
				   SampleClass info =new SampleClass();
			     
			        //String Id=(String)ctx.getAttribute("SessionId");
			       // info.setId(Id);
			      info.setUserName(uname);
			      String name=info.getUserName();
			     
			     String date=(String) ctx.getAttribute("date");
			     info.setDate(date);
			    
			     //String creationTime=info.getDate();
			     //int requests=(Integer)session.getAttribute("numberOfRequests");
					//out.print("<br>Requests: "+requests);
					//info.setRequests(requests);
				//	String inactive=(String) ctx.getAttribute("InActiveSessions");
					//int errors=(Integer)session.getAttribute("numberOfErrorResponses");
					//info.setErrorCount(errors);
			     map.put(name,info);
			     session.setAttribute("info",info);
			     request.setAttribute("FinalMap", map);
				 getServletContext().getRequestDispatcher("/table.jsp").include(request, response);	
				  }
			      //out.print(" " +map.get(info));
			     /* for (Entry<String, SampleClass> entry : map.entrySet()) {
			    	
			    	  out.print("<br>unsername: "+entry.getValue().getUserName());
			    	  out.print("<br>id: "+entry.getValue().getId());
			    	  
			    	  out.print("<br>creation time: "+entry.getValue().getDate());
			    	  out.print("<br>no.of requests:"+entry.getValue().getRequests());
			    	}*/
			    	
			    //  out.print(" <br>   Id: "+Id);
			      //  Enumeration users=getServletContext().getAttributeNames();
			      //  out.print("username" +name);
			      //  out.print("<br> id:" +session.get);
				
				//out.print("<br><h4>In Active Sessions" +inactive);
				//String paramvalue=(String) ctx.getAttribute("ParamValue");
				
			/*	*/
				
				
				 /*String user=entry.getKey();
			    	info.setUserName(user);
			    	String id=entry.getValue();
			    	info.setId(id);*/
			    	  //  out.print("<br> username: " + entry.getKey()+"<br> Id: "+entry.getValue());
				//int responses=(Integer)ctx.getAttribute("numberOfErrorResponses");
				//out.print("<br>error responses: "+responses);
				/*  try {
				   out.println("<html>");
				   out.println("<body>");
				   out.println("<tr>"+
				   "<th>Number of active sessions</th>" +
						   "<th>Requests</th>"+
						   "<th>users</th>" +
				       "</h2>" +
				      "</tr>");
				   out.println("</body>");
				   out.println("</html>");
				  } finally {
				   out.close();
				  }*/
			        out.close();

		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}