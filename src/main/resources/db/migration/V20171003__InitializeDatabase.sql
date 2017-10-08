CREATE TABLE Users (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    first VARCHAR(255),
    last VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    enabled BIT NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

CREATE TABLE Bills (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price NUMERIC NOT NULL,
    dueDate DATE NOT NULL,
    userId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES Users(id)
);

CREATE TABLE UserBills(
    userId INT NOT NULL,
    billId INT NOT NULL,
    amount DECIMAL(20,5) NOT NULL,
    amountType INT NOT NULL,
    PRIMARY KEY (userId, billId),
    FOREIGN KEY (userId) REFERENCES Users(id),
    FOREIGN KEY (billId) REFERENCES Bills(id)
);