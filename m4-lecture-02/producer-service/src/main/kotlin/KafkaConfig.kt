import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

object KafkaConfig {
    const val TOPIC = "topic1"
    private const val BOOTSTRAP_SERVERS = "localhost:9093"

    val producerProperties: Properties
        get() = Properties().apply {
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS)
            put(ProducerConfig.ACKS_CONFIG, "all")
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)

            // Дополнительные оптимизации (опционально)
            put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true")
            put(ProducerConfig.RETRIES_CONFIG, Int.MAX_VALUE.toString())
            put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5")
        }
}