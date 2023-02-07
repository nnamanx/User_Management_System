package service;

import exception.ListIsEmpty;
import exception.UserNameNotFoundException;
import global.GlobalData;
import model.Employee;

import static util.InputUtil.inputTypeLong;
import static util.InputUtil.inputTypeString;

import static util.InputUtil.*;

public class EmployeeManagementImpl implements EmployeeManagement {

    private static EmployeeService employeeService = new EmployeeServiceImpl();

    public static short employeesMenu() {

        System.out.println("===== Employee Management System =====" +
                "\n[0] Exit the system" +
                "\n[1] Registration" +
                "\n[2] Show the list" +
                "\n[3] Find an employee by name" +
                "\n[4] Get total number of the employees" +
                "\n[5] Update employee" +
                "\n[6] Delete employee" +
                "\n[7] Back to the Main page");

        return inputTypeShort("Choose an option: ");
    }

    public static void employeesOptions(short option) {

        switch (option) {
            case 0:
                System.exit(-1);
            case 1:
                if (employeeService.register()) {
                    System.out.println("Successfully completed. Continue with another option");
                }
                break;
            case 2:
                try {
                    employeeService.showList();
                } catch (ListIsEmpty e) {
                    System.out.println("The list is empty.");
                }
                break;
            case 3:
                try {
                    employeeService.findByName((inputTypeString("Enter the name of the employee looking for: ")));
                } catch (UserNameNotFoundException e) {
                    System.err.println("The name does not on the list. Try again");
                }
                break;
            case 4:
                try {
                    employeeService.getTotalEmployee();
                } catch (ListIsEmpty e) {
                    throw new RuntimeException(e);
                }
                break;
            case 5:
                try {
                    employeeService.update();
                } catch (ListIsEmpty e) {
                    throw new RuntimeException(e);
                }
                break;
            case 6:
                try {
                    employeeService.delete((inputTypeLong("Enter the id of the employee: ")));
                } catch (ListIsEmpty e) {
                    throw new RuntimeException(e);
                }
                break;
            case 7:
                MenuManagementImpl.entryOptions(MenuManagement.entryMenu());
                break;
            default:
                System.err.println("Invalid option");
        }
    }

    //   Update Menu and options
    @Override
    public short employeesUpdateMenu() {

        System.out.println("===== Update Employee Menu =====" +
                "\n[0] Exit the system" +
                "\n[1] Edit full name" +
                "\n[2] Edit birt date" +
                "\n[3] Edit profession");

        return inputTypeShort("Choose an option: ");
    }

    @Override
    public void employeesUpdateOptions(short option, long id){

        Employee employee = new Employee();
        EmployeeService employeeService = new EmployeeServiceImpl();

        switch (option) {
            case 0:
                System.exit(-1);
            case 1:
                GlobalData.employees[(int) id].setFullName(inputTypeString("Enter a new name: "));
                try {
                    employeeService.update();
                } catch (ListIsEmpty e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                employee.setBirthDate(inputTypeString("Enter a new birth date: "));
                break;
            case 3:
                employee.setProfession(inputTypeString("Enter a new profession: "));
                break;
            default:
                System.err.println("Invalid option");
        }
    }
}