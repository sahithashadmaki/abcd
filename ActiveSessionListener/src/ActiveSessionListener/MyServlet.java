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
			     
			      
			      info.setUserName(uname);
			      String name=info.getUserName();
			     
			     String date=(String) ctx.getAttribute("date");
			     info.setDate(date);
			  
			     map.put(name,info);
			     session.setAttribute("info",info);
			     request.setAttribute("FinalMap", map);
				 getServletContext().getRequestDispatcher("/table.jsp").include(request, response);	
				 
				  }
			   
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