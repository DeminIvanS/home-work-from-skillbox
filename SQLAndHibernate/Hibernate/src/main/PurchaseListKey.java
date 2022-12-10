import jakarta.persistence.Column;
import java.io.Serializable;

    public class PurchaseListKey implements Serializable {

        @Column(name = "student_name")
        String studentName;

        @Column(name = "Course_name")
        String courseName;


        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }


    }
