# Kotlin & Rest Assured & Junit 5

[![Kotlin Badge](https://img.shields.io/badge/-Kotlin-9370DB?logo=kotlin&logoColor=white&style=for-the-badge)](https://kotlinlang.org/) [![Rest Assured)](https://img.shields.io/github/v/tag/rest-assured/rest-assured?color=3CB371&label=latest&style=for-the-badge)](https://rest-assured.io/)

It is a simple test project prepared using [Rest Assured](http://rest-assured.io/), which makes it easy to test REST
services with [Kotlin](https://kotlinlang.org/) programming
language. [Google Blogger API v3.0](https://developers.google.com/blogger/docs/3.0/using) is used as an example.

## Requirements

- Generate an API Key via Google Cloud Platform Console
- Insert your API key to the field inside quotation marks of the below code

```kotlin
 const val apiKey: String = "[YOUR_API_KEY]"
```

## Commands

```git
git clone git@github.com:burakkaygusuz/kotlin-rest-assured-junit5.git
cd kotlin-rest-assured-junit5
gradle wrapper
./gradlew clean && ./gradlew test
```
