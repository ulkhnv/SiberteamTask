import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {

    List<Card> cards;

    public CardComparator(List<Card> cards) {
        this.cards = cards;
    }


    // Сравнение по количеству одинаковых карт, затем по старшинству ранга
    @Override
    public int compare(Card card1, Card card2) {
        int count1 = 0;
        int count2 = 0;

        for (Card card : cards) {
            if (card.getRank() == card1.getRank()) {
                count1++;
            }

            if (card.getRank() == card2.getRank()) {
                count2++;
            }
        }

        if (count1 == count2) {
            return Integer.compare(card2.getRankPosition(), card1.getRankPosition());
        }

        return Integer.compare(count2, count1);
    }
}
