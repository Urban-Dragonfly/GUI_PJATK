package pl.pjatk.s36691.gui.zad05;

public class Main {
    public static void main(String args[]) {
        Person p1 = new Person("Jan", 50);
        Student s1 = new Student("Jasiek", 20);
        Student s2 = new Student("John", 20);
        Student s3 = new Student("Jonas", 20);
        Student s4 = new Student("Ian", 20);
        Student s5 = new Student("Johnny", 20);
        Student s6 = new Student("Ivan", 20);
        Student s7 = new Student("Janek", 20);
        Student s8 = new Student("Janusz", 20);
        Student s9 = new Student("Johan", 20);
        Student s10 = new Student("Johann", 20);
        Student s11 = new Student("Johnson", 20);
        Student s12 = new Student("Janek jr.", 20);
        Student s13 = new Student("Jo", 20);

        Person p3 = (Person)s1;
        p1.sayHelloTo(p3); //Hi Jasiek!
        p3.sayHelloTo(p1); //Hi Jan!
        Subject s = new Subject("GUI");
        s.setTeacher(p1);
        try {
            s.addStudent(s1);
            s.addStudent(s2);
            s.addStudent(s3);
            s.addStudent(s4);
            s.addStudent(s5);
            s.addStudent(s6);
            s.addStudent(s7);
            s.addStudent(s8);
            s.addStudent(s9);
            s.addStudent(s10);
            s.addStudent(s11);
            s.addStudent(s12);
            s.addStudent(s13);

        } catch(TooManyStudentsException e) {
            e.printStackTrace();
        }
        System.out.println(s); //GUI, teacher: Jan, students: Jasiek
    }
}
