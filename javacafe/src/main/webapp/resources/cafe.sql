
-- 카테고리 --
CREATE TABLE MainCategory(
	mainId 		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	mainCategory 	VARCHAR(20) 	NOT NULL
)AUTO_INCREMENT = 1;

SELECT * FROM MainCategory;
SELECT mainCategory FROM MainCategory;
DROP TABLE MainCategory;


CREATE TABLE subCategory(
	subId 		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	mainId		BIGINT			NOT NULL,
	subCategory VARCHAR(20) 	NOT NULL
)AUTO_INCREMENT = 1;
-- mainId forignkey

SELECT * FROM subCategory;
DROP TABLE subCategory;

-- 메뉴 --
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

-- 장바구니 --
CREATE TABLE CartItem (
	id 					BIGINT			PRIMARY KEY AUTO_INCREMENT,
	mainCategory		VARCHAR(20)		NOT NULL,		
	subCategory			VARCHAR(20)		NOT NULL,		
	itemCode			VARCHAR(20)		NOT NULL,
	itemName			VARCHAR(20)		NOT NULL,
	itemPrice			BIGINT			NOT NULL,
	count				INT				DEFAULT 1
)AUTO_INCREMENT = 1;

SELECT * FROM CartItem;
DROP TABLE CartItem;
SELECT sum(itemPrice) FROM CartItem;

-- 매출관리 --
CREATE TABLE Sale (
	sid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	mainCategory		VARCHAR(20)		NOT NULL,		
	subCategory			VARCHAR(20)		NOT NULL,		
	itemCode			VARCHAR(20)		NOT NULL,
	itemName			VARCHAR(20)		NOT NULL,
	itemPrice			BIGINT			NOT NULL,
	count				INT				NOT NULL,
	regDate		 		TIMESTAMP	  	NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

SELECT * FROM Sale;
DROP TABLE Sale;
