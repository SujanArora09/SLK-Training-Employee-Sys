package jdbcapp.service;
import java.util.List;
import jdbcapp.dao.DepartmentDAO;
import jdbcapp.dao.DepartmentDAOImpl;
import jdbcapp.model.Department;

public class DepartmentServiceImpl implements DepartmentService {

	public Department addDepartment(Department department) {
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		Department dept = deptDAO.addDepartment(department);
		return dept;
	}

	public Department getDepartment(Integer deptNo) {
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		Department dept = deptDAO.getDepartment(deptNo);
		return dept;
	}

	public Department updateDepartment(Department department) {
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		return deptDAO.updateDepartment(department);
		
	}

	public String deleteDepartment(Integer deptNo) {
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		return deptDAO.deleteDepartment(deptNo);
	}
	public List<Department> retrieveAllDepartment() {
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		return deptDAO.retrieveAllDepartment();
	}
	

}
