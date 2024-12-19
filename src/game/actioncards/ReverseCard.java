package game.actioncards;

import game.UnoGame;
import game.cards.Card;
import game.cards.Color;

public class ReverseCard extends ActionCard {
    public ReverseCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
        if (other.getColor() == this.getColor()) {
            return true;
        } else if (other instanceof ReverseCard) {
            return true;
        }
        return false;
    }

    @Override
    public void action(UnoGame game) {
        game.reverseDirection();
    }

    @Override
    public String toString() {
        return this.getColor() + "_REVERSE";
    }
}