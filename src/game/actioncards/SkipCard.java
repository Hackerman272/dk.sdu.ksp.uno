package game.actioncards;

import game.UnoGame;
import game.cards.Card;
import game.cards.Color;

public class SkipCard extends ActionCard {
    public SkipCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
        if (other.getColor() == this.getColor()) {
            return true;
        } else if (other instanceof SkipCard) {
            return true;
        }
        return false;
    }

    @Override
    public void action(UnoGame game) {
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return this.getColor() + "_SKIP";
    }
}
