## ENGLISH

# README
Hi!
this is the readme file of the *SeleniumTestNG  QA Engineer Task - test automation challenge.*  I have automated the automationpractice page as UI.
## Overview
This project is designed for UI automation testing. The framework is setup on Maven build tool, therefore all the dependency and libraries are managed through pom.xml file. I used Java as a programming language, Selenium as a Webdriver, TestNG for Assertions, TestNG Extent Report. All the details of the Framework will be explained below.
## Short Intro and Benefits
I can describe my framework as **easy to maintain, scalable and highly reusable** because of the following reasons:
- I am using **Page Object Model**, which separates test scripts and web element locators. By that way even if there is a change in a web element which is used in many places, I am changing it in a central one place.
- I am using **Configuration Properties** file, so that all the system variable are in central place. Thus, changing an url or credential in overall system is quite easy.
- Thanks to the **singleton pattern** structure that I used in my framework, I can run *regular tests, as well as cross browser/cross platform tests (including web)*
- By adding necessary dependencies, I can test **Front-end** simultaneously (i.e. comparison of all UI).
## Install to Local and Run
Its a **maven** project. Therefore, you need to pull it to your machine and run either through maven lifecycle (test) or from terminal. After locating terminal to the project directory, type the following:
`> mvn test `
#### Alternatively:
You can run projects from maven lifecycle: edit the browser from configuration.properties file (see available drivers in Driver class file) and then you can run test suite by clicking *maven lifecycle test*.
## Framework and Patterns
In a maven project I have the following structure:
### Root Files
- **pom.xml file:** to manage java version, dependency and libraries.
- **configuration.properties file:** I use this file to centralize system-wide variables such as urls, connnection strings, test environment adresses, browser names etc. By this way any change in any system variable can be effective in overall framework.
### Library
-  **pages package:** this package contains a base page for the *whole application* which contains the ***Page Object Model Design Pattern***,  common menus, web elements and methods. Moreover, the package contains Page class for every page in the web app, which centralizes the locators and methods related to the page.
- **user registration package:** this package contains the test script methods. Test scripts usess objects created from the page classes.
- **utilities package:** this page contains general important tools.
- ***Driver class:*** it has ***Singleton Pattern*** therefore supplies only one driver per thread so that the same driver is used.
- ***ConfigurationReader class:*** I use this class to read data from configuration.properties file.
- ***BrowserUtils class:*** This class is my toolkit for commonly used actions and methods, during the time it becomes more crowded. Here I only wrote necessary tools.
- ***TestBase class:*** The main purpose of using a Test Base Class is to take advantage of inheritance, encapsulation and clean code. These concepts are standard programming principles, these are used for all code environments, not just with test automation.

### Final Say
I hope this task has shown my interest in your company and the opportunities given by them and my desire to learn and develop more.

**************************************************************************************************************************

#DEUTSCH

# README
Hallo!
dies ist die Readme-Datei der *SeleniumTestNG QA Engineer Task - test automation challenge.* Ich habe die automationpractice Seite als UI automatisiert.
## Überblick
Dieses Projekt ist für UI-Automatisierungstests konzipiert. Das Framework wurde mit dem Maven Build Tool erstellt, daher werden alle Abhängigkeiten und Bibliotheken über die pom.xml Datei verwaltet. Ich habe Java als Programmiersprache, Selenium als Webdriver, TestNG für Assertions und TestNG Extent Report verwendet. Alle Details des Frameworks werden im Folgenden erläutert.
## Kurzes Intro und Vorteile
Ich kann mein Framework als **einfach zu warten, skalierbar und hochgradig wiederverwendbar** beschreiben, und zwar aus den folgenden Gründen:
- Ich verwende das **Page Object Model**, das Testskripte und Web-Element-Locators voneinander trennt. Auf diese Weise ändere ich ein Webelement, das an vielen Stellen verwendet wird, nur an einer zentralen Stelle.
- Ich verwende die Datei **Configuration Properties**, so dass alle Systemvariablen an einer zentralen Stelle zu finden sind. So ist das Ändern einer Url oder eines Credential im gesamten System recht einfach.
- Dank der **Singleton Pattern** Struktur, die ich in meinem Framework verwendet habe, kann ich sowohl *reguläre Tests als auch browser- und plattformübergreifende Tests (einschließlich Web)** durchführen.
- Durch Hinzufügen der notwendigen Abhängigkeiten kann ich **Front-End** gleichzeitig testen (d.h. Vergleich aller UI).
## Lokal installieren und ausführen
Es ist ein **Maven** Projekt. Daher müssen Sie es auf Ihren Rechner ziehen und entweder über den Maven-Lifecycle (Test) oder über das Terminal ausführen. Nachdem Sie mit dem Terminal in das Projektverzeichnis gewechselt sind, geben Sie das Folgende ein:
`> mvn test `
#### Alternativ dazu:
Sie können Projekte über Maven Lifecycle ausführen: Bearbeiten Sie den Browser in der Datei configuration.properties (siehe verfügbare Drivers in der Driver-Klassendatei) und führen Sie dann die Testsuite aus, indem Sie auf *maven lifecycle test* klicken.
## Framework und Patterns
In einem Maven Projekt habe ich die folgende Struktur:
### Root Files
- **pom.xml Datei:** um Java Version, Abhängigkeiten und Bibliotheken zu verwalten.
- **configuration.properties Datei:** Ich verwende diese Datei, um systemweite Variablen wie URLs, Verbindungsstrings, Testumgebungsadressen, Browsernamen usw. zu zentralisieren. Auf diese Weise kann jede Änderung an einer Systemvariablen im gesamten Framework wirksam werden.
### Bibliothek
- **Seiten-Paket:** Dieses Paket enthält eine Basisseite für die *gesamte Anwendung*, die das ***Page Object Model Design Pattern***, gemeinsame Menüs, Webelemente und Methoden enthält. Außerdem enthält das Paket die Klasse Page für jede Seite in der Webanwendung, die die mit der Seite verbundenen Locators und Methoden zentralisiert.
- **Benutzerregistrierungspaket:** Dieses Paket enthält die Testskriptmethoden. Die Testskripte verwenden Objekte, die aus den Seitenklassen erstellt wurden.
- **Hilfspaket:** Diese Seite enthält allgemeine wichtige Werkzeuge.
- ***Treiberklasse:*** sie hat das ***Singleton Pattern*** und liefert daher nur einen Treiber pro Thread, so dass der gleiche Treiber verwendet wird.
- ***ConfigurationReader Klasse:*** ich benutze diese Klasse um Daten aus der configuration.properties Datei zu lesen.
- ***BrowserUtils Klasse:*** Diese Klasse ist mein Toolkit für häufig verwendete Aktionen und Methoden, im Laufe der Zeit wird es immer voller. Hier habe ich nur notwendige Tools geschrieben.
- ***TestBase Klasse:*** Der Hauptzweck der Verwendung einer Test Base Klasse ist es, die Vorteile von Vererbung, Kapselung und sauberem Code zu nutzen. Diese Konzepte sind Standard-Programmierprinzipien, die für alle Code-Umgebungen verwendet werden, nicht nur bei der Testautomatisierung.

### Schlusswort
Ich hoffe, dass diese Aufgabe mein Interesse an Ihre Firma und den von ihnen gebotenen Möglichkeiten sowie meinen Wunsch, mehr zu lernen und zu entwickeln, gezeigt hat.
