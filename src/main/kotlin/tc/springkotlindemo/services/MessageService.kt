package tc.springkotlindemo.services

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import tc.springkotlindemo.data.Message

@Service
class MessageService(val db: JdbcTemplate) {
    fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message) {
        db.update(
            "insert into messages values ( ?, ? )",
            message.id, message.text
        )
    }
}