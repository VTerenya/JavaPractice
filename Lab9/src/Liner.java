class Liner extends Series {

    Liner(int size, double q, double a1) {
        super(size, q, a1);
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                series[i] = a1;
                continue;
            }
            series[i] = a1 + q * i;
        }
    }

    @Override
    public double calculationElemnt(int index) {
        return series[index];
    }
}
