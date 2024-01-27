public class Tax<T extends Number, E extends Number> {
   T taxRate;
   E taxConstant;


   Tax(T taxRate, E taxConstant){
       this.taxRate = taxRate;
       this.taxConstant = taxConstant;
   }

   E getTaxConstant(){
       return this.taxConstant;
   }

   T getTaxRate(){
       return this.taxRate;
   }

}
