package jdbcapp.dao;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbcapp.model.Department;
import jdbcapp.utility.DBConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		
		Connection conn = DBConnectionUtil.getDBConnection();
		PreparedStatement PS;
		try {
			PS = conn.prepareStatement("Insert into Department (deptno,deptname) values (?,?)");
	        PS.setInt(1, department.getDeptNo());
	        PS.setString(2, department.getDeptName());
	        int Row = PS.executeUpdate();
	        if(Row != 0) {
	        	return department;
	        }
	        
	        PS.close();
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}

	public Department getDepartment(Integer deptNo) {
		// TODO Auto-generated method stub
		Department department = null;
		Connection conn = DBConnectionUtil.getDBConnection();
		try {
			PreparedStatement PS = conn.prepareStatement("Select * From Department where deptno = ?");
	        PS.setInt(1, deptNo);
	        ResultSet RS = PS.executeQuery();
	        while(RS.next()) {
	        	department = new Department();
	        	department.setDeptNo(RS.getInt("deptNo"));
	        	department.setDeptName(RS.getString(2));
	        }
	        PS.close();
	        RS.close();
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}

	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Connection conn = DBConnectionUtil.getDBConnection();
		PreparedStatement PS = null;
		try {
			PS = conn.prepareStatement("Update department Set deptname = ? where deptno = ?");
			PS.setString(1, department.getDeptName());
			PS.setInt(2, department.getDeptNo());
			
			int rowsUpdated = PS.executeUpdate();
			
			if(rowsUpdated > 2) {
				return department;
			}
			PS.close();
	        conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String deleteDepartment(Integer deptNo) {
		String sqlDelete ="delete from department where deptno = ?";
		Connection conn = DBConnectionUtil.getDBConnection();
		PreparedStatement pStmt;
		try {
			pStmt=conn.prepareStatement(sqlDelete);
			pStmt.setInt(1, deptNo);
			int row = pStmt.executeUpdate();
			if(row == 1) {
				return "Department with dept number "+deptNo+" deleted successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Unable to department with dept number "+deptNo;
		
	}
	public List<Department> retrieveAllDepartment() {
		String selectAllSQL ="select * from department;";
		Connection conn = DBConnectionUtil.getDBConnection();
		List<Department> listOfDepartment = new ArrayList<Department>();
		Department department;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectAllSQL);
			while(rs.next()) {
				department=new Department();
				department.setDeptNo(rs.getInt(1));
				department.setDeptName(rs.getString(2));
				listOfDepartment.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfDepartment;
	}

}
