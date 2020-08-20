CREATE SCHEMA productDB

CREATE TABLE Product (
    num varchar(50) primary key,
    name varchar(50),
    price int,
    amount int,
    Inch int,
    liter int,
    gubun char(1) -- 'T', 'R' 
)

-- 상품정보 전체를 검색하는 기능
select * 
from product;

-- 상품번호로 상품을 검색하는 기능
insert 
  into product 
values('t1','samsung',10000,2,5,null,'T');

insert 
  into product 
values('r1','samsung',20000,3,null, 33, 'T');

-- 상품번호로 상품을 검색하는 기능
select * from product
    where productNum = "??";
    
-- 상품명으로 상품을 검색하는 기능
select * 
	from product
	where n Like '%??%';
    
-- TV만 검색
select * 
	from product
	where gubun = "T";
    
-- 냉장고만 검색
select * 
	from product
	where gubun = "R";

-- 400L 이상의 냉장고만 검색
select * 
	from product
	where gubun = "R" and L >= 400;
    
-- 50inch 이상의 TV만 검색
select * 
  from product
 where gubun = "T" 
   and inch >= 50;

-- 상품번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능
UPDATE product
   SET price = "상품가격"
 WHERE productNum = "상품번호";
    
-- 상품번호로 상품을 삭제하는 기능
delete 
  from product
 WHERE productNum = "상품번호";
 
-- 전체 재고 상품 금액을 구하는 기능
select sum(price * cargo) 
  from product;