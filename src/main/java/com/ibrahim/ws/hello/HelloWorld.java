package com.ibrahim.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.logging.Logger;

/**
 * Created by ibrahim on 3/22/18.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class HelloWorld {

    private static final Logger LOG =Logger.getLogger(HelloWorld.class.getName());

    @WebMethod
    public String say(String name){
        LOG.info("Web service is called!");
        return String.format("Hello,  %s!", name);
    }

    public static void main(String[] args){
        String msg = new HelloWorld().say("Ibrahim");
        LOG.info(msg);
    }

}
