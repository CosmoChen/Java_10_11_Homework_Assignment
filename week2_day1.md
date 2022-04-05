# Lock
-	**`Synchronized`**
The use of synchronized methods or statements provides access to the implicit monitor lock associated with every object, but forces all lock acquisition and release to occur in a block-structured way: when multiple locks are acquired they must be released in the opposite order, and all locks must be released in the same lexical scope in which they were acquired.
While the scoping mechanism for synchronized methods and statements makes it much easier to program with monitor locks, and helps avoid many common programming errors involving locks, there are occasions where you need to work with locks in a more flexible way. For example, some algorithms for traversing concurrently accessed data structures require the use of "hand-over-hand" or "chain locking": you acquire the lock of node A, then node B, then release A and acquire C, then release B and acquire D and so on. Implementations of the Lock interface enable the use of such techniques by allowing a lock to be acquired and released in different scopes, and allowing multiple locks to be acquired and released in any order.

-	**`Lock`**
Lock implementations provide more extensive locking operations than can be obtained using synchronized methods and statements. They allow more flexible structuring, may have quite different properties, and may support multiple associated Condition objects.
A lock is a tool for controlling access to a shared resource by multiple threads. Commonly, a lock provides exclusive access to a shared resource: only one thread at a time can acquire the lock and all access to the shared resource requires that the lock be acquired first. However, some locks may allow concurrent access to a shared resource, such as the read lock of a ReadWriteLock.

# Lock interface
-	lock(). unlock(), newCondition(). tryLock(), lockInterruptibly();

**`void lock()`**
Acquires the lock.
If the lock is not available then the current thread becomes disabled for thread scheduling purposes and lies dormant until the lock has been acquired.
A Lock implementation may be able to detect erroneous use of the lock, such as an invocation that would cause deadlock, and may throw an (unchecked) exception in such circumstances. The circumstances and the exception type must be documented by that Lock implementation.

**`void unlock()`**
Releases the lock.
A Lock implementation will usually impose restrictions on which thread can release a lock (typically only the holder of the lock can release it) and may throw an (unchecked) exception if the restriction is violated. Any restrictions and the exception type must be documented by that Lock implementation.

**`Condition newCondition()`**
Returns a new Condition instance that is bound to this Lock instance.
Before waiting on the condition the lock must be held by the current thread. A call to Condition.await() will atomically release the lock before waiting and re-acquire the lock before the wait returns.
The exact operation of the Condition instance depends on the Lock implementation and must be documented by that implementation.

**`boolean tryLock(long time, TimeUnit unit) throws InterruptedException`**
Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
If the lock is available this method returns immediately with the value true. If the lock is not available then the current thread becomes disabled for thread scheduling purposes and lies dormant until one of three things happens:
•	The lock is acquired by the current thread; or 
•	Some other thread interrupts the current thread, and interruption of lock acquisition is supported; 
•	or The specified waiting time elapses
If the lock is acquired then the value true is returned.
If the current thread:
•	has its interrupted status set on entry to this method; or
•	is interrupted while acquiring the lock, and interruption of lock acquisition is supported,
then InterruptedException is thrown and the current thread's interrupted status is cleared.
If the specified waiting time elapses then the value false is returned. If the time is less than or equal to zero, the method will not wait at all.

**`void lockInterruptibly() throws InterruptedException`**
Acquires the lock unless the current thread is interrupted.
Acquires the lock if it is available and returns immediately.

If the lock is not available then the current thread becomes disabled for thread scheduling purposes and lies dormant until one of two things happens:
•	The lock is acquired by the current thread; or
•	Some other thread interrupts the current thread, and interruption of lock acquisition is supported.
If the current thread:
•	has its interrupted status set on entry to this method; or
•	is interrupted while acquiring the lock, and interruption of lock acquisition is supported,
then InterruptedException is thrown and the current thread's interrupted status is cleared.


### ReentrantLock class
The ReentrantLock class implements the Lock interface and provides synchronization to methods while accessing shared resources. The code which manipulates the shared resource is surrounded by calls to lock and unlock method. This gives a lock to the current working thread and blocks all other threads which are trying to take a lock on the shared resource. 

As the name says, ReentrantLock allows threads to enter into the lock on a resource more than once. When the thread first enters into the lock, a hold count is set to one. Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one. For every unlocks request, hold count is decremented by one and when hold count is 0, the resource is unlocked. 

Reentrant Locks also offer a fairness parameter, by which the lock would abide by the order of the lock request i.e. after a thread unlocks the resource, the lock would go to the thread which has been waiting for the longest time. This fairness mode is set up by passing true to the constructor of the lock.

# ReadWriteLock interface
A lock is a device for commanding access to an assigned resource by multiple threads. Usually, a lock grants exclusive access to a shared resource: just one thread at a flash can acquire the lock and everyone accesses to the shared resource requires that the lock be acquired first. Though, some locks may allow side-by-side access to a shared resource, as the read lock of a ReadWriteLock.
ReadWriteLock is an interface. ReadWriteLock is implemented by ReentrantReadWriteLock Class which is in java.util.concurrent.locks package. So, to use a ReadWriteLock we have to use ReentrantReadWriteLock.
-	Method
1.	Lock readLock()
If there is no thread that has requested the write lock and the lock for writing, then multiple threads can lock the lock for reading. It means multiple threads can read the data at the very moment, as long as there’s no thread to write the data or to update the data.
2.	Lock writeLock()
If no threads are writing or reading, only one thread at a moment can lock the lock for writing. Other threads have to wait until the lock gets released. It means, only one thread can write the data at the very moment, and other threads have to wait.

-	ReentrantReadWriteLock
ReentrantReadWriteLock class of Java is an implementation of ReadWriteLock, that also supports ReentrantLock functionality.

The ReadWriteLock is a pair of associated locks, one for read-only operations and one for writing. Whereas, the ReentrantLock is a re-entrant mutual exclusion Lock with the same behavior as the implicit monitor lock accessed using synchronized methods and statements, but with some more extended capabilities.

# Future vs CompletableFuture
A Future is used as a reference to the result of an asynchronous computation. It provides an isDone() method to check whether the computation is done or not, and a get() method to retrieve the result of the computation when it is done.

CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a means of writing non-blocking code by running a task on a separate thread than the main application thread and notifying the main thread about its progress, completion or failure. This way, your main thread does not block/wait for the completion of the task and it can execute other tasks in parallel.
