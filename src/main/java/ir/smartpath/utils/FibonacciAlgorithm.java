package ir.smartpath.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;



@Component
@Getter
public class FibonacciAlgorithm {
    public int calc(int number) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5) / 2;
        int nthTerm = (int) ((Math.pow(phi, number) - Math.pow(-phi, -number)) / squareRootOf5);
        return nthTerm;
    }
}


