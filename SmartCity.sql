CREATE TABLE Users (
    user_id NUMBER PRIMARY KEY,
    username VARCHAR2(50) UNIQUE NOT NULL,
    password VARCHAR2(50) NOT NULL,
    email VARCHAR2(100),
    role VARCHAR2(20) -- 'admin', 'tourism', 'business', 'student'
);

CREATE TABLE Hotels (
    hotel_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    address VARCHAR2(255),
    rating NUMBER,
    contact_info VARCHAR2(100)
);

CREATE TABLE Restaurants (
    restaurant_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    address VARCHAR2(255),
    cuisine_type VARCHAR2(50),
    contact_info VARCHAR2(100)
);

CREATE TABLE ShoppingMarts (
    mart_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    address VARCHAR2(255),
    contact_info VARCHAR2(100)
);

CREATE TABLE TouristPlaces (
    place_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    description VARCHAR2(500),
    address VARCHAR2(255),
    contact_info VARCHAR2(100)
);

CREATE TABLE Transportation (
    transport_id NUMBER PRIMARY KEY,
    type VARCHAR2(50),
    details VARCHAR2(255),
    contact_info VARCHAR2(100)
);
