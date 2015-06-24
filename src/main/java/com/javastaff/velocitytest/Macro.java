package com.javastaff.velocitytest;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class Macro {
    public static void main(String a[]) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("macro.vm");
        
        List<Utente> utenteList=listUtenti();
        
        VelocityContext context = new VelocityContext();
        context.put("utenteList", utenteList);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println(writer);
    }
    
    public static List<Utente> listUtenti() {
        List<Utente> utenteList=new ArrayList<Utente>();
        
        Utente utente=new Utente();
        utente.setCognome("Rossi");
        utente.setNome("Mario");
        utente.setCodiceFiscale("1234567890");
        utenteList.add(utente);
        
        Utente utente2=new Utente();
        utente2.setCognome("Bianchi");
        utente2.setNome("Andrea");
        utente2.setCodiceFiscale("0987654321");
        utenteList.add(utente2);
        
        return utenteList;
    }
}
