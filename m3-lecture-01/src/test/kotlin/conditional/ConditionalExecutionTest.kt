package conditional

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.condition.*

class ConditionalExecutionTest {

    @Test
    @EnabledOnOs(OS.MAC, OS.LINUX)
    fun onlyOnMacAndLinux() {
        println("Этот тест работает только на Mac и Linux")
        assertTrue(true)
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    fun notOnWindows() {
        println("Этот тест НЕ работает на Windows")
        assertEquals(4, 2 + 2)
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11, JRE.JAVA_17, JRE.JAVA_21)
    fun onlyOnJava11AndAbove() {
        println("Этот тест работает только на Java 11, 17, 21")
        assertTrue(true)
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    fun disabledForJava8To11() {
        println("Этот тест отключен для Java 8-11")
        assertEquals("test", "TEST".lowercase())
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    fun onlyOn64BitArchitecture() {
        println("Этот тест работает только на 64-битной архитектуре")
        assertTrue(true)
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    fun notOnCIServer() {
        println("Этот тест не запускается на CI-сервере")
        assertEquals(6, 2 * 3)
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "RUN_ALL_TESTS", matches = "true")
    fun onlyWhenEnvVarSet() {
        println("Этот тест работает только если RUN_ALL_TESTS=true")
        assertTrue(true)
    }
}