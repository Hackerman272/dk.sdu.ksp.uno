package game.actioncards;
import game.UnoGame;
import game.cards.Card;
import game.cards.Color;

public class WildCard extends ActionCard {
    public WildCard() {
        super(Color.WILD);
    }

    @Override
    public boolean matches(Card other) {
        return true;
    }

    @Override
    public void action(UnoGame game) {
        Color newColor = game.getCurrentPlayer().announceCardColor();
        System.out.println("Wild card played. New color is: " + newColor);
        this.setColor(newColor);
    }

    @Override
    public String toString() {
        return this.getColor().toString() + "_WILD";
    }
}
