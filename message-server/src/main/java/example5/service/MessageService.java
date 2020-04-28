package example5.service;

import example5.buffer.RequestMessageBuffer;
import example5.data.FinanceMessage;
import example5.parser.MessageParser;
import example5.pool.FinanceMessagePool;
import example5.pool.Pool;
import example5.server.SocketServer;
import example5.validator.FinanceMessageValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    private final String FAILED = "failed";
    private final String SUCCESS = "success";

    private SocketServer socketServer;
    private RequestMessageBuffer requestMessageBuffer;
    private MessageParser messageParser;
    private Pool<FinanceMessage> messagePool;
    private FinanceMessageValidator financeMessageValidator;


    public MessageService() {
        this.requestMessageBuffer = new RequestMessageBuffer();
        this.messageParser = new MessageParser();
        this.messagePool = new FinanceMessagePool(4);
        this.socketServer = new SocketServer(4999);
        this.financeMessageValidator = new FinanceMessageValidator();
        LOGGER.info("Initialized successfully MessageService.");
    }

    public void start() {
            //listen to TCP socket and store read data in Buffer
            Thread serverSocketTask = new Thread(serverSocketTask());
            serverSocketTask.start();
            LOGGER.info("Successfully started " + serverSocketTask.getName() + " with state " + serverSocketTask.getState() + ".");

            //process message from Buffer
            processMessageTask();
    }

    private Runnable serverSocketTask() {
        return () -> {
            while (true) {
                    Map<Integer, String> requestMessage = socketServer.retrieveRequestMessage();
                    requestMessageBuffer.add(requestMessage);
            }
        };
    }

    private void processMessageTask() {

        //get message from buffer and process it
        while (true) {
            while (!requestMessageBuffer.isEmpty()) {
                if (!messagePool.isEmpty()) {
                    processMessage();
                }
            }
        }
    }

    //main business flow
    private void processMessage() {
        LOGGER.debug("Buffer and Pool is not empty. Starting processing of RequestMessage.");

        //request to be processed
        Map<Integer, String> requestMessage = requestMessageBuffer.get();
        LOGGER.debug("Retrieved RequestMessage from Buffer: " + requestMessage);

        //checkout object from pool
        FinanceMessage financeMessage = messagePool.checkOut();

        //reset object
        financeMessage.reset();

        //parse bytes into MyMessage when object available
        messageParser.parseRequestMessageIntoFinanceMessage(requestMessage, financeMessage);

        //validate FinanceMessage and SessionStatus
        financeMessageValidator.validate(financeMessage);

        //send response
        if (financeMessage.isValidationFailed()) {
            socketServer.sendResponse(financeMessage.getId() + FAILED);
        } else {
            socketServer.sendResponse(financeMessage.getId() + SUCCESS);
        }

        //return object to pool
        messagePool.returnObject(financeMessage);
        LOGGER.debug("Finished successfully processing message with ID: " + requestMessage.get(1));
    }
}
