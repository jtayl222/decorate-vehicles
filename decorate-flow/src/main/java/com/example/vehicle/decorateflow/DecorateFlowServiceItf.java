package com.example.vehicle.decorateflow;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.example.vehicle.datamodel.Car;

@RegisterRestClient(configKey="decorate-car-color")
@Path("/v1")
public interface DecorateFlowServiceItf {
    @POST
    @Path("/decorate-car-color")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Car updateCar(Car carToSend);
}
