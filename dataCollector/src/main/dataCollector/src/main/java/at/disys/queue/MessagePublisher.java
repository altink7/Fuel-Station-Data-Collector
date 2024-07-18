package at.disys.queue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * This class is responsible for sending messages from a RabbitMQ queue
 */
public class MessagePublisher extends QueueService{
    public MessagePublisher(String queueName) {
        super(queueName);
    }

    /**
     * Send a message to the queue
     * @param message the message to send
     * @throws IOException if there's an issue sending the message
     */
    public void sendMessage(String message) throws IOException {
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("Sent message: " + message);
    }
}
