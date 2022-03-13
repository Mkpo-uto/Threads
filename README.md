## Concurrency in Java

This project contains Java classes that demonstrate the concept
of concurrency in Java with key terminologies.

1. Process is a unit of execution with a memory called heap.
2. Thread is a unit of execution in a process with its onw memory
called threadstack. 
3. Every process has at least one thread called the main thread and 
can have other threads that perform other tasks such as memory management
and IO. As Java developers we do not code or create processes on these threads
as the processes we code run on the main thread exclusively. Additionally
we cannot guarantee the other in which the threads we create run as that depends
on the JVM and the OS.