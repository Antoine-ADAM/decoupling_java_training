package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if(args.length == 0) {
            help();
            return;
        }
        switch (args[0]) {
            case "-interactive":
                interactively();
                break;
            case "-auto":
                if (args.length == 2) {
                    try {
                        long nb = Long.parseLong(args[1]);
                        automatically(nb);
                    } catch (NumberFormatException e) {
                        System.out.println("The second argument must be an long number");
                    }
                }
                break;
            default:
                help();
        }
    }
    public static void interactively() {
        Player player = new HumanPlayer();
        Simulation sim = new Simulation(player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        sim.initialize(randomNumber);
        sim.loopUntilPlayerSucceed(Long.MAX_VALUE);
    }
    public static void automatically(long number) {
        Player player = new ComputerPlayer();
        Simulation sim = new Simulation(player);
        sim.initialize(number);
        sim.loopUntilPlayerSucceed(1000);
    }
    public static void help(){
        System.out.println("Usage: java -jar guessgame.jar [-auto <number> | -interactive]");
    }
}
