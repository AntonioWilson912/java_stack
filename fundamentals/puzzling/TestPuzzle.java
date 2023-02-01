import java.util.ArrayList;

public class TestPuzzle {
    public static void main(String[] args) {
        PuzzleJava appTest = new PuzzleJava();

        System.out.println("-----Ten Rolls Test-----");
        int[] tenRolls = appTest.getTenRolls();
        for (int i : tenRolls) {
            System.out.println(i);
        }

        System.out.println("-----Random Letter Test-----");
        char randomLetter = appTest.getRandomLetter();
        System.out.println(randomLetter);

        System.out.println("-----Generate Password Test-----");
        String password = appTest.generatePassword();
        System.out.println(password);

        System.out.println("-----Generate Password Set Test-----");
        ArrayList<String> passwordSet = appTest.getNewPasswordSet(3);
        for (String pass : passwordSet) {
            System.out.println(pass);
        }

        System.out.println("-----Shuffle Array Test-----");
        Integer[] nums = {5, 1, 7, 8, 2, 7, 3, 5};
        appTest.shuffleArray(nums);
        for (Integer num : nums) {
            System.out.println(num);
        }

        String[] strings = {"hello", "world", "you", "are", "the", "best"};
        appTest.shuffleArray(strings);
        for (String str : strings) {
            System.out.println(str);
        }

        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);
        doubles.add(2.5);
        doubles.add(Math.PI);
        doubles.add(Math.E);
        doubles.add(5.92);
        appTest.shuffleArray(doubles);
        for (Double db : doubles) {
            System.out.println(db);
        }
    }
}
