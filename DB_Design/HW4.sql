-- Use the 'tax' database
USE Tax;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS SSN;
DROP TABLE IF EXISTS TaxPayer;

-- Create TaxPayer table
CREATE TABLE TaxPayer (
    PayerID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Street VARCHAR(255),
    City VARCHAR(255),
    State VARCHAR(2),
    ZipCode VARCHAR(10),
    Date_Recorded DATETIME
);

-- Create SSN table
CREATE TABLE SSN (
    SSN CHAR(11) PRIMARY KEY,
    Payer_ID INT,
    Date_Recorded DATETIME,
    FOREIGN KEY (Payer_ID) REFERENCES TaxPayer(PayerID)
);

-- Drop existing stored procedures if they exist
DROP PROCEDURE IF EXISTS populateTaxPayer;
DROP PROCEDURE IF EXISTS populateSSN;

-- Create stored procedure to populate the TaxPayer table
DELIMITER //
CREATE PROCEDURE populateTaxPayer()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 50000 DO
        INSERT INTO TaxPayer (PayerID, FirstName, LastName, Street, City, State, ZipCode, Date_Recorded)
        VALUES (i, CONCAT('FirstName', i), CONCAT('LastName', i), CONCAT('Street', i), 'City', 'ST', CONCAT('Zip', i), NOW());
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- Create stored procedure to populate the SSN table
DELIMITER //
CREATE PROCEDURE populateSSN()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 50000 DO
        INSERT INTO SSN (SSN, Payer_ID, Date_Recorded)
        VALUES (LPAD(i, 11, '0'), i, NOW());
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- Call the stored procedures to populate the tables
CALL populateTaxPayer();
CALL populateSSN();

-- Performance of queries without the non-clustered index
-- Before Index Creation
EXPLAIN SELECT * FROM TaxPayer WHERE ZipCode = '02740';

-- Create non-clustered index on FirstName and LastName
CREATE INDEX idx_name ON TaxPayer (FirstName, LastName);

-- Performance of queries with the non-clustered index
-- After Index Creation
EXPLAIN SELECT * FROM TaxPayer WHERE ZipCode = '02740';

-- Drop the created non-clustered index
DROP INDEX idx_name ON TaxPayer;

-- Query Optimization: Comparison of Efficient and Inefficient queries

-- Inefficient Query
SELECT * FROM TaxPayer WHERE ZipCode = '02740';

-- Efficient Query with Non-clustered Index
CREATE INDEX idx_zipcode ON TaxPayer(ZipCode);
SELECT * FROM TaxPayer WHERE ZipCode = '02740';

-- Drop the index created for the efficient query
DROP INDEX idx_zipcode ON TaxPayer;
