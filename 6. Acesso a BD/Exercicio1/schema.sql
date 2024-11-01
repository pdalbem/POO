CREATE TABLE departamento
(
 id integer primary key autoincrement, 
 nome TEXT, 
 sigla TEXT
 );


CREATE TABLE funcionario
(
 id integer primary key autoincrement,
 cpf text,
 nome text,
 departamento integer,
 foreign key (departamento) references departamento (id)
);

