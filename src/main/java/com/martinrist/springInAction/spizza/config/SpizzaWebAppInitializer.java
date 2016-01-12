package com.martinrist.springInAction.spizza.config;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Programmatic configuration class for the Spizza sample web app.
 * This configuration maps the Spring DispatcherServlet to all URLs under /spizza
 */
public class SpizzaWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        ServletRegistration.Dynamic registration = container.addServlet("spizzaDispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(2);

        registration.addMapping("/spizza/*");
        registration.setInitParameter("contextConfigLocation", "/WEB-INF/classes/spring/springInAction/spizza/applicationContext-spizza.xml");

    }


    @Override
    protected String getServletName() {
        return "spizzaDispatcher";
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/spizza/*" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { };
    }

}
