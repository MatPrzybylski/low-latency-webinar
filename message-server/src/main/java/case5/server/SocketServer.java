package case5.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class SocketServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketServer.class);

    private ServerSocket serverSocket;
    private Socket socket;

    public SocketServer(int port) {
        initialize(port);
    }

    private void initialize(int port) {
        try {
            serverSocket = new ServerSocket(port);
            LOGGER.info("ServerSocket initialized successfully on port " + port);
        } catch (IOException ex) {
            LOGGER.warn("Exception occurred during SocketServer initialization: " + ex);
        }
    }

    public Map<Integer, String> retrieveRequestMessage() {
        Map<Integer, String> messageAsMap = null;
        try {
            socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            messageAsMap = (Map<Integer, String>) objectInputStream.readObject();
        } catch (Exception ex) {
            LOGGER.warn("Exception occurred during retrieving data from Socket: " + ex);
        }
        LOGGER.info("Received data from Socket as MessageRequest: " + messageAsMap);
        return messageAsMap;
    }

    public void sendResponse(String response) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            objectOutputStream.writeObject(response);
            LOGGER.info("Successfully sent response " + response + " to the client!");
        } catch (IOException ex) {
            LOGGER.warn("Exception occurred during writing data to Socket: " + ex);
        }
    }
}
