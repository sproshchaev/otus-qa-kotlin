# Примеры к вебинару по Kotlin - Generics и функциональное программирование

1. Базовые примеры вебинара [basics](src/main/kotlin/basics) 


## Базовые примеры Generic'ов

1. Базовый пример generic-функции `printItem<T>`, работающей с любыми типами данных. [01_basic_generic_function.kt](src/main/kotlin/examples/01_basic_generic_function.kt)
2. Generic-класс `Pair<T, R>` с двумя параметрами типа и автоматическим выводом типов. [02_generic_class_multiple_params.kt](src/main/kotlin/examples/02_generic_class_multiple_params.kt)
3. Демонстрация автоматического вывода типов в `listOf` и `iterator`. [03_type_inference_demo.kt](src/main/kotlin/examples/03_type_inference_demo.kt)

## Ограничения типов (Type Bounds)

4. Ограничения типов `<T : Comparable<T>>` и `<T : Number>` для функций и классов. [04_upper_bounds.kt](src/main/kotlin/examples/04_upper_bounds.kt)
5. Ковариантность (`out T`) - когда тип используется только для возвращаемых значений. [05_covariance_out.kt](src/main/kotlin/examples/05_covariance_out.kt)
6. Контравариантность (`in T`) - когда тип используется только для входных параметров. [06_contravariance_in.kt](src/main/kotlin/examples/06_contravariance_in.kt)
7. Пример использования `Comparable<Number>` с контравариантностью. [07_comparable_example.kt](src/main/kotlin/examples/07_comparable_example.kt)  

## Star Projection и Type Erasure

8. Использование `<*>` (star projection) для работы с неизвестными generic-типами. [09_star_projection.kt](src/main/kotlin/examples/09_star_projection.kt)
9. Демонстрация стирания типов во время выполнения. [10_type_erasure.kt](src/main/kotlin/examples/10_type_erasure.kt)
10.`reified` типы в inline-функциях для сохранения информации о типах. [11_reified_types.kt](src/main/kotlin/examples/11_reified_types.kt)
11. Практические примеры использования star projection. [12_star_practical.kt](src/main/kotlin/examples/12_star_practical.kt)

## Функциональные типы

12. Базовые функциональные типы `(String) -> String` и их использование. [13_basic_function_types.kt](src/main/kotlin/examples/13_basic_function_types.kt)
13. Ссылки на функции: `::function`, `ClassName::method`, `obj::method`. [14_function_references.kt](src/main/kotlin/examples/14_function_references.kt)
14. Лямбда-выражения, включая использование `it` для единственного аргумента. [15_lambda_expressions.kt](src/main/kotlin/examples/15_lambda_expressions.kt)
15. Практический пример использования функциональных типов для фильтрации. [16_practical_functions.kt](src/main/kotlin/examples/16_practical_functions.kt)
16. Функции без аргументов и с возвращаемым типом `Unit`. [17_unit_functions.kt](src/main/kotlin/examples/17_unit_functions.kt)

## Функция в последнем аргументе

17. Базовый пример синтаксиса с лямбдой в последнем аргументе. [18_last_parameter_basic.kt](src/main/kotlin/examples/18_last_parameter_basic.kt)
18. Практические примеры: измерение времени, работа с ресурсами, повторные попытки. [19_practical_examples.kt](src/main/kotlin/examples/19_practical_examples.kt)
19. DSL-подобный синтаксис для тестовых сценариев. [20_dsl_style.kt](src/main/kotlin/examples/20_dsl_style.kt)  
20. Сравнение стилей: лямбда внутри скобок vs за скобками. [21_style_comparison.kt](src/main/kotlin/examples/21_style_comparison.kt)  
21. Пример простого тестового фреймворка с DSL-синтаксисом. [22_test_framework_example.kt](src/main/kotlin/examples/22_test_framework_example.kt)  

## Ссылки на свойства

22. Базовые ссылки на свойства классов и экземпляров. [23_property_references_basic.kt](src/main/kotlin/examples/23_property_references_basic.kt)  
23. Вычисляемые свойства и свойства с custom getter/setter. [25_computed_properties.kt](src/main/kotlin/examples/25_computed_properties.kt)  
24. Ссылки на статические свойства в companion object. [27_static_properties.kt](src/main/kotlin/examples/27_static_properties.kt)  

## SAM-интерфейсы

25. Базовые SAM-интерфейсы: `Runnable` и создание потоков. [28_sam_basic.kt](src/main/kotlin/examples/28_sam_basic.kt)  
26. Интеграция с Java SAM-интерфейсами: `Callable`, `Consumer`, `Predicate`. [31_java_integration.kt](src/main/kotlin/examples/31_java_integration.kt)  
27. Практический пример SAM-преобразования в работе с потоками. [33_sam_thread_example.kt](src/main/kotlin/examples/33_sam_thread_example.kt)  


