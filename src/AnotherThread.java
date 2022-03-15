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
		System.out.println(ThreadColor.ANSI_BLUE + 
	//	"Hello from another thread"  //this is the original display statement in this method for Release 1.0 dev-Beta on develop branch
	"Hello from "	+ currentThread().getName(); //This statement is used to test the difference between calling
												//the run() or start() method on a thread instance.
	);
		
	//Modification to display thread code performing other tasks apart from creating and starting threads
		try {
			Thread.sleep(3000); //sets the thread to sleep for 3 seconds i.e. measurement is in milliseconds in sleep() method
								//so 3000 milliseconds = 3 seconds. Sleep() method also has overloaded method that accepts a second
								//parameter for nanoseconds
		}catch(InterruptedException e) {
			System.out.println(ANSI_BLUE + "Another thread woke me up");//To be executed if another thread wakes up this thread
			return; // terminates anotherThread instance once it is interrupted 
		}
		
	//	The method below executes after 3 seconds to demonstrate thread performing the sleep task if the InterruptedException is not thrown
	System.out.println("Three seconds have passed and I'm awake");
	}
}
