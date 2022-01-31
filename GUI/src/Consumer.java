


import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {
    Buffer buffer;
    
    Consumer(Buffer buffer, int tiempoE) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println("Running Consumer...");
        Operation product;
        
        for(int i=0 ; i<5 ; i++) {
            product = this.buffer.consume();
            //System.out.println("Consumer consumed: " + product);
            Buffer.print("Consumer consumed: " + "(" + product.cType + " " + product.val1 + " " + product.val2 + ") -> " + product.solve());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
