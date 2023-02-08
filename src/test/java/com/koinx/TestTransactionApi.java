package com.koinx;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import  com.google.gson.Gson;

public class TestTransactionApi {

    Gson gson = new Gson();

    private static TransactionResponse transactionResponse;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://x8ki-letl-twmt.n7.xano.io/api:gHPd8le5";
    }

    @Test
    @Order(1)
    public void createTransactionTest() {

        Transaction transaction = new Transaction("INR", "USDT", 304, 3);

        Response response = given()
                .urlEncodingEnabled(false)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(transaction)
                .when()
                .post("/transaction")
                        .then().extract().response();

        transactionResponse =response.body().as(TransactionResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(transaction.getCoin1(),response.jsonPath().getString("sentCoin"));
        Assertions.assertEquals(transaction.getCoin2(),response.jsonPath().getString("receivedCoin"));
        Assertions.assertEquals(transaction.getCoin1Amount(),Integer.parseInt(response.jsonPath().getString("sentCoinAmount")));
        Assertions.assertEquals(transaction.getCoin2Amount(),Integer.parseInt(response.jsonPath().getString("receivedCoinAmount")));
        Assertions.assertNotNull(response.jsonPath().getString("id"));
        Assertions.assertNotNull(response.jsonPath().getString("created_at"));
    }

    @Test
    @Order(2)
    public void fetchTransactiontest(){

        Response response = given()
                .urlEncodingEnabled(false)
                .and()
                .pathParam("id", transactionResponse.getId())
                .when()
                .get("/transaction/{id}")
                .then().extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(transactionResponse.getId(),Integer.parseInt(response.jsonPath().getString("id")));
        float expected = (float) transactionResponse.getSentCoinAmount()/transactionResponse.getReceivedCoinAmount();
        Assertions.assertEquals(expected, Float.parseFloat(response.jsonPath().getString("receivedCoinMarketPrice")));

        long created = Long.parseLong(response.jsonPath().getString("created_at"));
        long difference = created - transactionResponse.getCreated_at();
        difference = difference / 1000;

        Assertions.assertTrue(difference<10);
    }

}
