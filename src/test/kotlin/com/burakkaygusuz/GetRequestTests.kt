@file:Suppress("ClassName")

package com.burakkaygusuz

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class `Get Request Tests` : BaseTest() {

    @Nested
    inner class `The status code should` {

        @Test
        fun `be 200 when the blogId is valid`() {

            Given {
                spec(requestSpecification)
            } When {
                get("/blogs/3213900")
            } Then {
                statusCode(HttpStatus.SC_OK)
            }
        }

        @Test
        fun `be 404 when the blogId is invalid`() {

            Given {
                spec(requestSpecification)
            } When {
                get("/blogs/6258425")
            } Then {
                statusCode(HttpStatus.SC_NOT_FOUND)
            }
        }
    }

    @Nested
    inner class `BlogId should` {

        @Test
        fun `be equal to 3213900 when queries the related blog url`() {

            Given {
                spec(requestSpecification)
                queryParam("url", "http://blogger-developers.googleblog.com")
            } When {
                get("/blogs/byurl")
            } Then {
                assertThat()
                body("id", equalTo("3213900"))
            }
        }

        @Test
        fun `not be equal to 3213900 when queries the unrelated blog url`() {

            Given {
                spec(requestSpecification)
                queryParam("url", "https://google.com")
            } When {
                get("/blogs/byurl")
            } Then {
                assertThat()
                body("id", not("3213900"))
            }
        }

    }
}