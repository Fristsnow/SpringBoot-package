package org.lucky.kfirstsnowluckyadmin.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName book
 */
@Data
public class Book implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String book;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String plane;

    /**
     *
     */
    private Date date;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBook() == null ? other.getBook() == null : this.getBook().equals(other.getBook()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPlane() == null ? other.getPlane() == null : this.getPlane().equals(other.getPlane()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBook() == null) ? 0 : getBook().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPlane() == null) ? 0 : getPlane().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", book=").append(book);
        sb.append(", name=").append(name);
        sb.append(", plane=").append(plane);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
