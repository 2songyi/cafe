CREATE TABLE MainCategory(
	mainId 		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	mainCategory 	VARCHAR(20) 	NOT NULL
)AUTO_INCREMENT = 1;

SELECT * FROM MainCategory;
SELECT mainCategory FROM MainCategory;

CREATE TABLE subCategory(
	subId 		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	mainId		BIGINT			NOT NULL,
	subCategory VARCHAR(20) 	NOT NULL
)AUTO_INCREMENT = 1;
-- mainId forignkey

SELECT * FROM subCategory;

CREATE TABLE MenuItem (
	itemId 				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	mainCategory		VARCHAR(20)		NOT NULL,		
	subCategory			VARCHAR(20)		NOT NULL,		
	itemCode			VARCHAR(20)		NOT NULL,
	itemName			VARCHAR(20)		NOT NULL,
	itemPrice			BIGINT			NOT NULL,
	itemImgae			VARCHAR(40)
)AUTO_INCREMENT = 1;

SELECT * FROM MenuItem;
DROP TABLE MenuItem;
