package io.hackfest.debezium;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DebeziumMessage<T>(
        DebeziumPayload<T> payload
) {
}
