@file:Suppress("ClassName")

package googleapis

import io.restassured.RestAssured.*
import org.apache.http.HttpStatus
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GetRequestTests {

    @BeforeEach
    fun setUp() {

        baseURI = "https://www.googleapis.com"
        basePath = "/blogger/v3"
    }

    @Nested
    inner class `the status code should` {

        val apiKey = "AIzaSyC-oGQs1Sx9YPWepK1-xC44qhQSzzU3iEk"

        @Test
        fun `be 200 when the blogId is valid`() {

            val blogId = 2399953

            val request = given()
                .queryParam("key", apiKey)

            request.get("/blogs/$blogId").then().statusCode(HttpStatus.SC_OK)
        }

        @Test
        fun `be 404 when the blogId is invalid`() {

            val blogId = 6258425

            val request = given()
                .queryParam("key", apiKey)

            request.get("/blogs/$blogId").then().statusCode(HttpStatus.SC_NOT_FOUND)
        }

    }
}