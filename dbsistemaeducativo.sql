DROP DATABASE dbsistemaeducativo;
CREATE DATABASE dbsistemaeducativo;
USE dbsistemaeducativo;

/*-------- TABLAS --------*/
CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    correo VARCHAR(50),
    clave VARCHAR(100),
    estado BIT DEFAULT 1,
    fecha_registro DATETIME DEFAULT NOW()    
);

CREATE TABLE carrera(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_carrera VARCHAR(50)
);

CREATE TABLE categoria(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_categoria VARCHAR(1)
);


CREATE TABLE semestre(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_semestre VARCHAR(3)
);

CREATE TABLE alumno(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(50),
    correo VARCHAR(50),
    carrera_id INT,
    categoria_id INT,
    semestre_id INT,
    estado BIT DEFAULT 1,
    fecha_registro DATETIME DEFAULT NOW(),
    FOREIGN KEY (carrera_id) REFERENCES carrera(id),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    FOREIGN KEY (semestre_id) REFERENCES semestre(id)
);

CREATE TABLE notas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    alumno_id INT,
    semestre_id INT,
    promedio INT,
    
    FOREIGN KEY (alumno_id) REFERENCES alumno(id),
    FOREIGN KEY (semestre_id) REFERENCES semestre(id)
);
ALTER TABLE notas MODIFY COLUMN promedio DOUBLE DEFAULT 0.0;
ALTER TABLE notas ADD COLUMN finalizado BIT DEFAULT 0;


/*-------- INSERTS --------*/
INSERT INTO usuario(nombre, correo, clave) VALUES
('Admin', '1547896@cesal.pe','123');


INSERT INTO notas (alumno_id, semestre_id, promedio) VALUES 
(8, 4, 14.0),
(8, 3, 14),
(8, 2, 15),
(8, 1, 16),
(6, 3, 17);

INSERT INTO categoria(nombre_categoria) VALUES
('A'),
('B'),
('C'),
('D');

INSERT INTO carrera(nombre_carrera) VALUES
('Desarrollo de Software'),
('Administracion de Empresas'),
('Ingenieria Industrial'),
('Obstetricia'),
('Arquitectura'),
('Electronica');

INSERT INTO semestre(nombre_semestre) VALUES
('I'),
('II'),
('III'),
('IV'),
('V'),
('VI');

INSERT INTO alumno(nombres, correo, carrera_id, categoria_id, semestre_id) VALUES
('Martin Izaguirre', '13985543@cesal.pe', 1, 2, 4),
('José Vargas', '8754213@cesal.pe', 1, 2, 4),
('Pedro Mendoza', '9615445@cesal.pe', 1, 2, 5),
('Manuel Montoya', '1398339@cesal.pe', 2, 1, 2),
('Marco Piccazo', '1394118@cesal.pe', 1, 2, 5);

UPDATE alumno SET estado = 0 WHERE nombres = 'Pedro Mendoza';
-- SET SQL_SAFE_UPDATES = 0;

/*-------- SELECTS --------*/	

SELECT * FROM usuario;
SELECT * FROM alumno;
SELECT * FROM categoria;
SELECT * FROM semestre;
SELECT * FROM carrera;
SELECT * FROM notas;

SELECT alumno.id, alumno.nombres, alumno.correo, carrera.nombre_carrera AS carrera, categoria.nombre_categoria AS categoria, semestre.nombre_semestre AS semestre, alumno.estado
FROM alumno
LEFT JOIN carrera ON alumno.carrera_id = carrera.id
LEFT JOIN categoria ON alumno.categoria_id = categoria.id
LEFT JOIN semestre ON alumno.semestre_id = semestre.id;

SELECT * FROM notas WHERE alumno_id = 6
