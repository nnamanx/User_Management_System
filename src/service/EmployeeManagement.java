package service;

import exception.ListIsEmpty;

interface EmployeeManagement {
    short employeesUpdateMenu();

    void employeesUpdateOptions(short option, long id) throws ListIsEmpty;
}
