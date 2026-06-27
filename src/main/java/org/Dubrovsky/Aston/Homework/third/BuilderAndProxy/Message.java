package org.Dubrovsky.Aston.Homework.third.BuilderAndProxy;

public class Message {

    private final String text;
    private final String sender;

    private Message(Builder builder) {
        this.text = builder.text;
        this.sender = builder.sender;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public static class Builder {

        private String text;
        private String sender;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
