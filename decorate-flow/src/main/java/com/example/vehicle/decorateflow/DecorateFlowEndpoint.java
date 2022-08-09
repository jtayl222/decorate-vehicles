package com.example.vehicle.decorateflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.vehicle.datamodel.Vehicle;
import com.example.vehicle.datamodel.Car;


@Path("/v1")
@ApplicationScoped
public class DecorateFlowEndpoint {
    Logger log = LoggerFactory.getLogger(DecorateFlowEndpoint.class);

    @Inject
    @RestClient
    DecorateFlowServiceItf service;

    @POST
    @Path("/decorate-flow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<Vehicle>>  decorateFlow(Map<String, List<Vehicle>>  vehicleRequestGroups){
        log.info("hello from decorateFlow");
        Map<String, List<Vehicle>> vehicleResponseGroups = new HashMap<>();
        
        for (Map.Entry<String,List<Vehicle>> vehicleRequestGroup : vehicleRequestGroups.entrySet()) {
            log.info("vehicleRequestGroup is {}", vehicleRequestGroup.getKey());
            
            List<Vehicle> vehicleListOut = new ArrayList<>();
            for (Vehicle vehicle : vehicleRequestGroup.getValue()) {
                if (vehicle instanceof Car) {
                    log.info("Vehicle is {}", vehicle);
                    vehicleListOut.add(service.updateCar((Car)vehicle));
                } else {
                    vehicleListOut.add(vehicle);
                }
                
            }
            vehicleResponseGroups.put(vehicleRequestGroup.getKey(), vehicleListOut);
        }
        return vehicleResponseGroups;
    } 

}
