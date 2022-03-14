/*
MyRunnable class implements the interface Runnable run() method
With this option of creating threads instead of having a subclass
of the Thread class implement it's run() method, any class can implement
the Runnable interface and implement its run() method with the code
written in the run() method to execute on the thread we create 
*/
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(ThreadColor.ANSI_RED + "Hello from MyRunnable's implementation of run()");
	}
}
