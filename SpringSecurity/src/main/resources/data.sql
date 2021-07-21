DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
  id VARCHAR(20) PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  salary REAL NOT NULL,
  designation VARCHAR(250) NOT NULL
);

INSERT INTO Employee(id, username, password, salary, designation) VALUES
  ('101', 'Roy', '$2a$10$MR85UL8uQZMPd.bLHeQceONqdlmln.MszYwKLWSjr1nGc/FF46px2', 40000, 'SDE'),
  ('102', 'James', '$2a$10$MR85UL8uQZMPd.bLHeQceONqdlmln.MszYwKLWSjr1nGc/FF46px2', 60000, 'SDE');