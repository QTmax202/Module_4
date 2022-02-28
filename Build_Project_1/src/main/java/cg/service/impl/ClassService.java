package cg.service.impl;

import cg.model.Classes;
import cg.repository.IClassRepository;
import cg.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository iClassRepository;
    @Override
    public Iterable<Classes> findAll() {
        return iClassRepository.findAll();
    }

    @Override
    public Classes findById(long id) {
        return iClassRepository.findById(id);
    }
}
