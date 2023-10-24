import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PokerHandTest {

    @Test
    void compareCombinationTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("KH QH 9H JH TH", deck); // Стрит флэш
        PokerHand hand2 = new PokerHand("AS QS KS JS TS", deck); // Роял флэш
        PokerHand hand3 = new PokerHand("2H 4H 5H 6H 7H", deck); // Флэш


        List<PokerHand> hands = new ArrayList<>(List.of(hand1, hand2, hand3));
        Collections.sort(hands);

        Assertions.assertEquals(hand2, hands.get(0));
        Assertions.assertEquals(hand1, hands.get(1));
        Assertions.assertEquals(hand3, hands.get(2));

    }

    @Test
    void compareWithSameCombination() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("AS AH JS JH JC", deck); // Full house : three J and two A
        PokerHand hand2 = new PokerHand("KS KH QS QH QC", deck); // Full house : three Q and two  K

        List<PokerHand> hands = new ArrayList<>(List.of(hand1, hand2));
        Collections.sort(hands);

        Assertions.assertEquals(hand2, hands.get(0));
        Assertions.assertEquals(hand1, hands.get(1));

    }

    @Test
    void royalFlushTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("AS QS KS JS TS", deck);

        Assertions.assertEquals("Royal Flush", hand1.getCombination());
    }

    @Test
    void straightFlushTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("9S QS KS JS TS", deck);

        Assertions.assertEquals("Straight Flush", hand1.getCombination());
    }

    @Test
    void fourOfAKindTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("9S 9H 9D 9C AS", deck);

        Assertions.assertEquals("Four of a Kind", hand1.getCombination());
    }

    @Test
    void fullHouseTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("9S 9H 9D AC AS", deck);

        Assertions.assertEquals("Full House", hand1.getCombination());
    }

    @Test
    void flushTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("2S QS 5S 7S TS", deck);

        Assertions.assertEquals("Flush", hand1.getCombination());
    }

    @Test
    void straightTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("2S 3D 5S 4S 6S", deck);

        Assertions.assertEquals("Straight", hand1.getCombination());
    }

    @Test
    void threeOfAKindTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("9S 9H 9D TC QS", deck);

        Assertions.assertEquals("Three of a Kind", hand1.getCombination());
    }

    @Test
    void twoPairTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("9S 9H TD TC QS", deck);

        Assertions.assertEquals("Two Pair", hand1.getCombination());
    }

    @Test
    void pairTest() {
        Deck deck = new Deck();
        PokerHand hand1 = new PokerHand("9S 9H KD TC QS", deck);

        Assertions.assertEquals("Pair", hand1.getCombination());
    }
}
