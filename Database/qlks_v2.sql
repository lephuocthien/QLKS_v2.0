drop database qlks;
create database qlks;
use qlks;

/*==============================================================*/
/* Table: CO_SO                                                 */
/*==============================================================*/
create table CO_SO
(
   MACS                INT NOT NULL AUTO_INCREMENT,
   TEN                  varchar(25),
   primary key (MACS)
);
Insert into CO_SO(TEN) VALUES('Wifi');
Insert into CO_SO(TEN) VALUES('Tivi 50 ich');
Insert into CO_SO(TEN) VALUES('Máy lạnh');
Insert into CO_SO(TEN) VALUES('Ban công');
Insert into CO_SO(TEN) VALUES('Bồn tắm');
Insert into CO_SO(TEN) VALUES('Bàn làm việc');
Insert into CO_SO(TEN) VALUES('Khăn tắm');
Insert into CO_SO(TEN) VALUES('Dép');
Insert into CO_SO(TEN) VALUES('Giường đôi');
Insert into CO_SO(TEN) VALUES('Giường đơn');
Insert into CO_SO(TEN) VALUES('Máy sấy tóc');
Insert into CO_SO(TEN) VALUES('Ấm đun siêu tốc');

/*==============================================================*/
/* Table: CTHD_DICH_VU                                          */
/*==============================================================*/
create table CTHD_DICH_VU
(
   SOHDDV               int not null,
   MADV                 int not null,
   SOLUONG              numeric(3,0),
   primary key (SOHDDV, MADV),
   key AK_SOHDDV_MADV_PK (SOHDDV, MADV)
);
Insert into CTHD_DICH_VU VALUES(1,1,1);
Insert into CTHD_DICH_VU VALUES(1,2,2);
/*==============================================================*/
/* Table: CT_LOAI_PHONG                                         */
/*==============================================================*/
create table CT_LOAI_PHONG
(
   MACS                 int not null,
   MALP                 int not null,
   primary key (MACS, MALP),
   key AK_MALP_MACS_PK (MACS, MALP)
);

Insert into CT_LOAI_PHONG VALUES(1,1);
Insert into CT_LOAI_PHONG VALUES(2,1);
Insert into CT_LOAI_PHONG VALUES(3,1);
Insert into CT_LOAI_PHONG VALUES(7,1);
Insert into CT_LOAI_PHONG VALUES(8,1);
Insert into CT_LOAI_PHONG VALUES(10,1);
Insert into CT_LOAI_PHONG VALUES(1,2);
Insert into CT_LOAI_PHONG VALUES(2,2);
Insert into CT_LOAI_PHONG VALUES(3,2);
Insert into CT_LOAI_PHONG VALUES(7,2);
Insert into CT_LOAI_PHONG VALUES(9,2);
Insert into CT_LOAI_PHONG VALUES(10,2);
Insert into CT_LOAI_PHONG VALUES(11,2);
Insert into CT_LOAI_PHONG VALUES(1,3);
Insert into CT_LOAI_PHONG VALUES(2,3);
Insert into CT_LOAI_PHONG VALUES(3,3);
Insert into CT_LOAI_PHONG VALUES(7,3);
Insert into CT_LOAI_PHONG VALUES(9,3);
Insert into CT_LOAI_PHONG VALUES(10,3);
Insert into CT_LOAI_PHONG VALUES(11,3);
Insert into CT_LOAI_PHONG VALUES(4,3);
Insert into CT_LOAI_PHONG VALUES(1,4);
Insert into CT_LOAI_PHONG VALUES(2,4);
Insert into CT_LOAI_PHONG VALUES(3,4);
Insert into CT_LOAI_PHONG VALUES(7,4);
Insert into CT_LOAI_PHONG VALUES(8,4);
Insert into CT_LOAI_PHONG VALUES(10,4);
Insert into CT_LOAI_PHONG VALUES(6,4);
Insert into CT_LOAI_PHONG VALUES(11,4);
Insert into CT_LOAI_PHONG VALUES(12,4);
Insert into CT_LOAI_PHONG VALUES(1,5);
Insert into CT_LOAI_PHONG VALUES(2,5);
Insert into CT_LOAI_PHONG VALUES(3,5);
Insert into CT_LOAI_PHONG VALUES(4,5);
Insert into CT_LOAI_PHONG VALUES(5,5);
Insert into CT_LOAI_PHONG VALUES(6,5);
Insert into CT_LOAI_PHONG VALUES(7,5);
Insert into CT_LOAI_PHONG VALUES(8,5);
Insert into CT_LOAI_PHONG VALUES(9,5);
Insert into CT_LOAI_PHONG VALUES(11,5);
Insert into CT_LOAI_PHONG VALUES(12,5);
/*==============================================================*/
/* Table: CT_NUOC_UONG                                          */
/*==============================================================*/
create table CT_NUOC_UONG
(
   MANUOC               int not null,
   SOHDTIEC             int not null,
   SOLUONG              numeric(3,0),
   primary key (MANUOC, SOHDTIEC),
   key AK_MANUOC_SOHDTIEC_PK (MANUOC, SOHDTIEC)
);
Insert into CT_NUOC_UONG values(1,2,30);
Insert into CT_NUOC_UONG values(2,2,20);

/*==============================================================*/
/* Table: CT_THUC_DON                                           */
/*==============================================================*/
create table CT_THUC_DON
(
   TENMON               varchar(50) not null,
   MATD                 int not null,
   primary key (TENMON,MATD)
);

Insert into CT_THUC_DON VALUES('Gỏi mực kiểu Thái',1);
Insert into CT_THUC_DON VALUES('Súp cua gà xé',1);
Insert into CT_THUC_DON VALUES('Cá chẽm sốt Tứ Xuyên',1);
Insert into CT_THUC_DON VALUES('Sườn heo nấu đậu - Bánh mì',1);
Insert into CT_THUC_DON VALUES('Cơm chiên dương châu',1);
Insert into CT_THUC_DON VALUES('Chè nhãn nhục thạch dừa',1);
Insert into CT_THUC_DON VALUES('Gỏi sứa mực',2);
Insert into CT_THUC_DON VALUES('Súp chua cay Thượng Hải',2);
Insert into CT_THUC_DON VALUES('Gà hấp đông cô',2);
Insert into CT_THUC_DON VALUES('Bò nấu pate - Bánh mì',2);
Insert into CT_THUC_DON VALUES('Cơm gói lá sen',2);
Insert into CT_THUC_DON VALUES('Chè đậu đỏ',2);
Insert into CT_THUC_DON VALUES('Chả tôm hạt điều',3);
Insert into CT_THUC_DON VALUES('Súp cua gà xé',3);
Insert into CT_THUC_DON VALUES('Sườn kinh đô',3);
Insert into CT_THUC_DON VALUES('Bò nấu tiêu xanh',3);
Insert into CT_THUC_DON VALUES('Mì hấp dầu hào xá xíu',3);
Insert into CT_THUC_DON VALUES('Chè hạt sen',3);
/*==============================================================*/
/* Table: DAT_PHONG                                             */
/*==============================================================*/
create table DAT_PHONG
(
   MADAT                INT NOT NULL AUTO_INCREMENT,
   SOPHONG              int,
   MANV                 int,
   NGAYTHUE             datetime,
   NGAYTRA              datetime,
   SONGUOI              numeric(2,0),
   TIENTRA              numeric(12,0),
   TIENCON              numeric(12,0),
   HOTEN                varchar(45),
   CMND                 numeric(14,0),
   SDT                  numeric(12,0),
   DIACHI               varchar(100),
   primary key (MADAT)
);
Insert into DAT_PHONG(SOPHONG, MANV, NGAYTHUE, NGAYTRA, SONGUOI, TIENTRA, TIENCON, HOTEN, CMND, SDT, DIACHI)
	VALUES(1,2,STR_TO_DATE('15/4/2019 13:00:00','%d/%m/%Y %H:%i:%s'),STR_TO_DATE('16/4/2019 13:00:00','%d/%m/%Y %H:%i:%s'),'2','200000','800000','Đỗ Văn An',202020202,0123456789,'106c ABCD HCM');
Insert into DAT_PHONG(SOPHONG, MANV, NGAYTHUE, NGAYTRA, SONGUOI, TIENTRA, TIENCON, HOTEN, CMND, SDT, DIACHI)
	VALUES(6,1,STR_TO_DATE('23/5/2019 13:00:00','%d/%m/%Y %H:%i:%s'),STR_TO_DATE('25/5/2019 11:31:00','%d/%m/%Y %H:%i:%s'),'1','400000','2000000','Phạm Thị Hà',202020202,0123456789,'107C EGD HCM');

alter table dat_phong add NGAYSINH date;
/*==============================================================*/
/* Table: DAT_TIEC                                              */
/*==============================================================*/
create table DAT_TIEC
(
   SOTIEC               INT NOT NULL AUTO_INCREMENT,
   MAKHTIEC             int,
   MALT                 int,
   MASANH               int,
   MATD                 int,
   MANV                 int,
   SOBAN                numeric(2,0),
   TGDIENRA             datetime,
   COC                  numeric(12,0),
   TIENCON              numeric(12,0),
   primary key (SOTIEC)
);

Insert into Dat_Tiec(MAKHTIEC, MALT, MASANH, MATD, MANV, SOBAN, TGDIENRA, COC, TIENCON)
	values(1,1,2,2,1,10,STR_TO_DATE('10/6/2019 15:00','%d/%m/%Y %H:%i'),25000000,25000000);
Insert into Dat_Tiec(MAKHTIEC, MALT, MASANH, MATD, MANV, SOBAN, TGDIENRA, COC, TIENCON)
	values(2,3,1,1,2,20,STR_TO_DATE('15/5/2017 18:00','%d/%m/%Y %H:%i'),12000000,10000000);

/*==============================================================*/
/* Table: DICH_VU                                               */
/*==============================================================*/
create table DICH_VU
(
   MADV                 INT NOT NULL AUTO_INCREMENT,
   TENDV                varchar(50),
   DVT                  varchar(15),
   GIA                  numeric(12,0),
   primary key (MADV)
);
Insert into DICH_VU(TENDV, DVT, GIA) VALUES('karaoke','giờ',150000);
Insert into DICH_VU(TENDV, DVT, GIA) VALUES('giặt là','kg',55000);
Insert into DICH_VU(TENDV, DVT, GIA) VALUES('Coca','lon',30000);

/*==============================================================*/
/* Table: HD_DICH_VU                                            */
/*==============================================================*/
create table HD_DICH_VU
(
   SOHDDV               INT NOT NULL AUTO_INCREMENT,
   MANV                 int,
   MADAT               	int,
   THANHTIEN            numeric(12,0),
   NGAYLAP              datetime,
   primary key (SOHDDV)
);
Insert into HD_DICH_VU(MANV, MADAT, THANHTIEN, NGAYLAP) VALUES(1,1,205000,STR_TO_DATE('16/4/2019 13:00:00','%d/%m/%Y %H:%i:%s'));

/*==============================================================*/
/* Table: HD_TIEC                                               */
/*==============================================================*/
create table HD_TIEC
(
   SOHDTIEC             INT NOT NULL AUTO_INCREMENT,
   MANV                 int,
   SOTIEC               int,
   NGAYLAP              datetime,
   TONGTIEN             numeric(12,0),
   TIENTRA              numeric(12,0),
   TIENTHUA             numeric(12,0),
   TIENNUOC             numeric(12,0),
   TINHTRANG            varchar(15),
   primary key (SOHDTIEC)
);
Insert into HD_Tiec(MANV, SOTIEC, NGAYLAP, TONGTIEN, TIENTRA, TIENTHUA, TIENNUOC, TINHTRANG) 
	values(2,1,STR_TO_DATE('15/2/2017 21:00','%d/%m/%Y %H:%i'),22000000,11000000,null,0,'chua thanh toan');
Insert into HD_Tiec(MANV, SOTIEC, NGAYLAP, TONGTIEN, TIENTRA, TIENTHUA, TIENNUOC, TINHTRANG)
	values(3,2,STR_TO_DATE('15/5/2017 21:00','%d/%m/%Y %H:%i'),25000000,25100000,100000,790000,'da thanh toan');

/*==============================================================*/
/* Table: HOA_DON                                               */
/*==============================================================*/
create table HOA_DON
(
   SOHD                 INT NOT NULL AUTO_INCREMENT,
   MADAT                int,
   SOHDDV              	int,
   MANV                 int,
   TINHTRANG            varchar(15),
   NGAYLAP              datetime,
   TONGTIEN             numeric(12,0),
   TIENNHAN             numeric(12,0),
   TIENTHUA             numeric(12,0),
   primary key (SOHD)
);
Insert into HOA_DON(MADAT, SOHDDV, MANV, TINHTRANG, NGAYLAP, TONGTIEN, TIENNHAN,TIENTHUA) 
	VALUES(1,1,1,'chua thanh toan',null,1005000,0,0);

/*==============================================================*/
/* Table: KHACH_HANG_TIEC                                       */
/*==============================================================*/
create table KHACH_HANG_TIEC
(
   MAKHTIEC             INT NOT NULL AUTO_INCREMENT,
   HOTEN                varchar(25),
   SDT                  numeric(12,0),
   CMND                 numeric(14,0),
   primary key (MAKHTIEC)
);
Insert into KHACH_HANG_TIEC(HOTEN, SDT, CMND) VALUES('Nguyễn Văn An',3543838,528888888);
Insert into KHACH_HANG_TIEC(HOTEN, SDT, CMND) VALUES('Trần Văn B',6386386,88899999);
/*==============================================================*/
/* Table: LOAI_PHONG                                            */
/*==============================================================*/
create table LOAI_PHONG
(
   MALP                 INT NOT NULL AUTO_INCREMENT,
   LOAI                 varchar(15),
   GIA                  numeric(12,0),
   primary key (MALP)
);
Insert into LOAI_PHONG(LOAI, GIA) VALUES('thuong','1000000');
Insert into LOAI_PHONG(LOAI, GIA) VALUES('thuong','1200000');
Insert into LOAI_PHONG(LOAI, GIA) VALUES('thuong','1500000');
Insert into LOAI_PHONG(LOAI, GIA) VALUES('vip','2200000');
Insert into LOAI_PHONG(LOAI, GIA) VALUES('vip','2500000');

/*==============================================================*/
/* Table: LOAI_TIEC                                             */
/*==============================================================*/
create table LOAI_TIEC
(
   MALT                 INT NOT NULL AUTO_INCREMENT,
   TENLT                varchar(25),
   primary key (MALT)
);
Insert into Loai_Tiec(TENLT) values('Đám cưới');
Insert into Loai_Tiec(TENLT) values('Sinh nhật');
Insert into Loai_Tiec(TENLT) values('Liên hoan');
Insert into Loai_Tiec(TENLT) values('Khác');


/*==============================================================*/
/* Table: LUU_TRU                                               */
/*==============================================================*/
create table LUU_TRU
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   MADAT 				int,
   SOPHONG              int,
   HOTEN                varchar(50),
   CMND                 numeric(14,0),
   SDT                  numeric(12,0),
   NGAYSINH             date,
   NGAYDEN              datetime,
   NGAYDI 				datetime,
   primary key (ID)
);

Insert into LUU_TRU(MADAT, SOPHONG, HOTEN, CMND,SDT, NGAYSINH, NGAYDEN, NGAYDI) 
	VALUES(1,1,'Đỗ Văn An',202020202,0123456789,STR_TO_DATE('16/9/1969','%d/%m/%Y'),STR_TO_DATE('15/4/2019 13:00','%d/%m/%Y %H:%i'), STR_TO_DATE('18/4/2019 13:00','%d/%m/%Y %H:%i'));
Insert into LUU_TRU(MADAT, SOPHONG, HOTEN, CMND,SDT, NGAYSINH, NGAYDEN, NGAYDI)
	VALUES(2,6,'Phạm Thị Hà',202020202,0123456789,STR_TO_DATE('16/9/1970','%d/%m/%Y'),STR_TO_DATE('23/5/2019 13:00','%d/%m/%Y %H:%i'),STR_TO_DATE('26/5/2019 13:00','%d/%m/%Y %H:%i'));

 

/*==============================================================*/
/* Table: NHAN_VIEN                                             */
/*==============================================================*/
create table NHAN_VIEN
(
   MANV                 INT NOT NULL AUTO_INCREMENT,
   TENTK                varchar(25),
   MATKHAU              varchar(25),
   HOTEN                varchar(50),
   CHUCVU               varchar(100),
   DIACHI               varchar(100),
   SDT                  numeric(12,0),
   NGAYVAOLAM           date,
   ROLE_ID				int,
   primary key (MANV)
);

Insert into NHAN_VIEN(TENTK, MATKHAU, HOTEN, CHUCVU, DIACHI, SDT, NGAYVAOLAM, ROLE_ID) 
	VALUES('hoangduc','duc123','Trần Hoàng Đức','Quản trị hệ thống','163 Thống Nhất Hồ Chí Minh','0958789875',STR_TO_DATE('03/02/2019','%d/%m/%Y'), 1);
Insert into NHAN_VIEN(TENTK, MATKHAU, HOTEN, CHUCVU, DIACHI, SDT, NGAYVAOLAM, ROLE_ID)
	VALUES('thanhngan','ngan123','Nguyễn Thanh Ngân','Quản lý','164 Thống Nhất Hồ Chí Minh','0958789876',STR_TO_DATE('03/02/2019','%d/%m/%Y'), 2);
Insert into NHAN_VIEN(TENTK, MATKHAU, HOTEN, CHUCVU, DIACHI, SDT, NGAYVAOLAM, ROLE_ID)
	VALUES('minhnhat','nhat123','Phạm Minh Nhật','Nhân viên','165 Thống Nhất Hồ Chí Minh','0958789877',STR_TO_DATE('03/02/2019','%d/%m/%Y'), 3);
Insert into NHAN_VIEN(TENTK, MATKHAU, HOTEN, CHUCVU, DIACHI, SDT, NGAYVAOLAM, ROLE_ID)
	VALUES('tramy','my123','Đỗ Trà My','Quản trị hệ thống','166 Thống Nhất Hồ Chí Minh','0958789878',STR_TO_DATE('03/02/2019','%d/%m/%Y'), 1);
/*==============================================================*/
/* Table: ROLE                                            */
/*==============================================================*/
create table ROLES(
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(32),
	description varchar(128),
	primary key (id)
);
INSERT INTO roles( name, description ) VALUES ("ROLE_ADMIN", "Quản trị hệ thống");
INSERT INTO roles( name, description ) VALUES ("ROLE_MANAGER", "Quản lý");
INSERT INTO roles( name, description ) VALUES ("ROLE_USER", "Nhân viên");

SET FOREIGN_KEY_CHECKS=1;
/*==============================================================*/
/* Table: NUOC_UONG                                             */
/*==============================================================*/
create table NUOC_UONG
(
   MANUOC               INT NOT NULL AUTO_INCREMENT,
   TEN                  varchar(25),
   GIA                  numeric(12,0),
   primary key (MANUOC)
);
Insert into NUOC_UONG(TEN,GIA) values('Coca Cola',15000);
Insert into NUOC_UONG(TEN,GIA) values('Tigar Bạc',17000);
Insert into NUOC_UONG(TEN,GIA) values('Nước suối',10000);
Insert into NUOC_UONG(TEN,GIA) values('Heineken',18000);

/*==============================================================*/
/* Table: PHONG                                                 */
/*==============================================================*/
create table PHONG
(
   SOPHONG              INT NOT NULL AUTO_INCREMENT,
   TENPHONG				varchar(15),
   MADAT                int,
   MALP                 INT,
   TINHTRANG            varchar(15),
   primary key (SOPHONG)
);

Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1000',null,1,'thue');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1001',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1002',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1003',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1004',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1005',null,2,'coc');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1006',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1007',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1008',null,3,'sua');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P1009',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2000',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2001',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2002',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2003',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2004',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2005',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2006',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2007',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2008',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P2009',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3000',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3001',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3002',null,1,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3003',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3004',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3005',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3006',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3007',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3008',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P3009',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4000',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4001',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4002',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4003',null,5,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4004',null,5,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4005',null,5,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4006',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4007',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4008',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P4009',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5000',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5001',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5002',null,4,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5003',null,5,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5004',null,5,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5005',null,5,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5006',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5007',null,2,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5008',null,3,'trong');
Insert into PHONG(TENPHONG, MADAT, MALP, TINHTRANG) VALUES('P5009',null,3,'trong');


/*==============================================================*/
/* Table: SANH                                                  */
/*==============================================================*/
create table SANH
(
   MASANH               INT NOT NULL AUTO_INCREMENT,
   TENSANH              varchar(15),
   SOBANTOIDA           numeric(3,0),
   TINHTRANG            varchar(15),
   SOBANTOITHIEU        numeric(3,0),
   primary key (MASANH)
);
Insert into SANH(TENSANH, SOBANTOIDA, TINHTRANG, SOBANTOITHIEU) values('A',50,'trong',35);
Insert into SANH(TENSANH, SOBANTOIDA, TINHTRANG, SOBANTOITHIEU) values('B',40,'da dat',25);
Insert into SANH(TENSANH, SOBANTOIDA, TINHTRANG, SOBANTOITHIEU) values('C',40,'trong',25);
Insert into SANH(TENSANH, SOBANTOIDA, TINHTRANG, SOBANTOITHIEU) values('D',30,'trong',20);
Insert into SANH(TENSANH, SOBANTOIDA, TINHTRANG, SOBANTOITHIEU) values('E',10,'trong',6);
Insert into SANH(TENSANH, SOBANTOIDA, TINHTRANG, SOBANTOITHIEU) values('F',10,'trong',6);


/*==============================================================*/
/* Table: THUC_DON                                              */
/*==============================================================*/
create table THUC_DON
(
   MATD                 INT NOT NULL AUTO_INCREMENT,
   TEN                  varchar(25),
   GIA                  numeric(12,0),
   primary key (MATD)
);
Insert into THUC_DON(TEN, GIA) values('Thực đơn 1',2500000);
Insert into THUC_DON(TEN, GIA) values('Thực đơn 2',2200000);
Insert into THUC_DON(TEN, GIA) values('Thực đơn 3',2900000);



alter table CTHD_DICH_VU add constraint FK_CTHD_DICH_VU foreign key (MADV)
      references DICH_VU (MADV) on delete restrict on update restrict;

alter table CTHD_DICH_VU add constraint FK_CTHD_DICH_VU2 foreign key (SOHDDV)
      references HD_DICH_VU (SOHDDV) on delete restrict on update restrict;

alter table CT_LOAI_PHONG add constraint FK_CT_LOAI_PHONG foreign key (MACS)
      references CO_SO (MACS) on delete restrict on update restrict;

alter table CT_LOAI_PHONG add constraint FK_CT_LOAI_PHONG2 foreign key (MALP)
      references LOAI_PHONG (MALP) on delete restrict on update restrict;

alter table CT_NUOC_UONG add constraint FK_CT_NUOC_UONG foreign key (SOHDTIEC)
      references HD_TIEC (SOHDTIEC) on delete restrict on update restrict;

alter table CT_NUOC_UONG add constraint FK_CT_NUOC_UONG2 foreign key (MANUOC)
      references NUOC_UONG (MANUOC) on delete restrict on update restrict;

alter table CT_THUC_DON add constraint FK_GOM_CHI_TIET foreign key (MATD)
      references THUC_DON (MATD) on delete restrict on update restrict;

alter table DAT_PHONG add constraint FK_LAP foreign key (MANV)
      references NHAN_VIEN (MANV) on delete restrict on update restrict;

alter table DAT_PHONG add constraint FK__DUOC_THUE7 foreign key (SOPHONG)
      references PHONG (SOPHONG) on delete restrict on update restrict;

alter table DAT_TIEC add constraint FK_CO foreign key (MALT)
      references LOAI_TIEC (MALT) on delete restrict on update restrict;

alter table DAT_TIEC add constraint FK_DAT_TIEC foreign key (MAKHTIEC)
      references KHACH_HANG_TIEC (MAKHTIEC) on delete restrict on update restrict;

alter table DAT_TIEC add constraint FK_GOM___ foreign key (MATD)
      references THUC_DON (MATD) on delete restrict on update restrict;

alter table DAT_TIEC add constraint FK_LAP_DAT_TIEC foreign key (MANV)
      references NHAN_VIEN (MANV) on delete restrict on update restrict;

alter table DAT_TIEC add constraint FK_O foreign key (MASANH)
      references SANH (MASANH) on delete restrict on update restrict;

alter table HD_DICH_VU add constraint FK_LAP_DV foreign key (MANV)
      references NHAN_VIEN (MANV) on delete restrict on update restrict;

alter table HD_DICH_VU add constraint FK_THANH_TOAN_DICH_VU foreign key (MADAT)
      references DAT_PHONG (MADAT) on delete restrict on update restrict;

alter table HD_TIEC add constraint FK_LAP_ foreign key (MANV)
      references NHAN_VIEN (MANV) on delete restrict on update restrict;

alter table HD_TIEC add constraint FK_THANH_TOAN foreign key (SOTIEC)
      references DAT_TIEC (SOTIEC) on delete restrict on update restrict;

alter table HOA_DON add constraint FK_GOM_2 foreign key (MADAT)
      references DAT_PHONG (MADAT) on delete restrict on update restrict;

alter table HOA_DON add constraint FK_LAP_2 foreign key (MANV)
      references NHAN_VIEN (MANV) on delete restrict on update restrict;

alter table HOA_DON add constraint FK_RELATIONSHIP_11 foreign key (SOHDDV)
      references HD_DICH_VU (SOHDDV) on delete restrict on update restrict;

alter table LUU_TRU add constraint FK_LUU_TRU__ foreign key (SOPHONG)
      references PHONG (SOPHONG) on delete restrict on update restrict;

alter table PHONG add constraint FK_GOM foreign key (MALP)
      references LOAI_PHONG (MALP) on delete restrict on update restrict;
alter table nhan_vien add constraint FK_ROLES foreign key(role_id) 
	  references roles(id) on delete restrict on update restrict;
