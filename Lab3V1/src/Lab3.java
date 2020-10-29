import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab3 {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\teren\\IdeaProjects\\JavaLab3\\src\\input.txt";
        Path path = Paths.get(fileName);

        Scanner scanner = new Scanner(path);
        //СЃС‡РёС‚Р°РµРј СЂР°Р·РјРµСЂ РјР°С‚СЂРёС†С‹
        int n = 0;
        if (scanner.hasNextInt())
            n = scanner.nextInt();
        n += 1;
        int[][] matrix = new int[n - 1][n];

        //Р·Р°РЅСѓР»СЏРµРј
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        //СЃС‡РёС‚Р°РµРј Р·РЅР°С‡РµРЅРёСЏ РёР· С„Р°Р№Р»Р°
        int i = 0;
        int j = 0;
        int nextJ = j + 1;
        while (scanner.hasNextInt()) {

            if (j < n) {
                matrix[i][j] = scanner.nextInt();
                j++;
            } else {
                i++;
                if (i == (n - 1))
                    break;
                j = nextJ;
                nextJ++;
            }
        }

        //РѕР±СЂР°Р±РѕС‚РєР°
        System.out.println("Matrix:");
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("----------");
        int[] result = new int[n - 1];
        for (int k = 0; k < n - 1; k++) {
            result[k] = 0;
        }

        System.out.println();
        boolean r = false;
        result[n - 2] = matrix[n - 2][n - 1] / matrix[n - 2][n - 2];

        int k = n - 3;
        for (i = n - 3; i >= 0; i--) {
            int c = 0;
            for (j = n - 2; j >= 0; j--) {
                if (j == k)
                    continue;
                c += matrix[i][j] * result[j];
            }
            if((matrix[i][n - 1] - c)==0 && matrix[i][k]==0) {
                r = true;
                System.out.println("Infinity");
                break;
            }
            if((matrix[i][n - 1]-c)!=0 && matrix[i][k]==0){
                r= true;
                System.out.println("No solution");
                break;
            }
            result[k] = (matrix[i][n - 1] - c) / matrix[i][k];
            k--;
        }
        if(!r) {
            for (i = 0; i < n - 1; i++) {
                System.out.println("x" + i + ": " + result[i]);
            }
        }
    }
}
