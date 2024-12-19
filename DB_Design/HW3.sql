USE COMPANY;

-- Drop the existing procedure if it exists
DROP PROCEDURE IF EXISTS InsertNewEmployee;

-- Recreate the modified procedure
DELIMITER //

CREATE PROCEDURE InsertNewEmployee(
    IN p_First_Name VARCHAR(15),
    IN p_Last_Name VARCHAR(30),
    IN p_Birth_Date DATE,
    IN p_Home_Address VARCHAR(30),
    IN p_Gender CHAR,
    IN p_Salary DECIMAL(10, 2),
    IN p_Supervisor_SSN CHAR(9),
    IN p_Department_Number INT,
    OUT p_Success BOOLEAN
)
BEGIN
    DECLARE dept_exists INT;
    
    -- Check if the department exists
    SELECT COUNT(*) INTO dept_exists
    FROM DEPARTMENT
    WHERE Department_Number = p_Department_Number;

    IF dept_exists = 0 THEN
        SET p_Success = FALSE;
    ELSE
        INSERT INTO EMPLOYEE (
            First_Name, Last_Name, Birth_Date, Home_Address, Gender, Salary, Supervisor_SSN, Department_Number
        )
        VALUES (
            p_First_Name, p_Last_Name, p_Birth_Date, p_Home_Address, p_Gender, p_Salary, p_Supervisor_SSN, p_Department_Number
        );
        SET p_Success = TRUE;
    END IF;
END //

DELIMITER ;
CALL InsertNewEmployee(
    'Jane', 'Smith', '1990-01-01', '123 Main St', 'F', 55000.00, '123456789', 4, @SuccessFlag
);

-- Check the result
SELECT @SuccessFlag AS InsertionSuccess;