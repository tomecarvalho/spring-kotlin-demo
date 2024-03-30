package tc.springkotlindemo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController {
    @GetMapping("/check")
    fun health(): String = "ok"

    @GetMapping("/hello")
    fun helloName(@RequestParam(required = false, defaultValue = "user") name: String) = "Hello, $name"
}