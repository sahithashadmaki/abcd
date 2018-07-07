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
	
	    HashMap<String,String> map;
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		  //  map = (HashMap) getServletConfig().getServletContext().getAttribute("map");
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String uname=request.getParameter("uname");
		 System.out.println(""+uname);
		 
	/*	  PrintWriter out = response.getWriter();
		   
		   String pass=request.getParameter("pass");
		   //String[] str=request.getRequestURI().split("?");
			//int length=UrlPath.length;
		   System.out.println(""+uname+ " " +pass);
		  if(pass.equals("1234")){
			  HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			 //out.println("username : "+uname);
			  
			  //session.setMaxInactiveInterval(30);
		  }
		  
		   ServletContext ctx=getServletContext();  
		   SampleClass info =new SampleClass();
	        int ActiveSessions=(Integer)ctx.getAttribute("numberOfActiveSessions");  
	     //   String name=(String) .getAttribute("uname");
	        out.print("<br><h4>Active Sessions</h4>"+ActiveSessions); 
	        String Id=(String)ctx.getAttribute("SessionId");
	     	       // out.print("<br>id: </br>"+id);
	        //SampleClass map=(SampleClass)getServletContext().getAttribute("maps");
	      
	      info.setUserName(uname);
	      String name=info.getUserName();
	      map.put(name,Id);
	     
	      //out.print(" " +map.get(info));
	      for (Entry<String, String> entry : map.entrySet()) {
	    	    out.print("<br> username: " + entry.getKey()+"<br> Id: "+entry.getValue());
	    	}
	    //  out.print(" <br>   Id: "+Id);
	      //  Enumeration users=getServletContext().getAttributeNames();
	      //  out.print("username" +name);
	      //  out.print("<br> id:" +session.get);
		int requests=(Integer)ctx.getAttribute("numberOfRequests");
		out.print("<br>Requests: "+requests);
		
		String inactive=(String) ctx.getAttribute("InActiveSessions");
		out.print("<br><h4>In Active Sessions</h4>" +inactive);*/
		//String paramvalue=(String) ctx.getAttribute("ParamValue");
		
		String paramvalue=(String)getServletContext().getAttribute("error");
		int errorResponses=0;
		
		if(paramvalue!=null && paramvalue.equals("504")){
			errorResponses++;
			out.print("<br>Error Responses: "+errorResponses);
		
		}
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
}