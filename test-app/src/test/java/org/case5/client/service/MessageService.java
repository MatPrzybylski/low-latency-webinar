package org.case5.client.service;

import org.case5.client.socket.ClientSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    private ClientSocket<Map<Integer, String>, String> clientSocket;

    public MessageService(int port) {
        this.clientSocket = new ClientSocket<>(port);
    }

    public void sendMessage(Map<Integer, String> message ) {
        clientSocket.send(message);
        LOGGER.info("Message " + message + " sent successfully.");
    }

    public Map<Integer, String> prepareMessage(int id, String sender, String company, String sessionStatus) {
        Map<Integer, String> map = new HashMap<>(8);
        map.put(1, Integer.valueOf(id).toString());
        map.put(2, sender);
        map.put(3, company);
        map.put(4, sessionStatus);
        return map;
    }

    public String getResponse() {
        return clientSocket.acceptResponse();
    }
}
