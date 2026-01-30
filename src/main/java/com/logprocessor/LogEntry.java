package com.logprocessor;

import java.time.Instant;

public record LogEntry(
        String id,
        Instant timestamp,
        LogLevel level,
        String message,
        LogCategory category
) { }

enum LogLevel {
    INFO, WARN, ERROR, DEBUG
}