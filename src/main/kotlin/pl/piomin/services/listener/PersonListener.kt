package pl.piomin.services.listener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class PersonListener {

    val logger: Logger = LoggerFactory.getLogger(PersonListener::class.java)

    @RabbitListener(queues = ["myQueue"])
    fun listen(msg: String) {
        logger.info("Received: {}", msg)
    }

}