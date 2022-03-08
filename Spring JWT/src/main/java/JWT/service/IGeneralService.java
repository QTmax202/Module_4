package JWT.service;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();

    Optional<E> findById(Long id);

    E Save (E e);

    void remove(Long id);
}
