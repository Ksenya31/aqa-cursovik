

# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

## Документация

1. [План автоматизации](https://github.com/Ksenya31/aqa-cursovik/blob/main/Plan.md)

1. [Отчёт по итогам тестирования](https://github.com/Ksenya31/aqa-cursovik/blob/main/Report.md)

1. [Отчёт по итогам автоматизации](https://github.com/Ksenya31/aqa-cursovik/blob/main/Summary.md)

## Инструкция по запуску и сворачиванию приложения

### Запуск SUT
* Cкопировать ссылку на проект: клонировать с помощью Git-> git clone https://github.com/Ksenya31/aqa-cursovik.git  или открыть IntelliJ IDEA ->Empty Project и вставить ссылу  https://github.com/Ksenya31/aqa-cursovik.git
* Открыть проект в IntelliJ IDEA
* Запустить Docker Desktop
* В первом терминале запустить контейнер docker-compose up
* Запустить приложение командой java -jar artifacts/aqa-shop.jar
* Проверить, что приложение успешно запустилось (ввести URL в браузере Сhrome: http://localhost/8080)
* Запустить тесты в терминале 3: .\gradlew clean test

### Создание отчета
* Создать отчеты и открыть их в браузере командой ./gradlew allureServe

### Сворачивание приложения
* Остановить приложение: перейти в терминал, в котором оно было запущено, и ввести CTRL + C
* Остановить контейнеры docker-compose down
