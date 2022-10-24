package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        return
            new ContextualLogger(new CompositeLogger(
                new FilteredLogger(
                    new FileLogger("test.log"),
                    s -> !s.contains("player")
                ),
                new ConsoleLogger()
        ), name);
    }
}
