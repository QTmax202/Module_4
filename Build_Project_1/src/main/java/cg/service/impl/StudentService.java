package cg.service.impl;

import cg.model.Student;
import cg.repository.IStudentRepository;
import cg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void saveStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        iStudentRepository.deleteById(id);
    }
}
