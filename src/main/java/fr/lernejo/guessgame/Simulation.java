package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("You guessed the right number");
            return true;
        }
        if(guess < numberToGuess) {
            logger.log("The number to find is greater than your guess");
            player.respond(true);
        } else {
            logger.log("The number to find is lower than your guess");
            player.respond(false);
        }
        player.respond(guess < numberToGuess);
        return false;
    }

    public void loopUntilPlayerSucceed(long maxTry) {
        long time = System.currentTimeMillis();
        for (long i = 0; i < maxTry; i++) {
            if (nextRound()) {
                logger.log("You won in " + (i + 1) + " tries");
                //print time format mm:ss:SSS
                logger.log("Time: " + String.format("%02d:%02d:%03d", (System.currentTimeMillis() - time) / 60000, (System.currentTimeMillis() - time) / 1000 % 60, (System.currentTimeMillis() - time) % 1000));
                return;
            }
        }
        logger.log("You have reached the maximum number of tries");
    }
}
