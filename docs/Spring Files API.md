# Создание API для работы с файлами SpringBoot проекта. Структура проекта.

## Пример реализации

За основу был взят официальный пример на основе хранения файлов файловой системы:
https://spring.io/guides/gs/uploading-files/

Были взяты только основные методы и вырезана UI-часть, возврат списка файлов переделан на формат JSON.

Собственно весь API - это обертывание кодя для роботы с ФС 
**(см. ./SpringBootBackend/src/main/java/net/flexberry/flexberrySampleSpring/service/StorageService.java)** 
в методы контроллера 
**(см. ./SpringBootBackend/src/main/java/net/flexberry/flexberrySampleSpring/controller/FileUploadController.java)**

### Примеры запросов для работы с файлами

Загрузить файл:
```console
curl --location --request POST 'http://localhost:8080/files/' \
--form 'file=@"/home/user/test.txt"'
```

Получить список файлов:
```console
curl --location --request GET 'http://localhost:8080/files/'
```

Скачать указанный файл:
```console
curl --location --request GET 'http://localhost:8080/files/test.txt'
```