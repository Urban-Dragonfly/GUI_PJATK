# Zadanie 37 - Przerywanie wątków na przykładzie kotów

Należy przepisać i przeanalizować kod pokazujący działanie dwóch wątków.

## Wymagania
- Uruchomić program kilka razy.
- Zaobserwować równoległą pracę wątków.
- Zwrócić uwagę na sprawdzanie stanu przerwania wątku.
- Przeanalizować różnicę między ręcznym ustawieniem flagi przerwania a `InterruptedException`.

## Główne zagadnienia
- wielowątkowość
- `Thread`
- `Runnable`
- `interrupt()`

## Podsumowanie
Różnica między Cat1 i Cat2 polega na miejscu ustawienia flagi przerwania.

W Cat1 flaga ustawiana jest po metodach sleep(),
więc pętla kończy się przy następnym sprawdzeniu warunku.

W Cat2 flaga może zostać ustawiona przed sleep(),
dlatego wywołanie sleep() na przerwanym wątku powoduje InterruptedException.
