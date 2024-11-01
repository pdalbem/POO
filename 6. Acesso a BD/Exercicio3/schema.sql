CREATE TABLE time
(
  idTime integer primary key autoincrement,
  pais text
);

CREATE TABLE partida
(
  idPartida integer primary key autoincrement,
  dataJogo text,
  time1 integer,
  time2 integer,
  placarTime1 integer,
  placarTime2 integer,
  FOREIGN KEY (time1) REFERENCES time (idTime),
  FOREIGN KEY (time2) REFERENCES time (idTime)
);

