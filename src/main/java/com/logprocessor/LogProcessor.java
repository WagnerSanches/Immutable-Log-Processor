package com.logprocessor;

public class LogProcessor {
    public void process(LogEntry logEntry) {
        System.out.println("Iniciando o processamento do log: " + logEntry.id());

        switch(logEntry.category())
        {
            case NetworkError net ->
                handleNetworkIssue(net, logEntry.message());
            case DatabaseError db ->
                handleDatabaseIssue(db, logEntry.message());
            case SecurityAudit security ->
                handleSecurityEvent(security, logEntry.message());
        }
    }

    private void handleNetworkIssue(NetworkError error, String message)
    {
        System.out.printf("[ALERTA REDE] Protocolo: %s | Destino: %s | Mensagem: %s%n",
                error.protocol(), error.destinationIp(), message);
    }

    private void handleDatabaseIssue(DatabaseError error, String message)
    {
        System.out.printf("[LOG DB] Codigo: %s | Query: %s | Mensagem: %s%n",
                error.errorCode(), error.query(), message);
    }

    private void handleSecurityEvent(SecurityAudit error, String message)
    {
        System.out.printf("[CRITICO] Usuario: %s | Acao: %s | Mensagem: %s%n",
                error.usedId(), error.action(), message);
    }

}
