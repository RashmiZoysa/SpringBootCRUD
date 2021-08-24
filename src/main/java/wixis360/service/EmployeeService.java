package wixis360.service;

import wixis360.dto.EmployeeDTO;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/
public interface EmployeeService {
        void saveEmployee(EmployeeDTO dto);

        EmployeeDTO searchEmployee(String id);

        void updateEmployee(EmployeeDTO dto);

        void deleteEmployee(String id);

        ArrayList<EmployeeDTO> getAllEmployees();

    }

