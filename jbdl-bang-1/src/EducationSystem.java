public abstract class EducationSystem {
    public String name;
    public Integer numberOfStudents;
    public static Integer version;
    public Integer GetNumberOfStudents() {
        return this.numberOfStudents;
    }

    EducationSystem(String name, Integer numberOfStudents){
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }
}
