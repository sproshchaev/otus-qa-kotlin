package examples

class Configuration {
    companion object {
        const val VERSION = "1.0.0"
        val SETTINGS = mapOf("timeout" to 30, "retries" to 3)

        var debugMode: Boolean = false
            set(value) {
                println("Режим отладки: $value")
                field = value
            }
    }
}

fun main() {
    // Ссылки на статические свойства
    val versionRef = Configuration::VERSION
    val settingsRef = Configuration.Companion::SETTINGS
    val debugRef = Configuration::debugMode

    println("Версия: ${versionRef.get()}")
    println("Настройки: ${settingsRef.get()}")

    // Изменение статического свойства через ссылку
    debugRef.set(true)
    println("Режим отладки: ${Configuration.debugMode}")
}