import java.util.ArrayList;

public class School {
    //initialize array lists
	private ArrayList<Teacher> teacherList = new ArrayList<>();
	private ArrayList<Student> studentList = new ArrayList<>();
    public void addTeacher(Teacher var)
    //adds a teacher object to the teacher list
		{teacherList.add(var);}
	public void addStudent(Student var)
    //adds a student object to the student list
		{studentList.add(var);}
	public void showTeachers(){
    //prints out all teachers in the list
        System.out.println("All Teachers: ");
        int i;
        for (i = 0; i<teacherList.size(); i++)
            {System.out.println(teacherList.get(i));}
        System.out.println("\n");}
    public void showStudents(){
    //prints out all students in the list
        System.out.println("All Students: ");
        int i;
        for (i = 0; i<studentList.size(); i++)
            {System.out.println(studentList.get(i));}
        System.out.println("\n");}
    public void removeTeacher(Teacher var){
    //searches through the teacher list to search for a matching object to remove
        int i;
        for (i = 0; i<teacherList.size(); i++)
            if ((teacherList.get(i)).equals(var))
                {teacherList.remove(i);}}
	public void removeStudent(Student var){
    //searches through the student list to search for a matching object to remove
		int i;
		for (i = 0; i<studentList.size(); i++)
            if ((studentList.get(i)).equals(var))
                {studentList.remove(i);}}
}