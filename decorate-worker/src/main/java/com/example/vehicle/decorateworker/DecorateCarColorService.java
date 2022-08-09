package com.example.vehicle.decorateworker;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.vehicle.datamodel.Car;


@Path("/v1")
public class DecorateCarColorService {
    Logger log = LoggerFactory.getLogger(DecorateCarColorService.class);
   
    @POST
    @Path("/decorate-car-color")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCarColor(Car car) {
        log.info("car is {}", car);
        car.setColor("Color attribute has been decorated");
        return car;
    }
}
