

# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

## Документация

1. [План автоматизации]()

1. [Отчёт по итогам тестирования]()

1. [Отчёт по итогам автоматизации]()

## Инструкция по запуску и сворачиванию приложения

### Запуск SUT
* Cкопировать ссылку на проект: клонировать с помощью Git-> git clone ...  или открыть IntelliJ IDEA ->Empty Project  ...
* Запустить Docker Desktop
* Открыть проект в IntelliJ IDEA
* В первом терминале запустить контейнер docker-compose up
* Запустить приложение командой java -jar artifacts/aqa-shop.jar
* Проверить, что приложение успешно запустилось (ввести URL в браузере Сhrome: http://localhost/8080)
* 

### Создание отчета
* Создать отчеты и открыть их в браузере командой ./gradlew allureServe

### Сворачивание приложения
* Остановить приложение: перейти в терминал, в котором оно было запущено, и ввести CTRL + C
* Остановить контейнеры docker-compose down
