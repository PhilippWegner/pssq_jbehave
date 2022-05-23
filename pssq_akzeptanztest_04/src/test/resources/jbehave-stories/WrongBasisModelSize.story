Narrative:
Als Nutzer der GUI zum Speichern von Outdoorartikeln,
moechte ich Artikel zu einer Liste hinzufuegen und loeschen können,
damit ich den Überblick über meine Outrdoorartikel behalte.


Scenario: 
Ueberpruefe die Laenge der Artikelliste nach Hinzufuege- und Loeschvorgaenge

Given Eine leere Outdoorartikelliste
When Ich <artikelHinzu> Artikel in die Liste hinzufuege
And danach <artikelEntfernen> Artikel aus der Liste entferne
Then Hat die Liste die Laenge <artikelAnzahl>

Examples:
|artikelHinzu|artikelEntfernen|artikelAnzahl|
|3|2|1|
|10|2|8|
|7|7|0|