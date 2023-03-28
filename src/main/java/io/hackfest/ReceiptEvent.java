package io.hackfest;

public record ReceiptEvent(
        Long id,
        Long timestamp,
        String payload
) {
}
