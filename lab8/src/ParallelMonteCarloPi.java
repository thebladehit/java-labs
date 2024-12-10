import java.util.concurrent.ThreadLocalRandom;

public class ParallelMonteCarloPi implements Runnable {
    private final long iterations;
    public long inPiArea = 0;

    public ParallelMonteCarloPi(long iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            if ((x * x + y * y) <= 1) {
                inPiArea++;
            }
        }
    }

    public long getInPiArea() {
        return inPiArea;
    }
}
