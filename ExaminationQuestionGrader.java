import java.util.*;
import java.util.regex.*;

abstract class ExamQuestion {
    String type, text, correct, answer;
    double points;

    ExamQuestion(String t, String q, String c,
                 String a, double p) {
        type = t;
        text = q;
        correct = c;
        answer = a;
        points = p;
    }

    abstract double grade();
}

class MCQ extends ExamQuestion {
    MCQ(String q, String c, String a, double p) {
        super("MCQ", q, c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends ExamQuestion {
    TF(String q, String c, String a, double p) {
        super("TF", q, c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class Essay extends ExamQuestion {
    Essay(String q, String c, String a, double p) {
        super("ESSAY", q, c, a, p);
    }

    double grade() {
        int matches = 0;

        for (String keyword : correct.split(",")) {
            if (answer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher m = pattern.matcher(line);
            List<String> parts = new ArrayList<>();

            while (m.find()) {
                parts.add(m.group(1) != null
                        ? m.group(1) : m.group(2));
            }

            String type = parts.get(0);
            String question = parts.get(1);
            String correct = parts.get(2);
            String answer = parts.get(3);
            double points = Double.parseDouble(parts.get(4));

            ExamQuestion q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(question, correct, answer, points);
                    break;
                case "TF":
                    q = new TF(question, correct, answer, points);
                    break;
                default:
                    q = new Essay(question, correct, answer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}