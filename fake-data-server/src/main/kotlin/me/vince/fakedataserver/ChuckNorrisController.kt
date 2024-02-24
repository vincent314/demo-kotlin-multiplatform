package me.vince.fakedataserver

import net.datafaker.Faker
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@ResponseBody
class ChuckNorrisController {
    val faker = Faker(Locale.FRENCH)

    @GetMapping("/chuck")
    fun getFact(): Fact {
        return Fact(faker.chuckNorris().fact())
    }
}
