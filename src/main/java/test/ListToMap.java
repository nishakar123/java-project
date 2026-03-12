package test;

import java.util.*;
import java.util.stream.*;

public class ListToMap {
    static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Krisha"));
        studentList.add(new Student(2, "Aarya"));
        studentList.add(new Student(3, "Tisha"));
        studentList.add(new Student(3, "Ishana"));

        Map<Integer, String> studentMap = studentList.stream().collect(Collectors.toMap(Student::getId, Student::getName, (a, b) -> b));

        studentMap.forEach(
                (x, y) -> System.out.println("Student ID : " + x + ", Student Name : " + y));
    }
}

class Student {
    private Integer id;

    private String name;

    public Student(){}

    public Student(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
