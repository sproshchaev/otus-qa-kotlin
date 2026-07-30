# m3-lecture-03

**Сергей Прощаев**

[![Email](https://img.shields.io/badge/sproshchaev%40gmail.com-red?logo=gmail&logoColor=white)](mailto:sproshchaev@gmail.com)
[![Website](https://img.shields.io/badge/prosoft.pages.dev-blue?logo=googlechrome&logoColor=white)](https://prosoft.pages.dev)

---

### СТРУКТУРА ПРОЕКТА

```asciidoc
m3-lecture-03/
├── build.gradle.kts                 # Конфигурация сборки модуля (Kotlin JVM)
├── README.md
├── src/main/kotlin/ru/otus/m3/
│   └── Main.kt                      # Точка входа
└── src/test/kotlin/
    └── ExampleTest.kt               # Заготовка теста
```

### КОМАНДЫ

```bash
# Запуск приложения
./gradlew :m3-lecture-03:run

# Тесты модуля
./gradlew :m3-lecture-03:test

# Сборка модуля
./gradlew :m3-lecture-03:build
```
