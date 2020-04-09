package dev.more.core.moreappcore.entity;

import javax.persistence.Embeddable;

@Embeddable
public class UserImage {

    private String imageName;

    private String type;

    private byte[] pic;

    public UserImage() {
    }

    public UserImage(String imageName, String type, byte[] pic) {
        this.imageName = imageName;
        this.type = type;
        this.pic = pic;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
