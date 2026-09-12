public class MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {
        int sum = 0;

        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result.append("Match ").append(i + 1).append(": Power Surge");
            } else {
                result.append("Match ").append(i + 1).append(": Normal");
            }

            if (i < runsPerOver.length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {8, 10, 12},
            {4, 6, 5, 7},
            {15, 14, 13}
        };

        System.out.println(classifyMatches(runsPerOver, 10));
    }
}