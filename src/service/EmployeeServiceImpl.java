package service;

import jdk.nashorn.internal.objects.Global;
import model.Employee;
import global.GlobalData;
import exception.ListIsEmpty;
import exception.UserNameNotFoundException;

import static util.InputUtil.inputTypeLong;
import static util.InputUtil.inputTypeShort;
import static util.InputUtil.inputTypeString;

public class EmployeeServiceImpl implements EmployeeService {

    static long id = 1;

    //    Filling an employee info
    @Override
    public Employee fillEmployees() {

        String fullName = inputTypeString("Enter the employee's full name: ");
        String birthDate = inputTypeString("Enter the birthdate: ");
        String profession = inputTypeString("Enter the profession: ");

        return new Employee(fullName, birthDate, id++, profession);
    }

    //    Registration
    @Override
    public boolean register() {

//        Employee[] temp +=GlobalData.employees;

        short employeeSize = inputTypeShort("Enter the number of employees: ");
        GlobalData.employees = new Employee[employeeSize];

        for (int i = 0; i < employeeSize; i++) {

            System.out.println(i + 1 + ". Employee");
            GlobalData.employees[i] = fillEmployees();
            System.out.println("====================");
        }
        return true;
    }

    //    Displaying the employee list
    @Override
    public void showList() throws ListIsEmpty {
        if (GlobalData.employees.length == 0) {
            throw new ListIsEmpty();
        } else {

            for (int i = 0; i < GlobalData.employees.length; i++) {

                System.out.println("==========" + (i + 1) + ". Employee==========");
                System.out.println(GlobalData.employees[i]);
            }
        }
    }

    //    Finding an employee by name
    @Override
    public void findByName(String name) throws UserNameNotFoundException {

        if (GlobalData.employees == null) {
            throw new UserNameNotFoundException();
        } else {
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getFullName().contains(name)) {
                    System.out.println(GlobalData.employees[i]);
                } else throw new UserNameNotFoundException();
            }
        }
    }

    //    Updating employee information
    @Override
    public void update() throws ListIsEmpty {

        if (GlobalData.employees == null) {
            throw new ListIsEmpty();
        } else {

            EmployeeManagement manageEmployee = new EmployeeManagementImpl();

            long id = inputTypeLong("Enter the id of an employee wanted to delete: ");

            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == id) {
                    manageEmployee.employeesUpdateOptions(manageEmployee.employeesUpdateMenu(), i);
                }
            }
        }
    }

    //    Deleting the employee
    @Override
    public void delete(long id) throws ListIsEmpty {

        if (GlobalData.employees == null) {
            throw new ListIsEmpty();
        } else {
            Employee[] temp = new Employee[GlobalData.employees.length - 1];

            for (int i = 0, k = 0; i < GlobalData.employees.length; i++) {
                if (i != (id - 1)) {
                    temp[k] = GlobalData.employees[i];
                    k++;
                }
            }
            GlobalData.employees = temp;
        }
    }

    //    Getting total employee number
    @Override
    public void getTotalEmployee() throws ListIsEmpty {
        if (GlobalData.employees == null) {
            throw new ListIsEmpty();
        } else System.out.println(GlobalData.employees.length + " employees exist.");
    }
}
