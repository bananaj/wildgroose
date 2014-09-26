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

public class GrooseServlet extends GroovyServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected GroovyScriptEngine createGroovyScriptEngine(){
        String[] roots = new String[] {"groovy/scripts", "groovy/classes"};
        try {
            return new GroovyScriptEngine(roots);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getScriptUri(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        String returnValue = request.getPathInfo();
        if (returnValue.startsWith("/")) {
            returnValue = returnValue.substring(1);
        }
        return returnValue;
    }


}
