package example5.data;

import java.util.Objects;

public class FinanceMessage {

    private int id;
    private MyStringBuffer sessionStatus = new MyStringBuffer(new byte[64], 0, 0);
    private MyStringBuffer company = new MyStringBuffer(new byte[64], 0, 0);
    private MyStringBuffer sender = new MyStringBuffer(new byte[0], 0, 0);
    private boolean isValidationFailed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyStringBuffer getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus.setBuffer(sessionStatus.getBytes());
        this.sessionStatus.setOffset(0);
        this.sessionStatus.setLength(sessionStatus.length());
    }

    public MyStringBuffer getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company.setBuffer(company.getBytes());
        this.company.setOffset(0);
        this.company.setLength(company.length());
    }

    public MyStringBuffer getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender.setBuffer(sender.getBytes());
        this.sender.setOffset(0);
        this.sender.setLength(sender.length());
    }

    public boolean isValidationFailed() {
        return isValidationFailed;
    }

    public void setValidationFailed() {
        this.isValidationFailed = true;
    }

    public void reset() {
        this.id = -1;
        this.sender.reset();
        this.company.reset();
        this.sessionStatus.reset();
        this.isValidationFailed = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceMessage financeMessage = (FinanceMessage) o;
        return id == financeMessage.id &&
                isValidationFailed == financeMessage.isValidationFailed &&
                Objects.equals(sessionStatus, financeMessage.sessionStatus) &&
                Objects.equals(company, financeMessage.company) &&
                Objects.equals(sender, financeMessage.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionStatus, company, sender, isValidationFailed);
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", sessionStatus=" + sessionStatus +
                ", company=" + company +
                ", sender=" + sender +
                ", isValidationFailed=" + isValidationFailed +
                '}';
    }
}
