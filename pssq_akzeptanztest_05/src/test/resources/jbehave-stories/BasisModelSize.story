Narrative:
Zum Speichern von Outdoorartikeln, 
Als Nutzer der GUI
Möchte ich Artikel zu einer Liste hinzufuegen und loeschen können,
damit ich den Überblick über meine Outrdoorartikel behalte.


Scenario: 
Ueberpruefe die Laenge der Artikelliste nach Hinzufuege- und Loeschvorgaenge

Given Eine leere Outdoorartikelliste
When Ich drei Artikel in die Liste hinzufuege
And danach zwei Artikel aus der Liste entferne
Then Hat die Liste die Laenge 1