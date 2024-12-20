package game.actioncards;

import game.UnoGame;
import game.cards.Card;
import game.cards.Color;
import game.players.Player;

public class WildDraw4Card extends ActionCard {
    public WildDraw4Card() {
        super(Color.WILD);
    }

    @Override
    public boolean matches(Card other) {
        return true;
    }

    @Override
    public void action(UnoGame game) {
        Player currentPlayer = game.getCurrentPlayer();
        if (currentPlayer.hasMatchingColorCard(game.getDiscardPile().getTopCard().getColor())) {
            throw new IllegalStateException("Cannot play Wild Draw 4 when you have matching colors");
        }

        Color newColor = currentPlayer.announceCardColor();
        this.setColor(newColor);

        Player nextPlayer = game.getNextPlayer();
        for (int i = 0; i < 4; i++) {
            nextPlayer.drawCardFrom(game.getDrawPile());
        }
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return this.getColor() + "_WILD_DRAW4";
    }
}
