public class Teacher extends Person{
    private static int teacherIDnum = 0;
    private String teacherIDcode;

    Teacher(String tFirstName, String tLastName){
        super(tFirstName, tLastName);
        teacherIDnum += 1;
        teacherIDcode = ("T" + String.valueOf(teacherIDnum));
    }

    void printName(){
        System.out.println(getName() + " " + teacherIDcode);
    }
}
