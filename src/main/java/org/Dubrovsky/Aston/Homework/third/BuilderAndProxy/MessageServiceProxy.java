package org.Dubrovsky.Aston.Homework.third.BuilderAndProxy;

public class MessageServiceProxy implements MessageService {

    private final MessageService service;
    private final boolean allowed;

    public MessageServiceProxy(MessageService service, boolean allowed) {
        this.service = service;
        this.allowed = allowed;
    }

    @Override
    public void send(Message message) {

        if (!allowed) {
            System.out.println("Нет доступа к отправке сообщений");
            return;
        }

        service.send(message);
    }
}