package at.disys.queue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageConsumer extends QueueService{

    public MessageConsumer(String queueName) {
        super(queueName);
    }


    public String startListening(String queueName) throws IOException, TimeoutException, InterruptedException {
        connect();

        // Create a new consumer object
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Received message: " + message);
                // Return the received message
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        // Start consuming messages from the queue
        channel.basicConsume(queueName, false, consumer);

        // Wait for a message to be received
        while (true) {
            boolean delivered = channel.waitForConfirms(1000);

            if (delivered) {
                // Return the received message
                GetResponse response = channel.basicGet(queueName, false);
                if (response != null) {
                    byte[] body = response.getBody();
                    channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
                    return new String(body, "UTF-8");
                }
            }
        }
    }



}
