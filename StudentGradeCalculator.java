import java.util.Scanner;

public class StudentGradeCalculator {
    private static final int SUBJECT_COUNT = 5;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0;
        System.out.println("=== Student Grade Calculator ===");
        System.out.println("Enter marks out of 100 for " + SUBJECT_COUNT + " subjects.");

        for (int i = 1; i <= SUBJECT_COUNT; i++) {
            double mark;
            while (true) {
                System.out.print("Subject " + i + ": ");
                if (!input.hasNextDouble()) {
                    System.out.println("Please enter a number.");
                    input.next();
                    continue;
                }
                mark = input.nextDouble();
                if (mark >= 0 && mark <= 100) break;
                System.out.println("Marks must be between 0 and 100.");
            }
            total += mark;
        }

        double average = total / SUBJECT_COUNT;
        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 80) grade = "B";
        else if (average >= 70) grade = "C";
        else if (average >= 60) grade = "D";
        else grade = "F";

        System.out.printf("%nTotal marks: %.2f / %d%n", total, SUBJECT_COUNT * 100);
        System.out.printf("Average: %.2f%%%n", average);
        System.out.println("Grade: " + grade);
        input.close();
    }
}

