На данный момент в репозитории создан SpringBoot бэкенд.
Проект получен с помощью сервиса https://start.spring.io/
Для работы с проектом рекомендуется использовать IntelliJ IDEA не ниже версии 2022.1

Структура проекта

В проект добавлен spring boot стартовый пак spring-boot-starter-web для функций веб-приложения.
В базовый класс FlexberrySampleSpringApplication добавлены функции Rest-контроллера с методом, который обрабатывает запрос и возвращает строку "Hello World".
Также можно передать параметр.

Для проверки нужно запустить бэк в IDEA и выполнить запрос в браузере

http://localhost:8080/hello

или

http://localhost:8080/hello?myName=TestName

