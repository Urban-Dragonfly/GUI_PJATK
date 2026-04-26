# Zadanie 42 - StringTask i stany zadania

Należy stworzyć klasę `StringTask`, która symuluje długotrwałe obliczenia.

## Wymagania
- Klasa ma implementować `Runnable`.
- Konstruktor przyjmuje napis i liczbę powtórzeń.
- Powielenie ma odbywać się przez operator `+`.
- Wprowadzić stany zadania jako enum:
  - `CREATED`
  - `RUNNING`
  - `ABORTED`
  - `READY`
- Dodać metody:
  - `getResult()`
  - `getState()`
  - `start()`
  - `abort()`
  - `isDone()`
- Obsłużyć także wariant przerwania po sekundzie.

## Główne zagadnienia
- `Runnable`
- stany obiektu
- wątki
- przerwanie działania
