package pers.li.lambdas.$3;

import java.util.function.Function;

public class ClassStaticMethodTest {
	public static double worker(NumFunction nf, double num)
	{
		return nf.calculate(num);
	}
	public static void main(String[] args) {
		double a = -5.3;
		double b = worker(Math::abs, a);
		System.out.println(b);
		
		double c = worker(Math::floor, a);
		System.out.println(c);


	}	
}

interface NumFunction {
	double calculate(double num);
}
