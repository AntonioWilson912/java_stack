import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    public Random randMachine = new Random();

    public int[] getTenRolls() {
        int[] tenRolls = new int[10];

        for (int i = 0; i < tenRolls.length; i++) {
            tenRolls[i] = randMachine.nextInt(20) + 1;
        }

        return tenRolls;
    }

    public char getRandomLetter() {
        char[] letters = new char[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char)(65 + i);
        }
        char randomLetter = letters[randMachine.nextInt(letters.length)];

        return randomLetter;
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }

        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>();
        while (passwordSet.size() < length) {
            passwordSet.add(generatePassword());
        }

        return passwordSet;
    }

    public <T> void shuffleArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randIndex = randMachine.nextInt(arr.length);
            T temp = arr[randIndex];
            arr[randIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public <T> void shuffleArray(ArrayList<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int randIndex = randMachine.nextInt(arr.size());
            T temp = arr.get(randIndex);
            arr.set(randIndex, arr.get(i));
            arr.set(i, temp);
        }
    }
}
