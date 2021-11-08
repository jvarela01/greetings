package com.redhat.gps.nola.grettings;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/greeting")
public class GreetingResource {
    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    }

    /*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/int")
    public String greetingLang() {
        return "Hello!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/int/{lang}")
    public String greetingLang(@PathParam String lang) {
        return service.greetingLang(lang);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/int/{lang}/{name}")
    public String greetingLang(@PathParam String lang, @PathParam String name) {
        return service.greetingLang(lang,name);
    }
    */
}