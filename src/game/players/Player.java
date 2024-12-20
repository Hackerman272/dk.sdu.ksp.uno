package game.players;

import game.Describable;
import game.actioncards.WildDraw4Card;
import game.cards.Card;
import game.cards.Color;
import game.piles.DrawPile;
import game.piles.DiscardPile;

import java.util.ArrayList;

public abstract class Player implements Describable {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void drawCardFrom(DrawPile pile) {
        hand.add(pile.draw());
    }

    public boolean hasPlayableHand(Card card) {
        for (Card c : hand) {
            if (c.matches(card)) {
                return true;
            }
        }
        return false;
    }

    public void receiveCard(Card c) {
        hand.add(c);
    }

    public void displayHand() {
        System.out.println(name + "'s hand: ");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print(i + ":" + hand.get(i) + " | ");
        }
        System.out.println();
    }

    public abstract Card playCard(DiscardPile pile);

    public abstract Color announceCardColor();


    @Override
    public String getDescription() {
        return "Player: " + name + " with " + hand.size() + " cards";
    }

    public boolean hasMatchingColorCard(Color color) {
        for (Card card : hand) {
            if (card.getColor() == color) {
                return true;
            }
        }
        return false;
    }

    public boolean canPlayCard(Card card, Card topCard) {
        if (!card.matches(topCard)) {
            return false;
        }

        if (card instanceof WildDraw4Card) {
            return !hasMatchingColorCard(topCard.getColor());
        }

        return true;
    }
}