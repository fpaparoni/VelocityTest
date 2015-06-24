package com.javastaff.velocitytest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class LoadInputStream {
    public static void main(String a[]) {
        VelocityContext context = new VelocityContext();
        context.put("input", "una stringa");

        StringWriter swOut = new StringWriter();
        Reader templateReader = new BufferedReader(
                  new InputStreamReader(load()));
        
        Velocity.evaluate(context, swOut, "logTag", templateReader);
        System.out.println(swOut);
    }
    
    public static InputStream load() {
        String template=new String("Caricato da $input");
        ByteArrayInputStream bais=new ByteArrayInputStream(template.getBytes());
        return bais;
    }
}
