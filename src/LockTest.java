import com.sun.javafx.robot.FXRobotImage;
import javafx.concurrent.Task;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Source01{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void test01(){
            lock.lock();
            try {
                while (number!=1) {
                    condition1.await();
                }
                for (int i = 1; i <10; i++) {
                    System.out.println();
                }
                number=2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

    }
}

public class LockTest {
    HashMap
}
