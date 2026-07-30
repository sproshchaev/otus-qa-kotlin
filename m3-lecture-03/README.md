# BDD-подход. Spek, Serenity BDD, Cucumber

**Сергей Прощаев**

[![Email](https://img.shields.io/badge/sproshchaev%40gmail.com-red?logo=gmail&logoColor=white)](mailto:sproshchaev@gmail.com)
[![Website](https://img.shields.io/badge/prosoft.pages.dev-blue?logo=googlechrome&logoColor=white)](https://prosoft.pages.dev)

---

Демо к вебинару «BDD-подход» (Kotlin QA Engineer). Сквозной пример во всех десяти
демонстрациях — банковский перевод: слушатель уже знает сценарий, поэтому всё внимание
уходит на инструмент, а не на предметную область.

- **LIVE №1** — примеры 1–6: Spek Framework и Serenity BDD
- **LIVE №2** — примеры 7–10: Cucumber

### СТРУКТУРА ПРОЕКТА

```
m3-lecture-03/
├── build.gradle.kts
├── README.md
└── src
    ├── main/kotlin/ru/otus/qa/bdd/domain/
    │   ├── Account.kt
    │   └── BankService.kt
    └── test
        ├── kotlin/ru/otus/qa/bdd/
        │   ├── spek/                                   # LIVE №1, примеры 1–5
        │   │   ├── TransferSpecificationStyleSpec.kt
        │   │   ├── TransferGherkinStyleSpec.kt
        │   │   ├── SpekPhasesSpec.kt
        │   │   ├── SpekFixturesSpec.kt
        │   │   └── SpekCachingModeSpec.kt
        │   ├── serenity/                               # LIVE №1, пример 6
        │   │   ├── TransferSteps.kt
        │   │   └── TransferSerenityTest.kt
        │   └── cucumber/                               # LIVE №2, примеры 8–10
        │       ├── literal/
        │       │   ├── TransferLiteralStepDefinitions.kt
        │       │   └── RunLiteralCucumberTest.kt
        │       └── parameterized/
        │           ├── TransferParameterizedStepDefinitions.kt
        │           └── RunParameterizedCucumberTest.kt
        └── resources/features/                         # LIVE №2, пример 7
            └── transfer.feature
```

> Версия Kotlin задаётся централизованно в корневом `settings.gradle.kts` (2.2.20),
> поэтому в `build.gradle.kts` у `kotlin("jvm")` версия не указывается — только у
> Serenity-плагина. `useJUnitPlatform()` идёт без указания движка: в одном проекте
> соседствуют три инструмента, и каждый приносит свой движок (`junit-vintage-engine`
> для Serenity на JUnit 4).

### СООТВЕТСТВИЕ ДЕМО И КЛАССОВ

| № | LIVE | Инструмент | Имя класса / файла | Что демонстрирует |
|---|------|------------|--------------------|-------------------|
| — | — | — | `Account`, `BankService` | Класс, который тестируем во всех примерах |
| 1 | №1 | Spek | `TransferSpecificationStyleSpec` | Стиль specification: describe / context / it |
| 2 | №1 | Spek | `TransferGherkinStyleSpec` | Стиль gherkin: Feature / Scenario / Given / When / Then / And |
| 3 | №1 | Spek | `SpekPhasesSpec` | Фазы Discovery и Execution, реальный порядок выполнения |
| 4 | №1 | Spek | `SpekFixturesSpec` | Фикстуры: beforeGroup, beforeEachTest, afterEachTest, afterGroup |
| 5 | №1 | Spek | `SpekCachingModeSpec` | CachingMode: TEST против SCOPE |
| 6 | №1 | Serenity BDD | `TransferSteps`, `TransferSerenityTest` | Библиотека шагов `@Step`, тест `@Steps`, встроенный отчёт |
| 7 | №2 | Cucumber | `transfer.feature` | Спецификация в отдельном файле на языке Gherkin |
| 8 | №2 | Cucumber | `TransferLiteralStepDefinitions` | Привязка кода к строкам спецификации (стиль java8) |
| 9 | №2 | Cucumber | `RunLiteralCucumberTest` | Точка входа `@Suite`: движок, папка features, glue |
| 10 | №2 | Cucumber | `TransferParameterizedStepDefinitions` | Параметризация шагов через `{int}` |

### КОМАНДЫ ДЛЯ ДЕМО

##### Из корня проекта (otus-qa-kotlin):

```bash
# Все примеры разом
./gradlew :m3-lecture-03:test

# Только примеры Spek
./gradlew :m3-lecture-03:test --tests "ru.otus.qa.bdd.spek.*"

# Пример Serenity вместе с отчётом
./gradlew :m3-lecture-03:test :m3-lecture-03:aggregate

# Только примеры Cucumber
./gradlew :m3-lecture-03:test --tests "*CucumberTest"
```

Отчёт Serenity открывается по пути `m3-lecture-03/target/site/serenity/index.html`.
HTML-отчёт JUnit — `m3-lecture-03/build/reports/tests/test/index.html`.
