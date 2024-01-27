import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Movie movie = new Movie("Avenger");
//        System.out.println(movie.getName());
//        movie.play();
      //  printSortedArray(new SortImpl());
//        int  a = 2;
//        multiplyBy2(2);
//        System.out.println(a);
//        AnimationMovie animationMovie = new AnimationMovie();
//        animationMovie.setName("spiderman");
//       // animationMovie.play();
//
//        playMovie(movie);
//        playMovie(animationMovie);

//        SingletonExample.getInstance().print();
//        int[] arr = new int[]{10,4,2,34,5};
//        Sort sort2 = (x) -> {
//            Arrays.sort(x);
//        };
//        sort2.sort(arr);


        EducationSystem educationSystem = new School("school", 10);
        printNumberOfStudents(educationSystem);

        // lambda
        Sort sort1 = (arr) -> {
            Arrays.sort(arr);

        };
        sort1.sort(new int[]{4,5,6});

        Sort sort2 = (arr) -> {
            for(int i = 0; i< arr.length;i++){
                for(int j=i+1; j<arr.length;j++){
                   if(arr[i]>arr[j]){
                       int temp = arr[i];
                       arr[i]= arr[j];
                       arr[j]= temp;
                   }
                }
            }

        };
       sort1.sort(new int[]{4,5,6});

        Tax<Float, Integer> tax = new Tax<Float, Integer>(10f, 10);

        Integer a = new Integer(1);
        System.out.println("hashcode :"+a.hashCode());
        a = 2;

        System.out.println("hashcode :"+a.hashCode());

        String c = new String("gfg");
        String b = new String("gfg");

        System.out.println("hashcode :"+c.hashCode());

        System.out.println("hashcode :"+b.hashCode());
        c = "geeks";
        System.out.println("hashcode :"+c.hashCode());
        System.out.println("hashcode :"+b.hashCode());


        Collection<Integer> collections = new ArrayList<Integer>(
                Arrays.asList(1,2,3,4,5,6)
        );
        // get list of even numbers
        Collection<Integer> evenList = collections.stream()
                .filter(x -> x%2 ==0 )
                .collect(Collectors.toList());

        // sum of the even elements
        int sum = collections.
                stream().
                filter( x -> x%2 == 0)
                .reduce(0 , (acc,x) -> acc =acc +x)
                .intValue();

        System.out.println("sum is "+ sum);







    }

    static void printSortedArray(Sort sort){
        int[] arr = new int[]{10,4,2,34,5};
        sort.sort(arr);
        for (int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static void multiplyBy2(int a){
        a = a*2;
    }

    static void playMovie(AnimationMovie movie) {
        movie.play();

    }


    static void printNumberOfStudents(EducationSystem educationSystem){
       System.out.println( educationSystem.GetNumberOfStudents());
    }
}


// public

// package private