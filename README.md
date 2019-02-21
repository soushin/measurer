# Measurer

- Measurer is client library for Google Analytics(using measurement protocol).
- Kotlin Multi-platform support(JVM, Android).

## Features

- Supports all measurement protocol parameters.
- Supports all hit types.
- Supports batching of requests.

common sample code
```kotlin
class Sample {
    suspend fun measurer() {
        val mp = MeasurementProtocol
            .Builder(
                trackingId = "UA-12345678-1"
            ).build()

        mp.also { ga ->
            ga.pageView("mydemo.com", "/checkout").apply {
                clientId = "555"

                documentTitle = "Checkout"

                productAction = "checkout"

                product = Product(index = 1).apply {
                    sku = "P12345"
                    name = "Android Warhol T-Shirt"
                    category = "Apparel"
                    brand = "Google"
                    variant = "Black"
                    price = 1
                    quantity = 1
                }

                checkoutStep = 1
                checkoutStepOption = "Visa"
            }
        }.send()
    }
}
```

## Todo

- [ ] Upload bintray
- [ ] Support iOS, JS

## Usage

### Page Tracking

- Android, Jvm

```kotlin
class PageTracking {
    suspend fun pageTracking() {
        val mp = MeasurementProtocol
            .Builder(
                trackingId = "UA-12345678-1"
            ).build()

        mp.also { ga ->
            ga.pageView("mydemo.com", "/home").apply {
                clientId = "555"
                documentTitle = "homgepage"

                contentGroup = ContentGroup(index = 1).apply {
                    value = "news/sports"
                }
            }

            ga.pageView("mydemo.com", "/home").apply {
                clientId = "555"
                documentTitle = "homgepage"

                contentGroup = ContentGroup(index = 2).apply {
                    value = "news/finance"
                }
            }
        }.send()
    }
}
```

### Event Tracking

- Android, Jvm

```kotlin
class EventTracking {
    suspend fun eventTracking() {
        val mp = MeasurementProtocol
            .Builder(
                trackingId = "UA-12345678-1"
            ).build()

        mp.also { ga ->
            ga.event("video", "play").apply {
                clientId = "555"
                eventLabel = "holiday"
                eventValue = 300
            }
        }.send()
    }
}
```

## HttpClient

Library uses [Ktor](https://ktor.io/clients/http-client.html) client. If you want to use your http client, implements Client.

## Logger

Library uses [Napier](https://github.com/AAkira/Napier). If you want to use your logging library, implements Logger.

## Licence

Copyright (C) 2019 soushin

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

## Credit

This library is inspired by [brsanthu/google-analytics-java](https://github.com/brsanthu/google-analytics-java).
