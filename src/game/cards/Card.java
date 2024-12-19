package game.cards;

public abstract class Card {
    private Color color;

    public Card(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean matches(Card other);
}
