# Zadanie 39 - Losowe konta i problem spójności danych

Należy zmodyfikować poprzednie zadanie.

## Wymagania
- Konta `from` i `to` mają być wybierane losowo.
- Uruchomić program i sprawdzić, dlaczego suma sald się zmienia.

## Główne zagadnienia
- warunki wyścigu
- niesynchronizowany dostęp do danych

## Wnioski

Przy dużej ilości STEPS można empirycznie zaobserwować błędy,
spowodowane jednoczesnym korzystaniem z tych samych kont przez oba wątki.

Anomalia powstaje, ponieważ operacja transfer() nie jest atomowa,
a oba wątki korzystają z tych samych kont.

Dochodzi do `race condition`, w efekcie czego sprawdzany sumaryczny balans wszystkich kont jest błędny.
