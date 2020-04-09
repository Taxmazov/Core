package dev.more.core.moreappcore.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "User_entity",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "user_uid"})})

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_nick_name")
    @NotNull(message = "Please enter the a nickName")
    private String nickName;
    @Column(name = "user_name")
    @NotNull(message = "Please enter the a userName")
    private String userName;
    @Column(name = "user_phone")
    @NotNull(message = "Please  enter  userPhone")
    private String userPhone;
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
    @CreationTimestamp
    @Column(name = "user_uid")
    private Date uid;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "pic", column = @Column(length = 800000000))
    })
    private UserImage userImage;

    public UserEntity() {
    }

    public UserEntity(String nickName, String userName, String userPhone, UserType userType, UserImage userImage) {
        this.nickName = nickName;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userType = userType;
        this.userImage = userImage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Long getUid() {
        return uid.getTime();
    }

    public void setUid(Date uid) {
        this.uid = uid;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserImage getUserImage() {
        return userImage;
    }

    public void setUserImage(UserImage userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userType=" + userType +
                ", userCreated=" + uid +
                '}';
    }
}
