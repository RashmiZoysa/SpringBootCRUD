package wixis360.dao;

import wixis360.dto.EmployeeDTO;
import wixis360.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/
public interface EmployeeDAO {
    int saveEmployee(Employee employee);

    void searchEmployee(String id) ;

    int updateEmployee(Employee employee);

    int deleteEmployee(String id);

    ArrayList<EmployeeDTO> getAllEmployees();

}
