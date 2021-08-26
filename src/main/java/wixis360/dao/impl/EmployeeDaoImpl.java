package wixis360.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wixis360.dao.EmployeeDAO;
import wixis360.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveEmployee(Employee employee) {
        String save = "INSERT INTO employee(id,name,contact,address) VALUES (:id,:name,:contact,:address)";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id",employee.getId());
        mapSqlParameterSource.addValue("name",employee.getName());
        mapSqlParameterSource.addValue("contact",employee.getContact());
        mapSqlParameterSource.addValue("address",employee.getAddress());

        return namedParameterJdbcTemplate.update(save,mapSqlParameterSource);

    }

    @Override
    public Employee searchEmployee(String id) {

        String search = "SELECT * FROM employee WHERE id=?";

        return jdbcTemplate.queryForObject(search, (rs, rowNum) -> {
            return new Employee(rs.getString("id"),
                    rs.getString("name"),
                    rs.getInt("contact"),
                    rs.getString("address"));
        }, id);

    }



    @Override
    public int updateEmployee(Employee employee) {
        String update = "UPDATE employee SET name = :name , contact = :contact , address =:address where id = :id";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id",employee.getId());
        mapSqlParameterSource.addValue("name",employee.getName());
        mapSqlParameterSource.addValue("contact",employee.getContact());
        mapSqlParameterSource.addValue("address",employee.getAddress());

        return namedParameterJdbcTemplate.update(update,mapSqlParameterSource);
    }

    @Override
    public int deleteEmployee(String id) {
        String delete = "DELETE FROM employee WHERE id=:id ";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id",id);

        return namedParameterJdbcTemplate.update(delete,mapSqlParameterSource);

    }

    @Override
    public List<Employee> getAllEmployees() {
            String getAll = "SELECT * FROM employee ";
            List<Employee> list = null;
            try {
                list = jdbcTemplate.query(getAll,new ResultSetExtractor<List<Employee>>() {
                    public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        List<Employee> listTemp = new ArrayList<>();
                        while (resultSet.next()) {
                            try {
                                Employee employee = getEmployee(resultSet);
                                listTemp.add(employee);
                            } catch (Exception ex) {

                            }
                        }
                        return listTemp;
                    }
                });
            } catch (DataAccessException dataAccessException) {
                throw dataAccessException;
            }catch (Exception exception){

            }
            return list;

        }

    public Employee getEmployee(ResultSet resultSet) throws SQLException {


        Employee employee = new Employee();

        employee.setId(resultSet.getString("id"));
        employee.setName(resultSet.getString("name"));
        employee.setContact(resultSet.getInt("contact"));
        employee.setAddress(resultSet.getString("address"));

        return employee;

    }
    }



