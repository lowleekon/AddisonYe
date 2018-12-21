class Student extends Person{
    private static int studentIDnum = 0;
    private String studentIDcode;

    Student(String sFirstName, String sLastName){
        super(sFirstName, sLastName);
        studentIDnum += 1;
        studentIDcode = ("S" + String.valueOf(studentIDnum));
    }

    void printName(){
        System.out.println(getName() + " " + studentIDcode);
    }
}
