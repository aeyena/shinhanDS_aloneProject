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
    itemName varchar2(500) not null,
    itemInfo varchar2(500),
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
    set collectedAmount = collectedAmount + :new.investmentAmount, 
        percentage = (collectedAmount + :new.investmentAmount) / targetAmount * 100
    where itemID = :new.itemID;
    
    update investor
    set recharge = recharge - :new.investmentAmount
    where investorID = :new.investorID;
end;
/

create or replace trigger trg_02
before insert on funding
for each row
declare
    investor_recharge investor.recharge%TYPE;
begin 
    select recharge into investor_recharge
    from investor
    where investorId = :new.investorId;

    if investor_recharge < :new.investmentAmount then 
        raise_application_error(-20001,'잔액이 부족합니다');
    end if;
end;
/

--시퀀스 생성
create sequence seq_01
start with 1
increment by 1;

--데이터 삽입
insert into businessman values('plusnature','pn1234','주식회사 플러스네이처');
insert into businessman values('tendo','td5678','(주)텐도');
insert into businessman values('royalgum','rg9012','로얄금속공업(주)');
insert into businessman values('sharmil','si3456','주식회사 삶일운동');
insert into businessman values('honest','h7890','Honest');
insert into businessman values('jisangbong','jsb9876','지상봉');
insert into businessman values('theperfume','tpf5432','더퍼퓸');
insert into businessman values('naverwebtoon','nwt1098','네이버웹툰');
insert into businessman values('malmal','mm7654','말말');
insert into businessman values('imgotrip','igt3210','임고트립');

insert into item values(seq_01.nextval,'3억 유황바디바가 바디워스로 돌아왔어요! 온천 담그고 온듯한 피부 비결!','바디워시 1개: 21,700원, 바디워시 2개: 38,800원, 바디워시 3개: 53,900원',500000,0,0,'plusnature');
insert into item values(seq_01.nextval,'테이프를 원하는 넓이로 이제 종료별로 구매할 필요없어요!','싱글팩: 23,900원, 더블팩: 47,000원, 트리플팩: 69,200원',500000,0,0,'tendo');
insert into item values(seq_01.nextval,'세계에서 먼저 인정받은 한국 코털 정리기 BON','코털정리기: 45,000원, 손톱깎이: 35,500원, 기프트세트: 79,000원',500000,0,0,'royalgum');
insert into item values(seq_01.nextval,'1개 500만원 받는 노코딩 홈페이지 수익화 비법','초보패키지: 149,000원, 프린랜서패키지: 209,000원, 사업가패키지: 349,000원',500000,0,0,'sharmil');
insert into item values(seq_01.nextval,'인스타광고 대행사 광고 노하우','인스타광고 성공패키지: 149,000원, 온라인 LIVE 강의(4시간) 패키지: 290,000원, 매출진단 솔루션 패키지 490,000원',500000,0,0,'honest');
insert into item values(seq_01.nextval,'멋진 한글 사인 만들어 드립니다!','세글자+두글자+한글자 사인제작+전자서명 파일: 99,000원, 세글자 사인+한글자 사인+전자서명 파일: 65,000원, 두글자 사인+한글자 사인+전자서명 파일: 49,000원',500000,0,0,'jisangbong');
insert into item values(seq_01.nextval,'아기 냄새 좋아하면 모이세요! 뽀송한 파우더리 비누 향수','비누 향수 풀세트: 89,000원, 비누 향수 1개: 29,000원, 비누 향수1개+체험세트: 35,000원',500000,0,0,'theperfume');
insert into item values(seq_01.nextval,'평생 받을 마음양, <작전명 순정>다이어리에 적어봐!','A세트: 38,500원, B세트: 61,000원, C세트: 76,000원',3000000,0,0,'naverwebtoon');
insert into item values(seq_01.nextval,'몽글몽글 도깨비 키우기 게임<차깨비 찻집>','응원패키지: 9,900원, 디지털패키지: 24,000원, 문구패키지: 32,000원',2000000,0,0,'malmal');
insert into item values(seq_01.nextval,'2024 초등임용고시 대비 모의고사','모의고사 패키지: 28,000원, 모의고사 패키지(2인): 53,000원, 모의고사 패키지(3인): 78,000원',10000000,0,0,'imgotrip');

insert into investor values('kimjava','k1234','김자바',1000000);
insert into investor values('leejava','l5678','이자바',1000000);
insert into investor values('parkjava','p9012','박자바',1000000);
insert into investor values('jungjava','j3456','정자바',1000000);
insert into investor values('yangjava','y7890','양자바',1000000);
insert into investor values('namjava','n9876','남자바',1500000);
insert into investor values('songjava','s5432','송자바',1500000);
insert into investor values('yujava','y1098','유자바',1500000);
insert into investor values('limjava','l7654','임자바',1500000);
insert into investor values('kwanjava','k3210','권자바',1500000);
insert into investor values('kangjava','k1357','강자바',1300000);
insert into investor values('seojava','s9135','서자바',1300000);
insert into investor values('jangjava','j7913','장자바',1300000);
insert into investor values('najava','n5791','나자바',1300000);
insert into investor values('choijava','c3579','최자바',1300000);

insert into funding values('kimjava',5,290000);
insert into funding values('leejava',8,61000);
insert into funding values('parkjava',1,38800);
insert into funding values('jungjava',6,65000);
insert into funding values('yangjava',2,47000);
insert into funding values('namjava',7,29000);
insert into funding values('songjava',9,24000);
insert into funding values('yujava',3,35500);
insert into funding values('limjava',10,53000);
insert into funding values('kwanjava',7,29000);
insert into funding values('kangjava',4,209000);
insert into funding values('seojava',10,53000);
insert into funding values('jangjava',4,209000);
insert into funding values('najava',8,61000);
insert into funding values('choijava',9,24000);

insert into funding values('kimjava',9,24000);
insert into funding values('leejava',2,47000);
insert into funding values('parkjava',8,76000);
insert into funding values('jungjava',10,53000);
insert into funding values('yangjava',3,35500);
insert into funding values('namjava',1,38800);
insert into funding values('songjava',7,29000);
insert into funding values('yujava',9,24000);
insert into funding values('limjava',6,65000);
insert into funding values('kwanjava',4,149000);
insert into funding values('kangjava',10,53000);
insert into funding values('seojava',9,24000);
insert into funding values('jangjava',8,76000);
insert into funding values('najava',1,38800);
insert into funding values('choijava',3,35500);

insert into funding values('kimjava',1,53900);
insert into funding values('leejava',3,79000);
insert into funding values('parkjava',10,78000);
insert into funding values('jungjava',7,89000);
insert into funding values('yangjava',9,32000);
insert into funding values('namjava',8,76000);
insert into funding values('songjava',6,99000);
insert into funding values('yujava',2,69200);
insert into funding values('limjava',5,490000);
insert into funding values('kwanjava',8,76000);
insert into funding values('kangjava',9,32000);
insert into funding values('seojava',8,76000);
insert into funding values('jangjava',10,78000);
insert into funding values('najava',9,32000);
insert into funding values('choijava',4,349000);

insert into funding values('kimjava',8,61000);
insert into funding values('leejava',9,24000);
insert into funding values('parkjava',4,209000);
insert into funding values('jungjava',9,24000);
insert into funding values('yangjava',8,61000);
insert into funding values('namjava',9,24000);
insert into funding values('songjava',3,45000);
insert into funding values('yujava',1,38800);
insert into funding values('limjava',2,47000);
insert into funding values('seojava',7,35000);
insert into funding values('kangjava',1,38800);
insert into funding values('jangjava',7,35000);
insert into funding values('choijava',8,61000);

insert into funding values('choijava',1,53900);
insert into funding values('kangjava',7,89000);

insert into funding values('songjava',1,53900);
insert into funding values('yujava',7,89000);