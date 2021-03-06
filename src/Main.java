
public class Main {

	public static void main(String[] args) {
		System.out.println(ThreadColor.ANSI_PURPLE + 
				"Hello from the main thread"); //Display runs the application on the main thread
//	After the main thread writes to the console using the statement above
//we create an instance of the AnotherThread class we just created below
		Thread anotherThread = new AnotherThread();
//Setting the thread name is used to test output of calling run() method on thread instance instead of start()		
		anotherThread.setName("== Another Thread ==");
//Call the start() method on the newly created AnotherThread subclass instance to get the JVM to
//invoke the run() method overridden in the class		
		anotherThread.start(); //after inserting line 11 - anotherThread.setName(String name), this method displays
								//the output Hello from ===== Another Thread =====
		//anotherThread.run(); displays the output Hello from main

// Anonymous classes are better, easily configured and can be created to run threads in place of 
//named classes if you intend to only run the thread once whereas if you tend to run the same code 
//more than once(not start the thread because you are not allowed to start the same instance of a thread
//more than once i.e. You cannot start a thread instance that is already running as it results in an IllegalThreadStateException) 
//creating a named class for the thread is more well suited and gives better results. A consideration for which 
//option to use when creating a thread is anonymous class thread must be started immediately  		
		new Thread() {
			public void run() {
				System.out.println(ThreadColor.ANSI_GREEN + 
				"Hello from the anonymous class thread");
			}
		}.start();
		
//Upon running the anonymous class thread the output displays the Main thread first, the AnotherThread second, the Main thread second call and 
//finally the anonymous class thread output showing the autonomy of the JVM over which thread is scheduled to run first


//To implement MyRunnable thread class we create an instance of the Thread class not the subclass and pass in 
//an instance of the MyRunnable class to the Thread class constructor and then class the Thread class instance
//start() method as done previously
		Thread myRunnableThread = new Thread(new MyRunnable());
		myRunnableThread.start();
		anotherThread.interrupt(); //interrupts thread and displays statement 'another thread woke me up' before terminating abruptly

//Similar to when creating threads using a subclass we can also have an anonymous class implementation of MyRunnable
//class and pass its instance to the Thread class constructor		
		Thread myRunnableThread = new Thread(new MyRunnable() {
			@Override
			public void run() {
//If you use super.run() method as written below the output is the contents of the run() method overridden in MyRunnable class				
				//super.run();
				//Statement is displayed when super.run() is commented out
				System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
//The try catch block added below joins the myRunnableThread instance to anotherThread instance . You join a thread by calling the join() method
//on the thread instance for the thread you want to join in this case the anotherThread instance 
//It does not matter if the second thread is created using Runnable interface or Named class or Anonymous class
//To join a thread we just require a created thread instance . join() method can throw InterruptedException because just like
//with the sleep() method join() method can terminate prematurely if this thread is interrupted by another thread 	
			try {
					anotherThread.join(2000);
// Output for this try catch block when the main() method is executed is the first print statement in this run() method, then the anootherThread thread
//will sleep for 3 seconds suspending execution in try block of myRunnableThread thread. After 3 seconds anotherThread thread wakes up as well as myRunnableThread
//thread allowing the print statement below to be executed and displayed in the console	
//To avoid a scenario where the thread being called fails to terminate causing the process to continue running, the overloaded join() method is passed a parameter
//value of 2000 milliseconds and the sleep() method in AnotherThread class run() method is overloaded with the value 5000 milliseconds to test thread b in this case
//myRunnableThread exiting if it times out before thread a i.e. anotherThread thread completes execution. If the thread times out before the data is returned we have 
//to handle this scenario in production ready code and return to the user a useful error response such as 'timed out'			
					System.out.println("AnotherThread terminated,or timed out so I'm running again");
				} catch(InterruptedException e) {
					System.out.println("I couldn't wait after all. I was interrupted");
				}
			}
		});
		
//	This print statement below calls the main thread again demonstrating the autonomy of the JVM and OS over which thread
//  is scheduled to run first as the main thread runs twice because the thread we created runs in my output but note this might
// vary on your OS and the JVM. While it is up to the OS and JVM to schedule when a thread runs we can attempt to influence that 
// by setting up a priority on the thread but even with that the priority of thread scheduling and running is up to the system. 	
	System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");
		
		
	}

}
