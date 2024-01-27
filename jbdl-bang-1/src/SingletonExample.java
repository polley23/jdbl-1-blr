public class SingletonExample {

   String name;

   private volatile static SingletonExample obj ;

   private SingletonExample() {
      this.name = "xyz";
   }

   public static  SingletonExample getInstance(){

      // t0   Th1 , Th2
      if(obj == null){
         // t1 Th1, Th2, Th3
         synchronized (SingletonExample.class) {
            //t2 Th1 creates the object
            if(obj == null) {
               obj = new SingletonExample();
            }
         }
      }
      return obj;
   }

   void print(){
      System.out.println("Hello");
   }

}
