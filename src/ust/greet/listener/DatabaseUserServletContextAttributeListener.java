package ust.greet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import ust.greet.model.UserBean;

public class DatabaseUserServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		
		if(scae.getName().equals("user")) {
			System.out.println("ALERT. A new attribute has been added to context. Key: "
									+ scae.getName()
									+ " Value: " + ((UserBean) scae.getValue()).getfName());
		}else {
			System.out.println("ALERT. A new attribute has been added to context. Key: "
									+ scae.getName() 
									+ " Value: " + scae.getValue());
		}

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		
		if(scae.getName().equals("user")) {
			System.out.println("ALERT. A new attribute has been removed from context. Key: "
									+ scae.getName()
									+ " Value: " + ((UserBean) scae.getValue()).getfName());
		}else {
			System.out.println("ALERT. A new attribute has been removed from context. Key: "
									+ scae.getName() 
									+ " Value: " + scae.getValue());
		}

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {

		if(scae.getName().equals("user")) {
			System.out.println("ALERT. A new attribute has been replaced from context. Key: "
									+ scae.getName()
									+ " Value: " + ((UserBean) scae.getValue()).getfName());
		}else {
			System.out.println("ALERT. A new attribute has been replaced context. Key: "
									+ scae.getName() 
									+ " Value: " + scae.getValue());
		}

	}

}
