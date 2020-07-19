package case5.validator;

import case5.data.FinanceMessage;
import case5.util.MyStringBufferConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinanceMessageValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceMessageValidator.class);

    public void validate(FinanceMessage message) {
        if (!MyStringBufferConstants.GOOD_SENDER.equals(message.getSender())) {
            message.setValidationFailed();
            LOGGER.warn("Message with ID " + message.getId() + " failed validation for field Sender. Expected value: "
                    + MyStringBufferConstants.GOOD_SENDER + ". Actual value: " + message.getSender());
            return;
        }

        if (!MyStringBufferConstants.GOOD_COMPANY.equals(message.getCompany())) {
            message.setValidationFailed();
            LOGGER.warn("Message with ID " + message.getId() + " failed validation for field Company. Expected value: "
                    + MyStringBufferConstants.GOOD_COMPANY + ". Actual value: " + message.getCompany());
            return;
        }

        if (!MyStringBufferConstants.SESSION_OK.equals(message.getSessionStatus())) {
            LOGGER.warn("Message with ID " + message.getId() + " failed validation for field SessionStatus. Expected value: "
                    + MyStringBufferConstants.SESSION_OK + ". Actual value: " + message.getSessionStatus());
            message.setValidationFailed();
        }
    }
}
