package service;

import exception.ListIsEmpty;
import exception.UserNameNotFoundException;
import model.Employee;

interface EmployeeService {
    Employee fillEmployees();

    boolean register();

    void showList() throws ListIsEmpty;

    void findByName(String name) throws UserNameNotFoundException;

    void update() throws ListIsEmpty;

    void delete(long id) throws ListIsEmpty;

    void getTotalEmployee() throws ListIsEmpty;
}
