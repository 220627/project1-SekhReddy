package com.revature.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbDAO implements ReimbDAOInterface{

    @Override
    public boolean insertReimbursement(Reimbursement reimb) {
        
        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS, REIMB_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, reimb.getMoney());
            ps.setString(2, reimb.getReimbSubmitted());
            ps.setString(3, reimb.getReimbResolved());
            ps.setString(4, reimb.getReimbDescription());
            ps.setInt(5, reimb.getReimbAuthor());
            ps.setString(6, reimb.getreimbStatus());
            ps.setString(7, reimb.getReimbType());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error inserting reimbursement");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Reimbursement> getAllReimbursements() {
        
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM ERS_REIMBURSEMENT";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Reimbursement> reimbursements = new ArrayList<>();
            while(rs.next()) {
                Reimbursement reimb = new Reimbursement(
                    rs.getInt("REIMB_ID"),
                    rs.getBigDecimal("REIMB_AMOUNT"),
                    rs.getString("REIMB_SUBMITTED"),
                    rs.getString("REIMB_RESOLVED"),
                    rs.getString("REIMB_DESCRIPTION"),
                    rs.getInt("REIMB_AUTHOR"),
                    rs.getString("REIMB_STATUS"),
                    rs.getString("REIMB_TYPE")
                );
                reimbursements.add(reimb);
            }
            return reimbursements;

        } catch (SQLException e) {
            System.out.println("Error getting all reimbursements");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteReimbursement(int id) {
        
        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Employee deleted");


        } catch (SQLException e) {
            System.out.println("Error deleting reimbursement");
            e.printStackTrace();
        }
        
    }

    //update reimbursements

    @Override
    public void updateReimbursement(int id) {

        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS = ? WHERE REIMB_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "PAID");
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Reimbursement updated");
            
        } catch (SQLException e) {
            System.out.println("Error updating reimbursement");
            e.printStackTrace();
    }

}
    
}
