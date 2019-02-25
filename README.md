[![Bintray](https://api.bintray.com/packages/soushin/maven/measurer/images/download.svg) ](https://bintray.com/soushin/maven/measurer/_latestVersion)


# Measurer

- Measurer is client library for Google Analytics(using measurement protocol).
- Kotlin Multi-platform support(JVM, Android, iOS).

## Features

- Supports all measurement protocol parameters.
- Supports all hit types.
- Supports batching of requests.
- This library abstracts the HTTP client. you can implement by any HTTP client(like ktor client, etc).

common sample code
```kotlin
class Sample {
    suspend fun track() {
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

- [x] Upload bintray
- [x] Support iOS
- [ ] Support JS

## Installation

Add the measurer bintray repository to your build.gradle

```groovy
repositories {
    maven { url "https://dl.bintray.com/soushin/maven" }
}
```

Depending on your type of Kotlin project add one of these dependencies:

**Common**
```groovy
implementation 'com.github.soushin:measurer:0.0.1'
```

**JVM**
```groovy
implementation 'com.github.soushin:measurer-jvm:0.0.1'

```
**Android**
```groovy
implementation 'com.github.soushin:measurer-android:0.0.1'
```

## Usage

- Common module

```kotlin
object GoogleAnalytics {

    private val httpClient = SampleHttpClient(SampleHttpClientConfig.httpClient, SampleNapierLogger())

    suspend fun pageTracking(tid: String) {
        val mp = MeasurementProtocol
            .Builder(
                trackingId = tid,
                httpClient = httpClient
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

- Android, Jvm

Call tracking method.

```kotlin
GoogleAnalytics.pageTracking(tid: "UA-12345678-1")
```

- iOS

prepare a proxy at Common module.

```kotlin
fun pageTracking(tid: String) {
    NativeScope().launch {
        GoogleAnalytics().pageTracking(tid)
    }
}
```

Call proxy from ios project.

```swift
MeasurerProxyKt.pageTracking(tid: "UA-12345678-1")
```

## Logger

Library uses [Napier](https://github.com/AAkira/Napier). If you want to use your logging library, implements Logger.

## Licence

Copyright (C) 2019 soushin

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

## Credit

This library is inspired by [brsanthu/google-analytics-java](https://github.com/brsanthu/google-analytics-java).

Thanks for advice.
@AAkira, @horita-yuya
