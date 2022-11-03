CREATE TABLE users (
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE matches (
    id IDENTITY PRIMARY KEY,
    user1 INT NOT NULL,
    user2 INT NOT NULL,
    user1Hand VARCHAR,
    user2Hand VARCHAR,
    isActive BOOLEAN
);

CREATE TABLE matchinfo (
    id IDENTITY PRIMARY KEY,
    user1 INT NOT NULL,
    user2 INT NOT NULL,
    user1Hand VARCHAR,
    isActive BOOLEAN
);
