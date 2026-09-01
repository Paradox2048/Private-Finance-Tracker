PERSONAL FINANCE AND BUDGET TRACKER

This is a console-based personal finance tracker built in Java. Add income and expenses, categorise spending, check your balance, and see a full summary — with data saved between sessions.

I built this to get hands-on experience with core Java, finally going beyond the tutorials. Features like; real inheritance and polymorphism, casting, collections, file I/O, and exception handling, all applied to something I could actually use myself as a student managing my own finances.

FEATURES: 
* Add Income — record income with an amount, description, and source
* Add Expense — record expenses with an amount, description, and category (Rent, Food, Transport, Subscriptions, Entertainment, Bills, Other)
* Check Balance — see total income minus total expenses at any time 
* Summary View — total income, total expenses, balance, and a full breakdown of spending by category 
* Persistent Storage — all transactions are saved to a file on exit and automatically reloaded the next time the program runs 
* Input Validation — invalid amounts (zero or negative) and non-numeric menu input are caught and handled gracefully instead of crashing the program

BUILT WITH:
* Java — core language, no external frameworks 
* OOP principles — abstraction, inheritance, and polymorphism (Transaction as an abstract base class, extended by Income and Expense)
* Collections — ArrayList for storing transactions, HashMap for category-based totals 
* File I/O — FileWriter/BufferedReader for saving and loading data between sessions 
* Exception Handling — a custom InvalidAmountException, plus handling for malformed user input

PROJECT STRUCTURE:

├── Main.java              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Entry point, console menu and user input  
├── FinanceManager.java    &nbsp;&nbsp;&nbsp;# Core logic: totals, balance, category breakdown  
├── FileStorage.java       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Saving and loading transactions to/from a file  
├── Transaction.java       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Abstract base class  
├── Income.java            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Extends Transaction  
├── Expense.java           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Extends Transaction  
├── Category.java          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Enum of expense categories  
└── InvalidAmountException.java

HOW TO RUN:
1) Clone this repository 
2) Open the project in any Java IDE
3) Make sure you have JDK 17 or later installed 
4) Run Main.java 
5) Follow the on-screen menu to add income/expenses, check your balance, or view a summary

WHAT I LEARNED: 
* How inheritance and polymorphism work in practice, not just in theory — using an abstract Transaction class to model two genuinely different but related types of data 
* Downcasting and instanceof checks, and why they're needed when working with a collection of a shared parent type 
* Building an accumulator pattern with HashMap.getOrDefault() to group and sum data by category 
* Reading and writing plain text files in Java, and handling the checked exceptions that come with file operations 
* Designing a custom exception class and deciding where validation should actually happen in a program's flow

POSSIBLE FUTURE ADDITIONS:
* Budget limits per category with over-budget warnings 
* A savings goal tracker 
* Export summary reports to CSV 
* Unit tests with JUnit