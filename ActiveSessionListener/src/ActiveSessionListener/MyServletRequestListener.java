package ActiveSessionListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class MyServletRequestListener
 *
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
	ServletContext ctx=null;
	private static int numberOfRequests;
	private static int numberOfErrorResponses;
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
		    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  { 
      numberOfRequests++;
      ctx=event.getServletContext();
		ctx.setAttribute("numberOfRequests", numberOfRequests);
		ServletRequest servletrequest=event.getServletRequest();
		HttpServletRequest req=(HttpServletRequest) servletrequest;
		//String ParamName = "error";
		//String ParamValue=req.getParameter("error");
		//System.out.println("parameter value"+ParamValue);
		
		//ctx.setAttribute("error", ParamValue);
         //ctx.setAttribute("ParamName", ParamName);   
         
    }
	
}
