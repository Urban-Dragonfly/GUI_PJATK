# Zadanie 38 - Bank i przelewy w dwóch wątkach

Należy stworzyć klasę `Bank` przechowującą salda kont w tablicy.

## Wymagania
- Konstruktor ma przyjmować liczbę kont i saldo początkowe.
- Dodać metodę `getTotalBalance()`.
- Dodać metodę `transfer(int from, int to, int amount)`.
- W `ThreadsTest` utworzyć dwa wątki:
  - pierwszy przelewa z konta 0 na 1,
  - drugi z konta 2 na 3.
- Po zakończeniu wypisać sumę środków.

## Główne zagadnienia
- tablice
- wątki
- współdzielony stan

## Wnioski
W zadaniu 38 wątki operują na osobnych parach kont: 0→1 oraz 2→3.

Dlatego nie dochodzi do typowego konfliktu przy modyfikacji tych samych kont.

Suma sald najczęściej pozostaje poprawna.

Teoretyczna anomalia mogłaby pojawić się tylko wtedy,
gdy metoda getTotalBalance() odczytałaby tablicę w trakcie wykonywania transferu,
między withdraw() a deposit().
