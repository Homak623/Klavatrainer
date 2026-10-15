# Klavatrainer - программа, нацеленная на помощь в освоении десятипальцевого метода печати

  1. [Documentation](https://github.com/Homak623/Klavatrainer/blob/main/Documentation/Requirements%20Documents.md)
  2. [Mockups](https://github.com/Homak623/Klavatrainer/tree/main/Mockups)
  3. [Diagrams](https://github.com/Homak623/Klavatrainer/tree/main/Diagrams)
  4. [Code](https://github.com/Homak623/Klavatrainer/tree/main/klavatrainer)
  5. [Test](https://github.com/Homak623/Klavatrainer/tree/main/Testing)

## Сборка и запуск

Нужны JDK 21 и Maven 3.9+. Команды выполняются из корня репозитория:

- `mvn -B package` — собрать проект (результат в `target/`);
- `mvn javafx:run` — запустить приложение;
- `mvn -B test` — прогнать unit-тесты (JUnit 5, исходники в `klavatrainer/test/`, дисплей не нужен).

## Тесты

Unit-тесты написаны на JUnit 5 и лежат в `klavatrainer/test/`. JavaFX Application они не запускают, поэтому дисплей не нужен.

Что покрыто:

- `sample.test.TextCreatorTest` проверяет генератор текста `TextCreator`:
  - `shiftText` убирает первый символ;
  - `newText` для уровней 1–7 даёт 11 символов только из алфавита своего уровня;
  - нечисловой или нулевой уровень вызывает исключение;
  - `gootTextForLevel` отличает текст текущего уровня от текста с символом следующего уровня.
- `sample.GUI.InformationTest` проверяет значения по умолчанию и сеттеры `GUIInformation` и `TrainingInformation`.

Запуск (из корня репозитория):

- все тесты: `mvn -B test`;
- один тестовый класс: `mvn -B test -Dtest=TextCreatorTest`;
- один тестовый метод: `mvn -B test -Dtest=TextCreatorTest#shiftTextRemovesFirstSymbol`;
- несколько методов по шаблону: `mvn -B test -Dtest='TextCreatorTest#newText*'`.
