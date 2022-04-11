# Transaction
A database transaction symbolizes a unit of work performed within a database management system against a database, and treated in a coherent and reliable way independent of other transactions. A transaction generally represents any change in a database.

# How to solve the deadlock
In a database, a deadlock is a situation in which two or more transactions are waiting for one another to give up locks.
For example, Transaction A might hold a lock on some rows in the Accounts table and needs to update some rows in the Orders table to finish. Transaction B holds locks on those very rows in the Orders table but needs to update the rows in the Accounts table held by Transaction A. Transaction A cannot complete its transaction because of the lock on Orders. 
Transaction B cannot complete its transaction because of the lock on Accounts. All activity comes to a halt and remains at a standstill forever unless the DBMS detects the deadlock and aborts one of the transactions.
![image](https://user-images.githubusercontent.com/16676447/162657824-fe4ef56d-0ca5-4903-98a3-5832553880b2.png)

-	Avoiding deadlocks
  
Using both row-level locking and the TRANSACTION_READ_COMMITTED isolation level makes it likely that you will avoid deadlocks (both settings are Derby defaults). However, deadlocks are still possible.
-	Deadlock detection

When a transaction waits more than a specific amount of time to obtain a lock (called the deadlock timeout), Derby can detect whether the transaction is involved in a deadlock.
-	Lock wait timeouts

Even if a transaction is not involved in a deadlock, it might have to wait a considerable amount of time to obtain a lock because of a long-running transaction or transactions holding locks on the tables it needs.
-	Configuring deadlock detection and lock wait timeouts

You configure the amount of time a transaction waits before Derby does any deadlock checking with the derby.locks.deadlockTimeout property.
-	Debugging Deadlocks

If deadlocks occur frequently in your multi-user system with a particular application, you might need to do some debugging.
-	Programming applications to handle deadlocks

When you configure your system for deadlock and lockwait timeouts and an application could be chosen as a victim when the transaction times out, you should program your application to handle them.
