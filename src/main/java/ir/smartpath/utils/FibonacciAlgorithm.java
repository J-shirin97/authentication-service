package ir.smartpath.utils;

import org.springframework.stereotype.Component;

@Component
public class FibonacciAlgorithm {
    public int calc(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5) / 2;
        int nthTerm = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / squareRootOf5);
        return nthTerm;
    }
}


