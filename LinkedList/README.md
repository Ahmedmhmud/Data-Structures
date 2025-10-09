# LinkedList Data Structure

A generic singly linked list implementation in Java that provides efficient insertion and deletion operations.

## Overview

This `LinkedList<T>` class is a custom implementation of a singly linked list data structure. It stores elements in nodes, where each node contains data and a reference to the next node in the sequence. The class uses Java generics to support any data type.

## Package

```
com.mycompany.data.structures
```

## Features

- **Generic Implementation**: Works with any object type using Java generics
- **Dynamic Size**: Automatically grows and shrinks as elements are added or removed
- **Flexible Operations**: Supports insertion, deletion, retrieval, and search operations
- **Index-based Access**: Access elements by their position in the list

## Constructor Methods

### `LinkedList()`
Creates an empty linked list.

```java
LinkedList<String> list = new LinkedList<>();
```

### `LinkedList(T data)`
Creates a linked list with a single element.

```java
LinkedList<Integer> list = new LinkedList<>(42);
```

## Core Methods

### Adding Elements

#### `void add(T data, int index)`
Inserts an element at the specified index position. All subsequent elements are shifted forward.

- **Parameters**: 
  - `data`: The element to insert
  - `index`: Position where the element should be inserted (0-based)
- **Throws**: `IndexOutOfBoundsException` if index is invalid

```java
list.add("Hello", 0);  // Insert at beginning
list.add("World", 1);  // Insert at position 1
```

#### `void append(T data)`
Adds an element to the end of the list.

```java
list.append("Last Item");
```

### Accessing Elements

#### `T getItem(int index)`
Retrieves the element at the specified index.

- **Returns**: The element at the given position
- **Throws**: `IndexOutOfBoundsException` if index is invalid

```java
String item = list.getItem(2);
```

#### `void set(T item, int index)`
Replaces the element at the specified index with a new value.

- **Throws**: `IndexOutOfBoundsException` if index is invalid

```java
list.set("Updated", 1);
```

### Removing Elements

#### `void deleteByIndex(int index)`
Removes the element at the specified index position.

- **Throws**: `IndexOutOfBoundsException` if index is invalid

```java
list.deleteByIndex(0);  // Remove first element
```

#### `void deleteByValue(T item)`
Removes all occurrences of the specified element from the list.

```java
list.deleteByValue("Duplicate");  // Removes all instances
```

### Search Operations

#### `int isExist(T item)`
Searches for an element and returns its index.

- **Returns**: Index of the first occurrence, or -1 if not found

```java
int index = list.isExist("Search Term");
```

#### `boolean contains(T item)`
Checks whether the list contains a specific element.

- **Returns**: `true` if found, `false` otherwise

```java
if (list.contains("Item")) {
    // Element exists
}
```

### Utility Methods

#### `int getSize()`
Returns the number of elements in the list.

```java
int count = list.getSize();
```

#### `boolean isEmpty()`
Checks if the list is empty.

```java
if (list.isEmpty()) {
    // List has no elements
}
```

#### `void clear()`
Removes all elements from the list.

```java
list.clear();
```

#### `String toString()`
Returns a string representation of the list.

```java
System.out.println(list);  // Output: List: [1, 2, 3]
```

## Example Usage

```java
// Create a new list
LinkedList<Integer> numbers = new LinkedList<>();

// Add elements
numbers.append(10);
numbers.append(20);
numbers.append(30);
numbers.add(5, 0);  // Insert at beginning

// Access elements
int first = numbers.getItem(0);  // Returns 5

// Search
if (numbers.contains(20)) {
    System.out.println("Found 20!");
}

// Modify
numbers.set(25, 2);

// Remove
numbers.deleteByValue(10);

// Display
System.out.println(numbers);  // List: [5, 20, 25, 30]

// Get size
System.out.println("Size: " + numbers.getSize());
```

## Notes

- The list uses 0-based indexing
- The `deleteByValue()` method removes all occurrences of an element, not just the first one
- Null values are supported as valid elements
- The implementation is not thread-safe
