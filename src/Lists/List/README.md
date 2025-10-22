# List Data Structure

A generic dynamic array (ArrayList) implementation in Java that provides fast random access and automatic capacity management.

## Overview

This `List<T>` class is a custom implementation of a dynamic array data structure. It stores elements in a contiguous array that automatically expands when full. The class uses Java generics to support any data type and provides O(1) random access to elements.

## Features

- **Generic Implementation**: Works with any object type using Java generics
- **Dynamic Capacity**: Automatically doubles in size when full (similar to C++ vectors)
- **Fast Random Access**: O(1) time complexity for indexed access
- **Flexible Operations**: Supports insertion, deletion, retrieval, and search operations
- **Capacity Management**: Efficient memory usage with automatic expansion

## Constructor Methods

### `List()`
Creates an empty list with default capacity of 10 elements.

```java
List<String> list = new List<>();
```

### `List(int capacity)`
Creates an empty list with a specified initial capacity.

```java
List<Integer> list = new List<>(50);  // Start with capacity for 50 elements
```

## Core Methods

### Adding Elements

#### `void add(T item, int index)`
Inserts an element at the specified index position. All subsequent elements are shifted forward. Automatically expands capacity if needed.

- **Parameters**: 
  - `item`: The element to insert
  - `index`: Position where the element should be inserted (0-based)
- **Throws**: `IndexOutOfBoundsException` if index is invalid

```java
list.add("Hello", 0);  // Insert at beginning
list.add("World", 1);  // Insert at position 1
```

#### `void append(T item)`
Adds an element to the end of the list. Automatically expands capacity if needed.

```java
list.append("Last Item");
```

### Accessing Elements

#### `T getItem(int index)`
Retrieves the element at the specified index with O(1) time complexity.

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
Removes the element at the specified index position. All subsequent elements are shifted backward.

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

### Capacity and Size Methods

#### `int getSize()`
Returns the number of elements currently stored in the list.

```java
int count = list.getSize();
```

#### `int getCapacity()`
Returns the current capacity (total number of elements the list can hold without expansion).

```java
int cap = list.getCapacity();
```

#### `boolean isEmpty()`
Checks if the list contains no elements.

```java
if (list.isEmpty()) {
    // List has no elements
}
```

#### `boolean isFull()`
Checks if the list has reached its current capacity.

```java
if (list.isFull()) {
    // Next insertion will trigger expansion
}
```

### Utility Methods

#### `String toString()`
Returns a string representation of the list showing all elements.

```java
System.out.println(list);  // Output: List: [1, 2, 3]
```

## Example Usage

```java
// Create a new list with default capacity
List<Integer> numbers = new List<>();

// Add elements
numbers.append(10);
numbers.append(20);
numbers.append(30);
numbers.add(5, 0);  // Insert at beginning

// Access elements (fast O(1) access)
int first = numbers.getItem(0);  // Returns 5

// Check capacity and size
System.out.println("Size: " + numbers.getSize());        // 4
System.out.println("Capacity: " + numbers.getCapacity()); // 10

// Search
if (numbers.contains(20)) {
    System.out.println("Found 20 at index: " + numbers.isExist(20));
}

// Modify
numbers.set(25, 2);

// Remove
numbers.deleteByValue(10);

// Display
System.out.println(numbers);  // List: [5, 20, 25, 30]
```

## Capacity Expansion

The list automatically doubles its capacity when full, similar to C++ vectors:

```java
List<String> list = new List<>(2);  // Initial capacity: 2
list.append("A");  // Size: 1, Capacity: 2
list.append("B");  // Size: 2, Capacity: 2 (full)
list.append("C");  // Size: 3, Capacity: 4 (expanded!)
list.append("D");  // Size: 4, Capacity: 4 (full)
list.append("E");  // Size: 5, Capacity: 8 (expanded!)
```

## Notes

- The list uses 0-based indexing
- Initial default capacity is 10 elements
- Capacity doubles each time expansion is needed
- The `deleteByValue()` method removes all occurrences, not just the first one
- Null values are supported as valid elements
- The underlying array uses `Object[]` with generic casting
