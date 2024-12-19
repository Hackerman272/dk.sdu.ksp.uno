package game.piles;

import game.Descriptable;
import game.actioncards.*;
import game.cards.Card;
import game.cards.NumberCard;
import game.cards.Color;

import java.util.ArrayList;
import java.util.Collections;

public class DrawPile implements Descriptable {
    private ArrayList<Card> cards;

    public DrawPile() {
        cards = new ArrayList<>();
        initializeCards();
        shuffle();
    }

    private void initializeCards() {
        for (Color color : new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW}) {
            cards.add(new NumberCard(color, 0));

            for (int i = 1; i <= 9; i++) {
                cards.add(new NumberCard(color, i));
                cards.add(new NumberCard(color, i));
            }

            // Two of each action card per color
            cards.add(new Draw2(color));
            cards.add(new Draw2(color));

            cards.add(new ReverseCard(color));
            cards.add(new ReverseCard(color));

            cards.add(new SkipCard(color));
            cards.add(new SkipCard(color));
        }

        // Add wild cards (4 of each type)
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard());
            cards.add(new WildDraw4Card());
        }
    }


    private void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (isEmpty()) {
            throw new RuntimeException("DrawPile is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getSize() {
        return cards.size();
    }

    @Override
    public String getDescription() {
        return "DrawPile containing " + getSize() + " cards";
    }
}