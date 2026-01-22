import org.slf4j.LoggerFactory
import kotlin.system.exitProcess

fun main() {
    val logger = LoggerFactory.getLogger("Main")
    val consumer = SimpleConsumer()

    // Обработка сигналов завершения
    Runtime.getRuntime().addShutdownHook(Thread {
        logger.info("Shutdown hook triggered")
        consumer.close()
    })

    try {
        logger.info("Starting Kafka Consumer...")
        logger.info("Press Ctrl+C to stop")

        consumer.subscribeAndConsume()

    } catch (e: Exception) {
        logger.error("Application error", e)
        exitProcess(1)
    }
}