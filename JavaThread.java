package javathread;
 
public class JavaThread implements Runnable {
    public static int a;
    public char linha;
 
    public void linhaA() throws InterruptedException {
        synchronized (this) {
            a+=3;
        }
    }
 
    public void linhaB() throws InterruptedException {
        synchronized (this) {
            a*=2;
        }
    }
 
    @Override
    public void run() {
        a = 2;
        try {
            switch (this.linha) {
                case 'A':
                    this.linhaA();
                    break;
                case 'B':
                    this.linhaB();
                    break;
                default:
                    System.out.println("Invalido");
                    break;
            }
        } catch (InterruptedException e) {
            System.out.println("Exception:" + e);
        }
    }
 
    public static void main(String[] args) {
        JavaThread td = new JavaThread();
         
        for (int i=0; i<5; i++) {
            td.linha = 'A';
            new Thread(td).start();
            td.linha = 'B';
            new Thread(td).start();
            System.out.println(a);
        }
    }
}