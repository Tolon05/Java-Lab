import java.util.*;

class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Set<Integer> courses;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Integer> getCourses() {
        return courses;
    }

    public void addCourse(Integer course) {
        courses.add(course);
    }

    public void removeCourse(Integer course) {
        courses.remove(course);
    }

    public String getInformation() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Courses: " + courses;
    }
}

class StudentManager {
    private SortedMap<Integer, Student> students = new TreeMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        students.remove(id);
    }

    public void updateStudent(int id, String name, int age, Set<Integer> courses) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.getCourses().clear();
            student.getCourses().addAll(courses);
        }
    }

    public void displayAllStudents() {
        List<Student> studentList = new ArrayList<>(students.values());
        Collections.sort(studentList, Comparator.comparing(Student::getId));
        for (Student student : studentList) {
            System.out.println(student.getInformation());
        }
    }

    public void searchStudentById(int id) {
        Student student = students.get(id);
        if (student != null) {
            System.out.println(student.getInformation());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void listStudentsByCourse(Integer course) {
        students.values().stream()
                .filter(s -> s.getCourses().contains(course))
                .forEach(s -> {
                    System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge() + ", Courses: " + s.getCourses());
                });
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student s1 = new Student(1, "Alice", 20);
        s1.addCourse(101);
        s1.addCourse(102);

        Student s2 = new Student(2, "Bob", 22);
        s2.addCourse(101);

        manager.addStudent(s1);
        manager.addStudent(s2);

        System.out.println("All Students:");
        manager.displayAllStudents();

        System.out.println("\nSearch Student by ID (1):");
        manager.searchStudentById(1);

        System.out.println("\nStudents enrolled in course 101:");
        manager.listStudentsByCourse(101);
    }
}
