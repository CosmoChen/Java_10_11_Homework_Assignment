# optimistic lock and pessimistic lock

**`Optimistic locking`** is a technique for SQL database applications that does not hold row locks between selecting and updating or deleting a row.
The application is written to optimistically assume that unlocked rows are unlikely to change before the update or delete operation. If the row does change, the update or delete will fail and the application logic handles such failures by, for example, retrying the select. One advantage of optimistic locking is improved concurrency, because other applications can read and write that row. In a three tier environment where business transactions have no correlation to database transaction, the optimistic locking technique is used, because locks cannot be maintained across the business transaction.
However, optimistic locking by values has some disadvantages:
- Can result in false positives without additional data server support, a condition when using optimistic locking whereby a row that is changed since it was selected cannot be updated without first being selected again. (This can be contrasted with false negatives, the condition whereby a row that is unchanged since it was selected cannot be updated without first being selected again.)
- Requires more re-try logic in applications
-	It is complicated for applications to build the UPDATE search conditions
-	It is inefficient for the Db2® server to search for the target row based on values
-	Data type mismatches between some client types and database types, for example, timestamps, prevent all columns from being used in the searched update

The support for easier and faster optimistic locking with no false positives has the following new SQL functions, expressions, and features:
-	Row Identifier (RID_BIT or RID) built-in function
-	ROW CHANGE TOKEN expression
-	Time-based update detection
-	Implicitly hidden columns

**`Pessimistic locking`**, as the name implies, uses a less optimistic approach. It assumes that conflicts will occur and it actively blocks anything that could possibly cause a conflict.

When interacting with a relational database, this is done by actively locking database rows or even database tables when you retrieve the data you will operate on. The locks will be held until your transaction completes. 

There are generally two types of locks: shared locks (read locks) and exclusive locks (write locks). Shared locks are used for reading data that you simply need to stay the same until your operation completes. 

A shared lock allows others to take a shared lock as well (you still allow others to read the object as this does not create a conflict). Exclusive locks are used for reading and updating data that you want to change. 

Exclusive locks do not allow anyone else to take a lock on the same data. Any attempts to obtain a lock when it’s not allowed at the time will block until the conflicting locks are released.
