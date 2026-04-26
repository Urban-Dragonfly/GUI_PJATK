# Zadanie 40 - Synchronizacja metod banku

Należy poprawić poprzednie zadanie przez synchronizację.

## Wymagania
- Dodać słowo kluczowe `synchronized` do metod:
  - `transfer`
  - `getTotalBalance`
- Uruchomić program i porównać wyniki.

## Główne zagadnienia
- `synchronized`
- bezpieczeństwo wątkowe

## Wnioski
Dodanie słowa kluczowego `synchronized` naprawia problem z poprzedniego zadania.

Dzięki `synchronized` tylko jeden wątek naraz może wykonywać daną metodę na tym samym obiekcie `Bank`,
więc operacje przelewu i odczytu sumy sald nie nachodzą na siebie.
Końcowa suma pieniędzy w banku pozostaje zgodna z wartością początkową.