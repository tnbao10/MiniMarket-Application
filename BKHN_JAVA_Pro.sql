USE master
GO

DROP DATABASE IF EXISTS BKHN_JAVA
CREATE DATABASE BKHN_JAVA
GO

USE BKHN_JAVA
GO

DROP TABLE IF EXISTS Supplier
CREATE TABLE Supplier
(
	IdSup INT PRIMARY KEY IDENTITY,
	NameSup Nvarchar(50) NOT NULL,
	AddressSup Nvarchar(50)	NOT NULL,
	PhoneSup VARCHAR(20)	NOT NULL,
	AccNumSup VARCHAR(20)	NOT NULL,
	TINSup VARCHAR(20)	NOT NULL
)
GO

DROP TABLE IF EXISTS Customer
CREATE TABLE Customer
(
	IdCus INT PRIMARY KEY IDENTITY,
	NameCus Nvarchar(50) NOT NULL,
	GenderCus BIT,
	DOBCus DATE	NOT NULL,
	AddrCus NVARCHAR(50) NOT NULL,
	PhoneCus NVARCHAR(10) NOT NULL,
)
GO

DROP TABLE IF EXISTS Employee
CREATE TABLE Employee
(
	IdEmp INT	PRIMARY KEY	IDENTITY,
	NameEmp Nvarchar(50),	
	GenderEmp BIT	,
	DOBEmp DATE		,
	AddrEmp NVARCHAR(50)	,
	PhoneEmp NVARCHAR(10)	,
	Email VARCHAR(30)	,
	UserName VARCHAR(20)	,
	Pass VARCHAR(25)	,
	Authority	VARCHAR(25)	
)
GO

DROP TABLE IF EXISTS Product
CREATE TABLE Product
(
	IdPro INT PRIMARY KEY IDENTITY,
	IdProCate INT,
	NamePro		NVarchar(20) NOT NULL,
	AvtPro	Varchar(50) NOT NULL,
	BeginDate DATE NOT NULL,
	EndDate DATE NOT NULL,
	UnitPro Nvarchar(10)	NOT NULL,
	CostPro Float	NOT NULL,
	QuantityPro INT	NOT NULL,
	DiscountPro	Float(10),
	VATPro	Float(10),
	TotalCostPro Float(20),
	TotalDisPro Float(20)
)
GO

DROP TABLE IF EXISTS ProductCategory
CREATE TABLE ProductCategory
(
	IdProCate INT PRIMARY KEY IDENTITY,
	NameProCate Nvarchar(50)	NOT NULL,
)
GO

DROP TABLE IF EXISTS DetailBill
CREATE TABLE DetailBill
(
	IdDBill INT PRIMARY KEY IDENTITY,
	IdBill INT NOT NULL,
	IdPro INT NOT NULL,
	PriceDB Float ,
	QuantityDB INT ,
	TotalMoneyDB Float 
)
GO

DROP TABLE IF EXISTS Bill
CREATE TABLE Bill
(
	IdBill INT PRIMARY KEY IDENTITY,
	IdEmp INT ,
	IdCus INT ,
	NameBill NVARCHAR(10),
	DateBill DATE NOT NULL,
	TotalMoneyBill Float
)
GO

DROP TABLE IF EXISTS DetailImportNote
CREATE TABLE DetailImportNote
(
	IdDIN INT PRIMARY KEY IDENTITY,
	IdIN INT NOT NULL,
	IdPro INT	NOT NULL,
	CostDIN Float	NOT NULL,
	QuantityDIN INT	NOT NULL,
	TotalCostDIN FLOAT,
)
GO

DROP TABLE IF EXISTS ImportNote
CREATE TABLE ImportNote
(	
	IdIN INT   PRIMARY KEY,
	IdSup INT	NOT NULL,
	IdEmp INT	NOT NULL,
	NameIN NVARCHAR(10) NOT NULL,
	DateIN Date	NOT NULL,
	TotalCostIN FLOAT 
)
GO


DROP TABLE IF EXISTS SpendNote
CREATE TABLE SpendNote
(
	IdSN INT PRIMARY KEY IDENTITY,
	IdEmp INT	NOT NULL,
	IdIN INT	NOT NULL,
	NamePerSN Nvarchar(50)	NOT NULL,
	DateSN Date	NOT NULL,
	MoneySN Float	NOT NULL,
	ReasonSN NVARCHAR(255)	NOT NULL,
)
GO

-- LIÊN KẾT CÁC BẢNG
ALTER TABLE ImportNote
ADD CONSTRAINT	FK_ImportNote_Supplier
FOREIGN KEY(idSup)
REFERENCES Supplier(idSup)
GO

ALTER TABLE ImportNote	
ADD CONSTRAINT	FK_ImportNote_Employee
FOREIGN KEY(IdEmp)
REFERENCES Employee(IdEmp)
GO

ALTER TABLE DetailImportNote	
ADD CONSTRAINT	FK_DetailImportNote_ImportNote
FOREIGN KEY(IdIN)
REFERENCES ImportNote(IdIN)
GO

ALTER TABLE DetailImportNote	
ADD CONSTRAINT	FK_DetailImportNote_Product
FOREIGN KEY(IdPro)
REFERENCES Product(IdPro)
GO

ALTER TABLE Product	
ADD CONSTRAINT	FK_Product_ProductCategory
FOREIGN KEY(IdProCate)
REFERENCES ProductCategory(IdProCate)
GO

ALTER TABLE SpendNote	
ADD CONSTRAINT	FK_SpendNote_ImportNote
FOREIGN KEY(IdIN)
REFERENCES ImportNote(IdIN)
GO

ALTER TABLE SpendNote	
ADD CONSTRAINT	FK_SpendNote_Employee
FOREIGN KEY(IdEmp)
REFERENCES Employee(IdEmp)
GO

ALTER TABLE Bill	
ADD CONSTRAINT	FK_Bill_Employee
FOREIGN KEY(IdEmp)
REFERENCES Employee(IdEmp)
GO

ALTER TABLE Bill	
ADD CONSTRAINT	FK_Bill_Customer
FOREIGN KEY(IdCus)
REFERENCES Customer(IdCus)
GO

ALTER TABLE DetailBill	
ADD CONSTRAINT	FK_DetailBill_Product
FOREIGN KEY(IdPro)
REFERENCES Product(IdPro)
GO

ALTER TABLE DetailBill	
ADD CONSTRAINT	FK_DetailBill_Bill
FOREIGN KEY(IdBill)
REFERENCES Bill(IdBill)
GO

-- TẠO BẢNG CHO ADMIN
DROP TABLE IF EXISTS AdminTable
CREATE TABLE AdminTable
(
	UserName VARCHAR(50) PRIMARY KEY,
	Pass VARCHAR(50)	NOT NULL
)
GO

-- ĐĂNG KÝ (KHI CHƯA CÓ THÌ INSERT VÔ)
CREATE PROC insertAcc
@Email	VARCHAR(30),	@Username	VARCHAR(20), @Pass	VARCHAR(25),
 @Authority	VARCHAR(25)
AS
BEGIN	
	INSERT INTO	Employee(Email, UserName, Pass, Authority)
	VALUES(@Email, @Username, @Pass, @Authority)
END
GO


-- Kiểm tra account đã tồn tại chưa (NẾU CHƯA THÌ VÀO ĐĂNG KÝ)
CREATE PROC selectAcc
@Email VARCHAR(30)
AS
BEGIN
	SELECT * FROM Employee
	WHERE Email = @Email
END
GO

-- ĐĂNG NHẬP
CREATE PROC signIn
@Email VARCHAR(30),	@Pass VARCHAR(25)
AS
BEGIN
	SELECT * FROM Employee
	WHERE Email = @Email 
	AND	Pass = @Pass
END
GO


-- CẬP NHẬT PASSWORD	
CREATE PROC updatePass
@Pass VARCHAR(20),
@Email VARCHAR(30)
AS
BEGIN
	UPDATE Employee
	SET Pass = @Pass
	WHERE Email = @Email
END
GO

-- PHÂN LẠI QUYỀN
CREATE PROC updateAuthority
@IdEmp INT,
@Authority NVARCHAR(20)
AS
BEGIN
	UPDATE Employee
	SET Authority = @Authority
	WHERE IdEmp = @IdEmp
END
GO





-------------------------------PHẦN CUSTOMER ----------------------------------
CREATE PROC SelectCus
@pageNumber int,
@rowOfPage int
AS
BEGIN
    SELECT C.IdCus, C.NameCus, C.GenderCus, C.DOBCus, C.AddrCus, C.PhoneCus
	FROM Customer AS C
	ORDER BY C.IdCus
   OFFSET (@pageNumber - 1) * @rowOfPage ROWS
    FETCH NEXT @rowOfPage ROWS ONLY;
END
GO

CREATE PROCEDURE countCus
AS
BEGIN
	SELECT COUNT(IdCus) total FROM Customer
END
GO

INSERT INTO Customer (NameCus, GenderCus, DOBCus, AddrCus, PhoneCus)
VALUES
(N'Như Bảo', 1, '2023-08-10', N'Nguyễn Trãi, Hà Nội', '0346006090'),
(N'Lê Nhã', 1, '2023-09-10', N'Hồ lô, TP.HCM', '0336006090'),
(N'Nguyễn Khoa', 1, '2022-07-10', N'Nguyễn Trãi, Hà Nội', '0346006090'),
(N'Phạm Hùng', 1, '2023-05-10', N'Phạm Văn, Đà Nẵng', '0346006090'),
(N'Trần Mai', 0, '2023-02-10', N'Trường Chinh, TP.HCM', '0396006090'),
(N'Vũ Linh', 1, '2021-10-05', N'Hồ Chí Minh, Bình Dương', '0316006090'),
(N'Hoàng Lan', 0, '2020-12-20', N'Phú Nhuận, TP.HCM', '0326006090'),
(N'Trương Hòa', 1, '2023-04-15', N'Quận 5, TP.HCM', '0356006090'),
(N'Nguyễn Lan Anh', 0, '2021-01-01', N'Hà Đông, Hà Nội', '0376006090'),
(N'Phan Lâm', 1, '2022-11-11', N'Bình Thạnh, TP.HCM', '0386006090')
GO


-- INSERT
CREATE PROC insertCus
@NameCus NVARCHAR(50), @GenderCus BIT,
@DOBCus date, @AddrCus NVARCHAR(50), @PhoneCus VARCHAR(10)
AS
BEGIN
	INSERT INTO Customer(NameCus, GenderCus, DOBCus, AddrCus, PhoneCus)
	VALUES(@NameCus, @GenderCus, @DOBCus, @AddrCus, @PhoneCus)
END
GO
-- DELETE
CREATE PROC deleteCus
@IdCus INT
AS
BEGIN
    DELETE FROM Customer
    WHERE IdCus = @IdCus;
END
GO

--UPDATE
CREATE PROC UpdateCus
@IdCus INT, @NameCus NVARCHAR(50), @GenderCus BIT,
@DOBCus date, @AddrCus NVARCHAR(50), @PhoneCus VARCHAR(10)
AS
BEGIN
	UPDATE Customer
	SET NameCus = @NameCus, GenderCus = @GenderCus, DOBCus = @DOBCus, AddrCus = @AddrCus, PhoneCus = @PhoneCus
	WHERE IdCus = @IdCus
END
GO


-------------------------------PHẦN SUPPLIER ----------------------------------
CREATE PROC SelectSup
@pageNumber int,
@rowOfPage int
AS
BEGIN
    SELECT S.IdSup, S.NameSup, S.AddressSup, S.PhoneSup, S.AccNumSup, S.TINSup
	FROM Supplier AS S
	ORDER BY S.IdSup
   OFFSET (@pageNumber - 1) * @rowOfPage ROWS
    FETCH NEXT @rowOfPage ROWS ONLY;
END
GO

CREATE PROCEDURE countSup
AS
BEGIN
	SELECT COUNT(IdSup) total FROM Supplier
END
GO

INSERT INTO Supplier (NameSup, AddressSup, PhoneSup, AccNumSup, TINSup)
VALUES
(N'Công ty TNHH Tiki', N'Tòa nhà Pearl Plaza, TP.HCM', '0909876543', N'01765478563', '9865475231'),
(N'Công ty Cổ phần Thế Giới Di Động', N'Đường Lê Văn Lương, TP.HCM', '0912345678', N'01765478564', '9865475232'),
(N'Công ty Cổ phần FPT', N'Đường Phạm Văn Đồng, TP.HCM', '0901234567', N'01765478565', '9865475233'),
(N'Công ty TNHH Viettel', N'Đường Cộng Hòa, TP.HCM', '0934567890', N'01765478566', '9865475234'),
(N'Công ty CP VinGroup', N'Đường Vinhomes, Hà Nội', '0912345679', N'01765478567', '9865475235');
GO




-- INSERT
CREATE PROC insertSup
@NameSup NVARCHAR(50), @AddressSup NVARCHAR(50), @PhoneSup NVARCHAR(20),
@AccNumSup VARCHAR(20), @TINSUP VARCHAR(20)
AS
BEGIN
	INSERT INTO Supplier(NameSup, AddressSup, PhoneSup, AccNumSup, TINSup)
	VALUES(@NameSup, @AddressSup, @PhoneSup, @AccNumSup, @TINSup)
END
GO

-- DELETE
CREATE PROC deleteSup
@IdSup INT
AS
BEGIN
    DELETE FROM Supplier
    WHERE IdSup = @IdSup;
END
GO

--UPDATE
CREATE PROC UpdateSup
@IdSup INT, @NameSup NVARCHAR(50), @AddressSup NVARCHAR(50), @PhoneSup NVARCHAR(20),
@AccNumSup VARCHAR(20), @TINSUP VARCHAR(20)
AS
BEGIN
	UPDATE Supplier
	SET NameSup = @NameSup, AddressSup = @AddressSup, PhoneSup = @PhoneSup, AccNumSup = @AccNumSup, TINSUP = @TINSUP
	WHERE IdSup = @IdSup
END
GO

---------------------PHẦN COMMONITY ----------------------------------
INSERT INTO ProductCategory (NameProCate)
VALUES (N'Gia dụng'), (N'Thực phẩm'), (N'Gia vị'), (N'Mỹ Phẩm');
GO

-- Chèn dữ liệu vào bảng Product

INSERT INTO Product (IdProCate, namePro, AVTPro, BeginDate, EndDate, UnitPro, CostPro, QuantityPro, DiscountPro, VATPro,TotalCostPro,TotalDisPro)
VALUES 
(1, N'Snack Tôm', 'image/product/SnackTomOishi.jpg', '2023-01-01', '2023-12-31', N'Cái', 100000.0, 50, 0, 10,0,0),
(2, N'Cocacola', 'image/product/coca.jpg', '2023-01-01', '2023-12-31', N'Chai', 150000.0, 30, 0, 10,0,0),
(1, N'Pepsi', 'image/product/Pepsi.png', '2023-01-01', '2023-12-31', N'Chai', 200000.0, 20, 0, 10,0,0),
(2, N'Snack Khoai', 'image/product/potato.jpg', '2023-01-01', '2023-12-31', N'Cái', 250000.0, 40, 0, 10,0,0),
(2, N'sting', 'image/product/sting.jpg', '2023-01-01', '2023-12-31', N'Chai', 300000.0, 25, 0, 10,0,0),
(1, N'Snack Tôm', 'image/product/SnackTomOishi.jpg', '2023-01-01', '2023-12-31', N'Cái', 100000.0, 50, 0, 10,0,0),
(2, N'Cocacola', 'image/product/coca.jpg', '2023-01-01', '2023-12-31', N'Chai', 150000.0, 30, 0, 10,0,0),
(1, N'Pepsi', 'image/product/Pepsi.png', '2023-01-01', '2023-12-31', N'Chai', 200000.0, 20, 0, 10,0,0),
(2, N'Snack Khoai', 'image/product/potato.jpg', '2023-01-01', '2023-12-31', N'Cái', 250000.0, 40, 0, 10,0,0),
(2, N'sting', 'image/product/sting.jpg', '2023-01-01', '2023-12-31', N'Chai', 300000.0, 25, 0, 10,0,0)
GO 

--Select
CREATE PROC SelectPro
@pageNumber int,
@rowOfPage int
AS
BEGIN
    SELECT P.IdPro, P.NamePro, P.AVTPro, P.UnitPro, P.CostPro, P.BeginDate, p.EndDate, P.QuantityPro, P.DiscountPro, P.VATPro, P.TotalCostPro, P.TotalDisPro, PC.NameProCate AS NameProCate  
    FROM Product AS P
    INNER JOIN ProductCategory AS PC ON P.IdProCate = PC.IdProCate
    ORDER BY P.IdPro
    OFFSET (@pageNumber - 1) * @rowOfPage ROWS
    FETCH NEXT @rowOfPage ROWS ONLY;
END
GO

CREATE PROCEDURE countPro
AS
BEGIN
	SELECT COUNT(IdPro) total FROM Product
END
GO

CREATE PROCEDURE InsertPro
    @NamePro NVARCHAR(20),
    @NameProCate NVARCHAR(50),
    @BeginDate DATE,
    @EndDate DATE,
    @AvtPro VARCHAR(50),
    @UnitPro NVARCHAR(10),
    @CostPro FLOAT,
    @QuantityPro INT,
    @DiscountPro FLOAT,
    @VATPro FLOAT
AS
BEGIN
    -- Chèn dữ liệu vào bảng ProductCategory nếu tên danh mục sản phẩm chưa tồn tại
	DECLARE @IdProCate INT

	 -- Kiểm tra xem tên danh mục đã tồn tại chưa
    IF NOT EXISTS (SELECT 1 FROM ProductCategory WHERE NameProCate = @NameProCate)
        -- Nếu chưa tồn tại, thêm tên danh mục mới
        INSERT INTO ProductCategory (NameProCate)
        VALUES (@NameProCate);
    ELSE
        -- Nếu tên danh mục đã tồn tại, lấy Id của nó
        SELECT @IdProCate = IdProCate FROM ProductCategory WHERE NameProCate = @NameProCate;

		-- Chèn dữ liệu vào bảng Product
		INSERT INTO Product (NamePro, IdProCate, AvtPro, BeginDate, EndDate, UnitPro, CostPro, QuantityPro, DiscountPro, VATPro)
		VALUES (@NamePro, @IdProCate, @AvtPro, @BeginDate, @EndDate, @UnitPro, @CostPro, @QuantityPro, @DiscountPro, @VATPro);
	
	
END;
GO

CREATE PROCEDURE UpdatePro
    @IdPro INT,
    @NamePro NVARCHAR(20),
	@NameProCate NVARCHAR(50),
    @BeginDate DATE,
    @EndDate DATE,
	@AvtPro VARCHAR(50),
    @UnitPro NVARCHAR(10),
    @CostPro FLOAT,
    @QuantityPro INT,
    @DiscountPro FLOAT,
    @VATPro FLOAT

AS
BEGIN
	 DECLARE @IdProCate INT;

    -- Kiểm tra xem tên danh mục đã tồn tại chưa
    IF NOT EXISTS (SELECT 1 FROM ProductCategory WHERE NameProCate = @NameProCate)
        -- Nếu chưa tồn tại, thêm tên danh mục mới
        INSERT INTO ProductCategory (NameProCate)
        VALUES (@NameProCate);
    ELSE
        -- Nếu tên danh mục đã tồn tại, lấy Id của nó
        SELECT @IdProCate = IdProCate FROM ProductCategory WHERE NameProCate = @NameProCate;
   -- Cập nhật bảng Product
    UPDATE Product
    SET
        NamePro = @NamePro,
        AvtPro = @AvtPro,
        BeginDate = @BeginDate,
        EndDate = @EndDate,
        UnitPro = @UnitPro,
        CostPro = @CostPro,
        QuantityPro = @QuantityPro,
        DiscountPro = @DiscountPro,       
		IdProCate = @IdProCate
    WHERE
        IdPro = @IdPro;

	UPDATE Product
	SET
		VATPro = @VATPro
END
GO

CREATE PROCEDURE DeletePro
    @IdPro INT
AS
BEGIN
    -- Xóa sản phẩm từ bảng Product
    DELETE FROM Product WHERE IdPro = @IdPro;
END;
GO


CREATE PROC SelectProByCategory
@pageNumber int,
@rowOfPage int,
@NameProCate NVARCHAR(50)
AS
BEGIN
    SELECT P.IdPro, P.NamePro, P.AVTPro, P.UnitPro, P.CostPro, P.BeginDate, p.EndDate, P.QuantityPro, P.DiscountPro, P.VATPro, P.TotalCostPro, P.TotalDisPro, PC.NameProCate AS NameProCate  
    FROM Product AS P
    INNER JOIN ProductCategory AS PC ON P.IdProCate = PC.IdProCate
	WHERE PC.NameProCate = @NameProCate
    ORDER BY P.IdPro
    OFFSET (@pageNumber - 1) * @rowOfPage ROWS
    FETCH NEXT @rowOfPage ROWS ONLY;
END
GO

CREATE PROC DiscountByCategory
@NameProCate NVARCHAR(50),
@DiscountPro FLOAT
AS
BEGIN
	  DECLARE @IdProCate INT;

    -- Kiểm tra xem tên danh mục đã tồn tại chưa
    IF NOT EXISTS (SELECT 1 FROM ProductCategory WHERE NameProCate = @NameProCate)
    BEGIN
        -- Nếu chưa tồn tại, báo lỗi
        THROW 50000, 'The product category does not exist', 1;
        RETURN;
    END
    ELSE
    BEGIN
        -- Nếu tên danh mục đã tồn tại, lấy Id của nó
        SELECT @IdProCate = IdProCate 
		FROM ProductCategory 
		WHERE NameProCate = @NameProCate;
    END

    -- Cập nhật bảng Product
    UPDATE Product
    SET
        DiscountPro = @DiscountPro 
    WHERE IdProCate = @IdProCate;

END
GO


-------------------------EMPLOYEE------------------------------


-- Chèn dữ liệu vào bảng Employee
INSERT INTO Employee (NameEmp, GenderEmp, DOBEmp, AddrEmp, PhoneEmp, Email, UserName, Pass, Authority)
VALUES (N'Như Bảo', 0, '1990-05-15', N'15 Phạm Văn Đồng, Quận Gò Vấp', '1234567890', 'nhubao123@gmail.com', 'van.a', 'Baoatm123@', 'Manager'),
       (N'Thị Bích', 1, '1992-08-20', N'30 Nguyễn Thị Minh Khai, Quận 1', '0987654321', 'thibich@gmail.com', 'thi.b', 'Abc1234@', 'Stockman'),
       (N'Trần Quang', 0, '1985-12-10', N'25 Lê Văn Sỹ, Quận 3', '0123456789', 'tranquang@gmail.com', 'van.c', 'Pass456@', 'Manager'),
       (N'Lê Mai', 1, '1991-03-25', N'10 Cộng Hòa, Quận Tân Bình', '0987123456', 'lemai@gmail.com', 'thi.d', 'Qwerty789@', 'Manager'),
       (N'Như Bảo', 0, '1990-05-15', N'15 Phạm Văn Đồng, Quận Gò Vấp', '1234567890', 'nhubao2@gmail.com', 'van.a', 'Password123@', 'Salesman'),
       (N'Thị Bích', 1, '1992-08-20', N'30 Nguyễn Thị Minh Khai, Quận 1', '0987654321', 'thibich2@gmail.com', 'thi.b', 'Abc12345@', 'Salesman'),
       (N'Trần Quang', 0, '1985-12-10', N'25 Lê Văn Sỹ, Quận 3', '0123456789', 'tranquang2@gmail.com', 'van.c', 'Pass4567@', 'Salesman'),
       (N'Lê Mai', 1, '1991-03-25', N'10 Cộng Hòa, Quận Tân Bình', '0987123456', 'lemai2@gmail.com', 'thi.d', 'Qwerty123@', 'Salesman'),
       (N'Như Bảo', 0, '1990-05-15', N'15 Phạm Văn Đồng, Quận Gò Vấp', '1234567890', 'nhubao3@gmail.com', 'van.a', 'Password789@', 'Stockman'),
       (N'Thị Bích', 1, '1992-08-20', N'30 Nguyễn Thị Minh Khai, Quận 1', '0987654321', 'thibich3@gmail.com', 'thi.b', 'Abc123678@', 'Stockman'),
       (N'Trần Quang', 0, '1985-12-10', N'25 Lê Văn Sỹ, Quận 3', '0123456789', 'tranquang3@gmail.com', 'van.c', 'Pass45689@', 'Stockman'),
       (N'Lê Mai', 1, '1991-03-25', N'10 Cộng Hòa, Quận Tân Bình', '0987123456', 'lemai3@gmail.com', 'thi.d', 'Qwerty789@', 'Stockman');
GO



CREATE PROC SelectEmp
@pageNumber int,
@rowOfPage int
AS
BEGIN
    SELECT e.IdEmp, e.NameEmp, e.GenderEmp, e.DOBEmp, e.AddrEmp, e.PhoneEmp, e.Email, e.UserName , e.Pass, e.Authority
	FROM Employee AS e
	ORDER BY e.IdEmp
   OFFSET (@pageNumber - 1) * @rowOfPage ROWS
    FETCH NEXT @rowOfPage ROWS ONLY;
END
GO

CREATE PROCEDURE countEmp
AS
BEGIN
	SELECT COUNT(IdEmp) total FROM Employee
END
GO


-- INSERT
CREATE PROC insertEmp
	@NameEmp NVARCHAR(50),
    @GenderEmp BIT,
    @DOBEmp DATE,
    @AddrEmp NVARCHAR(100),
    @PhoneEmp NVARCHAR(10),
    @Email VARCHAR(30),
    @UserName VARCHAR(20),
    @Pass VARCHAR(25),
    @Authority VARCHAR(25)
AS
BEGIN
	INSERT INTO Employee(NameEmp, GenderEmp, DOBEmp, AddrEmp, PhoneEmp,Email, UserName,	Pass, Authority )
	VALUES(@NameEmp, @GenderEmp, @DOBEmp, @AddrEmp, @PhoneEmp, @Email, @UserName, @Pass, @Authority )
END
GO

-- DELETE
CREATE PROC deleteEmp
@IdEmp INT
AS
BEGIN
    DELETE FROM Employee
    WHERE IdEmp = @IdEmp;
END
GO

--UPDATE
CREATE PROC UpdateEmp
	@IdEmp INT,
	@NameEmp NVARCHAR(50),
    @GenderEmp BIT,
    @DOBEmp DATE,
    @AddrEmp NVARCHAR(100),
    @PhoneEmp NVARCHAR(10)
    
AS
BEGIN
	UPDATE Employee
    SET NameEmp = @NameEmp,
        GenderEmp = @GenderEmp,
        DOBEmp = @DOBEmp,
        AddrEmp = @AddrEmp,
        PhoneEmp = @PhoneEmp
        
    WHERE IdEmp = @IdEmp;
END
GO

-----------------BILL-----------------------
CREATE PROCEDURE CreateBill
    @NameCus NVARCHAR(50),
    @PhoneCus NVARCHAR(10),
    @NameBill NVARCHAR(10)
AS
BEGIN
    DECLARE @IdCus INT

    -- Kiểm tra xem khách hàng đã tồn tại trong bảng Customer hay chưa
    IF NOT EXISTS (SELECT 1 FROM Customer WHERE NameCus = @NameCus AND PhoneCus = @PhoneCus)
    BEGIN
        -- Nếu không tìm thấy khách hàng, thêm mới vào bảng Customer
        INSERT INTO Customer (NameCus, PhoneCus, DOBCus, AddrCus)
        VALUES (@NameCus, @PhoneCus, GETDATE(), 'unknown')

        -- Lấy Id của khách hàng vừa thêm mới
        SET @IdCus = SCOPE_IDENTITY()
    END
    ELSE
    BEGIN
        -- Nếu khách hàng đã tồn tại, lấy Id của khách hàng đó từ bảng Customer
        SELECT @IdCus = IdCus FROM Customer WHERE NameCus = @NameCus AND PhoneCus = @PhoneCus;
    END

    -- Thêm hóa đơn vào bảng Bill với ngày hiện tại và Id của khách hàng
    INSERT INTO Bill (DateBill, IdCus, NameBill)
    VALUES (GETDATE(), @IdCus, @NameBill)
END
GO

CREATE PROCEDURE SelectDetailBill
@NameBill NVARCHAR(10)
AS
BEGIN
    SELECT DB.IdDBill, DB.PriceDB, DB.QuantityDB, DB.TotalMoneyDB, P.NamePro, P.IdPro
    FROM DetailBill AS DB
    INNER JOIN Bill AS B ON DB.IdBill = B.IdBill
    INNER JOIN Product AS P ON DB.IdPro = P.IdPro
    WHERE B.NameBill = @NameBill;
END
GO


CREATE PROCEDURE InsertDetailBill
@IdPro INT,
@Quantity INT,
@Namebill NVARCHAR(10)
AS
BEGIN
	DECLARE @IdBill INT;
	DECLARE @TotalDisPro FLOAT;
	DECLARE @TotalMoney FLOAT;

	-- Kiểm tra sự trùng lặp của idPro cho cùng một nameBill
    IF EXISTS (SELECT 1 FROM DetailBill WHERE idPro = @IdPro AND idBill = (SELECT IdBill FROM Bill WHERE NameBill = @Namebill))
    BEGIN
        -- Trả về lỗi nếu có sự trùng lặp
        THROW 50000, 'Duplicate for the same IDPro. Cannot insert.', 1;
        RETURN;
    END

	-- Lấy thông tin sản phẩm dựa trên IdPro
    SELECT @TotalDisPro =  TotalDisPro
    FROM Product
    WHERE IdPro = @IdPro

    -- Cập nhật số lượng sản phẩm trong bảng Product
    UPDATE Product
    SET QuantityPro = QuantityPro - @Quantity
    WHERE IdPro = @IdPro;

	-- Lấy IdBill dựa trên NameBill
    SELECT @IdBill = IdBill
    FROM Bill
    WHERE NameBill = @Namebill;

   	-- Insert dữ liệu vào bảng DetailBill
    INSERT INTO DetailBill (IdBill, IdPro, PriceDB, QuantityDB, TotalMoneyDB)
    VALUES (@IdBill, @IdPro, @TotalDisPro, @Quantity, @TotalDisPro * @Quantity);

	-- Tính tổng tiền cho hóa đơn dựa trên IdBill
	SELECT @TotalMoney = SUM(TotalMoneyDB)
    FROM DetailBill
    WHERE IdBill = @IdBill;

	 -- Cập nhật TotalMoneyBill trong bảng Bill
    UPDATE Bill
    SET TotalMoneyBill = @TotalMoney
    WHERE IdBill = @IdBill;

END
GO

CREATE PROCEDURE DeleteDetailBill
@IdPro INT,
@NameBill NVARCHAR(50),
@Quantity INT
AS
BEGIN
    DECLARE @IdBill INT;

    -- Lấy IdBill từ NameBill
    SELECT @IdBill = IdBill
    FROM Bill
    WHERE NameBill = @NameBill;

    -- Xóa dữ liệu từ bảng DetailBill dựa trên IdBill và IdPro
    DELETE FROM DetailBill
    WHERE IdBill = @IdBill AND IdPro = @IdPro;

	UPDATE Product
    SET QuantityPro = QuantityPro + @Quantity
    WHERE IdPro = @IdPro;

END
GO

CREATE PROCEDURE UpdateDetailBill
@IdPro INT,
@NameBill NVARCHAR(50),
@Quantity INT
AS
BEGIN
    DECLARE @IdBill INT;
	DECLARE @TotalDisPro FLOAT;

    -- Lấy IdBill từ NameBill
    SELECT @IdBill = IdBill
    FROM Bill
    WHERE NameBill = @NameBill;

	-- Lấy thông tin sản phẩm dựa trên IdPro
    SELECT @TotalDisPro =  TotalDisPro
    FROM Product
    WHERE IdPro = @IdPro

	 -- Cập nhật số lượng chi tiết hóa đơn trong bảng DetailBill
    UPDATE DetailBill
    SET QuantityDB = @Quantity,
		TotalMoneyDB = @TotalDisPro * @Quantity
    WHERE IdBill = @IdBill AND IdPro = @IdPro;

END
GO

CREATE PROCEDURE getDetailBill
@NameBill NVARCHAR(10)
AS
BEGIN
    SELECT DB.IdDBill, DB.PriceDB, DB.QuantityDB, DB.TotalMoneyDB, P.NamePro, P.DiscountPro, B.TotalMoneyBill
    FROM DetailBill AS DB
    INNER JOIN Bill AS B ON DB.IdBill = B.IdBill
    INNER JOIN Product AS P ON DB.IdPro = P.IdPro

	SELECT C.NameCus, C.PhoneCus
	FROM Bill AS B
	 INNER JOIN Customer AS C ON C.NameCus = C.PhoneCus
	WHERE B.NameBill = @NameBill;
END
GO	

