--���̺� ����
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

--Ʈ���� ����
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
        raise_application_error(-20001,'�ܾ��� �����մϴ�');
    end if;
end;
/

--������ ����
create sequence seq_01
start with 1
increment by 1;

--������ ����
insert into businessman values('plusnature','pn1234','�ֽ�ȸ�� �÷�������ó');
insert into businessman values('tendo','td5678','(��)�ٵ�');
insert into businessman values('royalgum','rg9012','�ξ�ݼӰ���(��)');
insert into businessman values('sharmil','si3456','�ֽ�ȸ�� ���Ͽ');
insert into businessman values('honest','h7890','Honest');
insert into businessman values('jisangbong','jsb9876','�����');
insert into businessman values('theperfume','tpf5432','����Ǿ');
insert into businessman values('naverwebtoon','nwt1098','���̹�����');
insert into businessman values('malmal','mm7654','����');
insert into businessman values('imgotrip','igt3210','�Ӱ�Ʈ��');

insert into item values(seq_01.nextval,'3�� ��Ȳ�ٵ�ٰ� �ٵ������ ���ƿԾ��! ��õ ��װ� �µ��� �Ǻ� ���!','�ٵ���� 1��: 21,700��, �ٵ���� 2��: 38,800��, �ٵ���� 3��: 53,900��',500000,0,0,'plusnature');
insert into item values(seq_01.nextval,'�������� ���ϴ� ���̷� ���� ���Ằ�� ������ �ʿ�����!','�̱���: 23,900��, ������: 47,000��, Ʈ������: 69,200��',500000,0,0,'tendo');
insert into item values(seq_01.nextval,'���迡�� ���� �������� �ѱ� ���� ������ BON','����������: 45,000��, �������: 35,500��, ����Ʈ��Ʈ: 79,000��',500000,0,0,'royalgum');
insert into item values(seq_01.nextval,'1�� 500���� �޴� ���ڵ� Ȩ������ ����ȭ ���','�ʺ���Ű��: 149,000��, ����������Ű��: 209,000��, �������Ű��: 349,000��',500000,0,0,'sharmil');
insert into item values(seq_01.nextval,'�ν�Ÿ���� ����� ���� ���Ͽ�','�ν�Ÿ���� ������Ű��: 149,000��, �¶��� LIVE ����(4�ð�) ��Ű��: 290,000��, �������� �ַ�� ��Ű�� 490,000��',500000,0,0,'honest');
insert into item values(seq_01.nextval,'���� �ѱ� ���� ����� �帳�ϴ�!','������+�α���+�ѱ��� ��������+���ڼ��� ����: 99,000��, ������ ����+�ѱ��� ����+���ڼ��� ����: 65,000��, �α��� ����+�ѱ��� ����+���ڼ��� ����: 49,000��',500000,0,0,'jisangbong');
insert into item values(seq_01.nextval,'�Ʊ� ���� �����ϸ� ���̼���! �Ǽ��� �Ŀ���� �� ���','�� ��� Ǯ��Ʈ: 89,000��, �� ��� 1��: 29,000��, �� ���1��+ü�輼Ʈ: 35,000��',500000,0,0,'theperfume');
insert into item values(seq_01.nextval,'��� ���� ������, <������ ����>���̾�� �����!','A��Ʈ: 38,500��, B��Ʈ: 61,000��, C��Ʈ: 76,000��',3000000,0,0,'naverwebtoon');
insert into item values(seq_01.nextval,'���۸��� ������ Ű��� ����<������ ����>','������Ű��: 9,900��, ��������Ű��: 24,000��, ������Ű��: 32,000��',2000000,0,0,'malmal');
insert into item values(seq_01.nextval,'2024 �ʵ��ӿ��� ��� ���ǰ��','���ǰ�� ��Ű��: 28,000��, ���ǰ�� ��Ű��(2��): 53,000��, ���ǰ�� ��Ű��(3��): 78,000��',10000000,0,0,'imgotrip');

insert into investor values('kimjava','k1234','���ڹ�',1000000);
insert into investor values('leejava','l5678','���ڹ�',1000000);
insert into investor values('parkjava','p9012','���ڹ�',1000000);
insert into investor values('jungjava','j3456','���ڹ�',1000000);
insert into investor values('yangjava','y7890','���ڹ�',1000000);
insert into investor values('namjava','n9876','���ڹ�',1500000);
insert into investor values('songjava','s5432','���ڹ�',1500000);
insert into investor values('yujava','y1098','���ڹ�',1500000);
insert into investor values('limjava','l7654','���ڹ�',1500000);
insert into investor values('kwanjava','k3210','���ڹ�',1500000);
insert into investor values('kangjava','k1357','���ڹ�',1300000);
insert into investor values('seojava','s9135','���ڹ�',1300000);
insert into investor values('jangjava','j7913','���ڹ�',1300000);
insert into investor values('najava','n5791','���ڹ�',1300000);
insert into investor values('choijava','c3579','���ڹ�',1300000);

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