# Модульные тесты. JUnit 5

**Сергей Прощаев**

[![Email](https://img.shields.io/badge/sproshchaev%40gmail.com-red?logo=gmail&logoColor=white)](mailto:sproshchaev@gmail.com)
[![Website](https://img.shields.io/badge/prosoft.pages.dev-blue?logo=googlechrome&logoColor=white)](https://prosoft.pages.dev)

---

### СТРУКТУРА ПРОЕКТА

```asciidoc
m3-lecture-01/
├── build.gradle.kts                 # Конфигурация сборки, зависимости JUnit 5 (6.1.2)
├── README.md
│
└── src/test/kotlin/ru/otus/qa/junit5/
    ├── basics/                      # Основы: @Test, жизненный цикл, изоляция
    │   ├── FirstTestDemo.kt
    │   ├── LifecycleOrderDemo.kt
    │   ├── PerMethodIsolationDemo.kt
    │   └── PerClassLifecycleDemo.kt
    ├── params/                      # Параметризованные тесты
    │   ├── ValueSourceDemo.kt
    │   └── MultiSourceParametersDemo.kt
    ├── control/                     # Управление запуском и условное выполнение
    │   ├── TestControlDemo.kt
    │   └── ConditionalExecutionDemo.kt
    ├── extensions/                  # Механизм расширений
    │   ├── LoggingExtension.kt
    │   ├── LoggingExtensionDemo.kt
    │   ├── TimingExtension.kt
    │   ├── TimingExtensionDemo.kt
    │   ├── TestUser.kt
    │   ├── UserParameterResolver.kt
    │   └── ParameterResolverDemo.kt
    └── alternative/                 # Альтернативный фасад
        └── KotlinTestAssertionsDemo.kt
```

### ПОДКЛЮЧЕНИЕ (build.gradle.kts)

Три обязательные вещи: `api` для написания тестов, `engine` для их выполнения
и `useJUnitPlatform()` для Gradle. Версии `api` и `engine` обязаны совпадать — **6.1.2**,
иначе тесты компилируются, но не запускаются.

```kotlin
dependencies {
    testImplementation(kotlin("test"))                                   // обёртка kotlin.test (пример 12)
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.1.2")      // чем пишем тесты
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.1.2")   // источники параметров
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.1.2")      // движок для прогона
}

tasks.test {
    useJUnitPlatform()
}
```

Обратите внимание на разные префиксы: `testImplementation` для API и `testRuntimeOnly`
для движка — движок нужен только в момент прогона, не при компиляции.

### СООТВЕТСТВИЕ ДЕМО И СЛАЙДОВ

| № | Тема демо | Класс | Пакет | Слайд |
|---|---|---|---|---|
| 0 | Подключение зависимостей | `build.gradle.kts` | корень | 11. Установка |
| 1 | Первый тест: `@Test`, `assertEquals` | `FirstTestDemo` | basics | 12. Аннотации |
| 2 | Порядок Before/After, статичность `@BeforeAll` | `LifecycleOrderDemo` | basics | 12. Аннотации |
| 3 | Изоляция тестов, режим `PER_METHOD` | `PerMethodIsolationDemo` | basics | 14. Жизненный цикл |
| 4 | Режим `PER_CLASS`, общее состояние | `PerClassLifecycleDemo` | basics | 14. Жизненный цикл |
| 5 | Параметризация: `@ValueSource` | `ValueSourceDemo` | params | 13. Параметризация |
| 6 | Параметризация: `@CsvSource`, `@MethodSource` | `MultiSourceParametersDemo` | params | 13. Параметризация |
| 7 | `@Disabled`, `@Tag`, `@RepeatedTest` | `TestControlDemo` | control | 12. Аннотации |
| 8 | Условное выполнение по среде | `ConditionalExecutionDemo` | control | 19. Conditional Test Execution |
| 9 | Расширение с колбэками жизненного цикла | `LoggingExtension`, `LoggingExtensionDemo` | extensions | 15–17. Extension, Context |
| 10 | Замер времени, `TestExecution`-колбэки, `Store` | `TimingExtension`, `TimingExtensionDemo` | extensions | 16–17. Callbacks, Context |
| 11 | `ParameterResolver`, оба контекста | `TestUser`, `UserParameterResolver`, `ParameterResolverDemo` | extensions | 18, 20. ParameterContext, ParameterResolver |
| 12 | Альтернатива: `kotlin.test` | `KotlinTestAssertionsDemo` | alternative | 11. Установка |

> Классы `LoggingExtensionDemo` (пример 9) содержит **намеренно падающий** тест — он показывает,
> как расширение реагирует на провал. При полном прогоне `test` этот тест ожидаемо красный.

### КОМАНДЫ ДЛЯ ДЕМО

##### Из корня проекта (otus-qa-kotlin):

```bash
# Все тесты модуля
./gradlew :m3-lecture-01:test

# Один класс
./gradlew :m3-lecture-01:test --tests "ru.otus.qa.junit5.basics.FirstTestDemo"

# Один пакет (все примеры основ)
./gradlew :m3-lecture-01:test --tests "ru.otus.qa.junit5.basics.*"

# Фильтрация по тегам (пример 7): только быстрые / только медленные
./gradlew :m3-lecture-01:test -DincludeTags=fast
./gradlew :m3-lecture-01:test -DexcludeTags=slow

# HTML-отчёт после прогона:
# m3-lecture-01/build/reports/tests/test/index.html
```
