import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    abstract String shape();
}

class Circle extends Plot {
    double radius;

    Circle(String o, double r) {
        super(o);
        radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String o, double l, double w) {
        super(o);
        length = l;
        width = w;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String o, double b, double h) {
        super(o);
        base = b;
        height = h;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            Plot p;

            switch (type) {
                case "CIRCLE":
                    p = new Circle(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    p = new Rectangle(owner,
                            sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    p = new Triangle(owner,
                            sc.nextDouble(), sc.nextDouble());
            }

            double a = p.area();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.shape(), a);
            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}