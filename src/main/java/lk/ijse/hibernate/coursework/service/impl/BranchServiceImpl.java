package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.BranchDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.repository.impl.BranchRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.BranchRepository;
import lk.ijse.hibernate.coursework.service.inter.BranchService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {

    private Session session;

    private static BranchService branchService;

    private final BranchRepository branchRepository;

    private BranchServiceImpl(){
        branchRepository=BranchRepositoryImpl.getInstance();
    }

    public static BranchService getInstance(){
        return branchService==null?branchService=new BranchServiceImpl():branchService;
    }

    @Override
    public Long saveBranch(BranchDto branchDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            Long id = branchRepository.save(branchDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public BranchDto getBranch(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            branchRepository.setSession(session);
            Branch branch = branchRepository.get(id);
            session.close();
            return branch.toDto(); // We convert the Entity back to a dto type before return to the controller
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateBranch(BranchDto branchDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            branchRepository.update(branchDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBranch(BranchDto branchDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            branchRepository.delete(branchDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<BranchDto> getAllBranches() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        branchRepository.setSession(session);
        List<Branch> allBranches = branchRepository.getAll(); // Here we're getting Entity type object result
        List<BranchDto> branchDtoList = new ArrayList<>();
        for (Branch branch : allBranches) {
            branchDtoList.add(branch.toDto()); // We convert the Entity back to a dto type before return to the controller
        }
        return branchDtoList;
    }

}

