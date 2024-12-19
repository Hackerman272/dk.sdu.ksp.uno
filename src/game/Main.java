package game;

import game.players.ComputerPlayer;
import game.players.HumanPlayer;

public class Main {
    public static void main(String[] args) {
        UnoGame game = new UnoGame();
        try {
            game.addPlayer(new ComputerPlayer("Computer1"));
            game.addPlayer(new ComputerPlayer("Computer2"));
            game.addPlayer(new ComputerPlayer("Computer3"));
            game.play();
        } catch (RuntimeException e) {
            System.err.println("Game error: " + e.getMessage());
        }
    }
}
