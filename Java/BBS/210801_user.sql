create table user (
userID varchar(20),
userPassword varchar(20),
userName varchar(20),
userGender varchar(20),
userEmail varchar(50),
primary key (userID)
);

insert into user values('gildong', '123456', '홍길동','남자', 'gildong@naver.com');

SELECT * FROM test.user;

commit;

desc user;