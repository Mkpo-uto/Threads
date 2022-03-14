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
>>>>>>> develop
