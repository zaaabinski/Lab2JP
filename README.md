## Lab2
Aplikacja dotyczy stworzenia systemu **maksymalizującego efektywność firm wytwarzających oprogramowanie IT**.

Firmy typu Software House realizują szereg projektów dla swoich klientów posiadając do dyspozycji pracowników o różnych kwalifikacjach. Algorytm powinien przypisać ludzi do odpowiednich projektów, aby zminimalizować braki ludzkie.
### Przykładowy plik wejściowy
```
PROJECTS
P1: JAVA JAVA QA PM
P2: PYTHON QA PM
P3: JS ANGULAR QA PM
P4: JAVA ANGULAR QA
P5: RUST

STAFF
R1: JAVA
R2: ANGULAR QA
R3: PYTHON QA
R4: JAVA PYTHON
R5: PM
R6: ANGULAR JS
R7: PM
R8: JAVA PYTHON
R9: QA
R10: BLOCKCHAIN PM QA
```

Wynikiem działania algorytmu jest przypisanie odpowiednich ludzi do projektu zgodnie z następującymi założeniami:

1. `QA` i `PM` mogą pracować jednocześnie na maksymalnie dwóch projektach (jeśli to ich jedyna cecha).
2. Pozostałe stanowiska pracują tylko na jednym projekcie
3. Jedna osoba może pełnić podwójną rolę w danym projekcie (np. `QA` i `PM`)
