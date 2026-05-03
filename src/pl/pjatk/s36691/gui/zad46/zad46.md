# Zadanie 46 - Dodawanie przycisku bezpośrednio i przez panel

Należy porównać dwa sposoby dodawania przycisku do okna.

## Wymagania
- Najpierw dodać przycisk bezpośrednio metodą `add`.
- Następnie opakować przycisk w `JPanel`.
- Porównać zachowanie obu rozwiązań.
- Wyjaśnić, z czego wynika różnica.

## Główne zagadnienia
- kontenery Swing
- domyślne layouty

## Podosumowanie:

W przypadku pierwszej ramki, przycisk dodany do JFrame jest dodawany do jego ContentPane,
które ma domyślny layout BorderLayout, więc przycisk jest rozciągany na całą ramkę jako element centralny.

W przypadku drugiej ramki, przycisk jest dodawany do JPanel,
który ma domyślny layout FlowLayout, więc przycisk jest ustawiony zgodnie z jego domyślnym layoutem,
czyli po środku u góry.
