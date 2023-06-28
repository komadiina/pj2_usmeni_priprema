package org.unibl.etf.myapp.package1;

public class PublicClass {

	final int a;
	
	{
//		a = 1;
	}
	
	public PublicClass() {
		a = 5;
	}
	
	public void method(){
		System.out.println("Method from PublicClass");
	}
	
	public static void main(String[] args) {
//		AbstractClass abstractClass = new AbstractClass();  
		PublicClass publicClass = new PublicClass();
		PackageClass packageClass = new PackageClass();
		AbstractClass abstractClass = new X();
		FinalClass finalClass = new FinalClass();
		publicClass.method();
		packageClass.method();
		finalClass.method();
	}

}

abstract class AbstractClass {

	public void method(){
		System.out.println("Method from AbstractClass");
	}
}

class X extends AbstractClass{
	
}

final class FinalClass{

	public void method(){
		System.out.println("Method from FinalClass");
	}
}
