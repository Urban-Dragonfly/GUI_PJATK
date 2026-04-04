# Zadanie 17 - Figure i wyjątek TooBigSquareException

Należy zdefiniować interfejs `Figure` i rozszerzyć zadanie z kwadratem.

## Wymagania
- Interfejs ma zawierać pole `max = 6`.
- Zadeklarować metody:
  - `getArea()`
  - `getPerimeter()`
- Klasa `Square` ma implementować `Figure`.
- W konstruktorze sprawdzić, czy długość boku nie przekracza `max`.
- W przypadku przekroczenia rzucić `TooBigSquareException`.

## Główne zagadnienia
- interfejsy
- wyjątki własne
- walidacja danych
