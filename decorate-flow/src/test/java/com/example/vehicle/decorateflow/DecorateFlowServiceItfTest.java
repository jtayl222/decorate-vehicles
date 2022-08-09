package com.example.vehicle.decorateflow;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DecorateFlowServiceItfTest {
    Logger log = LoggerFactory.getLogger(DecorateFlowServiceItfTest.class);


    String request = "\n"
    + "{\n"
    + "    \"vehicleInstances\": [\n"
    + "      {\n"
    + "        \"vehicleType\": \"Vehicle\",\n"
    + "        \"color\": \"red\",\n"
    + "        \"vehicleId\": 1\n"
    + "      },\n"
    + "      {\n"
    + "        \"vehicleType\": \"Car\",\n"
    + "        \"color\": \"bright green\",\n"
    + "        \"vehicleId\": 2,\n"
    + "        \"currentPassengers\": 5,\n"
    + "        \"maxPassengers\": 4\n"
    + "      },\n"
    + "      {\n"
    + "        \"vehicleType\": \"Car\",\n"
    + "        \"color\": \"lime green\",\n"
    + "        \"vehicleId\": 3,\n"
    + "        \"currentPassengers\": 2,\n"
    + "        \"maxPassengers\": 5\n"
    + "      },\n"
    + "      {\n"
    + "        \"vehicleType\": \"Truck\",\n"
    + "        \"color\": \"medium blue\",\n"
    + "        \"vehicleId\": 4,\n"
    + "        \"currentCargoWeight\": 5000,\n"
    + "        \"maxCargoWeight\": 4000\n"
    + "      },\n"
    + "      {\n"
    + "        \"vehicleType\": \"Truck\",\n"
    + "        \"color\": \"navy blue\",\n"
    + "        \"vehicleId\": 5,\n"
    + "        \"currentCargoWeight\": 2000,\n"
    + "        \"maxCargoWeight\": 5000\n"
    + "      }\n"
    + "    ]\n"
    + "}\n";

    @Test
    public void testDecorateFlowServiceItf() {
        log.info("HERE IN testDecorateFlowServiceItf");
        given()
        .body(request)
        .contentType(ContentType.JSON)
        .when().post("/v1/decorate-flow")
          .then()
             .statusCode(200)
             .body("vehicleInstances.color", hasItem("Color attribute has been decorated"));
    }

}