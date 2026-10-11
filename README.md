# Java Development Tasks

These are three independent console programs based on Tasks 1-3 in the attached brief:

1. **NumberGame**: guesses a random number from 1 to 100, gives higher/lower hints, limits guesses, supports replay, and tracks rounds won.
2. **StudentGradeCalculator**: reads five subject marks, validates the 0-100 range, and displays total, average, and a grade.
3. **ATMInterface**: demonstrates balance checks, deposits, withdrawals, and input validation using a separate `BankAccount` class.

## Run a program

Install a JDK, open a terminal in this folder, then compile and run one program at a time:

```text
javac NumberGame.java
java NumberGame

javac StudentGradeCalculator.java
java StudentGradeCalculator

javac ATMInterface.java
java ATMInterface
```

The ATM starts with a sample balance of $1,000. This is an in-memory learning example; it does not connect to a real bank. Grade bands are A >= 90, B >= 80, C >= 70, D >= 60, otherwise F. Adjust these rules if your school or mentor specifies different ones.
