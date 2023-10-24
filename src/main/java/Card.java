import java.util.Objects;

public class Card {

    private final String RANKS = "23456789TJQKA";
    private final String SUITS = "SHDC";
    private final char rank;
    private final char suit;

    public Card(String cardString) {
        rank = cardString.charAt(0);
        suit = cardString.charAt(1);

        if (!RANKS.contains(String.valueOf(rank)) || !SUITS.contains(String.valueOf(suit))) {
            throw new IllegalArgumentException("Invalid card " + cardString);
        }
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public int getRankPosition() {
        return RANKS.indexOf(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
