@file:Suppress("ClassName")

package googleapis

import org.apache.http.HttpStatus
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


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
                .queryParam("key", apiKey)

            request.get("/blogs/$blogId").then().statusCode(HttpStatus.SC_NOT_FOUND)
        }

    }
}