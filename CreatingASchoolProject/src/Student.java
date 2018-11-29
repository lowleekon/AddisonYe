public class Student {
    //unique student number creation
    private static int y;
    private int number(){
        y += 1;
        return(y);}
    //set variables
    private String lastName;
    private String firstName;
    private int grade;
    private int studentNumber = number();
    Student(String lastName, String firstName, int grade){
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;}
    public void setInfo(String lastName, String firstName, int grade){
    //set/resets info of student
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;}
    public String getInfo()
    //returns a string with student's variables
        {return ("Name: " + lastName + " " + firstName + "\n\tStudent Number: " + studentNumber + "\n\tGrade: " + grade);}
    public String toString(){return ("Name: " + lastName + " " + firstName + "\n\tStudent Number: " + studentNumber + "\n\tGrade: " + grade);}
}