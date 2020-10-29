//variant 1
import static java.lang.Math.*;

public class Lab1 {
    public static void main(String[] args) throws Exception {
        try {
            if (args.length != 2)
                throw new Exception();
            double sum = 0;
            double e = Double.parseDouble(args[1]);
            double x = Double.parseDouble(args[0]);
            double prevSum = sum;

            sum += pow(x, 3 * pow(1, 2));
            double prevX = sum - prevSum;
            int k = 1;
            while ((sum - prevSum) > e) {
                System.out.println("X" + "[" + k + "] : " + prevX);
                k++;
                prevSum = sum;
                sum += prevX * pow(x, 6 * k - 3);
                prevX = sum - prevSum;
            }
            System.out.println("Summary: " + sum);
        } catch (Exception e) {
            System.out.println("Wrong, u have much parameters");
        }

    }
}
