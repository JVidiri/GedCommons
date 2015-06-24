--delete tables iexists
drop table if exists "stationLoginData";
drop table if exists "userLoginData";
drop table if exists "stationDistributor";
drop table if exists "stationProducts";
drop table if exists "station";
drop table if exists "distributor";
drop table if exists "user";
drop table if exists "rankingDistributor";
drop table if exists "rankingUser";
drop table if exists "rankingStation";
drop table if exists "sintegraData";
drop table if exists "gasoline";
drop table if exists "etanol";
drop table if exists "diesel";
drop table if exists "product";
drop table if exists "UF";
drop table if exists "businessHours";
drop table if exists "activeSessions";

--active sessions hashes valids as credentials
CREATE TABLE "activeSessions"(
    "sessionId" SERIAL primary key,
    "hash" varchar(255),
    "activatedAt" bigint
);

CREATE TABLE "UF"(
    "UFNumber" int primary key,
    "UF" char(2)
);

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
    "phone" varchar NOT NULL,    
    "lastSintegraUpdate" date NOT NULL, 
    "companyOpenDate" date NOT NULL, 
    "authorised" int NOT NULL Check ("authorised" = 1 or "authorised" = 0), --must be 0 = false and 1 for true.  
    "authorisedDate" date NOT NULL, 
    "email" varchar NOT NULL
);

--business hours for station and distributors
CREATE TABLE "businessHours" (
  "id" integer NOT NULL PRIMARY KEY,  
  "open_time" int,
  "close_time" int
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
	"pointsRegistrationAge" integer not null
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
	"pointsConfidence" integer not null
);

--the product will be linked within the station by the stationProducts table,
--then will be created a function to find the procuts of the station, that will
--meke us database dependent but will help us to better control products, and make
--easy the application development
CREATE TABLE "product"(
   "productId" SERIAL primary key,
   "price" DECIMAL(6,3) not null,   
   "priceUnconstant" integer not null check ("priceUnconstant" = 0 or "priceUnconstant" = 1), -- 0 = false 1 = true
   "dateLastPriceChange" date not null,
   "overalQuality" integer not null,
   "densidadeAmbiente" DECIMAL(6,3) not null,
   "temperaturaAmostra" DECIMAL(6,3) not null,
   "quantidadeRecebidoAmbiente" integer not null,   
   "type" integer not null
);

--gasoline generyc type
CREATE TABLE "gasoline"(
   "gasolineId" SERIAL primary key,   
   "aspect" boolean,
   "density" DECIMAL(6,3),      
   "color" integer not null,
   "alcoholTenor" DECIMAL(6,3),
   "gasolineType" integer not null Check ("gasolineType" = 1 or "gasolineType" = 0 or "gasolineType" = 2), -- must be 0 = comum; 1 = premium; 2 = adtivada
   "product_id" integer references "product" --pk_gasolineProd
);

--etanol generic type
create table "etanol"(
  "etanolId" SERIAL primary key,  
  "incolorLII" integer not null, --boolean
  "density" decimal(6,3) not null,
  "alcoholicTenor" decimal(6,3)  not null,
  "etanolType" integer not null Check ("etanolType" = 1 or "etanolType" = 0), -- must be 0 = comum; 1 = premium
  "productId" integer references "product" --pk_etanolProd
);

--diesel product definitions 
create table "diesel"(
 "dieselId" SERIAL primary key,
 "dieselType" integer  not null Check ("dieselType" = 1 or "dieselType" = 0 or "dieselType" = 2), --must be 0 = S10; 1 = S500; 2 = s1800;
 "density" decimal(6,3)  not null,
 "productId" integer references "product" --pk_dieselProd
);

--station data
CREATE TABLE "station"(
    "id_station" SERIAL primary key,    
    "sintegraId" integer references "sintegraData", --pk_stationSintegra
    "rankingId" integer references "rankingStation", --pk_stationRanking
    "UF" integer references "UF" --pk_stationUF
);

--user data
CREATE TABLE "user"(
     "user_id" SERIAL primary key,    
     "birthdayDate" date not null,     
     "completeName" varchar not null,
     "e_mail" varchar not null,
     "userRanking" integer references "rankingUser" --pk_userRanking
);

--distributor data
CREATE TABLE "distributor"(
    "id_distributor" SERIAL primary key,	
    "CNPJ" char(14) NOT NULL,		
    "sintegraId" integer NOT NULL references "sintegraData", --pk_distributorSintegra
    "rankingId" integer references "rankingDistributor" --pk_distributorRanking
);

--user data
CREATE TABLE "stationLoginData"(
     "stationLogin_id" SERIAL primary key,
     "stationCNPJ" varchar not null,     
     "stationPassword" varchar not null,     
     "station_id" integer references "station" -- pk_stationLoginStation
);

--user data
CREATE TABLE "userLoginData"(
     "userLogin_id" SERIAL primary key,
     "userName" varchar not null,     
     "userPassword" varchar not null,     
     "user_id" integer references "user" -- pk_userLoginUser
);

--to link station to products 
create table "stationProducts"(
    "stationProduct_id" SERIAL primary key,
    "stationId" integer references "station", -- pk_stationProdStation
    "productId" integer references "product" --pk_stationProdProduct
);

--conection between station and distributor
CREATE TABLE "stationDistributor"(
	"id_distributorStation" SERIAL primary key,
	"id_station" integer references "station", --pk_stationDistStation
	"id_distributor" integer references "distributor" -- pk_stationDistDistributor
);

--initializing UFs
insert into "UF"("UFNumber","UF") values (11,'RO');
insert into "UF"("UFNumber","UF") values (12,'AC');
insert into "UF"("UFNumber","UF") values (13,'AM');
insert into "UF"("UFNumber","UF") values (14,'RR');
insert into "UF"("UFNumber","UF") values (15,'PA');
insert into "UF"("UFNumber","UF") values (16,'AP');
insert into "UF"("UFNumber","UF") values (17,'TO');
insert into "UF"("UFNumber","UF") values (21,'MA');
insert into "UF"("UFNumber","UF") values (22,'PI');
insert into "UF"("UFNumber","UF") values (23,'CE');
insert into "UF"("UFNumber","UF") values (24,'RN');
insert into "UF"("UFNumber","UF") values (25,'PB');
insert into "UF"("UFNumber","UF") values (26,'PE');
insert into "UF"("UFNumber","UF") values (27,'AL');
insert into "UF"("UFNumber","UF") values (28,'SE');
insert into "UF"("UFNumber","UF") values (29,'BA');
insert into "UF"("UFNumber","UF") values (31,'MG');
insert into "UF"("UFNumber","UF") values (32,'ES');
insert into "UF"("UFNumber","UF") values (33,'RJ');
insert into "UF"("UFNumber","UF") values (35,'SP');
insert into "UF"("UFNumber","UF") values (41,'PR');
insert into "UF"("UFNumber","UF") values (42,'SC');
insert into "UF"("UFNumber","UF") values (43,'RS');
insert into "UF"("UFNumber","UF") values (50,'MS');
insert into "UF"("UFNumber","UF") values (51,'MT');
insert into "UF"("UFNumber","UF") values (52,'GO');
insert into "UF"("UFNumber","UF") values (53,'DF');

--função para log de alterações no preço dos combustiveis
CREATE OR REPLACE FUNCTION f_prodUpdate()
RETURNS trigger AS
$$
BEGIN
  --registerng the price change
  IF ( NEW.price != OLD.price ) THEN
       NEW.dateLastPriceChange = current_date;
  END IF;
  --verifing if the price change is more than 10%
  IF ( (NEW.price > (NEW.price + NEW.price * 0.1)) OR (NEW.price < (NEW.price - NEW.price * 0.1)) ) THEN
       NEW.priceUnconstant = 1;      
  END IF;  
  
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--trigger
CREATE TRIGGER tg_product_log
BEFORE UPDATE 
ON product
FOR EACH STATEMENT
EXECUTE PROCEDURE f_prodUpdate();