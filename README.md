## Concurrency in Java

This project contains Java classes that demonstrate the concept
of concurrency in Java with key terminologies.

1. Process is a unit of execution with a memory called heap.
2. Thread is a unit of execution in a process with its own memory
called thread stack which only the thread can access. 
3. Every process has at least one thread called the main thread and 
can have other system threads that perform other tasks such as memory management
and IO. As Java developers we do not code or create those threads 
as the processes we code run on the main thread exclusively. Every thread
created by a process shares that process's memory abd files which can cause
problems. Additionally we cannot guarantee the order in which the threads we create 
are scheduled to run as that depends on the JVM and the OS.
4. Two main reasons for using muliple threads: performing a task that takes a long time.
Suspension of main thread while waiting for a response from an external source can create
the impression of a system hang or failure especially for UI applications to the end user.
Creating a second thread that handles fetching data from external source while the main 
thread continues to run processes and tasks is a way around this.
   The second reason is an API requires us to provide one e.g. passing in a particluar code
   at some point in a running application that the application needs to process.
5. Concurrency refers to an application doing more than one thing at a time. This means progress
can be made on more than one task at a time i.e. one task doesn't have to complete before another
one can start.
6. A second way of creating a thread is to use the Runnable interface. The advantage of using that 
is it only requires the implementation of one method - run() method. When deciding which option to use 
when creating threads most developers use the Runnable interface implementation option as many methods
in the Java APIs want a Runnable instance passed to them e.g. the introduction of lambda expressions makes
it more convenient to use anonymous Runnable instances so when presented with a choice because we are not 
calling a method that requires one or the other there isn't really a right or wrong answer but most developers
use the Runnable because it is more flexible.
7. A thread terminates when it returns from its run() method either implicitly because it reaches the methods end 
or explicitly because it executes a return statement. N/B: You implement the run() method but do not call it directly
as the JVM calls the run() method. Calling the run() method executes the code on the thread that calls the run() method
instead of on a new thread.
8. Besides creating and starting threads we can ask them to do other tasks such as sleep to give other threads the 
opportunity to run or perform a task after a specific amount of time has passed e.g. write to file every fifteen seconds
or check for requested data every two seconds, set a thread to sleep when it has to wait for return from another thread
to perform a task and the other thread only does it every 10 seconds for example - in this scenario the first thread can be
put to sleep for 10 seconds rather than having it continue to run when we know it has to wait for 10 seconds for the 
results to return from the other thread  
9. A thread can wake up prematurely because another thread interrupts it causing the InterruptedException to be thrown. If 
the thread in AnotherThread class is not interrupted it wakes up after 3 seconds executing the corresponding display statement
on the console. The code at this stage (ideally tag v1.3 Release 1.1 dev-Beta works because no thread interrupts the AnotherThread
during its sleep. It is not guaranteed the thread will sleep for the specified time and the JVM calls the underlying OS to put the 
thread to sleep and its possible the OS may not support the granularity that it is asking for such as nanoseconds making the sleep()
method execution OS and JVM dependent. We interrupt a thread when we want it to stop what it is doing and do something else. When 
we do that we interrupt the thread because we wnat it to terminate e.g. we have a thread monitoring a buffer for data another thread
is fetching, when the other thread realizes there will never be anymore data for any reason we can interrupt the monitoring thread
and it will terminate. There are two ways for threads to notice they have been interrupted, first is to catch the InterruptedException
in the run() method. When the run() method does not call any method that throws InterruptedException it should call the Interrupted method
periodically to check wether it has been interrupted and that method will return true when another thread has interrupted. One thread 
interrupts another by calling interrupt method on the instance of the thread it wants to interrupt meaning it needs a reference to the
thread instance to be able to call the interrupt method on it.  
10. Threads can be woken up from their sleep periodically to check if there is any work for it to do. In a scenario where we know a thread
can't continue to execute until another thread is terminated e.g. we might know there might not be any data to process until the thread that 
is fetching the data has finished executing. In this scenario, rather than waking up the thread periodically to see if there is any data we can
join the thread to the thread that is fetching the data. When we join a thread to a second thread, the first thread will wait for the second 
thread to terminate and then it will continue to execute.  

