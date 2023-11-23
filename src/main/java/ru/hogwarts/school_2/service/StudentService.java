package ru.hogwarts.school_2.service;

import ru.hogwarts.school_2.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);

    Student removeStudent(Long id);

    List<Student> studentsByAge(int age);
}
