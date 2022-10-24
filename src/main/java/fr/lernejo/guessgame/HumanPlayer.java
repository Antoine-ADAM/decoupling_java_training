package fr.lernejo.guessgame;

import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    @Override
    public long askNextGuess() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        LoggerFactory.getLogger("player").log("The number to find is " + (lowerOrGreater ? "greater" : "lower") + " than your guess");
    }
}
