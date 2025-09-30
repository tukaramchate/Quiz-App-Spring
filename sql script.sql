create database questionsdb;
use questionsdb;

-- Create table for Question model
CREATE TABLE question (
    id SERIAL PRIMARY KEY,
    question_title VARCHAR(255),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    right_answer VARCHAR(255),
    difficultylevel VARCHAR(50),
    category VARCHAR(50)
);
select * from question;
TRUNCATE TABLE question;

select * from quiz;
select * from quiz_questions;


-- Insert sample data
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(1, 'JAVA', 'Easy', 'class', 'interface', 'extends', 'implements', 'Which Java keyword is used to create a subclass?', 'extends'),
(2, 'Java', 'Easy', '4', '5', '6', 'Compile error', 'What is the output of the following Java code snippet?', '5'),
(3, 'Java', 'Easy', 'true', 'false', '0', 'null', 'In Java, what is the default value of an uninitialized boolean variable?', 'false'),
(4, 'Java', 'Easy', 'try', 'throw', 'catch', 'finally', 'Which Java keyword is used to explicitly throw an exception?', 'throw'),
(5, 'Java', 'Easy', 'It indicates that a variable is constant.', 'It indicates that a method can be accessed without creating an instance of the class.', 'It indicates that a class cannot be extended.', 'It indicates that a variable is of primitive type.', 'What does the "static" keyword mean in Java?', 'It indicates that a method can be accessed without creating an instance of the class.'),
(6, 'Java', 'Easy', 'constant int x = 5;', 'final int x = 5;', 'static int x = 5;', 'readonly int x = 5;', 'What is the correct way to declare a constant variable in Java?', 'final int x = 5;'),
(7, 'Java', 'Easy', 'for loop', 'while loop', 'do-while loop', 'switch loop', 'Which loop in Java allows the code to be executed at least once?', 'do-while loop'),
(8, 'Java', 'Easy', 'To terminate a loop or switch statement and transfer control to the next statement.', 'To skip the rest of the code in a loop and move to the next iteration.', 'To define a label for a loop or switch statement.', 'To check a condition and execute a block of code repeatedly.', 'What is the purpose of the "break" statement in Java?', 'To terminate a loop or switch statement and transfer control to the next statement.'),
(9, 'Java', 'Easy', '+', '-', '*', '/', 'Which Java operator is used to concatenate two strings?', '+'),
(10, 'Java', 'Easy', 'HashMap', 'ArrayList', 'LinkedList', 'HashSet', 'In Java, which collection class provides an implementation of a dynamic array?', 'ArrayList'),
(11, 'Python', 'Easy', 'count()', 'size()', 'length()', 'len()', 'Which Python function is used to calculate the length of a list?', 'len()'),
(12, 'Python', 'Easy', '[1, 2, 3]', '[1, 2, 3, 4]', '[4, 3, 2, 1]', 'Error', 'What is the output of the following Python code snippet?', '[1, 2, 3, 4]'),
(13, 'Python', 'Easy', 'break', 'continue', 'pass', 'return', 'Which Python statement is used to exit from a loop prematurely?', 'break'),
(14, 'Python', 'Easy', 'To generate a random number within a given range.', 'To iterate over a sequence of numbers.', 'To sort a list in ascending order.', 'To calculate the length of a string.', 'What is the purpose of the "range()" function in Python?', 'To iterate over a sequence of numbers.'),
(15, 'Python', 'Easy', 'int', 'float', 'str', 'list', 'In Python, which data type is mutable?', 'list'),
(16, 'Python', 'Easy', 'datetime', 'math', 'os', 'sys', 'Which Python module is used for working with dates and times?', 'datetime');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category) VALUES
-- 1
('Which keyword is used to define a class in Java?', 'function', 'define', 'class', 'struct', 'class', 'Easy', 'Java'),
-- 2
('Which SQL statement is used to retrieve data from a database?', 'SELECT', 'GET', 'EXTRACT', 'FETCH', 'SELECT', 'Easy', 'SQL'),
-- 3
('Which of the following is a Java primitive type?', 'String', 'int', 'Integer', 'List', 'int', 'Easy', 'Java'),
-- 4
('Which symbol is used for single-line comments in Java?', '//', '#', '--', '/* */', '//', 'Easy', 'Java'),
-- 5
('What does SQL stand for?', 'Structured Query Language', 'Simple Query Language', 'Sequential Query Language', 'Structured Question Language', 'Structured Query Language', 'Easy', 'SQL'),
-- 6
('Which collection class in Java does not allow duplicates?', 'ArrayList', 'HashSet', 'LinkedList', 'TreeMap', 'HashSet', 'Medium', 'Java'),
-- 7
('Which SQL clause is used to filter records?', 'WHERE', 'FILTER', 'HAVING', 'SORT', 'WHERE', 'Easy', 'SQL'),
-- 8
('In Java, which method is the entry point for execution?', 'start()', 'main()', 'execute()', 'run()', 'main()', 'Easy', 'Java'),
-- 9
('Which of the following is a DDL command in SQL?', 'SELECT', 'INSERT', 'CREATE', 'UPDATE', 'CREATE', 'Medium', 'SQL'),
-- 10
('Which Java keyword is used to inherit a class?', 'super', 'extends', 'this', 'implements', 'extends', 'Easy', 'Java'),
-- 11
('In SQL, which function returns the number of rows?', 'COUNT()', 'SUM()', 'ROWS()', 'TOTAL()', 'COUNT()', 'Easy', 'SQL'),
-- 12
('Which Java package contains the Scanner class?', 'java.io', 'java.lang', 'java.util', 'java.sql', 'java.util', 'Easy', 'Java'),
-- 13
('Which SQL keyword is used to sort the result-set?', 'SORT', 'ORDER BY', 'GROUP BY', 'ARRANGE', 'ORDER BY', 'Easy', 'SQL'),
-- 14
('Which Java interface is implemented to sort objects?', 'Comparable', 'Iterable', 'Serializable', 'Cloneable', 'Comparable', 'Medium', 'Java'),
-- 15
('Which SQL command is used to delete all records but keep the table structure?', 'DELETE', 'REMOVE', 'TRUNCATE', 'DROP', 'TRUNCATE', 'Medium', 'SQL'),
-- 16
('Which Java keyword is used to prevent method overriding?', 'final', 'static', 'const', 'protected', 'final', 'Medium', 'Java'),
-- 17
('In SQL, which join returns only matching rows from both tables?', 'FULL JOIN', 'INNER JOIN', 'LEFT JOIN', 'RIGHT JOIN', 'INNER JOIN', 'Medium', 'SQL'),
-- 18
('Which Java collection guarantees insertion order?', 'HashSet', 'LinkedHashSet', 'TreeSet', 'PriorityQueue', 'LinkedHashSet', 'Medium', 'Java'),
-- 19
('Which SQL aggregate function calculates the average value?', 'SUM()', 'AVG()', 'MEAN()', 'COUNT()', 'AVG()', 'Easy', 'SQL'),
-- 20
('Which keyword is used in Java for implementing an interface?', 'extends', 'implements', 'interface', 'import', 'implements', 'Easy', 'Java');

INSERT INTO question (
    question_title, option1, option2, option3, option4, right_answer, difficultylevel, category
) VALUES
('Which data structure uses LIFO order?', 'Queue', 'Stack', 'Heap', 'Graph', 'Stack', 'Easy', 'DSA'),
('What is the time complexity of binary search in a sorted array?', 'O(n)', 'O(log n)', 'O(n log n)', 'O(1)', 'O(log n)', 'Easy', 'DSA'),
('Which data structure is used in Breadth First Search (BFS)?', 'Stack', 'Queue', 'Priority Queue', 'HashMap', 'Queue', 'Easy', 'DSA'),
('Which traversal visits nodes in the order: Left, Root, Right?', 'Preorder', 'Inorder', 'Postorder', 'Level Order', 'Inorder', 'Easy', 'DSA'),
('What is the space complexity of merge sort?', 'O(1)', 'O(n)', 'O(log n)', 'O(n log n)', 'O(n)', 'Medium', 'DSA'),
('Which data structure is best for implementing recursion?', 'Stack', 'Queue', 'Array', 'Linked List', 'Stack', 'Easy', 'DSA'),
('Which sorting algorithm is the fastest in average case for large datasets?', 'Bubble Sort', 'Quick Sort', 'Insertion Sort', 'Selection Sort', 'Quick Sort', 'Medium', 'DSA'),
('Which data structure is used to implement priority queues?', 'Stack', 'Heap', 'Queue', 'Linked List', 'Heap', 'Medium', 'DSA'),
('Which algorithm is used for finding the shortest path in a weighted graph?', 'DFS', 'BFS', 'Dijkstra''s Algorithm', 'Prim''s Algorithm', 'Dijkstra''s Algorithm', 'Medium', 'DSA'),
('Which traversal is also known as depth-first traversal?', 'BFS', 'DFS', 'Level Order', 'Spiral Order', 'DFS', 'Easy', 'DSA'),
('What is the worst-case time complexity of quicksort?', 'O(n log n)', 'O(n^2)', 'O(log n)', 'O(n)', 'O(n^2)', 'Medium', 'DSA'),
('Which data structure is used for implementing undo operations in text editors?', 'Queue', 'Heap', 'Stack', 'Graph', 'Stack', 'Easy', 'DSA'),
('Which algorithm is used for minimum spanning tree?', 'Kruskal''s Algorithm', 'Dijkstra''s Algorithm', 'Bellman-Ford Algorithm', 'Floyd-Warshall Algorithm', 'Kruskal''s Algorithm', 'Medium', 'DSA'),
('Which data structure is used for implementing BFS in graphs?', 'Stack', 'Queue', 'Priority Queue', 'Set', 'Queue', 'Easy', 'DSA'),
('What is the time complexity of inserting into a binary search tree (average case)?', 'O(1)', 'O(log n)', 'O(n)', 'O(n log n)', 'O(log n)', 'Medium', 'DSA'),
('Which data structure uses FIFO order?', 'Stack', 'Queue', 'Heap', 'Array', 'Queue', 'Easy', 'DSA'),
('Which algorithm is used for finding strongly connected components in a graph?', 'Dijkstra''s Algorithm', 'Tarjan''s Algorithm', 'Kruskal''s Algorithm', 'Prim''s Algorithm', 'Tarjan''s Algorithm', 'Hard', 'DSA'),
('What is the height of a complete binary tree with n nodes?', 'O(log n)', 'O(n)', 'O(n log n)', 'O(1)', 'O(log n)', 'Medium', 'DSA'),
('Which traversal of a binary search tree gives sorted output?', 'Preorder', 'Inorder', 'Postorder', 'Level Order', 'Inorder', 'Easy', 'DSA'),
('Which data structure is used to detect cycles in a graph using DFS?', 'Queue', 'Recursion Stack', 'Heap', 'Linked List', 'Recursion Stack', 'Medium', 'DSA');

