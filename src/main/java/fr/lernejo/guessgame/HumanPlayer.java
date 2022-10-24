package fr.lernejo.guessgame;

import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    @Override
    public long askNextGuess() {
        LoggerFactory.getLogger("player").log("Enter a number between 0 and 100:");
        Scanner scan = new Scanner(System.in);
        return scan.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
    }
}
