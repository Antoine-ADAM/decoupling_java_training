package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final Logger delegateLogger;
    private final String name;
    private final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public ContextualLogger(Logger logger, String name) {
        this.delegateLogger = logger;
        this.name = name;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(this.pattern) + " " + this.name + " " + message);
    }
}

