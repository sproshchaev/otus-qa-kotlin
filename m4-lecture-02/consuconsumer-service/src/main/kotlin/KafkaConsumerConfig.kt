import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import java.util.*

object KafkaConsumerConfig {
    const val TOPIC = "topic1"
    private const val BOOTSTRAP_SERVERS = "localhost:9093"
    private const val GROUP_ID = "kotlin-consumer-group"

    val consumerProperties: Properties
        get() = Properties().apply {
            put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS)
            put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID)
            put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

            // Опциональные настройки для улучшения надежности
            put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false") // Ручное подтверждение
            put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10") // Максимальное количество записей за один poll
            put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000") // Таймаут сессии 30 секунд
        }
}