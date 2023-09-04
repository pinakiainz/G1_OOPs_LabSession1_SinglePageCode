package fundamentals;

import java.util.Random;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    private static final String COMPANY = "abc.com";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final String NUMBERS = "1234567890";
    private static final Random random = new Random();

    public static String generateEmailAddress(Employee employee, String department) {
        String firstName = employee.getFirstName().toLowerCase();
        String lastName = employee.getLastName().toLowerCase();
        return firstName + lastName + "@" + department.toLowerCase() + "." + COMPANY;
    }

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        password.append(randomDigit());
        password.append(randomUpperCase());
        password.append(randomLowerCase());
        password.append(randomSpecialCharacter());

        while (password.length() < 8) {
            char randomChar = randomChar();
            password.append(randomChar);
        }

        return password.toString();
    }

    public static void showCredentials(Employee employee, String department) {
        String email = generateEmailAddress(employee, department);
        String password = generatePassword();

        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }

    private static char randomChar() {
        return (char) (random.nextInt(26) + 'a');
    }

    private static char randomUpperCase() {
        return (char) (random.nextInt(26) + 'A');
    }

    private static char randomLowerCase() {
        return (char) (random.nextInt(26) + 'a');
    }

    private static char randomDigit() {
        return (char) (random.nextInt(10) + '0');
    }

    private static char randomSpecialCharacter() {
        return SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length()));
    }

	public static String getNumbers() {
		return NUMBERS;
	}
}

public class JavaLab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Choose a department:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        System.out.print("Enter the department number: ");
        
        String department;
        int departmentChoice = scanner.nextInt();
        
        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "HumanResource";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                department = "Please Enter Valid Input";
                break;
        }
scanner.close();

        Employee employee = new Employee(firstName, lastName);
        CredentialService.showCredentials(employee, department);
    }
}