package provaStrategy;

public class Test {
	public static void main(String[] args) {
		VettoreOrdinabile v = new VettoreOrdinabile(new QuickSort());
		v.add(1);
		v.add(6);
		v.add(2);
		v.add(7);
		v.add(8);
		v.add(3);
		System.out.println(v);
		v.sort();
		System.out.println(v);
	}
}
