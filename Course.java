public class Course {
    private String courseName;
    private StudentRecord[] enrolledStudents;

    public Course(String courseName, StudentRecord[] enrolledStudents) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
    }

    public Course(String courseName) {
        this(courseName, new StudentRecord[0]);
    }

    public String getCourseName() {
        return courseName;
    }

    public StudentRecord[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public String toString() {
        String result = "== " + courseName + " ==\n";
        for (int i = 0; i < enrolledStudents.length; i++) {
            result += enrolledStudents[i].toString() + "\n"; // need diff format here?
        }
        return result;
    }

    public String findBestStudent() {
        StudentRecord best = enrolledStudents[0];
        for (int i = 1; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i].getFinalAverage() > best.getFinalAverage()) {
                best = enrolledStudents[i];
            }
        }

        return best.getName();
    }

    public double calculateTestAverage(int testNumber) {
        int sum = 0;

        for (int i = 0; i < enrolledStudents.length; i++) {
            sum += enrolledStudents[i].getTestScore(testNumber);
        }

        return (double) sum / enrolledStudents.length;
    }

    public void addStudent(StudentRecord newStudent) {
        if (newStudent == null) {
            return;
        }

        StudentRecord[] newArray = new StudentRecord[enrolledStudents.length + 1];

        for (int i = 0; i < enrolledStudents.length; i++) {
            newArray[i] = enrolledStudents[i];
        }

        newArray[newArray.length - 1] = newStudent;
        enrolledStudents = newArray;
    }

    public void addStudent(String name, int[] scores) {
        addStudent(new StudentRecord(name, scores));
    }
}
