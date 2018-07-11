package ActiveSessionListener;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyActiveSessionListener
 *
 */
@WebListener
public class MyActiveSessionListener implements HttpSessionListener,ServletContextListener,HttpSessionBindingListener {
private static int numberOfActiveSessions;
ServletContext ctx=null;
static HashMap<String,SampleClass> map ;
private static final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

    /**
     * Default constructor. 
     */
    public MyActiveSessionListener() {
        // TODO Auto-generated constructor stub
    }
   /* public static int getActiveSessionListener(){
    	return numberOfActiveSessions;
    }*/

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		numberOfActiveSessions++;
		 HttpSession session = event.getSession();
		 ctx=event.getSession().getServletContext();
		ctx.setAttribute("numberOfActiveSessions", numberOfActiveSessions);
		//String SessionId = event.getSession().getId();
		//ctx.setAttribute("SessionId", SessionId);
		String date=df.format(new Date(session.getCreationTime()));
		ctx.setAttribute("date", date);
		//System.out.println("session created by ID: " +event.getSession().getId());
		//System.out.println("username: "+event.getClass().getName());
		//System.out.println("creation time: "+df.format(new Date(event.getSession().getCreationTime())));
		
	/*	synchronized(this){
			numberOfActiveSessions++;
		}*/
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		numberOfActiveSessions--;
		//map=new HashMap<String,SampleClass>();
		String username=(String) event.getSession().getAttribute("uname");
		ctx=event.getSession().getServletContext();
         ctx.setAttribute("InActiveSessions",username);
		for (Entry<String, SampleClass> entry : map.entrySet()) {
			if(entry.getKey().equals(username)){
		     map.remove(entry.getKey());
			}
		}
		
		
		// TODO Auto-generated method stub
		/*System.out.println("Session destroyed by Id : " +event.getSession().getId());
		System.out.println("username: "+event.getClass().getName());
		System.out.println("last Accessed Time: " +df.format(new Date(event.getSession().getLastAccessedTime())));
	     synchronized (this) {
	    	 numberOfActiveSessions--;
	}*/
		
	
}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
	ctx=event.getServletContext();
	map=new HashMap<String,SampleClass>();
	ctx.setAttribute("maps", map);
	//	ctx.setAttribute("map", map);
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		// Set< MyActiveSessionListener> logins = (Set< MyActiveSessionListener>) event.getSession().getServletContext().getAttribute("logins");
	     //   logins.add(this);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	//	Set<MyActiveSessionListener> logins = (Set<MyActiveSessionListener>) event.getSession().getServletContext().getAttribute("logins");
      //  logins.remove(this);
	}
}