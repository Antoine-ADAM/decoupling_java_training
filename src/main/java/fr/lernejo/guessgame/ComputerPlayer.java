package fr.lernejo.guessgame;

public class ComputerPlayer implements Player {
    private long min = 0;
    private long max = 100;
    private long guess = 50;

    @Override
    public long askNextGuess() {
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            if(guess == min){
                guess++;
                min++;
            }else{
                min = guess;
                guess = (min + max) / 2;
            }
        } else {
            if(guess == max){
                guess--;
                max--;
            }else{
                max = guess;
                guess = (min + max) / 2;
            }
        }
    }
}
