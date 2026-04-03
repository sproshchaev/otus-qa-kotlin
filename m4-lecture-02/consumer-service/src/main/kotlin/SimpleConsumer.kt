import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory
import java.time.Duration

class SimpleConsumer {
    private val logger = LoggerFactory.getLogger(SimpleConsumer::class.java)
    private val consumer: KafkaConsumer<String, String>

    init {
        consumer = KafkaConsumer(KafkaConsumerConfig.consumerProperties)
        logger.info("Consumer initialized. Group: ${KafkaConsumerConfig.consumerProperties.getProperty("group.id")}")
    }

    fun subscribeAndConsume() {
        consumer.subscribe(listOf(KafkaConsumerConfig.TOPIC))
        logger.info("Subscribed to topic: ${KafkaConsumerConfig.TOPIC}")

        try {
            while (true) {
                val records: ConsumerRecords<String, String> = consumer.poll(Duration.ofMillis(100))

                if (!records.isEmpty) {
                    logger.info("Received ${records.count()} messages")

                    records.forEach { record ->
                        processRecord(record)
                    }

                    // Ручное подтверждение обработки сообщений
                    consumer.commitSync()
                    logger.debug("Committed offsets")
                }

                // Небольшая задержка для снижения нагрузки на CPU
                Thread.sleep(50)
            }
        } catch (e: Exception) {
            logger.error("Error during consumption", e)
        } finally {
            close()
        }
    }

    private fun processRecord(record: ConsumerRecord<String, String>) {
        logger.info("""
            |=== Message Received ===
            |Topic:     ${record.topic()}
            |Partition: ${record.partition()}
            |Offset:    ${record.offset()}
            |Timestamp: ${record.timestamp()}
            |Key:       ${record.key()}
            |Value:     ${record.value()}
            |Headers:   ${record.headers().joinToString { "${it.key()}=${String(it.value())}" }}
            |=======================
        """.trimMargin())

        // Здесь можно добавить бизнес-логику обработки сообщения
        // Например, сохранение в базу данных, вызов API и т.д.
    }

    fun close() {
        consumer.close()
        logger.info("Consumer closed")
    }
}