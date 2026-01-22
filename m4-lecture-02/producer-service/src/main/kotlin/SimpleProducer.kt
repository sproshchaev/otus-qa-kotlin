import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory

class SimpleProducer {
    private val logger = LoggerFactory.getLogger(SimpleProducer::class.java)
    private val producer: KafkaProducer<String, String>

    init {
        producer = KafkaProducer(KafkaConfig.producerProperties)
        logger.info("Producer initialized with config: ${KafkaConfig.producerProperties}")
    }

    fun sendMessage(key: String?, value: String) {
        val record = ProducerRecord(KafkaConfig.TOPIC, key, value)

        producer.send(record) { metadata, exception ->
            if (exception == null) {
                logger.info("Message sent successfully! Topic: ${metadata.topic()}, " +
                        "Partition: ${metadata.partition()}, " +
                        "Offset: ${metadata.offset()}")
            } else {
                logger.error("Failed to send message", exception)
            }
        }

        producer.flush()
    }

    fun close() {
        producer.close()
        logger.info("Producer closed")
    }
}