package com.srimantatech.productservice;

import com.srimantatech.productservice.dto.OrderProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.EnableTestBinder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

@SpringBootTest
@EnableTestBinder
class ProductserviceApplicationTests {

	@Autowired
	private InputDestination input;
	@Autowired
	private OutputDestination output;

	@Test
	public void testProductAvailability() {
		input.send(MessageBuilder.withPayload(new OrderProductDto(1, 1, 1)).build(),
				"product-availability-queue");
		Message<byte[]> message = output.receive(10000, "product-confirmation-queue");

		assertThat(Boolean.parseBoolean(new String(message.getPayload())))
				.isTrue();
	}
}
