package org.case5;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.case5.client.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);

    private MessageService messageService = new MessageService(4999);
    private Map<Integer, String> messageToSend;

    @Given("message with id {int} and sender {string} and company {string} and session status {string}")
    public void message_with_id_and_sender_and_company_and_session_status(Integer id, String sender, String company, String sessionStatus) {
        this.messageToSend = messageService.prepareMessage(id, sender, company, sessionStatus);
        LOGGER.info("Prepared message to send " + messageToSend);
    }

    @When("send message to server")
    public void send_message_to_server() {
        messageService.sendMessage(messageToSend);
    }

    @Then("validate returned response id {int} and validation status {string}")
    public void validate_returned_response_id_and_validation_status(Integer id, String validationStatus) {
        String response = messageService.getResponse();
        LOGGER.info("Received response from server: " + response);
        assertEquals(id+validationStatus, response);
    }

}
