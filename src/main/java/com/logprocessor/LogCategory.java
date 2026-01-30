package com.logprocessor;

public sealed interface LogCategory permits NetworkError, DatabaseError, SecurityAudit { }

record NetworkError(String protocol, String destinationIp) implements LogCategory {}
record DatabaseError(String query, int errorCode) implements LogCategory {}
record SecurityAudit(String usedId, String action) implements LogCategory {}