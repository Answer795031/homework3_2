package ru.hogwarts.school_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school_2.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
