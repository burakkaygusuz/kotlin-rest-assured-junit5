@file:Suppress("ClassName")

package googleapis

import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GetRequestTests : BaseTest() {

    @Nested
    inner class `the status code should` {

        @Test
        fun `be 200 when the blogId is valid`() {

            val blogId = 2399953

            given()
                .queryParam("key", apiKey)
            .`when`()
                .get("/blogs/$blogId")
            .then()
                .statusCode(HttpStatus.SC_OK)
        }

        @Test
        fun `be 404 when the blogId is invalid`() {

            val blogId = 6258425

            given()
                .queryParam("key", apiKey)
            .`when`()
                .get("/blogs/$blogId")
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
        }
    }

    @Nested
    inner class `blogId should` {

        @Test
        fun `be equal to 3213900 when queries the related blog url`() {

            given()
                .queryParam("key", apiKey)
                .queryParam("url", "http://blogger-developers.googleblog.com")
            .`when`()
                .get("/blogs/byurl")
            .then()
                .assertThat()
                .body("id", equalTo("3213900"))
        }

        @Test
        fun `not be equal to 3213900 when queries the unrelated blog url`() {

            given()
                .queryParam("key", apiKey)
                .queryParam("url", "https://google.com")
            .`when`()
                .get("/blogs/byurl")
            .then()
                .assertThat()
                .body("id", not(equalTo("3213900")))
        }

    }
}