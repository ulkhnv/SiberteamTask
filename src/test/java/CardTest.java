import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CardTest {

    @Test
    void compareTest() {
        Card card1 = new Card("5S");
        Card card2 = new Card("6S");
        Card card3 = new Card("4S");
        Card card4 = new Card("4H");
        Card card5 = new Card("8S");

        List<Card> cards = new ArrayList<>(List.of(card1, card2, card3, card4, card5));
        CardComparator cardComparator = new CardComparator(cards);
        cards.sort(cardComparator);

        Assertions.assertEquals(card3, cards.get(0));
        Assertions.assertEquals(card4, cards.get(1));
        Assertions.assertEquals(card5, cards.get(2));
        Assertions.assertEquals(card2, cards.get(3));
        Assertions.assertEquals(card1, cards.get(4));
    }
}
