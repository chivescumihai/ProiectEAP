create schema proiectEAP_spital;

CREATE TABLE proiectEAP_spital.ANGAJATI(
    id INT NOT NULL,
    nume VARCHAR(50) NOT NULL,
    titlu VARCHAR(50) NOT NULL,
    varsta INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE proiectEAP_spital.DOCTORI(
    id INT NOT NULL,
    nume VARCHAR(50) NOT NULL,
    specializare VARCHAR(50) NOT NULL,
    varsta INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE proiectEAP_spital.PACIENTI(
    id INT NOT NULL,
    nume VARCHAR(50) NOT NULL,
    varsta INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE proiectEAP_spital.AFECTIUNI(
    nume VARCHAR(50) NOT NULL,
    primary key(nume)
);

CREATE TABLE proiectEAP_spital.INTER_AFECTIUNI_PACIENTI(
	id_pacient INT NOT NULL,
	nume_afectiune VARCHAR(50) NOT NULL,
    foreign key(id_pacient) references proiectEAP_spital.PACIENTI(id) on delete CASCADE,
    foreign key(nume_afectiune) references proiectEAP_spital.AFECTIUNI(nume) on delete CASCADE,
    primary key(id_pacient, nume_afectiune)
);