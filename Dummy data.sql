use questionsdb;
-- Java Questions (IDs 1-10)
-- Java Questions (IDs 1-10)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(1, 'Java', 'Easy', 'System.out.println()', 'console.log()', 'print()', 'echo()', 'Which method is used to print output to the console in Java?', 'System.out.println()'),
(2, 'Java', 'Easy', 'The object is created.', 'The object is destroyed.', 'The object is serialized.', 'The object is copied.', 'What happens during garbage collection in Java?', 'The object is destroyed.'),
(3, 'Java', 'Easy', 'abstract', 'implements', 'interface', 'extends', 'Which keyword is used to prevent a class from being inherited?', 'final'),
(4, 'Java', 'Easy', 'private', 'public', 'protected', 'default', 'Which access modifier is the most restrictive?', 'private'),
(5, 'Java', 'Easy', 'int x = 10', 'Integer x = 10', 'Both are the same', 'Neither is correct', 'Which is a wrapper class declaration in Java?', 'Integer x = 10'),
(6, 'Java', 'Easy', 'JVM', 'JRE', 'JDK', 'JIT', 'Which component is responsible for executing Java byte code?', 'JVM'),
(7, 'Java', 'Easy', '=="', 'equals()', 'isEqual()', 'compareTo()', 'Which method should be used to compare the content of two Strings?', 'equals()'),
(8, 'Java', 'Easy', 'java.lang', 'java.util', 'java.io', 'java.net', 'Which package contains the String class?', 'java.lang'),
(9, 'Java', 'Easy', 'new int[5]', 'int(5)', 'int[] x = new int[5]', 'array x = 5', 'How do you correctly instantiate an array of 5 integers?', 'int[] x = new int[5]'),
(10, 'Java', 'Easy', 'void', 'null', 'int', 'String', 'What is the return type of a constructor in Java?', 'void');

-- HTML Questions (IDs 11-20)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(11, 'HTML', 'Easy', '<a href="url">', '<link url="url">', '<url>', '<href>', 'Which tag is used to create a hyperlink?', '<a href="url">'),
(12, 'HTML', 'Easy', '<input type="checkbox">', '<input type="check">', '<input type="box">', '<checkbox>', 'How do you create a checkbox in HTML?', '<input type="checkbox">'),
(13, 'HTML', 'Easy', '<!DOCTYPE html>', '<!DOCTYPE HTML>', '<!HTML>', '<DOCTYPE html>', 'What is the correct declaration for HTML5?', '<!DOCTYPE html>'),
(14, 'HTML', 'Easy', '<td>', '<th>', '<tr>', '<table>', 'Which tag defines a standard data cell in a table?', '<td>'),
(15, 'HTML', 'Easy', 'href', 'link', 'rel', 'src', 'Which attribute specifies the URL of the page the link goes to?', 'href'),
(16, 'HTML', 'Easy', '<em>', '<i>', '<italic>', '<emp>', 'Which tag is used to define emphasized text?', '<em>'),
(17, 'HTML', 'Easy', 'width', 'size', 'cols', 'rows', 'Which attribute specifies the visible width of a text area?', 'cols'),
(18, 'HTML', 'Easy', 'GET', 'SEND', 'POST', 'SUBMIT', 'Which HTTP method is typically used to retrieve data from a server?', 'GET'),
(19, 'HTML', 'Easy', 'name', 'action', 'method', 'target', 'Which attribute of the <form> element specifies where to send the form data?', 'action'),
(20, 'HTML', 'Easy', '<span>', '<div>', '<section>', '<p>', 'Which is the correct way to specify a block-level element?', '<div>');

-- CSS Questions (IDs 21-30)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(21, 'CSS', 'Easy', 'inline', 'external', 'internal', 'all of the above', 'Which is a valid way to include CSS in an HTML document?', 'all of the above'),
(22, 'CSS', 'Easy', 'margin', 'padding', 'border', 'spacing', 'Which property refers to the space between the element content and the border?', 'padding'),
(23, 'CSS', 'Easy', 'width', 'height', 'max-width', 'min-width', 'Which property is recommended to use for making a layout responsive?', 'max-width'),
(24, 'CSS', 'Easy', 'background-image: url("img.png");', 'bg-img: "img.png";', 'image: url("img.png");', 'background-url: "img.png";', 'How do you add a background image in CSS?', 'background-image: url("img.png");'),
(25, 'CSS', 'Easy', 'text-transform: capitalize;', 'text-style: uppercase;', 'text-decoration: none;', 'text-align: center;', 'Which property makes all text capitalized?', 'text-transform: capitalize;'),
(26, 'CSS', 'Easy', 'h1, h2', 'h1 + h2', 'h1 > h2', 'h1 ~ h2', 'How do you select all h1 and h2 elements?', 'h1, h2'),
(27, 'CSS', 'Easy', 'float: left;', 'align: left;', 'position: left;', 'display: block;', 'Which property is used to move an element to the side?', 'float: left;'),
(28, 'CSS', 'Easy', 'border-radius', 'corner-style', 'border-style', 'border-corner', 'Which CSS property is used to add rounded corners to an element?', 'border-radius'),
(29, 'CSS', 'Easy', 'display: none;', 'visibility: hidden;', 'hidden: true;', 'display: off;', 'Which property hides an element while still taking up space?', 'visibility: hidden;'),
(30, 'CSS', 'Easy', 'px', 'em', '%', 'all of the above', 'Which are relative units in CSS?', 'all of the above');

-- JavaScript Questions (IDs 31-40)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(31, 'JS', 'Easy', 'new Array()', '[]', 'both A and B', 'array.create()', 'What is the preferred way to create an empty array in modern JavaScript?', '[]'),
(32, 'JS', 'Easy', 'function myFunc() {}', 'var myFunc = function() {}', '() => {}', 'all of the above', 'Which syntax is valid for creating a function?', 'all of the above'),
(33, 'JS', 'Easy', 'The scope is local to the function.', 'The scope is global.', 'The scope is block-level.', 'The scope is undefined.', 'What is the scope of a variable declared with var inside a function?', 'The scope is local to the function.'),
(34, 'JS', 'Easy', '2 + "2" = "22"', '2 + "2" = 4', '"2" + 2 = "22"', 'A and C', 'What is the result of 2 + "2" in JavaScript?', '2 + "2" = "22"'),
(35, 'JS', 'Easy', 'for...of', 'for...in', 'forEach', 'for loop', 'Which loop is best used for iterating over the properties of an object?', 'for...in'),
(36, 'JS', 'Easy', 'map()', 'filter()', 'reduce()', 'forEach()', 'Which array method creates a new array by calling a function on every element?', 'map()'),
(37, 'JS', 'Easy', 'string', 'number', 'boolean', 'symbol', 'What is the primitive data type used for large integers in modern JS?', 'bigint'),
(38, 'JS', 'Easy', 'getTime()', 'getYear()', 'getFullYear()', 'getDate()', 'Which method returns the year of a Date object?', 'getFullYear()'),
(39, 'JS', 'Easy', 'delete', 'pop', 'remove', 'splice', 'How do you remove a property from a JavaScript object?', 'delete'),
(40, 'JS', 'Easy', '||', '&&', '??', '!', 'Which logical operator is known as the Nullish Coalescing Operator?', '??');

-- ReactJS Questions (IDs 41-50)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(41, 'ReactJS', 'Easy', 'Props', 'State', 'Context', 'Ref', 'Which term describes data passed from a parent component to a child component?', 'Props'),
(42, 'ReactJS', 'Easy', 'React.Fragment', '<>', '<fragment>', 'A and B', 'What is a shorter syntax for React.Fragment?', '<>'),
(43, 'ReactJS', 'Easy', 'constructor', 'render', 'componentDidMount', 'shouldComponentUpdate', 'Which lifecycle method runs after the component is rendered for the first time?', 'componentDidMount'),
(44, 'ReactJS', 'Easy', 'It is optional.', 'It must be an arrow function.', 'It is called before the component renders.', 'It must return a cleanup function.', 'What must the function passed to useEffect return?', 'It must return a cleanup function.'),
(45, 'ReactJS', 'Easy', 'ReactDOM', 'ReactComponent', 'React.createElement', 'ReactDOM.render', 'Which is the entry point library for the DOM renderer?', 'ReactDOM'),
(46, 'ReactJS', 'Easy', 'A function that takes props and returns JSX.', 'A class that extends Component.', 'Both A and B', 'Neither A nor B', 'What defines a functional component?', 'A function that takes props and returns JSX.'),
(47, 'ReactJS', 'Easy', '()', '[]', '{}', '<>', 'What syntax is used in JSX to include JavaScript variables?', '{}'),
(48, 'ReactJS', 'Easy', 'UseMemo', 'UseEffect', 'UseState', 'UseCallback', 'Which hook is used for memoizing function instances?', 'UseCallback'),
(49, 'ReactJS', 'Easy', 'componentDidUpdate', 'componentWillUnmount', 'render', 'constructor', 'Which method is called right before a component is removed from the DOM?', 'componentWillUnmount'),
(50, 'ReactJS', 'Easy', 'A higher-order function', 'A wrapper element', 'A combination of two components', 'A component with children', 'What does the term "Higher-Order Component" (HOC) refer to?', 'A higher-order function');

-- DSA (Data Structures and Algorithms) Questions (IDs 51-67)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(51, 'DSA', 'Easy', 'LIFO', 'FIFO', 'Random', 'Indexed', 'What principle does a Stack follow?', 'LIFO'),
(52, 'DSA', 'Easy', 'LIFO', 'FIFO', 'Random', 'Indexed', 'What principle does a Queue follow?', 'FIFO'),
(53, 'DSA', 'Easy', 'O(N)', 'O(log N)', 'O(1)', 'O(N^2)', 'What is the best-case time complexity for searching an element in a Hash Table?', 'O(1)'),
(54, 'DSA', 'Easy', 'Graph', 'Linked List', 'Stack', 'Tree', 'Which data structure is best suited for representing hierarchical data?', 'Tree'),
(55, 'DSA', 'Easy', 'O(N^2)', 'O(N log N)', 'O(N)', 'O(log N)', 'What is the average time complexity of Quick Sort?', 'O(N log N)'),
(56, 'DSA', 'Easy', 'Root, Left, Right', 'Left, Root, Right', 'Left, Right, Root', 'Root, Right, Left', 'What is the order of nodes visited in Preorder traversal?', 'Root, Left, Right'),
(57, 'DSA', 'Easy', 'Root, Left, Right', 'Left, Root, Right', 'Left, Right, Root', 'Root, Right, Left', 'What is the order of nodes visited in Postorder traversal?', 'Left, Right, Root'),
(58, 'DSA', 'Easy', 'Stack', 'Array', 'Linked List', 'Queue', 'Which data structure uses sequential memory allocation?', 'Array'),
(59, 'DSA', 'Easy', 'O(N)', 'O(log N)', 'O(N^2)', 'O(1)', 'What is the worst-case time complexity of Bubble Sort?', 'O(N^2)'),
(60, 'DSA', 'Easy', 'ArrayList', 'HashMap', 'HashSet', 'LinkedList', 'Which Java class implements the Dynamic Array concept?', 'ArrayList'),
(61, 'DSA', 'Easy', 'Left > Root > Right', 'Left < Root < Right', 'Root < Left < Right', 'Root > Left > Right', 'Which condition defines a Binary Search Tree (BST)?', 'Left < Root < Right'),
(62, 'DSA', 'Easy', 'Stack', 'Priority Queue', 'Array', 'Queue', 'Breadth-First Search (BFS) typically uses which data structure?', 'Queue'),
(63, 'DSA', 'Easy', 'Stack', 'Queue', 'Heap', 'Array', 'Depth-First Search (DFS) typically uses which data structure?', 'Stack'),
(64, 'DSA', 'Easy', 'O(1)', 'O(N)', 'O(log N)', 'O(N^2)', 'What is the time complexity to insert an element into a full static array?', 'O(N)'),
(65, 'DSA', 'Easy', 'Set of nodes and keys', 'Set of vertices and edges', 'Set of rows and columns', 'Set of head and tail', 'A Graph is formally defined as a:', 'Set of vertices and edges'),
(66, 'DSA', 'Easy', 'Parent node is always a leaf.', 'Parent is always greater or smaller than children.', 'All nodes have two children.', 'It must be a balanced tree.', 'What is the primary property of a Heap data structure?', 'Parent is always greater or smaller than children.'),
(67, 'DSA', 'Easy', 'O(N^2)', 'O(log N)', 'O(N log N)', 'O(N)', 'What is the time complexity of Merge Sort?', 'O(N log N)');

-- SQL (Structured Query Language) Questions (IDs 68-84)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(68, 'SQL', 'Easy', 'WHERE', 'HAVING', 'GROUP BY', 'ORDER BY', 'Which clause is used to filter records after aggregation (GROUP BY)?', 'HAVING'),
(69, 'SQL', 'Easy', 'WHERE', 'HAVING', 'FILTER', 'SELECT', 'Which clause is used to filter individual rows based on a condition?', 'WHERE'),
(70, 'SQL', 'Easy', 'UPDATE TABLE', 'MODIFY TABLE', 'ALTER TABLE', 'CHANGE TABLE', 'Which command is used to change the structure of an existing table?', 'ALTER TABLE'),
(71, 'SQL', 'Easy', 'ADD DATA', 'INSERT INTO', 'NEW ROW', 'POPULATE', 'Which command is used to add new rows of data to a table?', 'INSERT INTO'),
(72, 'SQL', 'Easy', 'DELETE TABLE', 'DROP TABLE', 'REMOVE TABLE', 'TRUNCATE TABLE', 'Which command removes all rows from a table but keeps the table structure?', 'TRUNCATE TABLE'),
(73, 'SQL', 'Easy', 'Primary Key', 'Super Key', 'Composite Key', 'Foreign Key', 'Which type of key links two tables together in a relational database?', 'Foreign Key'),
(74, 'SQL', 'Easy', 'MODIFY', 'ALTER', 'CHANGE', 'UPDATE', 'Which DML command is used to modify existing data in a table?', 'UPDATE'),
(75, 'SQL', 'Easy', 'DELETE', 'REMOVE', 'DROP TABLE', 'TRUNCATE', 'Which command completely removes a table and all its data from the database?', 'DROP TABLE'),
(76, 'SQL', 'Easy', 'SUM', 'COUNT', 'AVG', 'TOTAL', 'Which aggregate function counts the number of non-null values in a column?', 'COUNT'),
(77, 'SQL', 'Easy', 'TOP', 'GREATEST', 'MAX', 'HIGH', 'Which aggregate function is used to find the largest value in a column?', 'MAX'),
(78, 'SQL', 'Easy', 'OUTER JOIN', 'CROSS JOIN', 'INNER JOIN', 'SELF JOIN', 'Which type of JOIN returns only the rows that have matching values in both tables?', 'INNER JOIN'),
(79, 'SQL', 'Easy', 'RIGHT JOIN', 'INNER JOIN', 'LEFT JOIN', 'FULL JOIN', 'Which JOIN returns all rows from the first table and the matched rows from the second table?', 'LEFT JOIN'),
(80, 'SQL', 'Easy', 'Atomicity', 'Consistency', 'Isolation', 'Durability', 'What does the ''A'' stand for in the ACID properties of a transaction?', 'Atomicity'),
(81, 'SQL', 'Easy', 'DML', 'DCL', 'TCL', 'DDL', 'CREATE TABLE and ALTER TABLE belong to which subset of SQL commands?', 'DDL'),
(82, 'SQL', 'Easy', 'SORT BY', 'ARRANGE BY', 'ORDER BY', 'GROUP BY', 'Which clause is used to sort the result set?', 'ORDER BY'),
(83, 'SQL', 'Easy', 'GROUP BY', 'COLLECT BY', 'BUNDLE BY', 'CLUSTER BY', 'Which clause is used to combine rows with the same values into summary rows?', 'GROUP BY'),
(84, 'SQL', 'Easy', 'Primary Key', 'Foreign Key', 'Candidate Key', 'Unique Constraint', 'Which constraint ensures that all values in a column are different (but allows NULL)?', 'Unique Constraint');

-- CN (Computer Networks) Questions (IDs 85-100)
INSERT INTO question (id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer) VALUES
(85, 'CN', 'Easy', 'Data Link Layer', 'Network Layer', 'Transport Layer', 'Application Layer', 'Which OSI layer is primarily responsible for routing data across different networks?', 'Network Layer'),
(86, 'CN', 'Easy', 'UDP', 'IP', 'ICMP', 'TCP', 'Which transport protocol guarantees reliable, ordered data delivery?', 'TCP'),
(87, 'CN', 'Easy', 'TCP', 'HTTP', 'SMTP', 'UDP', 'Which transport protocol is connectionless and fast, but unreliable?', 'UDP'),
(88, 'CN', 'Easy', 'Logical Address', 'Port Number', 'Physical Address', 'Domain Name', 'What is another name for the MAC (Media Access Control) address?', 'Physical Address'),
(89, 'CN', 'Easy', 'Physical Address', 'Logical Address', 'Service Address', 'Port Number', 'What type of address is an IP address?', 'Logical Address'),
(90, 'CN', 'Easy', 'Network Layer', 'Data Link Layer', 'Physical Layer', 'Transport Layer', 'Which OSI layer handles the electrical and mechanical interface to the transmission medium?', 'Physical Layer'),
(91, 'CN', 'Easy', 'Network Layer', 'Data Link Layer', 'Transport Layer', 'Application Layer', 'Which OSI layer is responsible for packet framing and error detection within a single link?', 'Data Link Layer'),
(92, 'CN', 'Easy', '21', '80', '23', '443', 'What is the default port number used by the HTTP protocol?', '80'),
(93, 'CN', 'Easy', '21', '80', '23', '443', 'What is the default port number used by the secure HTTPS protocol?', '443'),
(94, 'CN', 'Easy', 'Dynamic Naming Server', 'Distributed Network Service', 'Domain Name System', 'Data Node System', 'What does DNS stand for in networking?', 'Domain Name System'),
(95, 'CN', 'Easy', 'Repeater', 'Bridge', 'Gateway', 'Switch', 'Which device connects two different networks, often performing protocol translation?', 'Gateway'),
(96, 'CN', 'Easy', 'Bandwidth', 'Throughput', 'Latency', 'Jitter', 'What term describes the delay before a transfer of data begins following an instruction?', 'Latency'),
(97, 'CN', 'Easy', '5', '7', '8', '4', 'How many layers are in the standard OSI model?', '7'),
(98, 'CN', 'Easy', 'Presentation', 'Session', 'Transport', 'Application', 'What is the highest layer (Layer 7) in the OSI model?', 'Application'),
(99, 'CN', 'Easy', 'Antivirus', 'VPN', 'Intrusion Detector', 'Firewall', 'Which network security system monitors and controls incoming/outgoing network traffic?', 'Firewall'),
(100, 'CN', 'Easy', 'Data transfer rate', 'Maximum cable length', 'Signal strength', 'Packet size', 'What does the term "bandwidth" refer to?', 'Data transfer rate');
