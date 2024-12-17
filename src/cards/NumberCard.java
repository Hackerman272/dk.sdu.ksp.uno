package cards;

import java.lang.reflect.Array;

public class NumberCard extends Card {
    private int number;
    private int[] ALLOWED_NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    NumberCard(Color color, int number) {
        super(color);
        if (isValid(number)) {
            this.number = number;
        }
    }

    public boolean isValid(int number) {
        for (int allowedNumber : ALLOWED_NUMBERS) {
            if (allowedNumber == number) {
                return true;
            }
        }
        return false;
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
