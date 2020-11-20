package heima;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    
    public static void main(String[] args){
        App app = new App();
        Thread3 thread3 = app.new Thread3();
        thread3.start();
    }
    class Thread1 extends Thread{
        @Override
        public void run(){

            try {
                Thread.sleep(100);                
                System.out.println("t1开始运行");
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println("t2开始运行");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            new Thread1().start();
        }
    }

    class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println("t3开始运行");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            new Thread2().start();
        }
    }
}
