package juc;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-20
 */
public class PrintOddAndEvenNumbersInOrder {

    private int n = 1;
    private int limit = 100;

    public void printNumbers(){
        synchronized(this){
            try{
                while(n < limit){
                    System.out.println(n++);
                    this.notify();
                    this.wait();
                }
                this.notify();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
