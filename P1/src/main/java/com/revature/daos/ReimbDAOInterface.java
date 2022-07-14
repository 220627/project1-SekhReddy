package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbDAOInterface {
    
    boolean insertReimbursement(Reimbursement reimb);

    ArrayList<Reimbursement> getAllReimbursements();

    public void deleteReimbursement(int id);

}
