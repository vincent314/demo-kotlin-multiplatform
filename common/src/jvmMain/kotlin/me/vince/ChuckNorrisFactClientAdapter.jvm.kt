package me.vince

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ChuckNorrisFactClientAdapter {
    private val httpClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json()
        }
        engine {
            threadsCount = 8
            pipelining = true
        }
    }

    actual suspend fun fetchFact(url: String): Fact {
        return httpClient.get(url).body()
    }
}
