package org.case5.client.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket<T, R> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSocket.class);

    private Socket socket;

    public ClientSocket(int port) {
        start(port);
    }

    private void start(int port) {
        try {
            socket = new Socket("localhost", port);
            LOGGER.info("Created Socket " + socket + " successfully!");
        } catch (IOException ex) {
            LOGGER.error("Could not create Socket with " + port + ". Exception occurred: " + ex.getMessage());
        }
    }

    public void send(T message) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (Exception ex) {
            LOGGER.error("Could not send message " + message + ". Exception occurred: " + ex.getMessage());
        }
    }

    public R acceptResponse() {
        try (ObjectInputStream inputStreamReader = new ObjectInputStream(socket.getInputStream())) {
            return (R) inputStreamReader.readObject();
        } catch (Exception ex) {
            LOGGER.error("Could not read response from Socket. Exception occurred: " + ex.getMessage());
        }
        return null;
    }

}
