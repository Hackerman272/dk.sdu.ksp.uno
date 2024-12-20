package game.piles;

import game.Describable;
import game.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class DiscardPile implements Describable {
    private ArrayList<Card> cards;

    public DiscardPile(Card initialCard) {
        cards = new ArrayList<>();
        cards.add(initialCard);
    }

    public Card getTopCard() {
        return cards.get(cards.size() - 1);
    }

    public void addCard(Card card) {
        if (card.matches(getTopCard())) {
            cards.add(card);
        }
    }

    public DrawPile shuffleAndTurnAround() {
        Card topCard = cards.remove(cards.size() - 1);
        ArrayList<Card> shuffledCards = new ArrayList<>(cards);
        Collections.shuffle(shuffledCards);
        cards.clear();
        cards.add(topCard);
        return new DrawPile();
    }


    @Override
    public String getDescription() {
        return "DiscardPile with top card: " + getTopCard();
    }
}
