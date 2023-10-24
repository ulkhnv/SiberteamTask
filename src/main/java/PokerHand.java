import java.util.*;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand> {

    private final List<Card> cards;

    public PokerHand(String cardsString, Deck deck) {
        String[] cardsArray = cardsString.split(" ");

        if (cardsArray.length != 5) { // Проверка длины раздачи
            throw new IllegalArgumentException("Should be 5 cards");
        }

        cards = Arrays.stream(cardsArray) // Создание списка карт
                .map(Card::new)
                .collect(Collectors.toList());

        for (Card card : cards) { // Проверка розданных карт
            if (deck.contains(card)) {
                throw new IllegalArgumentException("Card already dealed");
            }
            deck.dealCard(card);
        }

        CardComparator cardComparator = new CardComparator(cards);
        cards.sort(cardComparator);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int compareTo(PokerHand other) {
        if (!getCombination().equals(other.getCombination())) {
            return compareCombination(other); // Сравнение разных комбинации
        } else {
            return compareCard(other); // Сравнение одинаковых комбинации
        }
    }

    private int compareCombination(PokerHand other) {
        List<String> combinations = Arrays.asList(
                "Royal Flush", "Straight Flush", "Four of a Kind", "Full House",
                "Flush", "Straight", "Three of a Kind", "Two Pair", "Pair", "High Card"
        );

        int thisRank = combinations.indexOf(getCombination());
        int otherRank = combinations.indexOf(other.getCombination());

        return Integer.compare(thisRank, otherRank);
    }

    private int compareCard(PokerHand other) {
        List<Card> otherCards = other.getCards();

        for (int i = 0; i < cards.size(); i++) {
            Card thisCard = cards.get(i);
            Card otherCard = otherCards.get(i);

            int cardDifference = Integer.compare(otherCard.getRankPosition(), thisCard.getRankPosition());

            if (cardDifference != 0) {
                return cardDifference;
            }
        }
        return 0;
    }

    public String getCombination() {
        return Combinations.determineCombination(this);
    }
}
