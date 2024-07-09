# Budget Tracker

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
  - [Adding an Expense](#adding-an-expense)
  - [Viewing Expenses](#viewing-expenses)
  - [Removing an Expense](#removing-an-expense)
  - [Viewing Total Expenses](#viewing-total-expenses)
  - [Clearing All Expenses](#clearing-all-expenses)
- [Code Structure](#code-structure)
- [Why This Approach](#why-this-approach)
- [Conclusion](#conclusion)

## Introduction
Welcome to the **Budget Tracker** project! This repository is designed to help users keep track of their expenses through a simple console-based Java application. 
The primary focus is on three main files: `Expense.java`, `BudgetTracker.java`, and `MoneyThings.java`, which collectively provide a comprehensive expense tracking solution.

![MoneyThings Preview] (MoneyThings.png)

## Features
- **Add Expense**: Record your expenses with a category, description, and amount.
- **View Expenses**: Display a list of all your recorded expenses.
- **Remove Expense**: Remove an expense by specifying its index (the number).
- **View Total Expenses**: Calculate and display the total amount of all your expenses.
- **Clear All Expenses**: Reset the expense tracker by clearing all data including the .txt output.
- **Art Logo**: Displays my custom art logo at the start of the application.

## Prerequisites
- Java Development Kit (JDK) 8 or higher installed on your machine.
- Basic understanding of how to run Java programs from the command line.
- IDE

## Installation
1. Clone this repo:
    ```bash
    git clone https://github.com/PradaFit/BudgetTracker.git
    ```
2. Navigate to the proj directory:
    ```bash
    cd BudgetTracker/src
    ```

## Usage

### Adding an Expense
1. Run the program:
    ```bash
    java MoneyThings
    ```
2. Choose option `1` to add an expense.
3. Enter the category, description, and amount for your expense.

### Viewing Charges
1. Run the program:
    ```bash
    java MoneyThings
    ```
2. Choose option `2` to view all of your expenses.

### Removing an Expense
1. Run the program:
    ```bash
    java MoneyThings
    ```
2. Choose option `3` to remove an expense.
3. Enter the index of the expense to remove.

### Viewing Total Expenses
1. Run the program:
    ```bash
    java MoneyThings
    ```
2. Choose option `4` to view your total expenses.

### Clearing All Expenses
1. Run the program:
    ```bash
    java MoneyThings
    ```
2. Choose option `6` to clear all expenses and restart the application.

## Code Structure
The project is structured into three main files:
- **Expense.java**: Represents an expense with a category, description, and amount.
- **BudgetTracker.java**: Manages the list of expenses, handles adding, removing, viewing, and saving/loading expenses from a file.
- **MoneyThings.java**: The main class that provides the user interface and handles user input.
- **LOGO.txt**: Contains the art logo displayed at the start of the application.

## Why This Approach

### Simplicity
The application is designed to be simple and easy to understand, making it accessible to beginners. 
If you're new to Java, input/output should be one of the first things you learn.

### Speed
By saving expenses to a text file (`expenses.txt`), the application ensures that data is not lost between sessions. 
This provides a practical way to manage expenses over time.

### Scalability
The code is structured into separate classes, each with a clear responsibility:
- `Expense` handles the representation of an expense.
- `BudgetTracker` manages the business logic related to expenses.
- `MoneyThings` handles user interaction.

### Clear and Informative
The application provides clear prompts and feedback to the user, ensuring a smooth and user-friendly experience.

## Conclusion
The Budget Tracker is a practical example of a console-based Java application. It demonstrates basic file I/O, class design, and user interaction in Java. This project is an excellent starting point for learning Java and can be expanded with additional features like categories, reports, and more advanced persistence options.
