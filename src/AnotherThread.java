/**
* For our first demo let us create a thread. There are two ways to do this
* 1. Is to create an instance of the Thread class. The goal here is to kick off
* a thread that is going to run some code. We need a way to tell the thread what 
* code we want to run which we achieve by creating a subclass of the Thread class
* and overriding the run() method meaning instead of creating a Thread instance we
* create an instance of our subclass(AnotherThread) that extends the Thread superclass
* that allows AnotherThread subclass to override the run() method.



*/
public class AnotherThread extends Thread {

	@Override
	public void run() {
		System.out.println(//ThreadColor.ANSI_BLUE + 
		"Hello from another thread" 
	//	+ currentThread().getName()
	);
		
	//	try {
	//		Thread.sleep(5000);
	//	}catch(InterruptedException e) {
	//		System.out.println("Another thread woke me up");
	//		return;
	//	}
		
	//	System.out.println("Three seconds have passed and I'm awake");
	}
}
