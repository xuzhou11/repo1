import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NumberTest {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void test01() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            ++number;
            System.out.println(Thread.currentThread().getName()+"   "+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void test02() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            --number;
            System.out.println(Thread.currentThread().getName()+"   "+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class TreadDemo {

    public static void main(String[] args) {
        NumberTest numberTest = new NumberTest();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                    numberTest.test01();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                    numberTest.test02();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                    numberTest.test01();
            }
        }, "c").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                    numberTest.test02();
            }
        }, "d").start();
    }

}

