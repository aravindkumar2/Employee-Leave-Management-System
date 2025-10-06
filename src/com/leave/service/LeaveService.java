package com.leaveapp.service;

import com.leaveapp.dao.LeaveRequestDAO;
import com.leaveapp.model.LeaveRequest;
import java.sql.SQLException;
import java.util.List;

public class LeaveService {
    private LeaveRequestDAO leaveDAO;

    public LeaveService(LeaveRequestDAO dao) {
        this.leaveDAO = dao;
    }

    public void applyLeave(LeaveRequest leave) throws SQLException {
        leaveDAO.applyLeave(leave);
    }

    public List<LeaveRequest> viewAllLeaves() throws SQLException {
        return leaveDAO.getAllLeaves();
    }

    public void approveLeave(int leaveId) throws SQLException {
        leaveDAO.updateLeaveStatus(leaveId, "approved");
    }

    public void rejectLeave(int leaveId) throws SQLException {
        leaveDAO.updateLeaveStatus(leaveId, "rejected");
    }
}
