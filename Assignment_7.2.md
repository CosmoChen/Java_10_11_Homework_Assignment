# view vs stored procedure
![image](https://user-images.githubusercontent.com/16676447/168450706-ea2ce906-232b-4fa9-9e09-6bdc00d43c34.png)
Much as its name would suggest, a **`view`** is simply a "window" where you can observe a specific segment of your data. Oftentimes a developer will create a view when they are constantly running a query and want to automate or make their process more simplified.

A **`stored procedure`** is an encapsulation of logic that can be called from an application (or run in SQL Management Studio). They are often used to perform common INSERT, DELETE, and UPDATE statements on data after a parameter has been passed in by an external application. They will often contain various loops, variables, and calls to other stored procedures, tables, and views.

Most simply, a view is used when only a SELECT statement is needed. Views should be used to store commonly-used JOIN queries and specific columns to build virtual tables of an exact set of data we want to see. Stored procedures hold the more complex logic, such as INSERT, DELETE, and UPDATE statements to automate large SQL workflows.

# view vs material view
![1649320602(1)](https://user-images.githubusercontent.com/16676447/162157389-c2c4cf95-0d0b-46bb-b550-1db600639143.jpg)
