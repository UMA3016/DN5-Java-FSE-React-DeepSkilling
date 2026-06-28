----------------------------------------------------
-- Exercise 1 : Control Structures
----------------------------------------------------

----------------------------------------------------
-- Create Tables
----------------------------------------------------

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER(10,2),
    IsVIP CHAR(1)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    FOREIGN KEY(CustomerID)
    REFERENCES Customers(CustomerID)
);

----------------------------------------------------
-- Insert Sample Data
----------------------------------------------------

INSERT INTO Customers VALUES (1,'Rahul',65,15000,'N');
INSERT INTO Customers VALUES (2,'Anjali',35,8000,'N');
INSERT INTO Customers VALUES (3,'Kiran',70,20000,'N');
INSERT INTO Customers VALUES (4,'Priya',28,5000,'N');

INSERT INTO Loans VALUES (101,1,9.5,SYSDATE+10);
INSERT INTO Loans VALUES (102,2,10,SYSDATE+40);
INSERT INTO Loans VALUES (103,3,8,SYSDATE+20);
INSERT INTO Loans VALUES (104,4,9,SYSDATE+5);

COMMIT;

----------------------------------------------------
-- Scenario 1
-- Apply 1% discount to customers above 60 years
----------------------------------------------------

BEGIN

    FOR cust IN (
        SELECT CustomerID, Age
        FROM Customers
    )
    LOOP

        IF cust.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

END;
/

----------------------------------------------------
-- Verify Scenario 1
----------------------------------------------------

SELECT * FROM Loans;

----------------------------------------------------
-- Scenario 2
-- Set VIP status for balance > 10000
----------------------------------------------------

BEGIN

    FOR cust IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP

        IF cust.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

END;
/

----------------------------------------------------
-- Verify Scenario 2
----------------------------------------------------

SELECT * FROM Customers;

----------------------------------------------------
-- Scenario 3
-- Loan reminders within next 30 days
----------------------------------------------------

SET SERVEROUTPUT ON;

BEGIN

    FOR loan_rec IN (

        SELECT c.CustomerName,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID

        WHERE l.DueDate
        BETWEEN SYSDATE
        AND SYSDATE + 30

    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: '
            || loan_rec.CustomerName
            || ' Loan Due On '
            || TO_CHAR(loan_rec.DueDate,'DD-MON-YYYY')
        );

    END LOOP;

END;
/