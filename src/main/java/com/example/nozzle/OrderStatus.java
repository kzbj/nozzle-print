package com.example.nozzle;

/*
 * Allowed transitions:
 *   LOOKING_FOR_PRINTER -> ACCEPTED, CANCELED, EXPIRED
 *   ACCEPTED            -> PRINTING
 *   PRINTING            -> SHIPPED
 *   SHIPPED             -> DELIVERED
 *   DELIVERED, CANCELED, EXPIRED -> (final, no transitions)
 */

public enum OrderStatus {
    LOOKING_FOR_PRINTER(false),
    ACCEPTED(false),
    PRINTING(false),
    SHIPPED(false),
    DELIVERED(true),
    CANCELED(true),
    EXPIRED(true);

    private final boolean isFinal;

    OrderStatus(boolean isFinal){
        this.isFinal = isFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
