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
