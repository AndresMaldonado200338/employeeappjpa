DROP TABLE IF EXISTS employee;

CREATE TABLE
    employee (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(200) NOT NULL,
        email VARCHAR(200) NOT NULL,
        phone VARCHAR(200) NOT NULL
    );

INSERT INTO
    employee (name, email, phone)
VALUES
    (
        'John Doe',
        'johndoe@gmail.com',
        '1234567890'
    );