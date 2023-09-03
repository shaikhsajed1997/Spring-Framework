package com.tech.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext ap=new AnnotationConfigWebApplicationContext();
		
		ap.register(AppConfigure.class);
		
		ap.setServletContext(sc);
	
		ServletRegistration.Dynamic srd=sc.addServlet("DispatcherServlet", new DispatcherServlet(ap));
		
		srd.addMapping("/");
		
	}

}
