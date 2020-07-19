package case5.parser;

import case5.data.FinanceMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MessageParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageParser.class);

    //predefined keys from doc
    public void parseRequestMessageIntoFinanceMessage(Map<Integer, String> requestMessage, FinanceMessage financeMessage) {
        financeMessage.setId(Integer.parseInt(requestMessage.get(1)));
        financeMessage.setSender(requestMessage.get(2));
        financeMessage.setCompany(requestMessage.get(3));
        financeMessage.setSessionStatus(requestMessage.get(4));
        LOGGER.debug("Successfully parsed RequestMessage " + requestMessage + " into " + financeMessage);
    }
}
