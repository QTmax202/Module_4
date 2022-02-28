package cg.service;

import cg.model.Student;

import java.util.Optional;

public interface IStudentService {
    Iterable<Student> findAll();

    Optional<Student> findStudentById(long id);

    void saveStudent(Student student);

    void delete(long id);
}
