CREATE TABLE partido
(
   numero integer primary key autoincrement,
   nome text,
   sigla text
 );

CREATE TABLE cargo
(
  idcargo integer primary key autoincrement,
  cargo text
);

CREATE TABLE candidato
(
  numero integer primary key autoincrement,
  nome text,
  partido integer,
  cargo integer,
  foreign key (partido) references partido(numero),
  foreign key (cargo) references cargo(idcargo)
);


