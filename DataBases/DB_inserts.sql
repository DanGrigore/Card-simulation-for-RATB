INSERT INTO CLIENT(first_name,last_name) VALUES('Dan','Grigore');
INSERT INTO CLIENT(first_name,last_name) VALUES('Andrei','Iancu');
INSERT INTO CLIENT(first_name,last_name) VALUES('Alexandra','Gigica');
INSERT INTO CLIENT(first_name,last_name) VALUES('Dan','Chiru');


INSERT INTO CARD(card_money,expire_on,client_id) VALUES(23,null,3);
INSERT INTO CARD(card_money,expire_on,client_id) VALUES(10,CURDATE() + INTERVAL 30 DAY,4);
INSERT INTO CARD(card_money,expire_on,client_id) VALUES(10,STR_TO_DATE('20-05-2018', '%d-%m-%Y'),2);

INSERT INTO TRANSPORT(line,type,charge_per_trip) VALUES(41,'tramvai',1.3);
INSERT INTO TRANSPORT(line,type,charge_per_trip) VALUES(336,'autobuz',1.3);
INSERT INTO TRANSPORT(line,type,charge_per_trip) VALUES(783,'express',3);

INSERT INTO CARD_TYPE(pass_type,price,card_id) VALUES('abonament-lunar',25,7);
INSERT INTO CARD_TYPE(pass_type,price,card_id) VALUES('abonament-zi',10,13);
INSERT INTO CARD_TYPE(pass_type,price,card_id) VALUES('recharge',null,10);

INSERT INTO VALIDATION(card_id,transport_id) VALUES(10,1);

DELETE FROM CARD WHERE card_id = 12;

DELETE FROM VALIDATION WHERE id = 3;

SELECT * FROM CARD;
SELECT * FROM CLIENT;
SELECT * FROM TRANSPORT;
SELECT * FROM CARD_TYPE;
SELECT * FROM VALIDATION;