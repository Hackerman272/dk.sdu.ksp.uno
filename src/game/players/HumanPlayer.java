package game.players;

import game.cards.Card;
import game.cards.Color;
import game.piles.DiscardPile;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard(DiscardPile pile) {
        while (true) {
            System.out.println("Choose a card index to play:");
            try {
                int index = scanner.nextInt();
                if (index >= 0 && index < getHand().size()) {
                    Card selectedCard = getHand().get(index);
                    if (canPlayCard(selectedCard, pile.getTopCard())) {
                        getHand().remove(index);
                        pile.addCard(selectedCard);
                        return selectedCard;
                    } else {
                        System.out.println("Invalid card. Try again.");
                    }
                } else {
                    System.out.println("Invalid index. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public Color announceCardColor() {
        while (true) {
            System.out.println("Choose a color (RED, GREEN, BLUE, YELLOW):");
            String colorInput = scanner.next().toUpperCase();

            try {
                Color chosenColor = Color.valueOf(colorInput);

                if (chosenColor != Color.WILD) {
                    return chosenColor;
                } else {
                    System.out.println("WILD is not a valid color choice. Please choose RED, GREEN, BLUE, or YELLOW.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid color! Please choose RED, GREEN, BLUE, or YELLOW.");
            }
        }
    }
}
