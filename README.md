# Internship Projects – Java Applications

This repository contains the implementation of four Java-based mini projects completed as part of my internship. Each task demonstrates core object-oriented programming concepts, user input handling, and logic building.

## Table of Contents

1. Number Game  
2. Student Grade Calculator  
3. ATM Interface  
4. Currency Converter  

---

## 1. Number Game

### Description  
A console-based game where the user guesses a randomly generated number. The program gives hints and continues until the correct number is guessed.

### Features  
- Random number generation  
- Loop for continuous guessing  
- Hint messages (too high / too low)  
- Optional: Score tracking or retry count  

### Technologies  
- Java (basic syntax, Scanner class, Random class)

---

## 2. Student Grade Calculator

### Description  
A program that accepts marks from a user and calculates the total, average, and grade based on predefined logic.

### Features  
- User input for marks  
- Total and average calculation  
- Grade assignment based on average  

### Technologies  
- Java (Scanner class, arrays, conditional statements)

---

## 3. ATM Interface

### Description  
Simulates the functionality of a basic ATM system, allowing users to interact with their bank account.

### Features  
- PIN login (predefined or hardcoded)  
- Balance inquiry  
- Deposit amount  
- Withdraw amount  

### Technologies  
- Java (Scanner class, loops, class methods)

---

## 4. Currency Converter

### Description  
Converts currency from one type to another using real-time exchange rates fetched from an online API.

### Features  
- Input for base and target currencies  
- Input amount to convert  
- Fetch conversion rate from [Frankfurter API](https://www.frankfurter.app)  
- Display converted result  

### Technologies  
- Java  
- HttpURLConnection for API calls  
- JSON parsing using `org.json`  
- External JAR support required (`json-20230227.jar` or similar)

---

## How to Run

Make sure Java is installed (JDK 8 or later).

### For standard programs:
```bash
javac FileName.java
java FileName
