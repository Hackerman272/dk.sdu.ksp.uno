package game.players;

import game.actioncards.WildCard;
import game.cards.Card;
import game.cards.Color;
import game.piles.DiscardPile;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard(DiscardPile pile) {
        Card topCard = pile.getTopCard();
        for (Card card : getHand()) {
            if (canPlayCard(card, topCard) && !(card instanceof WildCard)) {
                getHand().remove(card);
                pile.addCard(card);
                return card;
            }
        }
        for (Card card : getHand()) {
            if (canPlayCard(card, topCard)) {
                getHand().remove(card);
                pile.addCard(card);
                return card;
            }
        }
        throw new RuntimeException("No playable card in hand");
    }

    @Override
    public Color announceCardColor() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        return colors[new Random().nextInt(colors.length)];
    }
}