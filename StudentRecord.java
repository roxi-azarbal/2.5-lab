public class StudentRecord {
    private String name;
    private int[] scores;

    public StudentRecord(String name, int[] scores) {
        this.name = name;

        if (scores == null) {
            this.scores = new int[0];
            // this.scores = scores; //even need?
        } else {
            this.scores = scores;
        }
    }

    public StudentRecord(String name) { // constructor overloading
        this(name, new int[0]);
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }

    public int getTestScore(int testNumber) {
        if (testNumber > scores.length - 1 || testNumber < 0) {
            return -1;
        }

        return scores[testNumber];
    }

    public String toString() {
        String result = name + "'s scores: " + "[";

        for (int i = 0; i < scores.length; i++) {
            result += scores[i];
            if (i < scores.length - 1) {
                result += ", ";
            }
        }

        return result + "]";
    }

    public double getAverage(int first, int last) {
        int sum = 0;
        int count = 0;
        for (int i = first; i <= last; i++) {
            sum += scores[i];
            count++;
        }
        return (double) sum / count;
    }

    public double getAverage() {
        if (scores.length == 0) {
            return 0.0;
        }
        return getAverage(0, scores.length - 1);
    }

    public boolean hasImproved() {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public double getFinalAverage() {
        if (scores.length == 0) {
            return 0.0;
        }
        if (hasImproved()) {
            return getAverage(scores.length / 2, scores.length - 1);
        } else {
            return getAverage();
        }
    }
}
