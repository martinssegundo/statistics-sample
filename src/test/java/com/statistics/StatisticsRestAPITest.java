package com.statistics;

import com.statistics.domain.usercase.IDeleteAllStatistics;
import com.statistics.domain.usercase.IFindStatistics;
import com.statistics.domain.usercase.IInputStatistic;
import com.statistics.mappers.StatisticMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Named;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class StatisticsRestAPITest {

    @Inject
    StatisticMapper mapper;

    @Inject
    @Named("findStatistics")
    IFindStatistics findStatistics;
    @Inject
    @Named("inputStatistic")
    IInputStatistic inputStatistic;
    @Inject
    @Named("deleteAllStatistics")
    IDeleteAllStatistics deleteAllStatistics;

    @Test
    public void testHelloEndpoint() {
        System.out.println(buildBodySucess());
        given()
                .contentType(ContentType.JSON)
                .body(buildBodySucess())
                .when().post("/transactions")
                .then()
                .statusCode(201);
    }


    private JsonObject buildBodySucess() {
        JsonObject requestParams = new JsonObject();
        requestParams.put("amount", "110");
        requestParams.put("timestamp", "2023-01-13T11:41:00.000Z");
        return requestParams;
    }
}