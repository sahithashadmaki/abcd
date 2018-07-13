package ActiveSessionListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class MyServletRequestListener
 *
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
	ServletContext ctx=null;
	private static int numberOfRequests;
	private int numberOfErrorResponses=0;
	static HashMap<String,SampleClass> map;
    /**
     * Default constructor. 
     */
    public MyServletRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event)  { 
         // TODO Auto-generated method stub
    	 ctx=event.getServletContext();
    	 ServletRequest servletrequest=event.getServletRequest();
 		HttpServletRequest req=(HttpServletRequest) servletrequest;
 		HttpSession session=req.getSession();
    	 String paramvalue=(String) ctx.getAttribute("error");
    	//String username=(String) ((HttpServletRequest) event).getSession().getAttribute("uname");
    	 SampleClass classObj1=(SampleClass) session.getAttribute("classObj");
    	if(paramvalue!=null && paramvalue.equals("504")){
    		classObj1.increaseErrors();
			//numberOfErrorResponses++;
			session.setAttribute("classObj1", classObj1);
			//out.print("<br>Error Responses: "+errorResponses);
		//System.out.print(""+numberOfErrorResponses);
		}
    
		
		
		    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  { 
    	//numberOfRequests++;
      ctx=event.getServletContext();
		
		ServletRequest servletrequest=event.getServletRequest();
		HttpServletRequest req=(HttpServletRequest) servletrequest;
		HttpSession session=req.getSession();
		String ParamName = "error";
		String ParamValue=req.getParameter("error");
		//System.out.println("parameter value"+ParamValue);
		String username= (String) session.getAttribute("uname");
		ctx.setAttribute("error", ParamValue);
         //ctx.setAttribute("ParamName", ParamName); 
		//res.setStatus(ParamValue);
	/*	map=(HashMap<String, SampleClass>) ctx.getAttribute("maps");
		for (Entry<String, SampleClass> entry : map.entrySet()) {
			if(entry.getKey().equals(username)){
				numberOfRequests++;
			}
		}*/
		SampleClass classObj=(SampleClass) session.getAttribute("info");
	if(classObj!=null){
		classObj.increaseRequests();
			session.setAttribute("classObj", classObj);
			System.out.println("hello");
			
	}
		//session.setAttribute("numberOfRequests", numberOfRequests);
    }
	
}
