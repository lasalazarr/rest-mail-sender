package org.fastdev.restmailsender;

public class MailTo {

    private String to;

    private String subject;

    private String message;

    private String pathFileToAttach;

    public MailTo() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPathFileToAttach() {
        return pathFileToAttach;
    }

    public void setPathFileToAttach(String pathFileToAttach) {
        this.pathFileToAttach = pathFileToAttach;
    }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String toString() {
        return "MailTo{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", pathFileToAttach='" + pathFileToAttach + '\'' +
                '}';
    }
}