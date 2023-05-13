package at.disys.queue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * This class is resposible for base implementation of a queue service
 */

public abstract class QueueService {
    protected static final String RABBITMQ_HOST = "localhost";
    protected static final int RABBITMQ_PORT = 30003;
    protected final ConnectionFactory factory;
    protected Connection connection;
    protected Channel channel;
    protected String queueName;

    public QueueService(String queueName) {
        this.queueName = queueName;

        factory = new ConnectionFactory();
        factory.setPort(RABBITMQ_PORT);
        factory.setHost(RABBITMQ_HOST);
    }

    /**
     * Connect to RabbitMQ and create a queue with the specified name
     * @throws IOException if there's an issue creating the queue
     * @throws TimeoutException if there's a timeout connecting to RabbitMQ
     */
    public void connect() throws IOException, TimeoutException {
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
    }

    /**
     * Close the connection to RabbitMQ
     * @throws IOException if there's an issue closing the connection
     * @throws TimeoutException if there's a timeout closing the connection
     */
    public void close() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}