package com.burakkaygusuz

import io.restassured.RestAssured
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {

    @BeforeAll
    fun setUp() {
        RestAssured.baseURI = "https://www.googleapis.com"
        RestAssured.basePath = "/blogger/v3"
        RestAssured.useRelaxedHTTPSValidation()
    }

    @AfterAll
    fun tearDown() {
        RestAssured.reset()
    }
}