package case5.buffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestMessageBuffer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestMessageBuffer.class);

    private LinkedBlockingQueue<Map<Integer, String>> requestMessages;

    public RequestMessageBuffer() {
        this.requestMessages = new LinkedBlockingQueue<>();
        LOGGER.info("Created RequestMessageBuffer!");
    }

    public void add(Map<Integer, String> message) {
        requestMessages.add(message);
        LOGGER.debug("Added message to Buffer: " + message);
    }

    public boolean isEmpty() {
        return this.requestMessages.isEmpty();
    }

    public Map<Integer, String> get() {
        return this.requestMessages.poll();
    }
}
