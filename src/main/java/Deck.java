import java.util.HashSet;
import java.util.Set;

public class Deck {
    private final Set<Card> dealedCards = new HashSet<>();

    public void dealCard(Card card) {
        dealedCards.add(card);
    }

    public boolean contains(Card card) {
        return dealedCards.contains(card);
    }
}
