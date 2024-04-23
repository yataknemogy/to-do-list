# Aufgabenverwaltungssystem

Diese Anwendung ist ein Aufgabenverwaltungssystem, das es Benutzern ermöglicht, Aufgaben zu erstellen, zu löschen, zu aktualisieren und zu sortieren.

## Datenmodell
- ID
- Aufgabentitel
- Aufgabenbeschreibung
- Erstellungsdatum der Aufgabe
- Frist
- Aufgabenstatus (neu, in Bearbeitung, abgeschlossen)

## Funktionalität
- Aufgabe erstellen
- Aufgabe löschen
- Aufgabe aktualisieren
- Aufgabe sortieren

## Fehlerbehandlung
- Globaler Ausnahme-Handler `@ControllerAdvice` zur Behandlung möglicher Anwendungsfehler.

## Frontend
- Verwendung von Thymeleaf mit Spring MVC für serverseitiges Rendern.

## Testen
- Schreiben von Einheits- und Integrationstests für die Anwendung mit JUnit und Mockito.

### Einheitstests

Wir haben Einheitstests für die Klassen und Methoden unserer Anwendung mit dem JUnit-Framework erstellt. Sie können unsere Tests in der Datei [TaskServiceUnitTest.java](to-do-list/src/main/java/com/example/todolist/Service/TaskServiceUnitTest) einsehen.

### Integrationstests

Zur Überprüfung der Interaktion verschiedener Komponenten unserer Anwendung und ihrer korrekten Funktion zusammen führen wir Integrationstests durch. Wir verwenden das Mockito-Framework, um Mocks zu erstellen und das Verhalten abhängiger Komponenten zu emulieren.

## Verwendung der PostgreSQL-Datenbank

Diese Anwendung erfordert eine PostgreSQL-Datenbank.

### Installation und Konfiguration von PostgreSQL

1. **Installieren Sie PostgreSQL auf Ihrem Computer, indem Sie den Anweisungen auf der [offiziellen PostgreSQL-Website](https://www.postgresql.org/download/) folgen.**

2. **Nach der Installation geben Sie die relevanten Daten für die Verbindung zur PostgreSQL-Datenbank (Host, Port, Datenbankname, Benutzername und Passwort) in der Konfigurationsdatei Ihres Projekts (`application.properties`) an.**

3. **Nach dem Start der Anwendung in Ihrer integrierten Entwicklungsumgebung (IDE) wird die Klasse `Task.java` automatisch die erforderlichen Tabellen in der Datenbank erstellen. Stellen Sie einfach sicher, dass Ihre Datenbankverbindungskonfiguration korrekt ist.**

Bitte lassen Sie mich wissen, wenn Sie etwas anderes benötigen!

[EN](README_EN.MD) | [JP](README_JP.MD)