import java.util.*;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    void display() {
        double bonus = getBonus();
        double total = baseSalary + bonus;
        System.out.println(name + " (" + getClass().getSimpleName() +
                "): base " + baseSalary +
                ", bonus " + bonus +
                ", total " + total);
    }
}

class Teacher extends Staff {
    Teacher(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 5000;
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 2000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher"))
                staff[i] = new Teacher(name, salary);
            else if (type.equals("LabAssistant"))
                staff[i] = new LabAssistant(name, salary);
            else
                staff[i] = new Staff(name, salary);
        }

        for (Staff s : staff) {
            s.display();
            grandTotal += s.baseSalary + s.getBonus();
        }

        System.out.println("Grand Total Salary: " + grandTotal);
    }
}