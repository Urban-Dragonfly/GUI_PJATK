package pl.pjatk.s36691.gui.zad58.model;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class CardFactory {

    private static final List<String> CARD_FRONT_PATHS = List.of(
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_01_dali.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_02_picasso.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_03_monet.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_04_rembrandt.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_05_van_gogh.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_06_klimt.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_07_matisse.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_08_kandinsky.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_09_vermeer.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_10_hokusai.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_11_frida_kahlo.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_12_magritte.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_13_cezanne.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_14_gauguin.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_15_seurat.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_16_toulouse_lautrec.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_17_bosch.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_18_botticelli.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_19_caravaggio.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_20_michelangelo.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_21_leonardo.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_22_raphael.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_23_el_greco.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_24_goya.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_25_velazquez.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_26_turner.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_27_degas.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_28_renoir.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_29_manet.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_30_munch.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_31_mondrian.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_32_malevich.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_33_chagall.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_34_rothko.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_35_pollock.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_36_warhol.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_37_basquiat.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_38_okeeffe.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_39_hopper.png",
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_40_whistler.png"
    );

    public static List<Card> createCardsForBoard(int rows, int columns) {
        int numberOfCards = rows * columns;

        if (numberOfCards % 2 != 0) {
            throw new IllegalArgumentException("Board must have an even number of cards.");
        }

        int numberOfPairs = numberOfCards / 2;

        if (numberOfPairs > CARD_FRONT_PATHS.size()) {
            throw new IllegalArgumentException("Not enough card fronts for this board size.");
        }

        List<String> selectedFronts = new ArrayList<>(CARD_FRONT_PATHS);
        Collections.shuffle(selectedFronts);

        List<Card> cards = new ArrayList<>();

        for (int pairId = 0; pairId < numberOfPairs; pairId++) {
            String imagePath = selectedFronts.get(pairId);

            cards.add(new Card(pairId, imagePath));
            cards.add(new Card(pairId, imagePath));
        }

        Collections.shuffle(cards);

        return cards;
    }
}
