package ru.otus.qa.bdd.spek

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object SpekPhasesSpec : Spek({

    println(">>> DISCOVERY: тело Spek")

    describe("Группа верхнего уровня") {

        println(">>> DISCOVERY: начало тела группы")

        it("первый тест") {
            println("    EXECUTION: тело первого теста")
        }

        it("второй тест") {
            println("    EXECUTION: тело второго теста")
        }

        println(">>> DISCOVERY: конец тела группы")
    }
})
