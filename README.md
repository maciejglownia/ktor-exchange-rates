# ktor-exchange-rates

Still in progress...

### Goal
Have a server contains a json object I need to test Exchange Rates application for Android.
Check my [Exchange Rates](https://github.com/maciejglownia/Exchange-Rates/tree/development) to know details.

### Overview
This is a Ktor server application which works as a mirror of fixer.io API.
Server includes a few json objects as follows:

    {
        "base": "EUR",
        "date": "2022-12-15",
        "rates": {
            "AAA": 0.01,
            "BBB": 0.02,
            "CCC": 0.03,
            "DDD": 0.04,
            "EUR": 1.00,
            ...
        }
    }
        
- base: represents base currency,
- date: as a date an exchange rates is for, 
- rates: map of currency symbols as a keys and values as a Double contains calculated value.

In this project all values are fake. I need them only to display in android app.

### What I have used here
- [Intellij IDEA](https://www.jetbrains.com/idea/])
- [Kotlin](https://kotlinlang.org/)
- [Ktor project generator](https://start.ktor.io/#/settings)

### Thank you
- [Philipp Lackner](https://pl-coding.com/)

### Dear Visitor
If you see an opportunity to improve my code do not hesitate to contact me:
maciej.k.glownia@gmail.com. If you want to copy it and develop with your own idea, take it and enjoy
your learning path.
