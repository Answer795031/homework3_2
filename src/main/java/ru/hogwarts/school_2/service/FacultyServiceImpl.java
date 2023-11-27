package ru.hogwarts.school_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school_2.exception.StudentNotFoundException;
import ru.hogwarts.school_2.model.Faculty;
import ru.hogwarts.school_2.repository.FacultyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty addFaculty(Faculty faculty) { // добавление записи факультета
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(Long id) { // получение записи факультета
        if (facultyRepository.findById(id).isEmpty()) {
            throw new StudentNotFoundException("Ошибка! Факультет не найден!");
        }
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) { // изменение записи факультета
        if (facultyRepository.findById(id).isEmpty()) {
            return facultyRepository.save(faculty);
        }
        Faculty existingFaculty = facultyRepository.findById(id).get();
        existingFaculty.setName(faculty.getName());
        existingFaculty.setColor(faculty.getColor());
        return facultyRepository.save(existingFaculty);
    }

    @Override
    public Faculty removeFaculty(Long id) { // удаление записи факультета
        facultyRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Faculty> facultyByColor(String color) { // получение всех факультетов по цвету
        return facultyRepository.findAll().stream()
                .filter(student -> student.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
