import java.util.*;

// Student class
class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentCollectionDemo {

    public static void main(String[] args) {

        // 1. Store student objects in ArrayList
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Ravi", 85));
        studentList.add(new Student(2, "Anu", 92));
        studentList.add(new Student(3, "Ravi", 85)); // duplicate
        studentList.add(new Student(4, "Kiran", 78));

        // 2. Use HashMap for fast lookup (id → student)
        HashMap<Integer, Student> studentMap = new HashMap<>();
        for (Student s : studentList) {
            studentMap.put(s.id, s);
        }

        // 3. Sorting using Comparator (by marks)
        studentList.sort(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks; // descending
            }
        });

        // 4. Remove duplicates using Set (based on name+marks)
        Set<String> uniqueSet = new HashSet<>();
        ArrayList<Student> uniqueStudents = new ArrayList<>();

        for (Student s : studentList) {
            String key = s.name + s.marks;
            if (uniqueSet.add(key)) {
                uniqueStudents.add(s);
            }
        }

        // 5 & 8. Enhanced for loop + formatted report
        System.out.println("ID\tName\tMarks");
        System.out.println("---------------------");
        for (Student s : uniqueStudents) {
            System.out.println(s.id + "\t" + s.name + "\t" + s.marks);
        }

        // 6. Collection hierarchy demo
        Collection<Student> collection = studentList;
        List<Student> list = studentList;

        // 7. Memory optimization note:
        studentList.trimToSize(); // reduces unused memory
    }
}