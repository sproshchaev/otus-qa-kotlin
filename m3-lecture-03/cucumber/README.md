# Cucumber + Serenity BDD

Модуль демонстрирует BDD-тестирование с использованием **Cucumber** и интеграции **Serenity BDD** для генерации расширенных отчётов.

## Технологии

| Библиотека | Версия | Назначение |
|---|---|---|
| `serenity-core` | 3.9.0 | Ядро Serenity BDD |
| `serenity-cucumber` | 3.9.0 | Интеграция Serenity с Cucumber |
| `cucumber-java8` | 7.15.0 | Шаги в виде лямбд (Kotlin-стиль) |
| `cucumber-junit-platform-engine` | 7.15.0 | Запуск Cucumber через JUnit Platform |
| `junit-platform-suite` | 1.10.1 | `@Suite` для запуска Cucumber-раннера |

## Структура

```
src/test/
├── kotlin/ru/otus/
│   ├── CalculatorCucumberSteps.kt  — шаги Cucumber (En / лямбда-стиль)
│   └── CucumberTestRunner.kt       — раннер тестов (@Suite)
└── resources/features/
    └── calculator.feature          — сценарии на языке Gherkin
```

## Ключевые концепции

### Feature-файл (Gherkin)
Сценарии описываются на понятном языке в формате `Given / When / Then`:

```gherkin
Scenario: Сложение двух чисел
  Given пользователь открывает калькулятор
  When пользователь складывает 5 и 7
  Then результат должен быть 12
```

### Step Definitions (`CalculatorCucumberSteps`)
Реализация шагов через интерфейс `En` (Java 8 / Kotlin lambda-стиль):

```kotlin
class CalculatorCucumberSteps : En {
    init {
        When("пользователь складывает {int} и {int}") { x: Int, y: Int ->
            result = x + y
        }
        Then("результат должен быть {int}") { expected: Int ->
            assert(result == expected)
        }
    }
}
```

### Cucumber Runner (`CucumberTestRunner`)
Запускает все feature-файлы из classpath-ресурса `features`, ищет шаги в пакете `ru.otus`:

```kotlin
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "ru.otus")
class CucumberTestRunner
```

## Запуск тестов

```bash
./gradlew :m3-lecture-03:cucumber:test
```

## Просмотр отчёта

После выполнения тестов HTML-отчёт Serenity генерируется в:

```
build/site/serenity/index.html
```