package com.project.EasyRoom.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    public Room(int id_room){
            this.idRoom = id_room;
        }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoom;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String title; // Tiêu đề phòng

    @Column(columnDefinition = "nvarchar(4000)")
    private String description; // Mô tả chi tiết

    @Column(columnDefinition = "nvarchar(4000)")
	private String polyUseRoom; // Quy định sử dụng phòng

	@Column(columnDefinition = "nvarchar(1000)")
	private String addressRoom; // Địa chỉ phòng

	@Column(columnDefinition = "nvarchar(200)")
	private String avatarRoom; // Ảnh đại diện phòng

	@Column(columnDefinition = "nvarchar(4000)")
	private String imageRoom; // Ảnh phòng

    @Column(columnDefinition = "nvarchar(1000)")
    private String videoRoom; // Video giới thiệu phòng

    @Column(columnDefinition = "boolean default false")
    private boolean rentalType; // Loại thuê (0: theo tháng, 1: theo năm)

    private int price;  // Giá thuê phòng (đơn vị: đồng)
	private int promotionalPrice;   // Giá thuê phòng khuyến mãi (đơn vị: đồng)
	@Column(columnDefinition = "int default 0")
	private int oldPromotionalPrice;    // Giá thuê phòng cũ (đơn vị: đồng)

    private int deposit; // Tiền cọc
    private double area; // Diện tích (m²)
    private int capacity; // Sức chứa tối đa

    private Boolean isAvailable; // Trạng thái phòng

    private LocalDateTime createdAt; // Ngày tạo
    private LocalDateTime updatedAt; // Ngày cập nhật

    // Số lượng các loại phòng
    private int numberOfLivingRooms; // Số phòng khách
    private int numberOfBedrooms; // Số phòng ngủ
    private int numberOfBathrooms; // Số phòng tắm
    private int numberOfKitchens; // Số phòng bếp

    // Trạng thái sử dụng chung hay riêng
    private Boolean isBathroomShared; // Phòng tắm dùng chung?
    private Boolean isKitchenShared; // Phòng bếp dùng chung?
    private Boolean isWashingMachineShared; // Máy giặt dùng chung?
    private Boolean isKitchensShare; // Phòng bếp dùng chung?

    // Tiện nghi phổ biến
    private Boolean hasBed; // Giường ngủ
    private Boolean hasWardrobe; // Tủ quần áo
    private Boolean hasDesk; // Bàn làm việc/học tập
    private Boolean hasChair; // Ghế ngồi
    private Boolean hasBookshelf; // Kệ sách/kệ để đồ
    private Boolean hasRefrigerator; // Tủ lạnh
    private Boolean hasWashingMachine; // Máy giặt
    private Boolean hasAirConditioning; // Máy lạnh (điều hòa)
    private Boolean hasFan; // Quạt điện/quạt trần
    private Boolean hasTelevision; // Tivi
    private Boolean hasMicrowave; // Lò vi sóng
    private Boolean hasStove; // Bếp điện/bếp gas
    private Boolean hasWaterHeater; // Bình nước nóng
    private Boolean hasDiningTable; // Bàn ăn
    private Boolean hasMezzanine; // Gác lửng

    // Khu vực vệ sinh
    private Boolean hasPrivateBathroom; // Nhà vệ sinh riêng
    private Boolean hasSharedBathroom; // Nhà vệ sinh chung
    private Boolean hasPrivateShower; // Phòng tắm riêng
    private Boolean hasSharedShower; // Phòng tắm chung

    // Tiện ích chung
    private Boolean hasWifi; // Wi-Fi/internet
    private Boolean hasParking; // Chỗ để xe
    private Boolean hasElevator; // Thang máy
    private Boolean hasSecurityCamera; // Camera an ninh
    private Boolean hasFlexibleHours; // Giờ giấc tự do
    private Boolean isOwnerLivingIn; // Có chung chủ
    private Boolean hasCleaningService; // Dịch vụ dọn dẹp

    // Vị trí & Môi trường xung quanh
    private Boolean isNearSchool; // Gần trường học
    private Boolean isNearMarket; // Gần chợ/siêu thị
    private Boolean isNearHospital; // Gần bệnh viện/phòng khám
    private Boolean isNearBusStation; // Gần bến xe/trạm xe buýt
    private Boolean isInSafeArea; // Khu vực an ninh cao

    // Các yếu tố khác
    private Boolean hasSeparateElectricityMeter; // Đồng hồ điện riêng
    private int electricityPrice; // Giá điện (đồng hồ riêng)
    private Boolean hasSeparateWaterMeter; // Đồng hồ nước riêng
    private int waterPrice; // Giá nước (đồng hồ riêng)
    private Boolean hasRecyclingService; // Dịch vụ thu rác
    private Boolean hasEVCharging; // Trạm sạc xe điện

    private Date createDate;
	private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_roomType")
    @JsonIgnore
    private RoomType roomType; // Loại phòng

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private User user;  // Chủ sở hữu phòng

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<Booking> booking; // Danh sách đặt phòng
    
}
