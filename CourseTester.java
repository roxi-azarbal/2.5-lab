// REQ 03: answer after REQ 02
/*
 * 1. new StudentRecord("Dana Lee") runs a constructor whose only line
 *    is this(name, new int[0]). Which constructor's body finishes
 *    first? Why does only the two-parameter constructor need to set
 *    name and scores?
 *  ==>
 *    Answer: The two parameter constructor's body finishes first. 
 *              Only the two-parameter constructor needs to set name 
 *              and scores because the one parameter constructor just runs the two-parameter constructor.
 *
 * 2. StudentRecord will have both getAverage() and
 *    getAverage(int first, int last). Why does Java allow two methods
 *    with the same name? Why would it reject a third method,
 *    public int getAverage()?
 * ==>
 *    Answer: Java allows two methods with the same name because it distinguishes overloaded methods by the number, types, and order of their parameters, rather than their return types. Java would reject public int getAverage() because it has the same name and parameter list as getAverage(). having different return types alone isn't enough to distinguish two overloaded methods.
 */
public class CourseTester {
    public static void main(String[] args) {

        // TEST 02

        StudentRecord john = new StudentRecord("John Doe", new int[] { 80, 90, 100, 95 });
        System.out.println("john.getName() (expect John Doe): " + john.getName());
        StudentRecord dana = new StudentRecord("Dana Lee");
        System.out.println("dana.getScores().length (expect 0): " + dana.getScores().length);

        // TEST 04

        System.out.println("john.getTestScore() (expect 100): " + john.getTestScore(2));

        // TEST 05

        StudentRecord mia = new StudentRecord("Mia Ross", new int[] { 70, 80, 90, 100 });
        System.out.println("mia.toString() (expect \"Mia Ross's scores: [70, 80, 90, 100]\"): " + mia.toString());

        // TEST 06

        StudentRecord bob = new StudentRecord("Bob Brown", new int[] { 90, 85, 80, 75 });
        System.out.println("bob.getAverage(2, 3) (expect 77.5): " + bob.getAverage(2, 3));

        // TEST 07

        System.out.println("bob.getAverage() (expect 82.5): " + bob.getAverage());

        // TEST 08

        StudentRecord kai = new StudentRecord("Kai Moss", new int[] { 70, 75, 80, 85 });
        System.out.println("kai.hasImproved() (expect true): " + kai.hasImproved());

        // TEST 09

        System.out.println("bob.getFinalAverage() (expect 82.5): " + bob.getFinalAverage());

        // TEST 10

        StudentRecord charlie = new StudentRecord("Charlie Brown", new int[] { 93, 95, 97 });
        StudentRecord eva = new StudentRecord("Eva White", new int[] { 92, 94, 91 });
        StudentRecord frank = new StudentRecord("Frank Black", new int[] { 75, 80, 85 });
        StudentRecord[] roster = { charlie, eva, frank };
        Course math = new Course("Mathematics", roster);
        Course biology = new Course("Biology");

        System.out.println("math.getCourseName() (expect \"Mathematics\"): " + math.getCourseName());
        System.out.println("math.getEnrolledStudents() (expect \"roster\"): " + math.getEnrolledStudents());
        System.out.println("biology.getCourseName() (expect \"Biology\"): " + biology.getCourseName());
        System.out.println("biology.getEnrolledStudents() (expect \"0\"): " + biology.getEnrolledStudents());

        // TEST 11
        System.out.println(
                "math.toString() (expect \"== Mathematics ==\\n1.) Charlie Brown's scores: [93, 95, 97]\\n2.) Eva White's scores: [92, 94, 91]\\n3.) Frank Black's scores: [75, 80, 85]\\n\"): "
                        + math.toString());

        // TEST 12
        System.out.println("math.findBestStudent() (expect \"Charlie Brown\"): " + math.findBestStudent());

        // TEST 13
        System.out.println(
                "math.calculateTestAverage(0) (expect \"86.66666666666667\"): " + math.calculateTestAverage(0));

        // STRETCH

    }
}