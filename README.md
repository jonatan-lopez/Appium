# Appium
BUILD

Para buildear el proyecto se necesitaran las siguientes herramientas instaladas funcionando:
-Gradle : https://gradle.org/install/
-Java: https://java.com/en/download/
-Appium: https://appium.io/

Para buildear el projecto debes correr el siguiente comando:

gradle build allure -x test

RUN 

Una vez hecho el build podemos correr los tests tanto via por IDE(Intellij o Eclipse)o por linea de comando:

Linea de comando: Para correr los tests por linea de comando debes especificar con que dispositivo movil se esta trabajando en el archivo app.properties
que se encuentra en /src/main/resources
Basta con solo correr lo siguiente:

gradle build test 

IDE: Para correr los tests desde el IDE deben crear un perfil de TestNG solo con el tests que queremos correr.

Reportes:
Para generar los reportes se debe acudir al siguiente comando:

./gradlew allureReport

Y luego para visualizarlos

./graldew allureServe


