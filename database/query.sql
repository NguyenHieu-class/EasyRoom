CREATE DATABASE EasyRoom;

CREATE TABLE district (
    idDistrict INT PRIMARY KEY IDENTITY(1,1),
    nameDistrict NVARCHAR(255),
    createDate DATE,
    updateDate DATE,
    id_province INT
);

CREATE TABLE event (
    idEvent INT PRIMARY KEY IDENTITY(1,1),
    dateStartEvent NVARCHAR(255),
    dateEndEvent NVARCHAR(255),
    titleEvent NVARCHAR(500),
    contentEvent NVARCHAR(500),
    discount INT,
    createDate DATE,
    updateDate DATE
);

CREATE TABLE guidetowork (
    id INT PRIMARY KEY IDENTITY(1,1),
    content NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE insurance (
    idInsurance INT PRIMARY KEY IDENTITY(1,1),
    nameInsurance NVARCHAR(255),
    imageInsurance NVARCHAR(255),
    contentInsurance NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE notification (
    idNoti INT PRIMARY KEY IDENTITY(1,1),
    image NVARCHAR(255),
    titleNoti NVARCHAR(500),
    contentNoti NVARCHAR(2000),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE paymentbill (
    idPayment INT PRIMARY KEY IDENTITY(1,1),
    nameBank NVARCHAR(255),
    bankTranNo NVARCHAR(255),
    responseCode NVARCHAR(255),
    amountBill INT,
    id_user INT
);

CREATE TABLE policyandterms (
    idPolicy INT PRIMARY KEY IDENTITY(1,1),
    titlePolicy NVARCHAR(255),
    contentPolicy NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE province (
    idProvince INT PRIMARY KEY IDENTITY(1,1),
    nameProvince NVARCHAR(255),
    zipCode INT,
    imgProvince NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE requestwithdrawal (
    idRequest INT PRIMARY KEY IDENTITY(1,1),
    nameBank NVARCHAR(500),
    accountNumber NVARCHAR(255),
    nameAccount NVARCHAR(255),
    moneyNumber INT,
    statusRequest INT,
    createDate DATE,
    updateDate DATE,
    id_user INT
);

CREATE TABLE resuftpayment (
    status NVARCHAR(255),
    message NVARCHAR(255),
    url NVARCHAR(255)
);

CREATE TABLE role (
    idRole INT PRIMARY KEY IDENTITY(1,1),
    nameRole NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE room (
    idRoom INT PRIMARY KEY IDENTITY(1,1),
    title NVARCHAR(255),
    description NVARCHAR(4000),
    polyUseRoom NVARCHAR(4000),
    addressRoom NVARCHAR(1000),
    avatarRoom NVARCHAR(255),
    imageRoom NVARCHAR(4000),
    videoRoom NVARCHAR(1000),
    rentalType BIT,
    price INT,
    promotionalPrice INT,
    oldPromotionalPrice INT,
    deposit INT,
    area FLOAT,
    capacity INT,
    isAvailable BIT,
    createdAt DATETIME,
    updatedAt DATETIME,
    numberOfLivingRooms INT,
    numberOfBedrooms INT,
    numberOfBathrooms INT,
    numberOfKitchens INT,
    isBathroomShared BIT,
    isKitchenShared BIT,
    isWashingMachineShared BIT,
    isKitchensShare BIT,
    hasBed BIT,
    hasWardrobe BIT,
    hasDesk BIT,
    hasChair BIT,
    hasBookshelf BIT,
    hasRefrigerator BIT,
    hasWashingMachine BIT,
    hasAirConditioning BIT,
    hasFan BIT,
    hasTelevision BIT,
    hasMicrowave BIT,
    hasStove BIT,
    hasWaterHeater BIT,
    hasDiningTable BIT,
    hasMezzanine BIT,
    hasPrivateBathroom BIT,
    hasSharedBathroom BIT,
    hasPrivateShower BIT,
    hasSharedShower BIT,
    hasWifi BIT,
    hasParking BIT,
    hasElevator BIT,
    hasSecurityCamera BIT,
    hasFlexibleHours BIT,
    isOwnerLivingIn BIT,
    hasCleaningService BIT,
    isNearSchool BIT,
    isNearMarket BIT,
    isNearHospital BIT,
    isNearBusStation BIT,
    isInSafeArea BIT,
    hasSeparateElectricityMeter BIT,
    electricityPrice INT,
    hasSeparateWaterMeter BIT,
    waterPrice INT,
    hasRecyclingService BIT,
    hasEVCharging BIT,
    createDate DATE,
    updateDate DATE,
    id_roomType INT,
    id_user INT
);

CREATE TABLE roomtype (
    idRoomType INT PRIMARY KEY IDENTITY(1,1),
    nameType NVARCHAR(255),
    description NVARCHAR(4000),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE users (
    idUser INT PRIMARY KEY IDENTITY(1,1),
    username NVARCHAR(255),
    password NVARCHAR(255),
    nameDisplay NVARCHAR(255),
    image NVARCHAR(255),
    phone NVARCHAR(255),
    email NVARCHAR(255),
    address NVARCHAR(4000),
    city NVARCHAR(255),
    district NVARCHAR(255),
    ward NVARCHAR(255),
    dateOfBrith NVARCHAR(255),
    citizenId NVARCHAR(255),
    citizenIdQRImage NVARCHAR(255),
    sex BIT,
    createDate DATE,
    updateDate DATE,
    totalMoney INT,
    id_role INT
);

CREATE TABLE ward (
    idWard INT PRIMARY KEY IDENTITY(1,1),
    nameWard NVARCHAR(255),
    createDate DATE,
    updateDate DATE,
    id_district INT
);

CREATE TABLE blog (
    idBlog INT PRIMARY KEY IDENTITY(1,1),
    titleBlog NVARCHAR(400),
    describeBlog NVARCHAR(1000),
    imageBlog NVARCHAR(255),
    contentBlog NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE booking (
    idBooking INT PRIMARY KEY IDENTITY(1,1),
    phone NVARCHAR(255),
    address NVARCHAR(255),
    statusBill INT,
    dateStart DATE,
    dateEnd DATE,
    billTotal INT,
    createDate DATE,
    updateDate DATE,
    id_room INT,
    id_user INT
);

CREATE TABLE contract (
    idContract INT PRIMARY KEY IDENTITY(1,1),
    titleContract NVARCHAR(255),
    nameFile NVARCHAR(255),
    createDate DATE,
    updateDate DATE
);

CREATE TABLE detailnotification (
    idDetailNoti INT PRIMARY KEY IDENTITY(1,1),
    statusRead INT,
    url NVARCHAR(400),
    id_user INT,
    id_notification INT
);


-- Add Foreign Key Constraints
ALTER TABLE district
ADD CONSTRAINT FK_district_province FOREIGN KEY (id_province)
REFERENCES province(idProvince);
ALTER TABLE paymentbill
ADD CONSTRAINT FK_paymentbill_users FOREIGN KEY (id_user)
REFERENCES users(idUser);
ALTER TABLE requestwithdrawal
ADD CONSTRAINT FK_requestwithdrawal_users FOREIGN KEY (id_user)
REFERENCES users(idUser);
ALTER TABLE room
ADD CONSTRAINT FK_room_roomtype FOREIGN KEY (id_roomType)
REFERENCES roomtype(idRoomType);
ALTER TABLE room
ADD CONSTRAINT FK_room_users FOREIGN KEY (id_user)
REFERENCES users(idUser);
ALTER TABLE users
ADD CONSTRAINT FK_users_role FOREIGN KEY (id_role)
REFERENCES role(idRole);
ALTER TABLE ward
ADD CONSTRAINT FK_ward_district FOREIGN KEY (id_district)
REFERENCES district(idDistrict);
ALTER TABLE booking
ADD CONSTRAINT FK_booking_room FOREIGN KEY (id_room)
REFERENCES room(idRoom);
ALTER TABLE booking
ADD CONSTRAINT FK_booking_users FOREIGN KEY (id_user)
REFERENCES users(idUser);
ALTER TABLE detailnotification
ADD CONSTRAINT FK_detailnotification_users FOREIGN KEY (id_user)
REFERENCES users(idUser);
ALTER TABLE detailnotification
ADD CONSTRAINT FK_detailnotification_notification FOREIGN KEY (id_notification)
REFERENCES notification(idNoti);