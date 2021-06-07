-- creado registro articulo

create database umg
go
use umg
go
ALTER DATABASE umg SET READ_COMMITTED_SNAPSHOT ON
go
ALTER DATABASE umg SET ALLOW_SNAPSHOT_ISOLATION ON
go

-- ************************************** [Autor] 
CREATE TABLE [Autor] 
( 
 [autor_id]       int NOT NULL IDENTITY(1,1), 
 [autor_nombre]   varchar(20) NOT NULL , 
 [autor_apellido] varchar(20) NOT NULL , 
 CONSTRAINT [PK_autor] PRIMARY KEY CLUSTERED ([autor_id] ASC) 
); 
GO 
 
-- ************************************** [Biblioteca] 
-- ************************************** [Biblioteca] 
CREATE TABLE [Biblioteca] 
( 
 [biblio_id]        int NOT NULL  IDENTITY(1,1), 
 [biblio_nombre]    varchar(50) NOT NULL , 
 [direccion]        varchar(50) NOT NULL , 
 [telefono]         int NOT NULL , 
 [nombre_encargado] varchar(50) NOT NULL , 
 
 
 CONSTRAINT [PK_biblioteca] PRIMARY KEY CLUSTERED ([biblio_id] ASC) 
); 
GO 
 



-- ************************************** [Tipo_articulo] 
CREATE TABLE [Tipo_articulo] 
( 
 [tipo_arti_id] int NOT NULL  IDENTITY(1,1), 
 [tipo_arti]    varchar(50) NOT NULL , 
 CONSTRAINT [PK_tipo_articulo] PRIMARY KEY CLUSTERED ([tipo_arti_id] ASC) 
); 
GO






-- ************************************** [Articulo] 
CREATE TABLE [Articulo] 
( 
 [articulo_id]  int NOT NULL  IDENTITY(1,1), 
 [tipo_arti_id] int NOT NULL , 
 [arti_nombre]  varchar(50) NOT NULL , 
 [fecha_public] varchar(11) NOT NULL , 
 [ISBM]         int NOT NULL , 
 [costo]        float NOT NULL , 
 [biblio_id]    int NOT NULL , 
 
 
 CONSTRAINT [PK_articulo] PRIMARY KEY CLUSTERED ([articulo_id] ASC), 
 CONSTRAINT [bib_id] FOREIGN KEY ([biblio_id])     REFERENCES [Biblioteca]([biblio_id]), 
 CONSTRAINT [tip_id] FOREIGN KEY ([tipo_arti_id])  REFERENCES [Tipo_Articulo]([tipo_arti_id])
 
); 
go 
 

-- ************************************** [Creado] 
CREATE TABLE [Creado] 
( 
 [articulo_id] int NOT NULL , 
 [autor_id]    int NOT NULL , 
 
 
 CONSTRAINT [PK_creado] PRIMARY KEY CLUSTERED ([articulo_id] ASC, [autor_id] ASC), 
 CONSTRAINT [FK_arti_id] FOREIGN KEY ([articulo_id])  REFERENCES [Articulo]([articulo_id]), 
 CONSTRAINT FK_creadoAutor FOREIGN KEY (autor_id)  REFERENCES Autor(autor_id) 
); 
GO 
 
--CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID)    REFERENCES Persons(PersonID) 
 
 
-- ************************************** [Direccion_miembro] 
CREATE TABLE [Direccion_miembro] 
( 
 [numero_casa]    int NOT NULL  IDENTITY(1,1), 
 [numero_calle]   int NOT NULL , 
 [barrio_colonia] varchar(50) NOT NULL , 
 [zona]           int NOT NULL , 
 [codigo_postal]  int NOT NULL , 
 [municipio]      varchar(50) NOT NULL , 
 [departamento]   varchar(50) NOT NULL , 
 
 CONSTRAINT [PK_direccion_miembro] PRIMARY KEY CLUSTERED ([numero_casa] ASC) 
); 
GO 
 
-- ************************************** [Miembro] 
CREATE TABLE [Miembro] 
( 
 [miembro_id]        int NOT NULL  IDENTITY(1,1), 
 [miembro_nom]       varchar(50) NOT NULL , 
 [no_identificacion] int NOT NULL , 
 [miembro_tel]       int NOT NULL , 
 [contrasenha]       varchar(50) NOT NULL, 
 [fecha_nacimiento]  varchar(11) NOT NULL , 
 [miembro_email]     varchar(50) NOT NULL , 
 [genero]            varchar(1) NOT NULL , 
 [numero_casa]       int NOT NULL , 
 
 
 CONSTRAINT [PK_miembro] PRIMARY KEY CLUSTERED ([miembro_id] ASC), 
 CONSTRAINT FK_miembroDireccion FOREIGN KEY ([numero_casa])  REFERENCES [Direccion_miembro]([numero_casa]) 
); 
GO 
 
 
 
-- ************************************** [Registro] 
--print(registros T->registro)
CREATE TABLE [Registro] 
( 
 [registro_id]    int NOT NULL  IDENTITY(1,1), 
 [articulo_id]    int NOT NULL ,  --muchos a muchos PK
 [miembro_id]     int NOT NULL ,  --muchos a muchos PK
 [fecha_alquiler] varchar(11)  NULL , 
 [fecha_retorno]  varchar(11)  NULL , 
 [fecha_reserva]  varchar(11)  NULL , 
 [Mora]           float NULL , 
 
 
 CONSTRAINT [PK_reserva] PRIMARY KEY CLUSTERED ([registro_id] ASC), 
 CONSTRAINT FK_registroMiembro FOREIGN KEY ([miembro_id])  REFERENCES [Miembro]([miembro_id]), 
 CONSTRAINT FK_registroArticulo FOREIGN KEY ([articulo_id])  REFERENCES [Articulo]([articulo_id]) 
); 
GO 
 
--jorge alvarado
--insBiblioteca
INSERT INTO Biblioteca VALUES 
('Leonardo da Vinci', 'cuidad capital',12345678, 'Roy Vasquez'), 
('Miguel Angel', 'cuidad capital',55667788, 'Carmen Lara'), 
('Artemisia Gentileschi', 'Antigua Guatemala',12344321, 'Dobby Alvarez'), 
('Rembrandt', 'Mixco',22331155, 'Benito Bran'), 
('JMW Turner', 'Xela',5234341, 'Sabdy Cardona'), 
('Vincent van Gogh', 'Antigua Guatemala',32516673, 'Grecia Garcia'), 
('Paul Cezanne', 'cuidad capital',54339868, 'Valeria Cermeño'), 
('Claude Monet', 'Mixco',56123455, 'David Rodas'), 
('Mary Cassatt ', 'cuidad capital',59596365, 'Carlos Lopez'), 
('Tamara de Lempicka ', 'Xela',87651234, 'Rodrigo Menendez'), 
('Pablo Picasso', 'cuidad capital',65647889, 'Humberto Cardona'), 
('Frida Kahlo', 'Antigua Guatemala',59914556, 'Roberto Morales'), 
('Georgia OKeeffe', 'Mixco',23314145, 'Sebastian Castro'), 
('Jackson Pollock', 'cuidad capital',69931225, 'Regina Sierra'), 
('Edgar Degas', 'Xela',54369961, 'Emilio Echeverria') 
 
--insAutor
INSERT INTO Autor VALUES  
('Franciso', 'Gutierrez'), 
('Lorena', 'Mendoza'), 
('Margarita', 'Quezada'), 
('Manuel', 'Valenzuela'), 
('Jessica', 'Hernandez'), 
('Mauricio', 'Bonilla'), 
('Maria', 'Gomez'), 
('Angela', 'Molina'), 
('Flor', 'Caceres'), 
('Rosa', 'Martinez'), 
('Vanesa', 'Lopez'), 
('Liliana', 'Mota'), 
('Carme', 'Salinas'), 
('Miguel', 'Jackson'), 
('Cristian', 'Evans') 
 
--insTipoarticulo
INSERT INTO Tipo_articulo (tipo_arti) VALUES 
('LIBRO'), 
('VIDEO'), 
('CINTA DE AUDIO'), 
('DISCOS'), 
('REVISTA'), 
('CAFE'), 
('TE'), 
('STICKER'), 
('LAPICERO'), 
('LAPIZ'), 
('SEPARADOR'),
('POSTER'), 
('Pegatina'), 
('CD/DVD/USB'), 
('OTROS') 
 
--insArticulo
INSERT INTO Articulo (tipo_arti_id, arti_nombre, fecha_public, ISBM, costo, biblio_id) VALUES  
(1, 'El unicornio',          '12/11/1998', 234, 15.05,    1), 
(2, 'El campamento',         '04/10/2012', 124, 25.75,    2), 
(3, 'El llanto',             '02/01/1992', 323, 45.35,    3), 
(4, 'La revolucion',         '07/01/2002', 151, 37.99,    4), 
(5, 'La tragedia',           '12/11/1978', 534, 56.53,    5), 
(6, 'El despertar',          '09/14/2020', 551, 10.25,    6), 
(7, 'El unico',              '12/11/1945', 455, 42.99,    7), 
(8, 'La Granja',             '11/12/1963', 551, 15.55,    8), 
(9, 'La Naturaleza',         '06/22/2004', 336, 100.05,   9), 
(10, 'El planeta Tierra',    '05/25/2020', 534, 73.34,  10), 
(11, 'La Anatomia',          '01/01/2021', 754, 150.05, 11), 
(12, 'Programacion Java',    '09/07/2020', 174, 120.67, 12), 
(13, 'Historia de la Red',   '12/24/2019', 644, 75.75,  13), 
(14, 'La Guerra',            '10/15/2005', 761, 19.05,  14), 
(15, 'EL sistema Solar',     '06/08/1999', 545, 35.00,  15)

 
-- abner
--INSERT TABLA Direccion_miembro 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(3,'Jardines',13,1023,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(10,'La Chacara',11,1004,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(10,'San Rafael 1',19,1006,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(3,'El naranjo',13,1011,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(2,'Canalitos',6,1016,'Mixco','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(10,'Limonada',7,1014,'Guastatoya','Progreso'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(3,'Naranjada',17,1009,'Villa Nueva','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(6,'Mexico City',14,1023,'CDM','Mexico City'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(4,'Cayala',14,1018,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(7,'Gerona',8,1016,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(5,'Vista Linda',3,1006,'Mixco','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(10,'Pavon',8,1001,'Palin','Escuintla'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(2,'Saranate',16,1008,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(10,'CR7',3,1020,'Guatemala','Guatemala'); 
INSERT INTO Direccion_miembro([numero_calle],[barrio_colonia],[zona],[codigo_postal],[municipio],[departamento])  VALUES(3,'La palmita',13,1002,'Guatemala','Guatemala'); 

--INSERT TABLA MIEMBRO 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Jermaine Hull',    36,20,'05/12/1988','non@magnisdis.org',                  'F',1,'LLR40KQA2BJ'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Glenna Cameron',   37,21,'07/07/1991','nec.diam@volutpatNullafacilisis.net','F',2,'EZX59DAT4AJ'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Rudyard Bright',   38,22,'10/17/1996','mus@anteMaecenas.edu',               'M',3,'EXX67MKH4AM'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Paki Mccray',      39,23,'12/14/1995','vel.arcu.eu@elementum.co.uk',        'M',4,'ETW09YBT3GO'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Quyn Jones',       40,24,'09/24/1991','egestas@quisturpis.edu',             'M',5,'JBU58PQC1HU'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Jaquelyn King',    41,25,'08/02/1983','lectus.Cum.sociis@velconvallisin.ca','F',6,'OKD32DSD1EN'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Orson Frank',      42,26,'04/14/1995','ac.mattis@feugiat.edu',              'M',7,'ZNV66MAE6LO'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Xantha Chase',     43,27,'10/22/1984','vestibulum.massa@mi.edu',            'F',8,'NED85SFT3XP'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Barry Russell',    44,28,'10/24/1998','magna@pharetra.ca',                  'M',9,'IKS70WFS9SG'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Imogene Noel',     45,29,'07/15/1983','pede@diamSed.edu',                   'M',10,'YCH04RBK7WI'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Uma Drake',        46,30,'05/25/1994','Phasellus.at.augue@sed.net',         'F',11,'RSK02YTI9VR'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Sydney Dunn',      47,31,'02/04/1999','Proin.eget@velesttempor.edu',        'F',12,'IOB83IXL8MF'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Patrick Guerra',   48,32,'04/30/1991','ridiculus.mus@tincidunt.org',        'M',13,'LJS38LDL8KD'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Avye Haynes',      49,33,'04/17/1983','nisi@mi.edu',                        'F',14,'RDN40ZNY5QE'); 
INSERT INTO Miembro([miembro_nom],[no_identificacion],[miembro_tel],[fecha_nacimiento],[miembro_email],[genero],[numero_casa],[contrasenha])  VALUES('Richard Kirby',    50,34,'10/27/1995','pellentesque@Morbi.net',             'M',15,'VTB03TVX1IU'); 
 


---insRegistro 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(1,1,     '02/17/2020','03/20/2020','02/01/2020',67.30); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(2,2,     '12/21/2017','02/20/2018','11/22/2017',74.59); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(3,3,     '10/06/2019','01/20/2020','09/31/2019',457); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(4,4,     '08/09/2019','11/08/2019','07/09/2019',98.8); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(5,5,     '06/16/2020','10/04/2020','03/22/2020',591.2); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(6,6,     '01/10/2020','11/18/2020','01/02/2020',833.7); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(7,7,     '01/16/2021','03/25/2021','01/01/2021',468.2); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(8,8,     '02/04/2016','06/29/2016','01/17/2016',139.9); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(9,9,     '03/25/2021','07/05/2021','02/30/2021',709.1); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(10,10,   '03/05/2020','05/05/2020','02/08/2020',614.3); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(11,11,   '05/16/2020','07/16/2020','04/25/2020',358); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(12,12,   '03/19/2020','06/12/2020','02/02/2020',340.2); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(13,13,   '04/14/2018','12/30/2018','03/18/2018',939.5); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(14,14,   '09/05/2015','02/08/2016','06/23/2015',347.0); 
INSERT INTO Registro([articulo_id],[miembro_id],[fecha_alquiler],[fecha_retorno],[fecha_reserva],[Mora])  VALUES(15,15,   '03/12/2017','10/09/2017','03/09/2017',675.6); 
 
--insCreado 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(1,1); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(2,2); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(3,3); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(4,4); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(5,5); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(6,6); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(7,7); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(8,8); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(9,9); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(10,10); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(11,11); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(12,12); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(13,13); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(14,14); 
INSERT INTO Creado([articulo_id],[autor_id]) VALUES(15,15); 


