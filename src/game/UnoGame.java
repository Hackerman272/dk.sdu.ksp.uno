package game;

import game.actioncards.WildDraw4Card;
import game.cards.Card;
import game.piles.DrawPile;
import game.piles.DiscardPile;
import game.players.Player;
import game.actioncards.ActionCard;

import java.util.ArrayList;
import java.util.Random;

public class UnoGame implements Describable {
    private ArrayList<Player> players;
    private DrawPile drawPile;
    private DiscardPile discardPile;
    private Player currentPlayer;
    private Player winner;
    private boolean isClockwise = true;

    public UnoGame() {
        players = new ArrayList<>();
        drawPile = new DrawPile();
        discardPile = new DiscardPile(drawPile.draw());
    }

    public void addPlayer(Player player) {
        if (players.size() >= 10) {
            throw new RuntimeException("Maximum number of game.game.cards.cards.players reached");
        }
        if (players.contains(player)) {
            throw new RuntimeException("Player already exists in the game");
        }
        players.add(player);
    }

    public void play() {
        if (players.size() < 2 || players.size() > 10) {
            throw new RuntimeException("Invalid number of players");
        }

        dealCards();
        currentPlayer = players.get(new Random().nextInt(players.size()));

        while (winner == null) {
            printGameStatus();

            if (!currentPlayer.hasPlayableHand(discardPile.getTopCard())) {
                if (drawPile.isEmpty()) {
                    shuffleDiscardPile();
                }
                currentPlayer.drawCardFrom(drawPile);

                if (!currentPlayer.hasPlayableHand(discardPile.getTopCard())) {
                    passTurn();
                    continue;
                }
            }

            currentPlayer.displayHand();

            try {
                Card playedCard = currentPlayer.playCard(discardPile);

                if (!currentPlayer.canPlayCard(playedCard, discardPile.getTopCard()) ||
                        (playedCard instanceof WildDraw4Card && !isValidWildCardPlay(playedCard, currentPlayer))) {
                    throw new IllegalStateException("Invalid card play");
                }

                System.out.println(currentPlayer.getName() + " played: " + playedCard);

                if (playedCard instanceof ActionCard) {
                    ((ActionCard) playedCard).action(this);
                }

                if (currentPlayer.getHand().isEmpty()) {
                    winner = currentPlayer;
                    break;
                }

                passTurn();

            } catch (IllegalStateException e) {
                System.out.println("\nError: " + e.getMessage());
            }
        }

        System.out.println("\nWinner: " + winner.getName());
    }


    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.receiveCard(drawPile.draw());
            }
        }
    }

    private void passTurn() {
        int currentIndex = players.indexOf(currentPlayer);
        if (isClockwise) {
            currentPlayer = players.get((currentIndex + 1) % players.size());
        } else {
            currentPlayer = players.get((currentIndex - 1 + players.size()) % players.size());
        }
    }

    public void shuffleDiscardPile() {
        if (drawPile.isEmpty()) {
            drawPile = discardPile.shuffleAndTurnAround();
        }
    }


    private void printGameStatus() {
        System.out.println("\nCurrent player: " + currentPlayer.getName());
        System.out.println("Top card: " + discardPile.getTopCard());
        System.out.println("Draw pile size: " + drawPile.getSize());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String getDescription() {
        return "game.game.cards.cards.UnoGame with " + players.size() + " players";
    }

    public DrawPile getDrawPile() {
        return drawPile;
    }


    public void reverseDirection() {
        isClockwise = !isClockwise;
    }

    public void skipNextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        currentPlayer = players.get((currentIndex + 2) % players.size());
    }

    public boolean isValidWildCardPlay(Card card, Player player) {
        if (card instanceof WildDraw4Card) {
            return !player.hasMatchingColorCard(discardPile.getTopCard().getColor());
        }
        return true;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public Player getNextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        if (isClockwise) {
            return players.get((currentIndex + 1) % players.size());
        } else {
            return players.get((currentIndex - 1 + players.size()) % players.size());
        }
    }

}