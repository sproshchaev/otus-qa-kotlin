package ru.otus.qa.bdd.spek

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object SpekFixturesSpec : Spek({

    describe("Управление жизненным циклом") {

        beforeGroup { println("beforeGroup   — один раз перед всей группой") }
        beforeEachTest { println("  beforeEachTest — перед каждым тестом") }

        it("первый тест") { println("      тело первого теста") }
        it("второй тест") { println("      тело второго теста") }

        afterEachTest { println("  afterEachTest  — после каждого теста") }
        afterGroup { println("afterGroup    — один раз после всей группы") }
    }
})
