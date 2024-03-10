package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.repository.inter.BranchRepository;
import org.hibernate.Session;

import java.util.ArrayList;

public class BranchRepositoryImpl implements BranchRepository {
    @Override
    public Long save(Branch object) {
        return null;
    }

    @Override
    public void update(Branch object) {

    }

    @Override
    public Branch get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Branch object) {

    }

    @Override
    public ArrayList<Branch> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
