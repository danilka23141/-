plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

sourceCompatibility = 11

// кодировка файлов (если используете русский язык в файлах)
compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"

repositories {
    mavenCentral()
}


dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.6.1'
    // библиотека com.codeborne:selenide используется при построении проекта с использованием Selenide
    // testImplementation 'com.codeborne:selenide:6.17.2'

    // при реализации проекте с использованием Selenium вместо библиотеки com.codeborne:selenide подключаются
    // org.seleniumhq.selenium:selenium-java и io.github.bonigarcia:webdrivermanager
    testImplementation 'org.seleniumhq.selenium:selenium-java:4.18.1'
    testImplementation 'io.github.bonigarcia:webdrivermanager:5.7.0'
}

test {
    useJUnitPlatform()
    // в тестах, вызывая `gradlew test -Dselenide.headless=true` будем передавать этот параметр в JVM (где его подтянет Selenide)
    // свойство selenide.headless используется в проектах на основе Selenide для передачи значения параметра в JVM
    systemProperty 'selenide.headless', System.getProperty('selenide.headless')
    // свойство chromeoptions.prefs используется для задания настроек браузера в проектах на основе Selenide, выключаем менеджер паролей
    systemProperty 'chromeoptions.prefs', System.getProperty('chromeoptions.prefs', "profile.password_manager_leak_detection=false")
}