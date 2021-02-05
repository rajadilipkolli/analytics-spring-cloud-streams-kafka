package com.example.analytics.sink;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PageCountSink {

  @Bean
  public Consumer<KTable<String, Long>> processStreamFromPcsTopic() {
    return kTableCounts ->
        kTableCounts
            .toStream()
            .foreach((key, value) -> log.info("Key = {}, value = {}", key, value));
  }
}
