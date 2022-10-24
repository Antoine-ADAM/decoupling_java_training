package fr.lernejo.logger;

public class CompositeLogger implements Logger {
    private final Logger[] loggers;

    public CompositeLogger(Logger... loggers) {
        this.loggers = loggers;
    }

    @Override
    public void log(String message) {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }
}
