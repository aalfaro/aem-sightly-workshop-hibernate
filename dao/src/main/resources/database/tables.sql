/*
Category Table
*/

DROP TABLE IF EXISTS `Category`;
commit;

CREATE TABLE `Category` (
  `categoryID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `categoryCode` varchar(10) NOT NULL,
  `categoryName` varchar(100) NOT NULL,
  `categoryDescription` varchar(300) NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE(`categoryCode`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
commit;

INSERT INTO Category ( categoryID, categoryCode, categoryName )
VALUES ( 1, "laptop", "Laptops" );
commit;

INSERT INTO Category ( categoryID, categoryCode, categoryName )
VALUES ( 2, "desktop", "Desktops" );
commit;

INSERT INTO Category ( categoryID, categoryCode, categoryName )
VALUES ( 3, "tablet", "Tablets" );
commit;

INSERT INTO Category ( categoryID, categoryCode, categoryName )
VALUES ( 4, "printer", "Printers" );
commit;

INSERT INTO Category ( categoryID, categoryCode, categoryName )
VALUES ( 5, "monitor", "Monitors" );
commit;

INSERT INTO Category ( categoryID, categoryCode, categoryName )
VALUES ( 6, "accessory", "Accessories" );
commit;

/*
Product Table
*/

DROP TABLE IF EXISTS `Product`;
commit;

CREATE TABLE `Product` (
  `productID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `categoryID` int(11) unsigned NOT NULL,
  `productSKU` varchar(8) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `productDescription` varchar(300) NULL,
  `productPrice` decimal(8, 2) NOT NULL,
  PRIMARY KEY (`productID`),
  KEY `FK_CATEGORY_ID` (`categoryID`),
  CONSTRAINT `FK_CATEGORY_ID` FOREIGN KEY (`categoryID`) REFERENCES `Category` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 1, 1, "LAP001", "XPS 13", 100 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 2, 1, "LAP002", "XPS 15", 200 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 3, 1, "LAP003", "XPS 17", 300 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 4, 2, "DES001", "Mark I", 100 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 5, 2, "DES002", "Mark II", 200 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 6, 2, "DES003", "Mark III", 300 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 7, 3, "TAB001", "TAB 1", 100 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 8, 3, "TAB002", "TAB 2", 200 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 9, 3, "TAB003", "TAB 3", 300 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 10, 4, "PRINT001", "HP 1000", 100 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 11, 4, "PRINT002", "HP 2000", 200 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 12, 4, "PRINT003", "HP 3000", 300 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 13, 5, "MON001", "ViewSonic 13", 100 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 14, 5, "MON002", "ViewSonic 15", 200 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 15, 5, "MON003", "ViewSonic 17", 300 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 16, 6, "ACCS001", "Keyboard", 100 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 17, 6, "ACCS002", "Mouse", 200 );
commit;

INSERT INTO Product ( productID, categoryID, productSKU, productName, productPrice )
VALUES ( 18, 6, "ACCS003", "Headset", 300 );
commit;