package me.vince

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ChuckNorrisFactClientAdapter {
    actual suspend fun fetchFact(url: String): Fact {
        return window.fetch(url).await()
            .text().await()
            .let(Json.Default::decodeFromString)
    }
}
