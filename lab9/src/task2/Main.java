package task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CircularBuffer<String> buffer1 = new CircularBuffer<>(10);
        CircularBuffer<String> buffer2 = new CircularBuffer<>(10);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread producer = new Thread(() -> {
                try {
                    for (int j = 0; ; j++) {
                        String message = "Потік № " + finalI + " згенерував повідомлення " + j;
                        buffer1.add(message);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException ignored) {}
            });
            producer.setDaemon(true);
            producer.start();
        }

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            Thread translator = new Thread(() -> {
                try {
                    while (true) {
                        String message = buffer1.remove();
                        String translatedMessage = "Потік № " + finalI + " переклав повідомлення: " + message;
                        buffer2.add(translatedMessage);
                    }
                } catch (InterruptedException ignored) {}
            });
            translator.setDaemon(true);
            translator.start();
        }

        for (int i = 0; i < 100; i++) {
            String message = buffer2.remove();
            System.out.println(message);
        }
    }
}
