package bananaj.web.servlet;

import groovy.lang.GroovyClassLoader;
import groovy.servlet.GroovyServlet;
import groovy.servlet.ServletBinding;
import groovy.util.GroovyScriptEngine;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Collection;

/**
 * Created by cio on 25/09/14.
 */
public class GrooseSpringServlet extends GrooseServlet {

    private ApplicationContext applicationContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());

    }

    @Override
    protected void setVariables(ServletBinding binding) {
        binding.setVariable("applicationContext", applicationContext);
    }
}
