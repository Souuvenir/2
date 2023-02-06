

CREATE TABLE usuarios (
  id int(11) NOT NULL AUTO_INCREMENT,
  usuario varchar(255) DEFAULT NULL,
  contrasenia varchar(255) DEFAULT NULL,
  correo varchar(255) DEFAULT NULL,
  createdAt datetime NOT NULL,
  updatedAt datetime NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;