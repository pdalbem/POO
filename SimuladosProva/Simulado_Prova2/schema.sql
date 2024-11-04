CREATE TABLE especialidade
(
 id integer primary key autoincrement, 
 descricao text
);

CREATE TABLE medico
(
 id integer primary key autoincrement, 
 nome text, 
 numCRM text, 
 especialidade int, 
 foreign key (especialidade) references especialidade(id)
);

CREATE TABLE paciente
(
 id integer primary key autoincrement, 
 nome text, 
 telefone text
);

CREATE TABLE consulta
(
 id integer primary key autoincrement, 
 data text, 
 hora text, 
 paciente int, 
 medico int, 
 foreign key(paciente) references paciente(id), 
 foreign key(medico) references medico(id)
);



