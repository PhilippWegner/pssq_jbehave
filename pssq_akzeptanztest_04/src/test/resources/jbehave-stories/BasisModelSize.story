Narrative:
Als Nutzer der GUI zum Speichern von Outdoorartikeln,
moechte ich Artikel zu einer Liste hinzufuegen und loeschen können,
damit ich den Überblick über meine Outrdoorartikel behalte.

Scenario: 
Ueberpruefe die Laenge der Artikelliste nach Hinzufuege- und Loeschvorgaengen

Given Eine leere Outdoorartikelliste
When Ich drei Artikel in die Liste hinzufuege
And danach zwei Artikel aus der Liste entferne
Then Hat die Liste die Laenge 1