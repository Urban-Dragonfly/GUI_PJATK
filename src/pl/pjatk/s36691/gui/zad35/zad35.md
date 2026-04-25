# Zadanie 35 - Zapis danych osób trzema sposobami

Program ma pobierać dane kilku osób i zapisywać je do plików różnymi technikami.

## Wymagania
- Zebrać dane:
  - imię,
  - nazwisko,
  - PESEL,
  - data urodzenia,
  - adres.
- Zapisać dane:
  - zapisem znakowym,
  - zapisem binarnym,
  - serializacją.
- Napisać metody odczytu każdego pliku.
- Porównać rozmiary plików i uzasadnić różnice.

## Główne zagadnienia
- zapis znakowy
- zapis binarny
- serializacja

## Analiza rozmiaru plików

Najmniejszy okazał się plik tekstowy - tutaj dodatkowym symbolem był tylko średnik rozdzielający pola.

Intuicja podpowiadała, że powinien to być plik binarny, jednakże narzut techniczny formatu UTF-8 oraz dodatkowa informacja o ilości obiektów w pliku sprawiła, że okazałsię on o kilka bajtów większy.

Zdecydowanie najwięcej miejsca zajęły dane zapisane w postaci serializowanej.

