package com.practice.spring;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "spring-test.xml" })
public class SingletonTest {
    // @Autowired
    // private SingletonBean single;
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        applicationContext = new FileSystemXmlApplicationContext(
                "src/com/practice/spring/spring-test.xml");
        final SingletonBean single1 = (SingletonBean) applicationContext
                .getBean("singletonBean");
        final SingletonBean single2 = (SingletonBean) applicationContext
                .getBean("singletonBean");
        ExecutorService exec = Executors.newFixedThreadPool(1);
        final CountDownLatch count = new CountDownLatch(2);
        exec.submit(new Runnable() {
            @Override
            public void run() {
                ProtoTypeBean proto1 = single1.getPrototypeBean();
                proto1.increase();
                proto1.increase();
                System.out.println("thread name:"
                        + Thread.currentThread().getName());
                System.out.println("proto1 value:" + proto1.getValue());
                proto1.reset();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                count.countDown();
            }
        });
        exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    ProtoTypeBean proto2 = single2.getPrototypeBean();
                    proto2.increase();
                    System.out.println("thread name:"
                            + Thread.currentThread().getName());
                    System.out.println("proto2 value:" + proto2.getValue());
                    proto2.reset();
                    count.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("error");
                }
            }
        });
        try {
            count.await();
            System.out.println("End...");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
