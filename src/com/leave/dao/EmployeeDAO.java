package com.leaveapp.dao;

import com.leaveapp.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    public Employee getEmployeeByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE email=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Employee e = new Employee();
            e.setEmpId(rs.getInt("emp_id"));
            e.setName(rs.getString("name"));
            e.setEmail(rs.getString("email"));
            e.setRole(rs.getString("role"));
            e.setPassword(rs.getString("password"));
            e.setLeaveBalance(rs.getInt("leave_balance"));
            return e;
        }
        return null;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Employee e =	 new Employee();
            e.setEmpId(rs.getInt("emp_id"));
            e.setName(rs.getString("name"));
            e.setEmail(rs.getString("email"));
            e.setRole(rs.getString("role"));
            e.setPassword(rs.getString("password"));
            e.setLeaveBalance(rs.getInt("leave_balance"));
            list.add(e);
        }
        return list;
    }
}
