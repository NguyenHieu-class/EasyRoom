package com.project.EasyRoom.model;

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

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(name = "username", columnDefinition = "nvarchar(30) not null", unique = true)
	private String username;
	
	@Column(name = "password", columnDefinition = "nvarchar(200) not null")
	private String password;
	
	@Column(columnDefinition = "nvarchar(200) not null")
	private String nameDisplay;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String image;
	
	@Column(columnDefinition = "nvarchar(12)")
	private String phone;
	
	@Column(columnDefinition = "nvarchar(30)")
	private String email;

    @Column(columnDefinition = "nvarchar(4000) not null")
    private String address; // Địa chỉ

    @Column(columnDefinition = "nvarchar(12)")
	private String dateOfBrith;
	
	@Column(columnDefinition = "nvarchar(20)")
	private String citizenId;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String citizenIdQRImage;

    private boolean sex;
	
	private Date createDate;
	private Date updateDate; 

    @Column(columnDefinition = "integer default 0")
	private int totalMoney;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Room> rooms;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
	@JsonIgnore
	private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Booking> booking;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<PaymentBill> paymentBills ;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<RequestWithdrawal> requestWithdrawals ;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<DetailNotification> detailNotifications ;
}
