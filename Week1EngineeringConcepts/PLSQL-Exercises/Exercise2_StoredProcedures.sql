----------------------------------------------------
-- Exercise 3 : Stored Procedures
----------------------------------------------------

----------------------------------------------------
-- Create Accounts Table
----------------------------------------------------

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    AccountType VARCHAR2(20),
    Balance NUMBER(12,2)
);

----------------------------------------------------
-- Create Employees Table
----------------------------------------------------

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER(10,2)
);
----------------------------------------------------
-- Insert Sample Data
----------------------------------------------------

INSERT INTO Accounts VALUES (101,'Rahul','Savings',50000);
INSERT INTO Accounts VALUES (102,'Anjali','Savings',30000);
INSERT INTO Accounts VALUES (103,'Kiran','Current',45000);
INSERT INTO Accounts VALUES (104,'Priya','Savings',25000);

INSERT INTO Employees VALUES (1,'Amit','HR',40000);
INSERT INTO Employees VALUES (2,'Sneha','IT',60000);
INSERT INTO Employees VALUES (3,'Ravi','IT',55000);
INSERT INTO Employees VALUES (4,'Meena','Finance',50000);

COMMIT;
----------------------------------------------------
-- Scenario 1
-- Process Monthly Interest
----------------------------------------------------

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType='Savings';

    COMMIT;

END;
/
----------------------------------------------------
-- Scenario 2
-- Update Employee Bonus
----------------------------------------------------

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(

    p_department VARCHAR2,
    p_bonus NUMBER

)

IS

BEGIN

    UPDATE Employees

    SET Salary = Salary + (Salary*p_bonus/100)

    WHERE Department = p_department;

    COMMIT;

END;
/
----------------------------------------------------
-- Scenario 3
-- Transfer Funds
----------------------------------------------------

CREATE OR REPLACE PROCEDURE TransferFunds(

    p_from NUMBER,
    p_to NUMBER,
    p_amount NUMBER

)

IS

    v_balance NUMBER;

BEGIN

    SELECT Balance

    INTO v_balance

    FROM Accounts

    WHERE AccountID=p_from;

    IF v_balance >= p_amount THEN

        UPDATE Accounts

        SET Balance=Balance-p_amount

        WHERE AccountID=p_from;

        UPDATE Accounts

        SET Balance=Balance+p_amount

        WHERE AccountID=p_to;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

    END IF;

END;
/