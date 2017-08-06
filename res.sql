use petdatabase;
Create table Restaurant(
 res_id int(11) NOT NULL AUTO_INCREMENT,
 fk_owner_id int(11) ,
 res_name VARCHAR(45)  ,
 res_address VARCHAR(45) ,
 PRIMARY KEY (res_id)
);

Create table Dishes(
dis_id int(11) NOT NULL AUTO_INCREMENT,
fk_res_id int(11) ,
dis_name VARCHAR(45)  ,
description VARCHAR(1000),
dis_type VARCHAR(45)  ,
main_ingredient varchar(45) ,
price int(11),
total int(11) ,
unit VARCHAR(45) ,
version long,
 PRIMARY KEY (dis_id)
);

insert into Restaurant( res_id,fk_owner_id ,res_name,res_address ) values (1,1,'ABC','swher/sasd');

insert into Dishes(dis_id ,fk_res_id,dis_name ,description ,dis_type   ,main_ingredient ,price ,unit ,version) values (1,1,'ca chua','taste like shit','chay','rau',213,'dia',1);

Create table Booking(
booking_id int(11) NOT NULL AUTO_INCREMENT,
fk_dis_id int(11)  ,
fk_user_id int(11) ,
booking_amount int(11),
booking_date datetime
)

;



