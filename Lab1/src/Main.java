import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(getPerfectNumber(100000));
    }

    public static ArrayList<Integer> getPerfectNumber(int range) {
        ArrayList<Integer> res = new ArrayList<>();

        if (range < 6) return res;

        for (int i = 6; i <= range; i++) {
            int dividersSum = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    dividersSum += j;
                }
            }
            if (dividersSum == i) {
                res.add(i);
            }
        }

        return res;
    }
}