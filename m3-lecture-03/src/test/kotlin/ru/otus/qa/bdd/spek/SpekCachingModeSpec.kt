package ru.otus.qa.bdd.spek

import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object SpekCachingModeSpec : Spek({

    describe("Режимы кэширования") {

        // новый список перед каждым тестом
        val perTest by memoized(CachingMode.TEST) { mutableListOf<String>() }

        // один список на всю область видимости
        val perScope by memoized(CachingMode.SCOPE) { mutableListOf<String>() }

        it("первый тест добавляет по одному элементу в каждый список") {
            perTest.add("A")
            perScope.add("A")

            assertEquals(1, perTest.size)
            assertEquals(1, perScope.size)
        }

        it("второй тест видит разницу между режимами") {
            perTest.add("B")
            perScope.add("B")

            assertEquals(1, perTest.size)    // список создан заново
            assertEquals(2, perScope.size)   // список сохранился с прошлого теста
        }
    }
})
