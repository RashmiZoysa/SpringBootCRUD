package wixis360.service;

import wixis360.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/
public interface EmployeeService {
        int saveEmployee(EmployeeDTO dto);

        EmployeeDTO searchEmployee(String id) throws SQLException;

        int updateEmployee(EmployeeDTO dto);

        int deleteEmployee(String id);

        List<EmployeeDTO> getAllEmployees();

    }

