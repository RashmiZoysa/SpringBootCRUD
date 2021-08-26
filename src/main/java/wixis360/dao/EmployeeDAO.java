package wixis360.dao;

import wixis360.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/
public interface EmployeeDAO {
    int saveEmployee(Employee employee);

    Employee searchEmployee(String id) throws SQLException;

    int updateEmployee(Employee employee);

    int deleteEmployee(String id);

    List<Employee> getAllEmployees();

}
