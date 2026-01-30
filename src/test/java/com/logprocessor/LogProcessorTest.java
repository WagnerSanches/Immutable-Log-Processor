package com.logprocessor;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LogProcessorTest {
    private final LogProcessor processor = new LogProcessor();

    @Test
    void shouldProcessNetworkErrorCorrectly() {
        LogEntry entry = new LogEntry(
                UUID.randomUUID().toString(),
                Instant.now(),
                LogLevel.ERROR,
                "Connection refused",
                new NetworkError("TCP", "192.168.0.60")
        );

        assertDoesNotThrow(() -> processor.process(entry));
    }

    @Test
    void recordShouldMaintainDataIntegrity() {
        String message = "Database timeout";
        DatabaseError dbError = new DatabaseError("SELECT 1", 408);

        LogEntry entry = new LogEntry(
                UUID.randomUUID().toString(),
                Instant.now(),
                LogLevel.WARN,
                message,
                dbError
        );

        assertEquals(message, entry.message());
        assertEquals(dbError, entry.category());
    }
}
