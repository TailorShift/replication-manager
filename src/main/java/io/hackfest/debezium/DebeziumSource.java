package io.hackfest.debezium;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DebeziumSource(
        String name,
        String snapshot,
        String db,
        String schema,
        String table,
        Long txId
) {
}
