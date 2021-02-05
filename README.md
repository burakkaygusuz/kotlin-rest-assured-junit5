# Kotlin & Rest Assured & Junit 5

It is a simple test project prepared using [Rest Assured](http://rest-assured.io/), which makes it easy to test REST
services with [Kotlin](https://kotlinlang.org/) programming
language. [Google Blogger API v3.0](https://developers.google.com/blogger/docs/3.0/using) is used as an example.

## Requirements

- Generate an API Key via Google Cloud Platform Console
- Restrict your key for Blogger API v3
- Insert your API key to the field inside quotation marks of the below code

```kotlin
 private val apiKey: String = "<insert-your-google-api-key>"
```

## Commands

```git
git clone git@github.com:burakkaygusuz/kotlin-with-rest-assured.git
cd kotlin-with-rest-assured
gradle wrapper
./gradlew clean && ./gradlew test
```