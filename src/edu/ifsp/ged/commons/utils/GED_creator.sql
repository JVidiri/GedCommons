--data from fazenda and sintegra foreign systems
CREATE TABLE "sintegraData"(
    "sintegraId" SERIAL primary key,
    "companyNamevarchar" varchar NOT NULL,
    "companyNameFictitious" varchar NOT NULL,
    "street" varchar NOT NULL,
    "CEP" varchar NOT NULL,
    "adressNumber" varchar NOT NULL,
    "adressComplement" varchar NOT NULL,
    "district" varchar NOT NULL,
    "town" varchar NOT NULL,
    "UF" varchar NOT NULL,
    "phone" varchar NOT NULL,
    "country" varchar NOT NULL,
    "lastSintegraUpdate" date NOT NULL, 
    "companyOpenDate" date NOT NULL, 
    "authorised" int NOT NULL, --must be 0 = false and 1 for true.  
    "authorisedDate" date NOT NULL, 
    "email" varchar NOT NULL
);

--the product will be linked within the station by the stationProducts table,
--then will be created a function to find the procuts of the station, that will
--meke us database dependent but will help us to better control products, and make
--easy the application development
CREATE TABLE "product"(
   "productId" SERIAL integer primary key,
   "price" DECIMAL(6,3) not null,
   "quality" integer,
   "overalQuality" integer not null,
   "densidadeAmbiente" DECIMAL(6,3) not null,
   "temperaturaAmostra" DECIMAL(6,3) not null,
   "quantidadeRecebidoAmbiente" integer not null,   
);

--gasoline generyc type
CREATE TABLE "gasoline"(
   "gasolineId" SERIAL integer primary key,   
   "aspect" boolean,
   "density" DECIMAL(6,3)      
   "color" integer not null,
   "alcoholTenor" DECIMAL(6,3),
   "gasolineType" integer not null, -- must be 0 = comum; 1 = premium; 2 = adtivada
   "productId" integer foreign key references "product"     
);

--etanol generic type
create table "etanol"(
  "etanolId" SERIAL integer primary key,  
  "incolorLII" integer not null --boolean
  "density" decimal(6,3) not null,
  "alcoholicTenor" decimal(6,3)  not null,
  "etanolType" integer not null, -- must be 0 = comum; 1 = premium
  "productId" integer foreign key references "product"
);

create table "diesel"(
 "dieselId" SERIAL integer primary key,
 "dieselType" integer  not null, --must be 0 = S10; 1 = S500; 2 = s1800;
 "density" decimal(6,3)  not null,
 "productId" integer foreign key references "product"     
);


CREATE TABLE "stationProducts"(
--TODO    
);

CREATE TABLE "UF"(
    "UF" int primary key,
);

insert into "UF" (UF) values (35);

﻿CREATE TABLE "station"(
    "id_station" SERIAL primary key,	
    "CNPJ" char(14) NOT NULL,		
    "sintegraId" integer NOT NULL foreign key references "sintegraData",	  
    "rankingId" integer foreign key references "ranking",
    "Product"  integer foreign key references "stationProducts";
);

--distributor data
﻿CREATE TABLE "distributor"(
	"id_distributor" SERIAL primary key,	
	"CNPJ" char(14) NOT NULL,		
	"sintegraId" integer NOT NULL foreign key references "sintegraData",	  
    "rankingId" integer foreign key references "ranking",
);

--conection between station and distributor
CREATE TABLE "stationDistributor"(
	"id_distributorStation" SERIAL primary key
	"id_station" integer foreign key references "station",
	"id_distributor" integer foreign key references "distributor",
);

--user data
CREATE TABLE "user"(
     "user_id" SERIAL primary key
     "userName" varchar not null,
     "birthdayDate" date not null,
     "userPassword" varchar not null,
     "completeName" varchar not null,
     "e_mail" varchar not null,
     "userRanking" integer foreign key references "stationRanking";
);



--ranking of distributor
CREATE TABLE "rankingDistributor"(
	"rankDis_id" SERIAL primary key,
	"pointProduct" integer not null,
	"pointSeller" integer not null,
	"pointDriverAttendence" integer not null,
	"pointBillOfSalle" integer not null
);
--ranking station
CREATE TABLE "rankingStation"(
	"rankSta_id" SERIAL primary key,
	"points" integer not null,
	"pointsBase" integer not null,
	"pointsConvenience" integer not null,
	"pointsAtendense" integer not null,
	"pointsProducts" integer not null,
	"pointsPrice" integer not null,
	"pointsAnalyses" integer not null,
	"pointsRegistrationAge" integer not null,
);

--ranking for the user
CREATE TABLE "rankingUser"(
	"rankUser_id" SERIAL primary key,	
	"points" integer not null,
	"pointsDriven" integer not null,
	"pointsSearch" integer not null,
	"pointsUseFrequency" integer not null,
	"pointsRegistrationDate" integer not null,
	"pointsAnalyses" integer not null,
	"pointsConfidence" integer not null,
);

--business hours for station and distributors
CREATE TABLE "businessHours" (
  "id" integer NOT NULL PRIMARY KEY,
  "business_id" integer NOT NULL FOREIGN KEY REFERENCES "businesses", --questionate teacher business need to be generic?
  "day" integer NOT NULL,
  "open_time" time,
  "close_time" time
);