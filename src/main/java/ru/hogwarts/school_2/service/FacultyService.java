package ru.hogwarts.school_2.service;

import ru.hogwarts.school_2.model.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty getFaculty(Long id);

    Faculty updateFaculty(Long id, Faculty faculty);

    Faculty removeFaculty(Long id);

    List<Faculty> facultyByColor(String color);
}
