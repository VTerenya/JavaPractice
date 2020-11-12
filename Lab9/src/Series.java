import java.io.*;
abstract class Series {
    private int n;
    private double q;
    private double a0;
    public double[] series;

    Series(int size, double q, double a1) {
        n = size;
        series = new double[n];
    }

    public abstract double calculationElemnt(int index);

    public void recordInFile(String fileName) throws IOException {
        try(FileWriter fileWriter = new FileWriter(fileName,false)){
            String text = toString();
            fileWriter.write(text);
            fileWriter.flush();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public double sumProgression() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += series[i];
        }
        return sum;
    }

    public String toString(){
        String string = "[";
        for (int i = 0; i < n; i++) {
            string+=series[i];
            if(i!=n-1) string+=", ";
        }
        string+="]";
        return string;
    }
}
