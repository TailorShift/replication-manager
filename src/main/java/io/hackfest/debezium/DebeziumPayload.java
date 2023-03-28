package io.hackfest.debezium;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DebeziumPayload<T>(
        T before,
        T after,
        String op,
        @JsonProperty("ts_ms")
        Long tsMs
) {
}