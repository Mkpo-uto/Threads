## README mark down file provides a description of Threads repo

1. A process is a unit of execution with a memory called heap.
2. A thread is a unit of execution within a process with its own
memory called threadstack. Each process has at least one thread 
called the main thread and some other threads that perform tasks 
such as memory management and IO. As developers we cannot code or 
create these other threads but can only code processes that run on
the main thread exclusively. 
3. Threads can be created when you create a process and you can 
attempt to dictate the order in which threads ina process are run
but the outcome you specified is not guaranteed because the order 
in which threads are run depends on the JVM and OS.