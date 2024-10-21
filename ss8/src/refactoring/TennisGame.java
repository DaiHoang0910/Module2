package refactoring;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        if (scorePlayer1 == scorePlayer2) {
            return setScore(scorePlayer1) + "-All";
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return getWinner(player1Name, player2Name, scorePlayer1, scorePlayer2);
        } else {
            return getScore(scorePlayer1, scorePlayer2);
        }
    }

    private static String setScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }

    private static String getWinner(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) {
            return "Advantage " + player1Name;
        } else if (minusResult == -1) {
            return "Advantage " + player2Name;
        } else if (minusResult >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }

    private static String getScore(int scorePlayer1, int scorePlayer2) {
        int tempScore = 0;
        String score = "";
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                tempScore = scorePlayer1;
            } else {
                score += "-";
                tempScore = scorePlayer2;
            }
            score = setScore(tempScore);
        }
        return score;
    }
}
