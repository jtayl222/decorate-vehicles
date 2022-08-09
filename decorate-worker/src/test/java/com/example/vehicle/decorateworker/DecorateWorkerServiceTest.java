package com.example.vehicle.decorateworker;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DecorateWorkerServiceTest {
    @Test
    public void testDecorate() {

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

        System.out.println("request = " + request);
        given()
        .body(request)
        .contentType(ContentType.JSON)
        .when().post("/v1/decorate-car-color")
        .then()
             .statusCode(200)
             .body("vehicleInstances.color", hasItem("Color attribute has been decorated"));
    }
}

