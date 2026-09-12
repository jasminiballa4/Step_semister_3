import java.util.Arrays;

public class FantasyLeagueAutoDraft {

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        double fantasyPoints() {
            return matchesPlayed * battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints(), this.fantasyPoints());
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftablePlayers = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            boolean draftable;

            if (player.matchesPlayed >= 10) {
                draftable = isDraftable(player.matchesPlayed);
            } else {
                draftable = isDraftable(player.matchesPlayed, player.injured);
            }

            if (draftable) {
                draftablePlayers[count] = player;
                count++;
            }
        }

        Player[] selected = Arrays.copyOf(draftablePlayers, count);
        Arrays.sort(selected);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < selected.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(selected[i].name);

            if (i < selected.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Rahul", 12, 55.0, false),
            new Player("Virat", 15, 52.0, false),
            new Player("Dev", 8, 60.0, false),
            new Player("Arjun", 4, 70.0, false),
            new Player("Karan", 9, 65.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
