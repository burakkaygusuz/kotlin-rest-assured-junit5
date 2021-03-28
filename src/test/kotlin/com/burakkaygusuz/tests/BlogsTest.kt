@file:Suppress("ClassName")

package com.burakkaygusuz.tests

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test


class `Blogs Test` : BaseTest() {

    @Test
    fun `get by blog Id`() {

        val name: String = Given {
            spec(requestSpecification)
        } When {
            get("/blogs/3213900")
        } Then {
            statusCode(HttpStatus.SC_OK)
        } Extract {
            path("name")
        }

        assertThat(name, equalTo("Blogger Developers"))
    }

    @Test
    fun `get by url`() {

        val description: String = Given {
            spec(requestSpecification)
            queryParam("url", "http://blogger-developers.googleblog.com")
        } When {
            get("/blogs/byurl")
        } Then {
            statusCode(HttpStatus.SC_OK)
        } Extract {
            path("description")
        }

        assertThat(description, equalTo("The latest updates on Blogger developer tools\n"))
    }

}