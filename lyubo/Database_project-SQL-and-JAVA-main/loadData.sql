--Terminal
INSERT INTO FN72107.TERMINAL (NAME) VALUES ('1');

--Flights
INSERT INTO FN72107.FLIGHTS (NUMBER, COMPANY, TYPE, TIME, STARTPOINT, ENDPOINT, TERMINALNAME) VALUES ('WR2020AS', 'WizzAir', 'D', '20:45:00', 'Sofia', 'Viena', '1');
INSERT INTO FN72107.FLIGHTS (NUMBER, COMPANY, TYPE, TIME, STARTPOINT, ENDPOINT, TERMINALNAME) VALUES ('WR0721QW', 'WizzAir', 'A', '21:00:00', 'Rome', 'Sofia', '1');
INSERT INTO FN72107.FLIGHTS (NUMBER, COMPANY, TYPE, TIME, STARTPOINT, ENDPOINT, TERMINALNAME) VALUES ('RA1213JS', 'RyanAir', 'A', '12:00:00', 'Madrid', 'Sofia', '1');
INSERT INTO FN72107.FLIGHTS (NUMBER, COMPANY, TYPE, TIME, STARTPOINT, ENDPOINT, TERMINALNAME) VALUES ('TR5920QQ', 'TurkishAirlines', 'D', '23:20:00', 'Sofia', 'Istanbul', '1');
--Employee
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Ivan Georgiev', 'Level 1', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Ivailo Todorov', 'Level 1', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Petar Hristov', 'Level 1', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Kristina Pavlova', 'Level 2', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Kristian Petrov', 'Level 2', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Ilian Kamenov', 'Level 3', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Vladislav Stoyanov', 'Level 1', '1');
INSERT INTO FN72107.EMPLOYEE (NAME, POSITION, TERMINALNAME) VALUES ('Ivana Stoykova', 'Level 2', '1');
--PassportControl
INSERT INTO FN72107.PASSPORTCONTROL (NUMBER, TYPE, EMPLOYEENUM) VALUES ('P1 ', 'PASSPORT', 1002);
INSERT INTO FN72107.PASSPORTCONTROL (NUMBER, TYPE, EMPLOYEENUM) VALUES ('P2 ', 'PASSPORT', 1004);

--Gate
INSERT INTO FN72107.GATE (NUMBER, TYPE, FLIGHTNUM, EMPLOYEENUM) VALUES ('G1 ', 'GATE', 'RA1213JS', 1001);
INSERT INTO FN72107.GATE (NUMBER, TYPE, FLIGHTNUM, EMPLOYEENUM) VALUES ('G2 ', 'GATE', 'TR5920QQ', 1000);
INSERT INTO FN72107.GATE (NUMBER, TYPE, FLIGHTNUM, EMPLOYEENUM) VALUES ('G3 ', 'GATE', 'WR0721QW', 1003);
INSERT INTO FN72107.GATE (NUMBER, TYPE, FLIGHTNUM, EMPLOYEENUM) VALUES ('G4 ', 'GATE', 'WR2020AS', 1005);

--Desk
INSERT INTO FN72107.DESK (NUMBER, TYPE, EMPLOYEENUM, FLIGHTNUM) VALUES ('D1 ', 'DESK', 1006, 'TR5920QQ');
INSERT INTO FN72107.DESK (NUMBER, TYPE, EMPLOYEENUM, FLIGHTNUM) VALUES ('D2 ', 'DESK', 1007, 'WR2020AS');

--Passengers
INSERT INTO FN72107.PASSENGERS (EMAIL, NAME, TYPE) VALUES ('georgi@abv.bg                 ', 'Georgi Petkov', 'D');
INSERT INTO FN72107.PASSENGERS (EMAIL, NAME, TYPE) VALUES ('stoyan@gmail.com              ', 'Stoyan Vasilev', 'D');
INSERT INTO FN72107.PASSENGERS (EMAIL, NAME, TYPE) VALUES ('asen@abv.bg                   ', 'Asen Petkov', 'D');
INSERT INTO FN72107.PASSENGERS (EMAIL, NAME, TYPE) VALUES ('teodora@abv.bg                ', 'Teodora Asenov', 'D');
INSERT INTO FN72107.PASSENGERS (EMAIL, NAME, TYPE) VALUES ('vasil@gmail.com               ', 'Vasil Stefnov', 'D');

--Tickets
INSERT INTO FN72107.TICKETS (EMPLOYEENUM, EMAIL, FLIGHTNUM) VALUES (1006, 'asen@abv.bg', 'WR2020AS');
INSERT INTO FN72107.TICKETS (EMPLOYEENUM, EMAIL, FLIGHTNUM) VALUES (1006, 'teodora@abv.bg', 'TR5920QQ');
INSERT INTO FN72107.TICKETS (EMPLOYEENUM, EMAIL, FLIGHTNUM) VALUES (1007, 'georgi@abv.bg', 'WR2020AS');
INSERT INTO FN72107.TICKETS (EMPLOYEENUM, EMAIL, FLIGHTNUM) VALUES (1006, 'vasil@gmail.com', 'WR2020AS');
INSERT INTO FN72107.TICKETS (EMPLOYEENUM, EMAIL, FLIGHTNUM) VALUES (1007, 'stoyan@gmail.com', 'TR5920QQ');
