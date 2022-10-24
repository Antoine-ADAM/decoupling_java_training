package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger {
    private final Logger delegateLogger;
    private final Predicate<String> filter;

    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        this.delegateLogger = delegate;
        this.filter = condition;
    }

    @Override
    public void log(String message) {
        if (filter.test(message)) {
            delegateLogger.log(message);
        }
    }
}
