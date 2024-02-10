public class Incrementor {
    private long i ;

     void  increment(){
        System.out.println("Hello wrold");
        // critical section
         synchronized (this) {
             this.i = this.i + 1;
         }
    }
    public void print(){
        System.out.println(this.i);
    }
}
