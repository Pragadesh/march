package org.pg.march.thread;

public class TestThreadInterupt {


    public static void main(String[] args){
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(long l1 = 0; l1< Long.MAX_VALUE; l1++) {
                        for(long l2 = 0; l2 < Long.MAX_VALUE; l2++){
                            System.out.println(l1 + " - " + l2);
                            if(l2 % 1000 == 0)
                                Thread.sleep(1);
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        th1.setName("Number Loop");
        th1.start();
        try{Thread.sleep(2000);}catch(InterruptedException e){}
        th1.interrupt();
    }
}
