package pl.pjatk.s36691.gui.zad05;

public class Subject  {

    private String name;
    private Student[] group;
    private Person teacher;

    public Subject(String name) {
        this.name = name;
        this.group = new Student[10];
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) throws TooManyStudentsException {
        int freeSpot = findFreeSpot();
        if (freeSpot == -1) {
            throw new TooManyStudentsException();
        } else {
            group[freeSpot] = student;
        }
    }

    public int findFreeSpot() {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String teacherName;
        if (teacher == null) {
            teacherName = "none";
        } else {
            teacherName = teacher.getName();
        }

        StringBuilder students = new StringBuilder();
        for (Student student : group) {
            if (student == null) break;
            students.append(student.getName());
            students.append(", ");
        }
        if (!students.isEmpty()) {
            students.setLength(students.length() - 2);
        } else {
            students.append("none");
        }

        return name + ", teacher: " + teacherName + ", students: " + students.toString();
    }
}
