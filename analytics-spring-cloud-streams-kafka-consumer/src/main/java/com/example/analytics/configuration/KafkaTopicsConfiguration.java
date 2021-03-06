package com.example.analytics.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicsConfiguration {

    private final AnalyticsApplicationProperties analyticsApplicationProperties;

    public KafkaTopicsConfiguration(AnalyticsApplicationProperties analyticsApplicationProperties) {
        this.analyticsApplicationProperties = analyticsApplicationProperties;
    }

    @Bean
    public NewTopic kafkaStreamspcmvRePartitionTopic() {
        return new NewTopic(
                analyticsApplicationProperties.topicNameRePartition(),
                analyticsApplicationProperties.partitions(),
                analyticsApplicationProperties.replication());
    }

    @Bean
    public NewTopic kafkaStreamspcmvChangeLogTopic() {
        return new NewTopic(
                analyticsApplicationProperties.topicNameChangelog(),
                analyticsApplicationProperties.partitions(),
                analyticsApplicationProperties.replication());
    }

    @Bean
    public NewTopic pcsTopic() {

        return new NewTopic(
                analyticsApplicationProperties.topicNamePcs(),
                analyticsApplicationProperties.partitions(),
                analyticsApplicationProperties.replication());
    }

    @Bean
    public NewTopic pvsTopic() {

        return new NewTopic(
                analyticsApplicationProperties.topicNamePvs(),
                analyticsApplicationProperties.partitions(),
                analyticsApplicationProperties.replication());
    }
}
