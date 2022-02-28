package cg.service;

import cg.model.Classes;

public interface IClassService {
    Iterable<Classes> findAll();

    Classes findById(long id);
}
