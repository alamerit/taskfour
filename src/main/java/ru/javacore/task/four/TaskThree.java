package ru.javacore.task.four;

/**
 *@author Shafikov Almir
 */

public class TaskThree {
    static class MFU {
        Object tas1 = new Object();
        Object tas2 = new Object();
        public void print(String doc, int n){
            synchronized (tas1){
                System.out.println("The document starts printing: "+doc+"\n--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Page "+i+" of the document "+doc+"  is printed...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }System.out.println("Print document "+doc+" is completed.\n------------------------");
        }
        public void scan(String doc, int n){
            synchronized (tas2){
                System.out.println("Starts scanning the document: "+doc+"\n--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Page  "+i+" document "+doc+" is clean...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Scan a document "+doc+" completed.\n--------------------o");
        }
    }
    public static void main(String[] args) {
        MFU mfu = new MFU();

        new Thread(() -> mfu.scan ("A", 4)).start();
        new Thread(() -> mfu.print("A", 4)).start();
        new Thread(() -> mfu.print("B", 7)).start();
    }
}
