package pl.piomin.services.config

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun myQueue(): Queue {
        return Queue("myQueue", false)
    }

}