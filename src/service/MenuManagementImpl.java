package service;

import static util.InputUtil.inputTypeShort;

public class MenuManagementImpl implements MenuManagement {

    EmployeeManagement manageEmployee = new EmployeeManagementImpl();

    public static short entryMenu() {

        System.out.println("========== User Management System ==========" +
                "\n[0] Exit the system" +
                "\n[1] Employee Management");

        return inputTypeShort("Choose an option: ");
    }

    public static void entryOptions(short option) {
        while (true){
//        Cases for entry option
            switch (option) {
                case 0:
                    System.exit(-1);
                case 1:
                    EmployeeManagementImpl.employeesOptions(EmployeeManagementImpl.employeesMenu());
                    break;
                default:
                    System.err.println("Invalid option.");
            }
        }
    }


}




