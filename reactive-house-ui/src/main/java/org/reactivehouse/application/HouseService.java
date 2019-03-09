package org.reactivehouse.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

@Path("/api")
@ApplicationScoped
public class HouseService {

	@Inject
	Producer<String,String> producer;

	/*
	* Send a Message to the kafka Topic
	*/
	@GET
	@Path("/message/{topic}/{message}")
	public String message(@PathParam("topic") String topic, @PathParam("message") String message) {

		producer.send(new ProducerRecord<String, String>(topic, "HouseService", message));

		return "Success";
	}
}