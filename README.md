# TODOY

A simple console-based Todo list application built in Java, using a custom singly linked list (built from scratch with a Node class) instead of Java's built-in collections.

## Features
- Add a task
- View all tasks
- Mark a task as complete
- Edit a task's description
- Delete a task

## How it works
Tasks are stored as `Task` objects, each wrapped in a `Node`. The app manually manages the linked list — traversing, inserting, and removing nodes by hand rather than relying on `ArrayList` or `LinkedList`.

## How to run
1. Clone this repo
2. Compile: `javac Task.java Node.java TodoApp.java`
3. Run: `java TodoApp`

## Built with
- Java
- Custom singly linked list implementation
