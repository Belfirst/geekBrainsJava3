public class Main {
    public static void main(String[] args) {
        WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
        Thread thread1 = new Thread(() -> waitNotifyObj.printA());
        Thread thread2 = new Thread(() -> waitNotifyObj.printB());
        Thread thread3 = new Thread(() -> waitNotifyObj.printC());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
