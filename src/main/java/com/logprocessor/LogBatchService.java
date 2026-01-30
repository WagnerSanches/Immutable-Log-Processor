package com.logprocessor;

import java.util.List;

public class LogBatchService {
    private final LogProcessor processor = new LogProcessor();

    public long processAll(List<LogEntry> logs)
    {
        return logs.stream()
                .filter(logEntry -> logEntry.level() != LogLevel.DEBUG)
                .peek(processor::process)
                .count();
    }
}
