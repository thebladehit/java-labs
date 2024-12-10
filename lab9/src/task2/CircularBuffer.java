package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBuffer<T> {
    private final Object[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public CircularBuffer(int size) {
        this.buffer = new Object[size];
    }

    public void add(T value) throws InterruptedException {
        lock.lock();
        try {
            while (size == buffer.length) {
                notFull.await();
            }
            buffer[tail] = value;
            tail = (tail + 1) % buffer.length;
            size++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            T result = (T) buffer[head];
            head = (head + 1) % buffer.length;
            size--;
            notFull.signalAll();
            return result;
        } finally {
            lock.unlock();
        }
    }
}
