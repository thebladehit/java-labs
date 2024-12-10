public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("Provide Threads number");
            return;
        }

        int numThreads;
        try {
            numThreads = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Threads number must be an integer");
            return;
        }

        long all = 500000000L;
        long allInAreaPi = 0L;
        long iterationPerThread = all / numThreads;
        Thread[] threads = new Thread[numThreads];
        ParallelMonteCarloPi[] tasks = new ParallelMonteCarloPi[numThreads];

        long startTime = System.nanoTime();

        for (int i = 0; i < numThreads; i++) {
            tasks[i] = new ParallelMonteCarloPi(iterationPerThread);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (ParallelMonteCarloPi task : tasks) {
            allInAreaPi += task.getInPiArea();
        }

        long endTime = System.nanoTime();

        double piValue = (double) allInAreaPi / all * 4;

        System.out.println("PI is " + piValue);
        System.out.println("Threads: " + numThreads);
        System.out.println("Iterations: " + all);
        System.out.println("Total execution time: " + (endTime - startTime) / 1000 / 1000);
    }
}