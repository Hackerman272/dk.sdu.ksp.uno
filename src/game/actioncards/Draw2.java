package game.actioncards;

import game.UnoGame;
import game.cards.Card;
import game.cards.Color;
import game.players.Player;

public class Draw2 extends ActionCard {
    public Draw2(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
        if (other.getColor() == this.getColor()) {
            return true;
        } else if (other instanceof Draw2) {
            return true;
        }
        return false;
    }

    @Override
    public void action(UnoGame game) {
        Player nextPlayer = game.getNextPlayer();
        // Make next player draw 2 cards
        for (int i = 0; i < 2; i++) {
            nextPlayer.drawCardFrom(game.getDrawPile());
        }
        // Skip next player's turn
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return this.getColor() + "_DRAW2";
    }
}