package game.actioncards;

import game.UnoGame;
import game.cards.Card;
import game.cards.Color;

public abstract class ActionCard extends Card {
    public ActionCard(Color color) {
        super(color);
    }

    public abstract void action(UnoGame game);
}