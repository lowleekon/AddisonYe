import java.util.ArrayList;
import java.util.Arrays;

class Person {
    private String firstName;
    private String lastName;
    private ArrayList<Course> courses = new ArrayList<>();

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void printName(){
        System.out.println(firstName + lastName);
    }

    void changeName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getName(){
        return firstName + " " + lastName;
    }

    void setCourses(Course... course){
        courses.addAll(Arrays.asList(course));
    }

    void displayCourses(){
        System.out.println("Courses: " + courses.toString());
    }

    void removeCourse(int indexPosition){
        System.out.println("Removed " + courses.get(indexPosition));
        courses.remove(indexPosition);
    }

}
