package io.hackfest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Path("/hello")
public class GreetingResource {

    @Inject
    StreamProducer streamProducer;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws ExecutionException, InterruptedException, TimeoutException {
        streamProducer.sendReceiptEvent();
        return "Hello from RESTEasy Reactive";
    }
}