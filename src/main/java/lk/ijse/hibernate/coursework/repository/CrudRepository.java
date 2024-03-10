package lk.ijse.hibernate.coursework.repository;

import java.util.ArrayList;

public interface CrudRepository<T,ID> extends SuperRepository {

    ID save(T object);

    void update(T object);

    T get(ID id);

    void delete(T object);

    ArrayList<T> getAll();
}
