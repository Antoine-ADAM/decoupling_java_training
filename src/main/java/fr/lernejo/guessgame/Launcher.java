package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        Simulation sim = new Simulation(player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        sim.initialize(randomNumber);
        sim.loopUntilPlayerSucceed();
    }
}
