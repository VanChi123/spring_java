delete from users where 1=1;
insert into users( user_name,password,full_name) values('chibuivan97','chi','Bùi Văn Chí');
insert into users( user_name,password,full_name) values('tien','tien','Nguyễn Xuân Tiến');
insert into users( user_name,password,full_name) values('linh','linh','Vũ Quang Linh');
insert into users( user_name,password,full_name) values('le','le','Trần Lê Mai Chung');
insert into users( user_name,password,full_name) values('nguyen','nguyen','Lê Xuân Cung');

delete from roles where 1=1;
insert into roles(role_name,description) values('ROLE_MANAGER','Vai trò người quản lý');
insert into roles(role_name,description) values('ROLE_ADMIN','Vai trò người quản trị');
insert into roles(role_name,description) values('ROLE_SALE','Vai trò người bán hàng');

delete from user_role where 1=1;
insert into user_role values (1,3);
insert into user_role values (2,2);
insert into user_role values (2,3);
insert into user_role values (3,1);
insert into user_role values (4,1);
insert into user_role values (4,2);
insert into user_role values (5,2);

delete from orders where 1=1;
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200225.A01',1,76640000,'2020-02-25',1,'Lê Thị Giang');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200225.A02',2,64320000,'2020-02-25',0,'Trần Nguyên Hải');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200225.A03',2,107320000,'2020-02-25',3,'Chu Hà Phong');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200226.A01',3,25820000,'2020-02-26',1,'Trần Thị Hải Hà');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200226.A02',4,17320000,'2020-02-26',1,'Lê Nguyên Hồng');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200226.A03',4,17320000,'2020-02-26',0,'Lê Bảo Châu');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200228.A01',1,17320000,'2020-02-28',3,'Chu Hà Phong');
insert into orders(order_no,user_id, amount,order_date,status,customer_name) values('20200228.A02',2,0,'2020-02-28',0,'Nguyễn Tiến Dũng');



delete from order_line where 1=1;

insert into order_line(order_id , product_name ,quantity ,amount ) values(1,'Iphone X',2,42000000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(2,'SamSung S20+',1,2000000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(3,'Oppo Reno V2',4,90000000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(4,'Nokia 8',1,8500000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(5,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(6,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(7,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(1,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(2,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(3,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(4,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(1,'Iphone 7 Plus',2,17320000);
insert into order_line(order_id , product_name ,quantity ,amount ) values(2,'Oppo Reno V2',2,45000000);