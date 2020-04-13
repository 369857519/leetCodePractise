package Algorithm.categories.math;

public class Sqrt {

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        sqrt.sqrt(100);

    }

    public double sqrt(double n) {
        if (n < 0) {
            return -1.0;
        } else {
            double low, up, mid, last;
            double eps = 0.0001;
            low = 0;
            up = n > 1.0 ? n : 1;
            mid = (low + up) / 2;
            do {
                if (mid * mid < n) {
                    low = mid;
                } else {
                    up = mid;
                }
                last = mid;
                mid = (low + up) / 2;
            } while (Math.abs(mid - last) > eps);
            return mid;
        }
    }

    double SQR(double a) {
        double x = a, y = 0.0;
        while (Math.abs(x - y) > 0.0001) {
            y = x;
            x = 0.5 * (x + a / x);
        }
        return x;
    }
}
