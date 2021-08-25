package wixis360.service;

import wixis360.dto.EmployeeDTO;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/
public interface EmployeeService {
        int saveEmployee(EmployeeDTO dto);

        void searchEmployee(String id);

        int updateEmployee(EmployeeDTO dto);

        int deleteEmployee(String id);

        ArrayList<EmployeeDTO> getAllEmployees();

    }

