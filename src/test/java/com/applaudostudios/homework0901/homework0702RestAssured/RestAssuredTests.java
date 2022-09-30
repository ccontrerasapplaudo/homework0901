package com.applaudostudios.homework0901.homework0702RestAssured;


import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class RestAssuredTests {

    String token;
    String roomID;

    @Test(priority = 1)
    public void getRoom() {
        String id = "1";
        given()
                .baseUri("https://automationintesting.online").
                pathParam("id", id).
                when()
                .get("/room/{id}").
                then()
                .log().body();
    }

    @Test(priority = 2)
    public void postRetrieveToken() {
        File file = new File("resources/step01/authCredentials.json");
        Map<String, String> cookies = given()
                .baseUri("https://automationintesting.online")
                .contentType(ContentType.JSON)
                .body(file).
                when()
                .post("/auth/login").
                then()
                .statusCode(200)
                .extract().cookies();
        System.out.println("Token value: " + cookies.get("token"));
        token = cookies.get("token");
    }

    @Test(priority = 3)
    public void getRoom1N() {
        given()
                .baseUri("https://automationintesting.online").
                when()
                .get("/room/").
                then()
                .log().body();
    }

    @Test(priority = 4)
    public void getRoomID() {

        Response response = given()
                .baseUri("https://automationintesting.online").
                when()
                .get("/room/");

        JsonPath jsonPath = new JsonPath(response.asString());

        int min = 0;
        int max = jsonPath.getInt("rooms.size()")-1;
        int randomResult = (int)(Math.random()*(max-min+1)+min);
        int index = randomResult;

        String path = "rooms"+"["+index+"]"+".roomid";
        System.out.println("Selected ID to perform booking "+jsonPath.getString(path));
        roomID = jsonPath.getString(path);
    }

    @Test(priority = 5)
    public void postBooking1Room() {
        File file = new File("resources/step01/booking1Room.json");
        Cookie cookie = new Cookie.Builder("token", token).setSecured(true).setComment("Booking 1 room cookie").build();
        given()
                .baseUri("https://automationintesting.online")
                .cookie(cookie)
                .contentType(ContentType.JSON).
                body(file).
                when()
                .post("/booking/").
                then()
                .statusCode(201).
                log().all();
    }

}
