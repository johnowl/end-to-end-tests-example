package tests

import io.cucumber.java8.En
import io.restassured.RestAssured.given
import io.restassured.response.Response
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class StepDefinitions : En {

    init {
        val restAssured = given().baseUri("http://localhost:8080")
        lateinit var response: Response

        Given("I call the {string} endpoint with the {string} method") { path: String, method: String ->
            response = restAssured.request(method, path)
        }

        Then("I receive the message {string}") { expectedMessage: String ->
            assertThat(response.body.asString(), equalTo(expectedMessage))
        }
    }
}