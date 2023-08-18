package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/15 11:24
 */

public class Hj68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sort = in.nextInt();
        in.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = in.nextLine().split(" ");
            students.add(new Student(str[0], Integer.parseInt(str[1])));
        }
        students = students.stream().sorted((o1, o2) -> sort == 1 ? o1.score - o2.score : o2.score - o1.score)
                .collect(Collectors.toList());
        for (Student student : students) {
            System.out.println(student.name + " " + student.score);
        }
    }

    private static class Student {
        String name;
        int score;

        private Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
