import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lab3 {

    public static void swapLines(double[][] mas,int  a,int  b){
        double[] A= new double[mas.length];
        double[] B = new double[mas.length];
        for (int i = 0; i < mas.length; i++){
            A[i] = mas[a][i];
            B[i] = mas[b][i];
        }
        for(int i = 0; i < mas.length; i++){
            mas[b][i] = A[i];
            mas[a][i] = B[i];
        }
    }
    public static void swapElements(double[] mas, int a, int b){
        double tempA = mas[a];
        double tempB = mas[b];
        mas[a] = tempB;
        mas[b] = tempA;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\teren\\Documents\\LabsProgramming\\Lab3Java\\src\\in.txt";
        Path path = Paths.get(fileName);
        Scanner input = new Scanner(path);
        int n = 0;
        if (input.hasNextInt()) {
            n = input.nextInt();
        }
        double[][] matrix = new double[n][n];
        double[] answers = new double[n];
        double[] result = new double[n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (input.hasNextDouble()) {
            if (j == n) {
                j = 0;
                i++;
            }
            if (i == n)
                break;
            matrix[i][j] = input.nextDouble();
            j++;

        }
        while (input.hasNextDouble()) {
            answers[k] = input.nextDouble();
            k++;
        }

        for (i = 0; i < n; i++) {
            int maxI = 0;
            double max = -Double.MAX_VALUE;
            for (int ii = i; ii < n; ii++) {
                if (max < matrix[ii][i]) {
                    maxI = ii;
                    max = matrix[ii][i];
                }
            }
            swapLines(matrix,i,maxI);
            swapElements(answers,i,maxI);
            double kf = matrix[i][i];
            for (j = 0; j < n; j++){
                matrix[i][j]/=kf;
            }
            answers[i]/=kf;

            for(j = i+1; j < n; j++){
                kf = matrix[j][i];
                for(k = 0; k < n; k++){
                    matrix[j][k] -= matrix[i][k]*kf;
                }
                answers[j] -= answers[i]*kf;
            }

        }


        result[n-1] = answers[n-1]/matrix[n-1][n-1];
        double c = 0;
        for (i = n-2; i>=0; i--){
            for (j = 0; j < n; j++){
                if(j==i) continue;
                c +=matrix[i][j]*result[j];
            }
            result[i] = answers[i]-c;
            c = 0;
        }

        for (i = 0; i < n; i++){
            System.out.println(result[i] + " ");
        }
    }
}

