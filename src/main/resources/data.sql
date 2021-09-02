INSERT INTO client (document, name) VALUES('41067137050', 'robson grillo');

INSERT INTO service (code, description, value) VALUES(1, 'SERVICE 01', 100.00);
INSERT INTO service (code, description, value) VALUES(2, 'SERVICE 02', 200.00);
INSERT INTO service (code, description, value) VALUES(3, 'SERVICE 03', 300.00);

INSERT INTO scheduling (`hour`, note, client_id, service_id) VALUES('2021-01-01 00:00:00', 'teste', 1, 1);
