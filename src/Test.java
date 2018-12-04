import javax.swing.text.Segment;
import java.util.*;
import java.util.concurrent.*;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

public class Test {
    private static int NUMBER = 7;
    public static void main(String[] args) throws InterruptedException {
   /*     CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 1; i <=4 ; i++) {
            new Thread(()-> {System.out.println(Thread.currentThread().getName()+"报告，我干完了");
                countDownLatch.countDown();},String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"小伙子们干完了，该我干了");
    }*/

        /*Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "占的停车为");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "开车离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }*/
     /*   CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤神龙");
            }
        });
        for (int i = 1; i <=NUMBER ; i++) {
            int a = i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"获取第"+a+"龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }*/

        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map.toString());
            }).start();
        }

    }
}
