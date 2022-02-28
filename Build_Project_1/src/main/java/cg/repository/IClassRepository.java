package cg.repository;

import cg.model.Classes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends CrudRepository<Classes, Long> {
}
