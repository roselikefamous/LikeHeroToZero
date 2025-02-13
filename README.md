PROGRAMMIERUNG VON INDUSTRIELLEN INFORMATIONSSYSTEMEN MIT JAVA EE
IPWA02-01

Aufgabe 1 LikeHeroToZero

Dieses Projekt stellt eine kleine Java-Anwendung bereit, mit der CO₂-Emissionsdaten für verschiedene Länder erfasst,
angezeigt und verwaltet werden können. Es basiert auf folgenden Technologien:

-JSF (JavaServer Faces) für das Frontend
-JPA (Java Persistence API) / Hibernate für den Datenbankzugriff
-CDI (Contexts and Dependency Injection) zur Abhängigkeitsspritze
-H2 als In-Memory-Datenbank (für lokale Tests)
Die Anwendung enthält zudem ein simples Login-System für Wissenschaftler:innen, die neue Emissionsdaten eintragen können.

Deployment und Start

Build mit Maven
Führe im Projektverzeichnis den Build aus:
mvn clean install
Dabei wird das WAR-File (z. B. likeherotozero-1.0-SNAPSHOT.war) im Ordner target/ erzeugt.
Deployment in einem Servlet-Container
Kopiere das generierte WAR-File in das webapps/-Verzeichnis eines Servers (z. B. Apache Tomcat).
Alternativ kannst du Tomcats Adminoberfläche (Tomcat Manager) nutzen, um das WAR-File hochzuladen.
WAR in das Deployment-Verzeichnis legen bzw. über die Admin-Konsole bereitstellen.
Server starten oder neu starten, damit das Projekt automatisch entpackt wird.

Testen / Aufruf im Browser

Starte deinen Server (falls nicht bereits geschehen).
Rufe im Browser die URL auf, unter der die Anwendung verfügbar ist. Bei Tomcat könnte das z. B. sein:
http://localhost:8080/likeherotozero-1.0-SNAPSHOT/
oder – falls du das WAR-File umbenannt hast und/oder Tomcat anders konfiguriert ist – entsprechend eine abweichende URL.

H2-Datenbank

Per Default nutzt das Projekt eine H2-Datenbank im Home-Verzeichnis des Users (Datei ~/likeherotozero.mv.db).
Bei jedem Start des Servers (bzw. der Anwendung) wird versucht, die Tabellen automatisch zu erzeugen oder zu aktualisieren (gemäß hibernate.hbm2ddl.auto=update).
Du kannst die Datenbank mit der H2 Console einsehen, wenn du sie in deinen Server integrierst oder sie im Standalone-Modus startest.

Login / Neue Datensätze anlegen

Öffne die Startseite unter index.xhtml. Dort kannst du nach Ländern suchen und vorhandene CO₂-Daten einsehen.
Um neue Datensätze einzutragen, klicke auf „Wissenschaftler Login“. Dort kannst du dich mit Username und Passwort anmelden.
Nach dem Login kannst du über „Daten speichern“ neue Emissions-Einträge anlegen.

