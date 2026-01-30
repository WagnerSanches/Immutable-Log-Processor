package com.logprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


public class LogBatchServiceTest {

    private final LogBatchService service = new LogBatchService();

    @Test
    void shouldFilterOutDebugDuringBatchProcessing() {

        List<LogEntry> logs = List.of(
            new LogEntry(UUID.randomUUID().toString(), Instant.now(), LogLevel.ERROR, "Critical", new NetworkError("UDP", "1.1.1.1")),
            new LogEntry(UUID.randomUUID().toString(), Instant.now(), LogLevel.DEBUG, "Trace info", new NetworkError("TCP", "127.0.0.1"))
        );

        long processedLogs = service.processAll(logs);

        Assertions.assertEquals(1, processedLogs);
    }
}
