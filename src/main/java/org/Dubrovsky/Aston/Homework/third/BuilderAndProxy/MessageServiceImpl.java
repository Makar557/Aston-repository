package org.Dubrovsky.Aston.Homework.third.BuilderAndProxy;

public class MessageServiceImpl implements MessageService {

    @Override
    public void send(Message message) {
        System.out.println("Отправка сообщения:");
        System.out.println(message.getSender() + ": " + message.getText());
    }
}
