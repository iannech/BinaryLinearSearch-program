#BinaryLinearSearch-program
Search Mysql database with Binary search and linear search in java 

#What exactly?
The program compares the running time of the two algorithms on a data set of 500 entries.

##Linear Search
The Linear Search sequentially moves through the data collection until the element being searched is found. In short, if there are N items on the list, then the worst case scenario to find an item is N iterations. This is known as O(N) using the Big O Notation.

##Binary Search
Binary Search on the other hand relies on a divide and conquer strategy to find a value within an already sorted collection. It also depends on iterations in which after each iteration, half of the remaining possibilities are eliminated. This makes Binary search very efficient-even for large collection. Binary search has a O(log n) complexity.

##Hypothesis
 The Linear Search algorithm is faster on a small database of users but as the Database grows to hold more users, Binary search becomes faster.

##Test Design
To test the comparison between binary search and linear search algorithm, a database of users is used. Both search algorithms are applied to the database.

##Procedure
-	An address book database with 500 entries was created in MYSQL and hosted on a local XAMMP server. 
-	A JDBC application was then created to connect to and access the data stored in the database.
-	The Linear search and Binary search algorithms were then used to search for various users in the database and the time taken by each recorded. 
-	Time was measured in nanoseconds for clearer comparisons.
