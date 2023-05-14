package at.disys.service;

import at.disys.queue.MessageConsumer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * This class is responsible for dispatching the data collection to the correct
 * data collector. <br>
 *
 * <i><br>
 *     Starts the data gathering job<br>
 *     Has knowledge about the available stations<br>
 *     Sends a message for every charging station to the Station Data Collector<br>
 *     Sends a message to the Data Collection Receiver, that a new job started
 * </i>
 */

@Service
public class DataCollectionDispatcher {
    private final MessageConsumer messageConsumer;
    public DataCollectionDispatcher() {
        messageConsumer = new MessageConsumer("data-collection-queue");
    }

    /**
     * Receives the data collection job from the queue and dispatches it to the
     * correct data collector.
     */
    public void dispatchDataCollectionJob() {
        try {
            String receivedMessage = messageConsumer.startListening("data-collection-queue");
            // Process the received message
            System.out.println("Received message: " + receivedMessage);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
