package me.vince

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class ChuckNorrisFactClientAdapter() {
    suspend fun fetchFact(url: String): Fact
}
