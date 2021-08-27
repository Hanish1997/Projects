
Work-Bench SQL commands implemented-----------------------------------------

INSERT INTO `javafinalproject`.`logintbl`
(`LoginId`,
`Password`)
VALUES
("testId1",
"password");

.............................................................................

INSERT INTO `javafinalproject`.`customertbl`
(`customerId`,
`name`,
`address`,
`state`,
`postalCode`,
`loginId`)
VALUES
("1",
"Test Name 1",
"Test Add. 1",
"Test State 1",
"A1A1A1",
"testId1");

.............................................................................


INSERT INTO `javafinalproject`.`customeraccounttbl`
(`acctNo`,
`acctType`,
`acctBalance`,
`customerId`)
VALUES
("1111",
"checking",
"1000",
"1");

.............................................................................

INSERT INTO `javafinalproject`.`customerbilltbl`
(`billerName`,
`billerAccNo`,
`amt`,
`customerId`)
VALUES
("Test Name 1",
"1111",
"200",
"1");

.............................................................................

1. correct table name in the nested query


