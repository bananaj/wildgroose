package bananaj.web.servlet;

import groovy.servlet.GroovyServlet;
import groovy.util.GroovyScriptEngine;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Properties;

public class GrooseServlet extends GroovyServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected GroovyScriptEngine createGroovyScriptEngine(){
        String propertiesFilename = getServletConfig().getServletName() + "-gse.properties";
        getServletContext().log("Loading: " + propertiesFilename);
        GroovyScriptEngine returnValue = null;

        try {
           InputStream in = getClass().getClassLoader().getResourceAsStream(propertiesFilename);
            if (in != null) {
                Properties props = new Properties();
                props.load(in);
                String roots = props.getProperty("gse.roots");
                if (roots != null) {
                    String[] rootPaths = roots.split(",");
                    if (rootPaths.length > 0) {
                        String[] cleaned = new String[rootPaths.length];
                        for(int i = 0 ; i<rootPaths.length; i++) {
                            cleaned[i] = rootPaths[i].trim();
                        }
                        returnValue = new GroovyScriptEngine(cleaned);
                        getServletContext().log("Loaded gse.roots: " + roots + " from: " + propertiesFilename);
                    }
                    getServletContext().log("Invalid configuration: cannot split gse.roots: " + roots + " in: " + propertiesFilename);
                }
                else {
                    getServletContext().log("Invalid configuration: no gse.roots in: " + propertiesFilename);
                }
            }
            else {
                getServletContext().log("No configuration: " + propertiesFilename);
            }

            if (returnValue == null) {
                returnValue = super.createGroovyScriptEngine();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return returnValue;
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
