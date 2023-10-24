import java.util.List;
import java.util.stream.IntStream;

public class Combinations {

    public static String determineCombination(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        if (isRoyalFlush(cards)) {
            return "Royal Flush";
        }
        if (isStraightFlush(cards)) {
            return "Straight Flush";
        }
        if (isFourOfAKind(cards)) {
            return "Four of a Kind";
        }
        if (isFullHouse(cards)) {
            return "Full House";
        }
        if (isFlush(cards)) {
            return "Flush";
        }
        if (isStraight(cards)) {
            return "Straight";
        }
        if (isThreeOfAKind(cards)) {
            return "Three of a Kind";
        }
        if (isTwoPair(cards)) {
            return "Two Pair";
        }
        if (isPair(cards)) {
            return "Pair";
        }
        return "High Card";
    }

    private static boolean isRoyalFlush(List<Card> cards) {
        return isStraightFlush(cards) && cards.get(0).getRank() == 'A';
    }

    private static boolean isStraightFlush(List<Card> cards) {
        return isStraight(cards) && isFlush(cards);
    }

    private static boolean isFourOfAKind(List<Card> cards) {
        return cards.stream()
                .skip(1)
                .limit(3)
                .allMatch(e -> e.getRank() == cards.get(0).getRank());

    }

    private static boolean isFullHouse(List<Card> cards) {
        return cards.stream()
                .skip(1)
                .limit(2)
                .allMatch(e -> e.getRank() == cards.get(0).getRank()) &&
                cards.get(3).getRank() == cards.get(4).getRank();
    }

    private static boolean isFlush(List<Card> cards) {
        return cards.stream().map(Card::getSuit).distinct().count() == 1;
    }

    private static boolean isStraight(List<Card> cards) {
        return IntStream.range(0, cards.size() - 1)
                .allMatch(i -> cards.get(i).getRankPosition() - 1 == cards.get(i + 1).getRankPosition());
    }

    private static boolean isThreeOfAKind(List<Card> cards) {
        return cards.stream()
                .skip(1)
                .limit(2)
                .allMatch(e -> e.getRank() == cards.get(0).getRank());

    }

    private static boolean isTwoPair(List<Card> cards) {
        return cards.get(0).getRank() == cards.get(1).getRank() &&
                cards.get(2).getRank() == cards.get(3).getRank();
    }

    private static boolean isPair(List<Card> cards) {
        return cards.get(0).getRank() == cards.get(1).getRank();
    }
}
