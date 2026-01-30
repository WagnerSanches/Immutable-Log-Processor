package com.logprocessor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        LogBatchService service = new LogBatchService();

        List<LogEntry> logs = List.of(
                new LogEntry(UUID.randomUUID().toString(), Instant.now(), LogLevel.INFO, "User Login", new SecurityAudit("admin", "LOGIN")),
                new LogEntry(UUID.randomUUID().toString(), Instant.now(), LogLevel.DEBUG, "Fine grain trace", new NetworkError("TCP", "127.0.0.1")),
                new LogEntry(UUID.randomUUID().toString(), Instant.now(), LogLevel.ERROR, "database down", new DatabaseError("SELECT ... ", 500))
        );

        service.processAll(logs);
    }
}