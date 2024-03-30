package tc.springkotlindemo.controllers

import org.springframework.web.bind.annotation.*
import tc.springkotlindemo.data.Message

import tc.springkotlindemo.services.MessageService

@RestController
class MessageController(val service: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
        service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}