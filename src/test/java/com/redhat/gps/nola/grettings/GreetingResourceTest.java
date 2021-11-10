package com.redhat.gps.nola.grettings;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;
import java.util.Random;

@QuarkusTest
public class GreetingResourceTest {
    protected final String[] langs=new String[]{"en","es","it","fr","po","ru"};
    protected final String[] greetings=new String[]{"Hello","Hola","Ciao","Salut","Ola","Privet"};

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/greeting")
          .then()
             .statusCode(200)
             .body(is("Hello!"));
    }

    @Test
    public void testGreetingWithName(){
        String uuid = UUID.randomUUID().toString();
        given()
          .pathParam("name", uuid)
          .when().get("/greeting/{name}")
          .then()
            .statusCode(200)
            .body(is("Hello "+uuid+"!"));
    }

    
    @Test
    public void testGreetingDefaultInt(){
        given()
          .when().get("/greeting/int")
          .then()
            .statusCode(200)
            .body(is("Hello!"));
    }

    @Test
    public void testGreetingIntLang(){
        int randomLang=new Random().nextInt(((langs.length-1)-0)+0);
        String lang = this.langs[randomLang];
        given()
          .pathParam("lang",lang)
          .when().get("/greeting/int/{lang}")
          .then()
            .statusCode(200)
            .body(is(greetings[randomLang]+"!"));
    }

    @Test
    public void testGreetingIntLangName(){
        int randomLang=new Random().nextInt(((langs.length-1)-0)+0);
        String uuid = UUID.randomUUID().toString();
        String lang = this.langs[randomLang];
        given()
          .pathParam("lang",lang)
          .pathParam("name", uuid)
          .when().get("/greeting/int/{lang}/{name}")
          .then()
            .statusCode(200)
            .body(is(greetings[randomLang]+" "+uuid+"!"));
    }
}