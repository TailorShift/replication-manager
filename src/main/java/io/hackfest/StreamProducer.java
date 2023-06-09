package io.hackfest;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class StreamProducer {
    static final Logger logger = LoggerFactory.getLogger(GreetingResource.class);

    @Channel("output")
    Emitter<String> emitter;

    public void sendReceiptEvent() {
        logger.info("Send a receipt!");

        // product
//        String msg = """
//                {
//                  "schema": {
//                    "type": "struct",
//                    "fields": [
//                      {
//                        "type": "struct",
//                        "fields": [
//                          {
//                            "type": "int64",
//                            "optional": false,
//                            "field": "id"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "manufacturer"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "name"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "code"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "name": "io.debezium.data.Json",
//                            "version": 1,
//                            "field": "colors"
//                          },
//                          {
//                            "type": "bytes",
//                            "optional": false,
//                            "name": "org.apache.kafka.connect.data.Decimal",
//                            "version": 1,
//                            "parameters": {
//                              "scale": "2",
//                              "connect.decimal.precision": "10"
//                            },
//                            "field": "price"
//                          },
//                          {
//                            "type": "bytes",
//                            "optional": false,
//                            "name": "org.apache.kafka.connect.data.Decimal",
//                            "version": 1,
//                            "parameters": {
//                              "scale": "2",
//                              "connect.decimal.precision": "10"
//                            },
//                            "field": "tax_rate"
//                          }
//                        ],
//                        "optional": true,
//                        "name": "pg_datacenter.public.products.Value",
//                        "field": "before"
//                      },
//                      {
//                        "type": "struct",
//                        "fields": [
//                          {
//                            "type": "int64",
//                            "optional": false,
//                            "field": "id"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "manufacturer"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "name"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "code"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "name": "io.debezium.data.Json",
//                            "version": 1,
//                            "field": "colors"
//                          },
//                          {
//                            "type": "bytes",
//                            "optional": false,
//                            "name": "org.apache.kafka.connect.data.Decimal",
//                            "version": 1,
//                            "parameters": {
//                              "scale": "2",
//                              "connect.decimal.precision": "10"
//                            },
//                            "field": "price"
//                          },
//                          {
//                            "type": "bytes",
//                            "optional": false,
//                            "name": "org.apache.kafka.connect.data.Decimal",
//                            "version": 1,
//                            "parameters": {
//                              "scale": "2",
//                              "connect.decimal.precision": "10"
//                            },
//                            "field": "tax_rate"
//                          }
//                        ],
//                        "optional": true,
//                        "name": "pg_datacenter.public.products.Value",
//                        "field": "after"
//                      },
//                      {
//                        "type": "struct",
//                        "fields": [
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "version"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "connector"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "name"
//                          },
//                          {
//                            "type": "int64",
//                            "optional": false,
//                            "field": "ts_ms"
//                          },
//                          {
//                            "type": "string",
//                            "optional": true,
//                            "name": "io.debezium.data.Enum",
//                            "version": 1,
//                            "parameters": {
//                              "allowed": "true,last,false,incremental"
//                            },
//                            "default": "false",
//                            "field": "snapshot"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "db"
//                          },
//                          {
//                            "type": "string",
//                            "optional": true,
//                            "field": "sequence"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "schema"
//                          },
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "table"
//                          },
//                          {
//                            "type": "int64",
//                            "optional": true,
//                            "field": "txId"
//                          },
//                          {
//                            "type": "int64",
//                            "optional": true,
//                            "field": "lsn"
//                          },
//                          {
//                            "type": "int64",
//                            "optional": true,
//                            "field": "xmin"
//                          }
//                        ],
//                        "optional": false,
//                        "name": "io.debezium.connector.postgresql.Source",
//                        "field": "source"
//                      },
//                      {
//                        "type": "string",
//                        "optional": false,
//                        "field": "op"
//                      },
//                      {
//                        "type": "int64",
//                        "optional": true,
//                        "field": "ts_ms"
//                      },
//                      {
//                        "type": "struct",
//                        "fields": [
//                          {
//                            "type": "string",
//                            "optional": false,
//                            "field": "id"
//                          },
//                          {
//                            "type": "int64",
//                            "optional": false,
//                            "field": "total_order"
//                          },
//                          {
//                            "type": "int64",
//                            "optional": false,
//                            "field": "data_collection_order"
//                          }
//                        ],
//                        "optional": true,
//                        "field": "transaction"
//                      }
//                    ],
//                    "optional": false,
//                    "name": "pg_datacenter.public.products.Envelope"
//                  },
//                  "payload": {
//                    "before": null,
//                    "after": {
//                      "id": 1,
//                      "manufacturer": "RedHat",
//                      "name": "SocksTastic",
//                      "code": "1111",
//                      "colors": "[\\"red\\",\\"black\\",\\"unicorn\\",\\"rainbow\\"]",
//                      "price": "99.9",
//                      "tax_rate": "19.0"
//                    },
//                    "source": {
//                      "version": "1.9.7.Final",
//                      "connector": "postgresql",
//                      "name": "pg-datacenter",
//                      "ts_ms": 1679668428107,
//                      "snapshot": "false",
//                      "db": "pg-datacenter",
//                      "sequence": "[\\"503317576\\",\\"520098848\\"]",
//                      "schema": "public",
//                      "table": "products",
//                      "txId": 543,
//                      "lsn": 520098848,
//                      "xmin": null
//                    },
//                    "op": "u",
//                    "ts_ms": 1679668428389,
//                    "transaction": null
//                  }
//                }
//                """;

        String msg = """
                {"schema":{"type":"struct","fields":[{"type":"struct","fields":[{"type":"int64","optional":false,"field":"id"},{"type":"int64","optional":false,"name":"io.debezium.time.MicroTimestamp","version":1,"field":"timestamp"},{"type":"string","optional":false,"name":"io.debezium.data.Json","version":1,"field":"payload"}],"optional":true,"name":"pg_backoffice.public.debezium_receipt_export.Value","field":"before"},{"type":"struct","fields":[{"type":"int64","optional":false,"field":"id"},{"type":"int64","optional":false,"name":"io.debezium.time.MicroTimestamp","version":1,"field":"timestamp"},{"type":"string","optional":false,"name":"io.debezium.data.Json","version":1,"field":"payload"}],"optional":true,"name":"pg_backoffice.public.debezium_receipt_export.Value","field":"after"},{"type":"struct","fields":[{"type":"string","optional":false,"field":"version"},{"type":"string","optional":false,"field":"connector"},{"type":"string","optional":false,"field":"name"},{"type":"int64","optional":false,"field":"ts_ms"},{"type":"string","optional":true,"name":"io.debezium.data.Enum","version":1,"parameters":{"allowed":"true,last,false,incremental"},"default":"false","field":"snapshot"},{"type":"string","optional":false,"field":"db"},{"type":"string","optional":true,"field":"sequence"},{"type":"string","optional":false,"field":"schema"},{"type":"string","optional":false,"field":"table"},{"type":"int64","optional":true,"field":"txId"},{"type":"int64","optional":true,"field":"lsn"},{"type":"int64","optional":true,"field":"xmin"}],"optional":false,"name":"io.debezium.connector.postgresql.Source","field":"source"},{"type":"string","optional":false,"field":"op"},{"type":"int64","optional":true,"field":"ts_ms"},{"type":"struct","fields":[{"type":"string","optional":false,"field":"id"},{"type":"int64","optional":false,"field":"total_order"},{"type":"int64","optional":false,"field":"data_collection_order"}],"optional":true,"field":"transaction"}],"optional":false,"name":"pg_backoffice.public.debezium_receipt_export.Envelope"},"payload":{"before":null,"after":{"id":123,"timestamp":1680011789000000,"payload":"{\\"id\\":428522119583609806,\\"shopId\\":1,\\"posDeviceId\\":1,\\"customerId\\":null,\\"createdAt\\":\\"2023-03-28T13:53:54.8646475\\",\\"discountTotal\\":0.0,\\"taxTotal\\":0.0,\\"amountTotal\\":24.99,\\"employeeId\\":1,\\"deliveryShopId\\":null,\\"positions\\":[{\\"id\\":428522119583609806,\\"position\\":1,\\"productId\\":1,\\"size\\":\\"M\\",\\"color\\":\\"Black\\",\\"quantity\\":1,\\"returnedQuantity\\":null,\\"price\\":24.99,\\"discount\\":0,\\"discountReason\\":null,\\"taxRate\\":19.0}]}"},"source":{"version":"1.9.7.Final","connector":"postgresql","name":"pg-backoffice","ts_ms":1680004592161,"snapshot":"false","db":"pg-backoffice","sequence":"[\\"486543616\\",\\"520093736\\"]","schema":"public","table":"debezium_receipt_export","txId":532,"lsn":520093736,"xmin":null},"op":"c","ts_ms":1680004592471,"transaction":null}}
                """;

        try {
            emitter.send(msg)
                    .toCompletableFuture()
                    .get(5, TimeUnit.SECONDS);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
