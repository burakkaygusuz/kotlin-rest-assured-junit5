package googleapis

import io.restassured.RestAssured.*
import org.junit.jupiter.api.BeforeEach

open class BaseTest{

    @BeforeEach
    fun setUp(){
        baseURI = "https://www.googleapis.com"
        basePath = "/blogger/v3"
    }

    companion object{
        const val apiKey = "AIzaSyC-oGQs1Sx9YPWepK1-xC44qhQSzzU3iEk"
    }
}