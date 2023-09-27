--테이블 생성
create table investor(
    investorID char(50),
    investorPW varchar2(50) not null,
    investorName varchar2(50) not null,
    recharge number(15) not null,   
    constraint investor_pk primary key(investorID)
);

create table businessman(
    businessmanID char(50),
    businessmanPW varchar2(50) not null, 
    businessmanName varchar2(50) not null,
    constraint businessman_pk primary key(businessmanID)
);

create table item(
    itemID number(10),
    itemName varchar2(100) not null,
    itemInfo varchar2(150),
    targetAmount number(15) not null,
    collectedAmount number(15),
    percentage number(10,3),
    businessmanID char(50) not null,
    constraint item_pk primary key(itemID),
    constraint item_u unique(itemName),
    constraint item_fk foreign key(businessmanID) references businessman(businessmanID)
);

create table funding(
    investorID char(50),
    itemID number(10), 
    investmentAmount number(15),
    constraint funding_pk primary key(investorID,itemID),
    constraint funding_fk1 foreign key(investorID) references investor(investorID),
    constraint funding_fk2 foreign key(itemID) references item(itemID)
);

--트리거 생성
create or replace trigger trg_01
after insert 
on funding
for each row
begin
    update item 
    set collectedAmount = collectedAmount + :new.investmentAmount
    where itemID = :new.itemID;
    --commit;
end;
/

create or replace trigger trg_02
after insert on funding 
for each row
begin
    update investor
    set recharge = recharge - :new.investmentAmount
    where investorID = :new.investorID;
end;
/

create or replace trigger trg_03
after insert on funding
for each row
begin 
    update item
    set percentage = (collectedAmount + :new.investmentAmount) / targetAmount * 100
    where itemID = :new.itemID;
end;
/


-----------------------------------------------------------------------------------------------

update investor
set recharge = recharge + 10000
where investorID = 'cba';

rollback;

insert into businessman values('abc',1234,'김자바');
insert into item values (1,'뷰티','화장품',100000,0,0,'abc');
insert into investor values ('cba',4321,'이자바',1000000);
insert into funding values ('cba',1,10500);

insert into businessman values('abc2',12342,'김자바2');
insert into item values (12,'뷰티2','화장품2',1000002,0,0,'abc2');
insert into investor values ('cba2',43212,'이자바2',10000002);
insert into funding values ('cba2',12,102);

delete from funding;
drop table businessman;
drop trigger trg_03;
select * from item;
select * from funding;
select * from investor;
select * from item where businessmanId = 'abc   ';

select *
from user_cons_columns
where table_name = 'FUNDING';

select i.*
from item i inner join funding f on(i.itemID=f.itemID)
where investorID = 'cba';

select 59/1000 from dual;

select * from businessman where businessmanId='아이유' and businessmanPw='0303';

commit;
