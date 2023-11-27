package ru.hogwarts.school_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school_2.exception.StudentNotFoundException;
import ru.hogwarts.school_2.model.Student;
import ru.hogwarts.school_2.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) { // добавление записи студента
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        if (studentRepository.findById(id).isEmpty()) { // получение записи студента
            throw new StudentNotFoundException("Ошибка! Студент не найден!");
        }
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Long id, Student student) { // изменение записи студента
        if (studentRepository.findById(id).isEmpty()) {
            return studentRepository.save(student);
        }
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        return studentRepository.save(existingStudent);
    }

    @Override
    public Student removeStudent(Long id) { // удаление записи студента
        studentRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Student> studentsByAge(int age) { // получение всех студентов по возрасту
        return studentRepository.findAll().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}
