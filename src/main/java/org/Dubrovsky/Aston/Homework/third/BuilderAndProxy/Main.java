package org.Dubrovsky.Aston.Homework.third.BuilderAndProxy;

public class Main {
    public static void main(String[] args) {

        Message message = new Message.Builder().sender("Alex").text("Привет!").build();

        MessageService service = new MessageServiceImpl();

        service = new MessageServiceProxy(service, true);

        service.send(message);
    }

}
