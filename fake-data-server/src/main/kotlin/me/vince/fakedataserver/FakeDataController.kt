package me.vince.fakedataserver

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.runBlocking
import net.datafaker.Faker
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.http.MediaType
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("http://localhost:8080")
@RestController
@ResponseBody
@RequestMapping("/api")
class FakeDataController {
    val faker: Faker = Faker()
    val sharedFlow = MutableSharedFlow<Product>(1)

    @Async
    @EventListener(ApplicationStartedEvent::class)
    fun sendProduct() {
        runBlocking {
            while (true) {
                val product = Product.from(faker.commerce())
                sharedFlow.emit(product)
                delay(2000)
            }
        }
    }

    @GetMapping(produces = [MediaType.APPLICATION_NDJSON_VALUE])
    fun data() = sharedFlow
}
