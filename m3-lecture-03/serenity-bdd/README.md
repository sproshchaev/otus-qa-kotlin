# Serenity BDD

Модуль демонстрирует написание тестов с использованием фреймворка **Serenity BDD** и **JUnit 5**.

## Технологии

| Библиотека | Версия | Назначение |
|---|---|---|
| `serenity-core` | 3.9.0 | Ядро Serenity BDD |
| `serenity-junit5` | 3.9.0 | Интеграция с JUnit 5 |
| `junit-jupiter` | 5.10.1 | Запуск тестов |

## Структура

```
src/test/kotlin/ru/otus/
├── CalculatorSteps.kt     — шаги теста с аннотацией @Step
└── SimpleSerenityTest.kt  — тестовый класс с @ExtendWith(SerenityJUnit5Extension)
```

## Ключевые концепции

### Step Library (`CalculatorSteps`)
Класс, методы которого помечены `@Step`. Serenity перехватывает вызовы этих методов и записывает их в HTML-отчёт.

```kotlin
@Step("Пользователь складывает {0} и {1}")
fun add(a: Int, b: Int) {
    result = a + b
    Serenity.recordReportData().withTitle("Результат").andContents(result.toString())
}
```

### Тестовый класс
Подключение Serenity через `@ExtendWith(SerenityJUnit5Extension::class)`:

```kotlin
@ExtendWith(SerenityJUnit5Extension::class)
class SimpleSerenityTest {
    private val steps = CalculatorSteps()

    @Test
    fun `сложение двух чисел работает корректно`() {
        steps.add(2, 3)
        steps.resultShouldBe(5)
    }
}
```

## Запуск тестов

```bash
./gradlew :m3-lecture-03:serenity-bdd:test
```

## Просмотр отчёта

После выполнения тестов HTML-отчёт Serenity генерируется в:

```
build/site/serenity/index.html
```