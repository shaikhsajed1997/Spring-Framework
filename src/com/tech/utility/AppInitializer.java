package com.tech.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext acwp=new AnnotationConfigWebApplicationContext();
		
		acwp.register(AppConfiguration.class);
		
		acwp.setServletContext(sc);
		
		ServletRegistration.Dynamic srd=sc.addServlet("DispatcherServlet", new DispatcherServlet(acwp));
		
		srd.addMapping("/");
	}

}
