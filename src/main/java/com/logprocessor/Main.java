package com.logprocessor;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        LogProcessor processor = new LogProcessor();

        LogEntry entry = new LogEntry("1", Instant.now(), LogLevel.ERROR, "Timeout", new NetworkError("HTTPS", "10.0.0.0"));

        processor.process(entry);
    }
}