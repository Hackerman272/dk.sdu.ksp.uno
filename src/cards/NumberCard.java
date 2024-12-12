package cards;

public class NumberCard extends Card {
    private int number;
    private int[] ALLOWED_NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    NumberCard(Color color) {
        super(color);
    }

    public int GetNumber() {
        return number;
    }

    @Override
    public boolean matches(Card other) {
        if (other.getColor() == this.getColor()) {
            return true;
        } else if (other instanceof NumberCard) {
            NumberCard otherNumberCard = (NumberCard) other;
            return this.number == otherNumberCard.number;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getColor() + "_" + this.GetNumber();
    }
}
