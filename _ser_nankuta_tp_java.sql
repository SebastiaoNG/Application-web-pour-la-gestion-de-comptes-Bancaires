--creation de la base de donnée
create database GestionCompteBancaire;
-- ouverture de la base de données
use GestionCompteBancaire;

--creation de la table Account

create table Account
(
accountNumber int not null,
solde float,
creationDate date,
constraint pkAccount primary key (accountNumber)
);

--creation de la table Customer
create table Client
(
num int not null,
accountNumber int foreign key references Account(accountnumber),
firstName char(40) not null,
lastName char(40) not null,
birthdate date not null,
solde real,
creationDate date,
constraint pkCustomer primary key (num)

);

--creation de la table currentAccount
create table currentAccount(
id_currentAccount int  not null,
creditCardNumber int  not null,
accountNumber int foreign key references Account(accountnumber),
overdraft real not null,
constraint pkcurrentAccount primary key (id_currentAccount)

);

--creation de la table savingAccount
create table savingAccount
(
id_savingAccount int  not null,
accountNumber int foreign key references Account(accountnumber),
overdraft real not null,
constraint pk_savingtAccount primary key (id_savingAccount)
);

--creation de la table Operation
create table Operation
(
id_operation int  not null,
id_currentAccount int not null  foreign key references currentAccount(id_currentAccount),
id_savingAccount int not null foreign key references savingAccount(id_savingAccount),
operation_date  date not null,
constraint pk_id_opeartion primary key (id_operation)
);


insert into Account values (1, 532, '01-12-2011')
insert into Account values (2, 4353, '01-02-2016')