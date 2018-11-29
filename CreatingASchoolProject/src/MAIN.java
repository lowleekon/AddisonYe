public class MAIN {
    public static void main(String[] args) {
        //initialize school object
        School school = new School();
        //initialize students
        Student student1 = new Student(null, null, 0);
        Student student2 = new Student(null, null, 0);
        Student student3 = new Student(null, null, 0);
        Student student4 = new Student(null, null, 0);
        Student student5 = new Student(null, null, 0);
        Student student6 = new Student(null, null, 0);
        Student student7 = new Student(null, null, 0);
        Student student8 = new Student(null, null, 0);
        Student student9 = new Student(null, null, 0);
        Student student10 = new Student(null, null, 0);
        //adding students to student list
        school.addStudent(student1);school.addStudent(student2);school.addStudent(student3);school.addStudent(student4);
        school.addStudent(student5);school.addStudent(student6);school.addStudent(student7);school.addStudent(student8);
        school.addStudent(student9);school.addStudent(student10);
        //initialize teachers
        Teacher teacher1 = new Teacher(null, null, null);
        Teacher teacher2 = new Teacher(null, null, null);
        //add teachers to teacher list
        school.addTeacher(teacher1);school.addTeacher(teacher2);
        //show teacher and student list
        school.showStudents();school.showTeachers();
        //remove 2 students
        school.removeStudent(student6);school.removeStudent(student9);
        //remove 1 teacher
        school.removeTeacher(teacher1);
        //show teacher and student list
        school.showStudents();school.showTeachers();
    }
}