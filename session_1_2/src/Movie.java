public class Movie {
    private String name;
    static String version = "v1";

    protected Movie(String name){
        this.name = name;
    }

    Movie(){

    }

    public void play() {
        System.out.println("Playing movie "+ name);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
         this.name = name;
    }

}
