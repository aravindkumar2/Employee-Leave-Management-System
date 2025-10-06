package com.leave;

import com.leaveapp.dao.*;
import com.leaveapp.model.*;
import com.leaveapp.service.LeaveService;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
        	Connection conn = DriverManager.getConnection(
        		    "jdbc:mysql://localhost:3306/leave_management", "root", "5684"
        		);

            LeaveRequestDAO leaveDAO = new LeaveRequestDAO(conn);
            LeaveService service = new LeaveService(leaveDAO);

            // Example: Apply leave
            LeaveRequest leave = new LeaveRequest();
            leave.setEmpId(1);
            leave.setStartDate(Date.valueOf("2025-10-10"));
            leave.setEndDate(Date.valueOf("2025-10-12"));
            leave.setReason("Medical leave");

            service.applyLeave(leave);
            System.out.println("Leave Applied Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
