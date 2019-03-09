package org.reactivehouse.kafka;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

/*
* CDI Producer for KafkaProducer
*/
@ApplicationScoped
public class KafkaProducerProducer {

    @Inject
    @ConfigProperty(name = "kafka.hostname", defaultValue = "localhost")
    String hostname;

    @Inject
    @ConfigProperty(name = "kafka.port", defaultValue = "9092")
    int port;

    @Produces
    public Producer<String,String> createKafkaProducer() {
		Properties props = new Properties();
		props.put("bootstrap.servers", hostname + ":" + port);
		props.put("acks", "all");
		props.put("delivery.timeout.ms", 120000);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		return new KafkaProducer<>(props);
    }

    public void close(@Disposes Producer<String,String> toClose) {
        toClose.close();
    }
}