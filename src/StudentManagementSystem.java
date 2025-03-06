import java.util.*;

class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Set<String> courses;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public String getInformation() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Courses: " + courses;
    }
}

class StudentManager {
    private Map<Integer, Student> students = new HashMap<>();
    private Map<String, Set<Student>> courseStudentsMap = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        for (String course : student.getCourses()) {
            if (!courseStudentsMap.containsKey(course)) {
                courseStudentsMap.put(course, new HashSet<>());
            }
            courseStudentsMap.get(course).add(student);
        }
    }

    public void removeStudent(int id) {
        Student student = students.remove(id);
        if (student != null) {
            for (String course : student.getCourses()) {
                Set<Student> studentsInCourse = courseStudentsMap.get(course);
                if (studentsInCourse != null) {
                    studentsInCourse.remove(student);
                    if (studentsInCourse.isEmpty()) {
                        courseStudentsMap.remove(course);
                    }
                }
            }
        }
    }

    public void updateStudent(int id, String name, int age, Set<String> courses) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.getCourses().clear();
            student.getCourses().addAll(courses);
            for (String course : courses) {
                if (!courseStudentsMap.containsKey(course)) {
                    courseStudentsMap.put(course, new HashSet<>());
                }
                courseStudentsMap.get(course).add(student);
            }
        }
    }

    public void displayAllStudents() {
        List<Student> studentList = new ArrayList<>(students.values());
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getId().compareTo(s2.getId());
            }
        });
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

    public void listStudentsByCourse(String courseName) {
        Set<Student> studentsInCourse = courseStudentsMap.get(courseName);
        if (studentsInCourse != null) {
            for (Student student : studentsInCourse) {
                System.out.println(student.getInformation());
            }
        } else {
            System.out.println("No students found for the course: " + courseName);
        }
    }

    public void displayAllStudentsSortedByName() {
        List<Student> studentList = new ArrayList<>(students.values());
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        for (Student student : studentList) {
            System.out.println(student.getInformation());
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student s1 = new Student(1, "Daniyar", 20);
        s1.addCourse("Programming in Java");
        s1.addCourse("Data Structures");

        Student s2 = new Student(2, "Erlan", 22);
        s2.addCourse("Programming in Java");

        Student s3 = new Student(3, "Akbar", 21);
        s3.addCourse("Algorithms");

        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);

        System.out.println("All Students (sorted by ID):");
        manager.displayAllStudents();

        System.out.println("\nSearch Student by ID (1):");
        manager.searchStudentById(1);

        System.out.println("\nUpdating Student with ID 2...");
        Set<String> updatedCourses = new HashSet<>(Arrays.asList("Data Structures", "Algorithms"));
        manager.updateStudent(2, "Atai", 23, updatedCourses);

        System.out.println("\nAll Students after update:");
        manager.displayAllStudents();

        System.out.println("\nStudents enrolled in 'Programming in Java':");
        manager.listStudentsByCourse("Programming in Java");

        System.out.println("\nAll Students (sorted by Name):");
        manager.displayAllStudentsSortedByName();
    }
}