public class Teacher {
    //set variables
    private String lastName;
    private String firstName;
    private String subject;
    Teacher(String lastName, String firstName, String subject){
        this.lastName = lastName;
        this.firstName = firstName;
        this.subject = subject;}
    public void setInfo(String lastName, String firstName, String subject){
    //sets/resets info for a teacher object
        this.lastName = lastName;
        this.firstName = firstName;
        this.subject = subject;}
    public String getInfo()
    //return info of teacher object
        {return ("Name: " + lastName + " " + firstName + "\n\tSubject: " + subject);}
    public String toString(){return ("Name: " + lastName + " " + firstName + "\n\tSubject: " + subject);}
}