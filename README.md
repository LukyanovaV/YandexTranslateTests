# Тесты для проекта Яндекс Переводчик (https://translate.yandex.ru/)
Финальный проект курса Otus "Автоматизатор в тестировании". Данный проект демонстрирует полученные навыки в ходе прохождения курса. Состоит из двух модулей:
1. yandex-translate-tests-UI     //Модуль содержащий автоматизированные тесты для DOM
2. yandex-translate-tests-REST   //Модуль тестов для Rest API



# yandex-translate-tests-UI
Тесты содержатся в папке - yandex-translate-tests-UI\src\test\java\tests
- Тесты для страницы https://translate.yandex.ru/ : TestTranslationToRus.java, TestTranslationToLangs.java, TestTranslationTextPage.java;
- Tесты для страницы https://translate.yandex.ru/translate : SiteTranslationTest.java;
- Тесты для страницы https://translate.yandex.ru/ocr : ImageTranslationTest.java


В разарботке тестов использована модель "page object" - yandex-translate-tests-UI\src\test\java\pages

Тестовое окружение (листнеры, раннеры, логирование) -  yandex-translate-tests-UI\src\test\java\environment\

Для формирования репортов используется Allure. Отчёты хранятся в папке - yandex-translate-tests-UI\allure-report\ 

Логи хранятся в папке - yandex-translate-tests-UI\results\

Для загрузки картинок написан скрипт yandex-translate-tests-UI\resources\loadImage.exe ; Данный скрипт разработан при помощи инструментов AutoIT
