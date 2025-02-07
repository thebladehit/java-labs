CREATE TABLE IF NOT EXISTS public.departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.employees (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(10),
    second_name VARCHAR(20),
    position VARCHAR(20),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE IF NOT EXISTS public.tasks (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);


INSERT INTO departments (name, phone) VALUES
('HR', '111111'), ('IT', '222222'), ('Sales', '333333');

INSERT INTO employees (first_name, second_name, position, department_id) VALUES
('Alice', 'Jackson', 'Junior HR', 1), ('Bob', 'Cooper', 'Middle Full-stack', 2), ('Charlie', 'Davidson', 'Senior Pomidor', 3);

INSERT INTO tasks (description, employee_id) VALUES
('Prepare report', 1), ('Fix bugs', 2), ('Call clients', 3);