package com.leaveapp.dao;

import com.leaveapp.model.LeaveRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveRequestDAO {
    private Connection conn;

    public LeaveRequestDAO(Connection conn) {
        this.conn = conn;
    }

    public void applyLeave(LeaveRequest leave) throws SQLException {
        String sql = "INSERT INTO LeaveRequest(emp_id, start_date, end_date, reason) VALUES(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, leave.getEmpId());
        ps.setDate(2, leave.getStartDate());
        ps.setDate(3, leave.getEndDate());
        ps.setString(4, leave.getReason());
        ps.executeUpdate();
    }

    public List<LeaveRequest> getAllLeaves() throws SQLException {
        List<LeaveRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM LeaveRequest";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            LeaveRequest l = new LeaveRequest();
            l.setLeaveId(rs.getInt("leave_id"));
            l.setEmpId(rs.getInt("emp_id"));
            l.setStartDate(rs.getDate("start_date"));
            l.setEndDate(rs.getDate("end_date"));
            l.setReason(rs.getString("reason"));
            l.setStatus(rs.getString("status"));
            list.add(l);
        }
        return list;
    }

    public void updateLeaveStatus(int leaveId, String status) throws SQLException {
        String sql = "UPDATE LeaveRequest SET status=? WHERE leave_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, leaveId);
        ps.executeUpdate();
    }
}
