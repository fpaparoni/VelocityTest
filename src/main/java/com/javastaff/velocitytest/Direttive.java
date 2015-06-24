package com.javastaff.velocitytest;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class Direttive {
    public static void main(String a[]) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("direttive.vm");
        
        VelocityContext context = new VelocityContext();
        context.put("header", "header.vm");
        context.put("livello", 6);
        context.put("luogo", "Roma");
        context.put("data", "08/06/2015");
        
        List<String> itemList=new ArrayList<String>();
        itemList.add("Item1");
        itemList.add("Item2");
        itemList.add("Item3");
        context.put("itemList", itemList);
        context.put("footer", "footer.vm");
        
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println(writer);
    }
}
