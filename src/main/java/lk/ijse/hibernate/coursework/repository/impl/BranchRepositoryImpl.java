package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.repository.inter.BranchRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {

    private Session session;

    private static BranchRepositoryImpl branchRepositoryImpl;

    private BranchRepositoryImpl(){}

    public  static  BranchRepositoryImpl getInstance(){
        return null==branchRepositoryImpl?branchRepositoryImpl=new BranchRepositoryImpl():branchRepositoryImpl;
    }
    @Override
    public Long save(Branch branch) {
        return (Long) session.save(branch);
    }

    @Override
    public void update(Branch branch) {
    session.update(branch);
    }

    @Override
    public Branch get(Long id) {
        return session.get(Branch.class,id);
    }

    @Override
    public void delete(Branch branch) {
       session.delete(branch);
    }

    @Override
    public List<Branch> getAll() {
       String sql="FROM Branch";
       Query query = session.createQuery(sql);
       List list = query.list();
       session.close();
       return list;
    }

    @Override
    public void setSession(Session session) {
          this.session=session;
    }
}
