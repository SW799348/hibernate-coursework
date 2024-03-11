package lk.ijse.hibernate.coursework.repository;

import java.util.ArrayList;
import java.util.List;

public interface CrudRepository<T,ID> extends SuperRepository {

    ID save(T object);

    void update(T object);

    T get(ID id);

    void delete(T object);

    List<T> getAll();
}
