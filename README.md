Java бэкенд на основе фреймворка Spring Boot
Проект получен с помощью сервиса https://start.spring.io/
Для работы с проектом рекомендуется использовать IntelliJ IDEA не ниже версии 2022.1

Возможности, реализованные на данный момент:

1) Работа с БД Postgres. Для примера созданы сущности Customer и Comment.
2) Выполнение простых REST запросов к сущностям - GET, POST, PUT, DELETE.
3) Связи между сущностями. Comment является детейлом Customer.
4) Аудит операций на основе Envers. Для каждой таблицы автоматически создается таблица аудита в этой же БД + одна общая служебная таблица.
5) Запуск в Docker.

### Запуск в Docker

Для запуска бэкенда в Docker необходимо выполнить

`Flexberry.SpringReactApplication.Sample\Docker\build.sh`

`Flexberry.SpringReactApplication.Sample\Docker\run.cmd`

Для остановки контейнера

`Flexberry.SpringReactApplication.Sample\Docker\stop.cmd`

### Примеры запросов

Запросы выполняются в Postman

![image](https://user-images.githubusercontent.com/13151962/208077421-dc281e00-9ae4-4ddb-965a-de31fa31c441.png)


![image](https://user-images.githubusercontent.com/13151962/208077800-2ef45a9d-f697-4282-a433-1c195ea293d7.png)


![image](https://user-images.githubusercontent.com/13151962/208077968-88424ebc-3dc5-41c5-b424-52ee2c2f7c0c.png)


![image](https://user-images.githubusercontent.com/13151962/208078069-c59be0ca-9e67-42be-abc3-8a6e0f996fc6.png)


![image](https://user-images.githubusercontent.com/13151962/208078189-dbd020fa-22b3-491a-84ad-291f3e29dc52.png)
