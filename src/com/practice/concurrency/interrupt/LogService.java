package com.practice.concurrency.interrupt;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogService {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private final LoggerThread loggerThread = new LoggerThread();
    private final PrintWriter writer;

    public LogService(OutputStream out) throws FileNotFoundException {
        // File file = new File("test.txt");
        // writer = new PrintWriter(file);
        writer = new PrintWriter(out);
    }

    private boolean isShutdown = false;
    private int reservations = 0;

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException();
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    synchronized (LogService.this) {
                        if (isShutdown && reservations == 0) {
                            break;
                        }
                    }
                    String msg = queue.take();
                    synchronized (LogService.this) {
                        --reservations;
                    }
                    writer.println(msg);
                    // writer.flush();
                }
            } catch (InterruptedException e) {

            } finally {
                writer.close();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        LogService logService = new LogService(System.out);
        try {
            logService.start();
            logService.log("1");
            logService.log("4");
            logService.log("5");
            logService.log("6");
            logService.log("7");
            Thread.sleep(5000);
            logService.stop();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
