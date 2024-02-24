package me.vince

class ChuckNorrisFactService(
    private val baseUrl: String,
) {
    private val client = ChuckNorrisFactClientAdapter()

    suspend fun fetchFact(): Fact {
        return client.fetchFact("$baseUrl/chuck")
    }
}
