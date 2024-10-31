# Data Structures and String Operations Testing

This repository contains implementations and test cases for a Static Array, Dynamic Array, and String Operations in Java. The purpose of these test cases is to validate the functionality and correctness of the implemented classes.

## Table of Contents

- [Project Overview](#project-overview)
- [Getting Started](#getting-started)
- [Static Array](#static-array)
- [Dynamic Array](#dynamic-array)
- [String Operations](#string-operations)
- [Running Tests](#running-tests)
- [License](#license)

## Project Overview

This project includes:

1. **StaticArray**: A static implementation of an array with operations for insertion, deletion, and traversal.
2. **DynamicArray**: A dynamic implementation of an array that automatically resizes as needed, also with insertion, deletion, and traversal operations.
3. **StringOperations**: A set of methods for string manipulation, including concatenation, substring extraction, comparison, and character frequency counting.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven (for dependency management and running tests)
- An IDE like IntelliJ IDEA or Eclipse (optional, but recommended)

### Project Structure


## Static Array

The `StaticArray` class implements a fixed-size array with the following operations:

- **Insertion**: Add an element at a specified index.
- **Deletion**: Remove an element from a specified index.
- **Traversal**: Print all elements in the array.

### Test Cases

- Tests for successful insertion, deletion, and traversal.
- Edge cases for insertion beyond capacity and deletion from an empty array.

## Dynamic Array

The `DynamicArray` class implements a resizable array with similar operations:

- **Insertion**: Adds an element at a specified index and resizes if necessary.
- **Deletion**: Removes an element from a specified index.
- **Traversal**: Prints all elements in the array.

### Test Cases

- Tests for insertion at the end and beyond initial capacity.
- Validates deletion and checks for array resizing.

## String Operations

The `StringOperations` class provides methods for:

- **Concatenation**: Combine two strings.
- **Substring**: Extract a part of a string.
- **Comparison**: Compare two strings lexicographically.
- **Character Frequency**: Count occurrences of each character in a string.

### Test Cases

- Tests for successful concatenation, substring extraction, and string comparison.
- Validates character frequency counting for normal and empty strings.

## Running Tests

To run the test cases, ensure you have Maven installed and follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the project directory:
   ```bash
   cd path/to/data-structures-project
