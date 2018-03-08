package ust.greet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserHttpSessionListenerCount implements HttpSessionListener {
	
	static int userCount = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		userCount++;
		
		HttpSession session = hse.getSession();
		System.out.print("A new session was created: " + session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		userCount--;
		
		HttpSession session = hse.getSession();
		System.out.println("A session was destroyed: " + session.getId());
	}
	
	public static int getUserCount() {
		return userCount;
	}

}
