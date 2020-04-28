package example5;

import example5.data.Message;
import example5.pool.MessagePool;
import example5.pool.Pool;

import java.time.LocalDateTime;

public class SimpleMain {

    public static void main(String[] args) throws Exception {
        final Pool<Message> messagePool = new MessagePool(3);

        Runnable runnable = () -> {

            Message messageOne = messagePool.checkOut();
            System.out.println("I've got message " + messageOne + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());
            Message messageTwo = messagePool.checkOut();
            System.out.println("I've got " + messageTwo + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());
            try {
                System.out.println("Waiting for 4s from Thread " + Thread.currentThread() + " at time " + LocalDateTime.now());
                Thread.sleep(4000);
            } catch (Exception ex) {
                System.out.println(ex);
            }

            System.out.println("Returning " + messageTwo + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());
            messagePool.returnObject(messageTwo);

            try {
                System.out.println("Waiting for 1s from Thread " + Thread.currentThread() + " at time " + LocalDateTime.now());
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            System.out.println("Returning " + messageOne + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());
            messagePool.returnObject(messageOne);
        };

        new Thread(runnable).start();

        Message messageThree = messagePool.checkOut();
        System.out.println("I've go " + messageThree + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());

        System.out.println("Waiting for 1s from Thread " + Thread.currentThread() + " at time " + LocalDateTime.now());
        Thread.sleep(1000);

        Message messageFour = messagePool.checkOut();
        System.out.println("I've got " + messageFour + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());

        System.out.println("Waiting for 1s from Thread " + Thread.currentThread() + " at time " + LocalDateTime.now());
        Thread.sleep(1000);

        Message messageFive = messagePool.checkOut();
        System.out.println("I've got " + messageFive + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());

/*        Message messageSix = messagePool.checkOut();
        System.out.println("I've got " + messageSix + " in " + Thread.currentThread() + " at time " + LocalDateTime.now());*/

        messagePool.returnObject(messageThree);
        messagePool.returnObject(messageFour);
        messagePool.returnObject(messageFive);
        // messagePool.returnObject(messageSix);
        System.out.println("Pool size at the end " + messagePool.availableObjects());
    }

}
