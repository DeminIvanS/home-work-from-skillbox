
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey key;

    @Column(name = "student_name", insertable = false,updatable = false)
    private int studentName;

    @Column(name = "course_name", insertable = false,updatable = false)
    private int courseName;

    @Column(columnDefinition = "int")
    private int price;
    @Column(name = "subscription_date",columnDefinition = "datetime")
    private Date subscriptionDate;

    public PurchaseListKey getKey() {
        return key;
    }

    public void setId(PurchaseListKey key) {
        this.key = key;
    }

    public int getStudentName() {
        return studentName;
    }

    public void setStudentName(int studentName) {
        this.studentName = studentName;
    }

    public int getCourseName() {
        return courseName;
    }

    public void setCourseName(int courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public void setKey(PurchaseListKey key) {
        this.key = key;
    }

}

