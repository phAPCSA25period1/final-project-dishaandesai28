import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizRunner
{

    static String[][] leaderboard = new String[5][2];
    static int leaderboardCount = 0;

    /*
    * Main method that simulates the quiz game
    */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain)
        {
            ArrayList<Question> questions = new ArrayList<>();
            sleep(300);
            System.out.println("Enter your name: ");
            String playerName = scanner.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player";

            int subject = 0;
            while (subject < 1 || subject > 3)
            {
                showMenu();
                try {
                    subject = Integer.parseInt(scanner.nextLine().trim());
                    if (subject < 1 || subject > 3)
                    {
                        sleep(200);
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                        subject = 0;
                    }
                }
                catch (NumberFormatException e) {
                    sleep(200);
                    System.out.println("Invalid input: Please enter a number. ");
                    subject = 0;
                }
            }

            switch (subject)
            {
                case 1:
                    HistoryQuiz hq = new HistoryQuiz();
                    questions = hq.loadQuestions();
                    break;
                case 2:
                    MathQuiz mq = new MathQuiz();
                    questions = mq.loadQuestions();
                    break;
                case 3:
                    ChemistryQuiz cq = new ChemistryQuiz();
                    questions = cq.loadQuestions();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            int finalScore = runQuiz(questions, scanner);
            updateLeaderboard(playerName, finalScore, questions.size());
            displayLeaderboard();

            sleep(400);
            System.out.println("\nWould you like to play again? (Y/N");
            System.out.println("Your choice: ");
            String again = scanner.nextLine().trim().toUpperCase();
            while (!again.equals("Y") && !again.equals("N"))
            {
                System.out.println("Invalid input. Enter Y or N: ");
                again = scanner.nextLine().trim().toUpperCase();
            }
            playAgain = again.equals("Y");
        }

        System.out.println("\nThanks for playing. Goodbye!");
        scanner.close();
    }

    /*
    * Method that simulates the quiz to the user
    * @Param questions --> the list of quiz questions that will be displayed to the user
    * @Param scanner --> the scanner allows the user to put input to ensure the quiz works as intended
    */
    public static int runQuiz(ArrayList<Question> questions, Scanner scanner)
    {
        Collections.shuffle(questions); // randomizes the order of the questions for each quiz
        int score = 0;
        ArrayList<Question> wrong = new ArrayList<>(); // keeps track of the questions the user got wrong to review at the end of the quiz

        sleep(300);
        System.out.println("\n-------------------------------");
        System.out.println("   Quiz starting! Good Luck!");
        System.out.println("-------------------------------");
        sleep(600);

        for (int i = 0; i < questions.size(); i++)
        {
            sleep(300);
            System.out.println("\nQuestion " + (i+1) + " of " + questions.size());
            System.out.println("(Enter 'Q' at any time to quit)");
            questions.get(i).displayQuestion();
            sleep(1000);
            System.out.print("Enter the letter of your answer: ");

            String answer = getValidInput(scanner);

            if (answer.equals("Q"))
            {
                sleep(200);
                System.out.println("\nQuiz exited early");
                System.out.println("Questions answered: " + i + " of " + questions.size());
                sleep(300);
                showResults(score, i, wrong);
                return score;
            }

            String guess = questions.get(i).getChoice(answer);

            if (questions.get(i).isCorrect(guess))
            {
                sleep(200);
                System.out.println("   >> Correct!");
                score++;
            }
            else
            {
                sleep(200);
                System.out.println("   >> Wrong! The correct answer was: " +  questions.get(i).getAnswerLetter() + questions.get(i).getAnswer());
                wrong.add(questions.get(i));
            }
            sleep(400);
        }

        showResults(score, questions.size(), wrong);
        return score;
    }

    /*
    * Method that displays the user an introductory menu to the quiz
    */
    public static void showMenu()
    {
        sleep(400);
        System.out.println("\n===============================");
        System.out.println("      JAVA QUIZ APP      ");
        System.out.println("===============================");
        sleep(200);
        System.out.println("\nSelect a subject you wish to study: ");
        sleep(100);
        System.out.println("  1. History");
        sleep(100);
        System.out.println("  2. Math");
        sleep(100);
        System.out.println("  3. Chemistry");
        System.out.println("-----------------------------");
        System.out.print("Enter your choice (number): ");
    }

    /*
    * Method that displays the user's results at the end of the quiz
    * @Param int score --> how many questions the user got correct out of 10
    * @Param int total --> how many questinos the user was quized on
    * @Param wrong --> an arrayList of the questions the user got incorrect
    */
    public static void showResults(int score, int total, ArrayList<Question> wrong)
    {
        sleep(400);
        System.out.println("\n===============================");
        System.out.println("           Quiz Complete           ");
        System.out.println("===============================");
        sleep(300);
        System.out.println("   Your score:    " + score + " / " + total);
        sleep(200);

        int percentage = (int) ((double) score / total * 100);
        System.out.println("Percentage: " + percentage + "%");

        if (percentage == 100)
        {
            sleep(250);
            System.out.println("Excellent work! You got a perfect score!");
        }
        else if (percentage >= 70)
        {
            sleep(250);
            System.out.println("Good Work! You passed the quiz!");
        }
        else
        {
            sleep(250);
            System.out.println("Keep practicing! You'll get better with more practice!");
        }
        sleep(300);
        System.out.println("------------------------------------------");

        if (wrong.size() > 0)
        {
            sleep(200);
            System.out.println("\nQuestions you missed:");
            for (Question q : wrong)
            {
                sleep(300);
                q.displayQuestion();
                System.out.println("   >> Correct answer: " + q.getAnswer());
                System.out.println();
            }
            System.out.println("------------------------------------------");
        }
    }

    /*
    * Method that handles invalid input from the user to promote program functionality
    * @Param scanner --> input that is given by the user
    * @Return input --> returns the string value input
    */
    public static String getValidInput(Scanner scanner)
    {
        String[] valid = {"A", "B", "C", "D", "Q"};

        while (true)
        {
            String input = scanner.nextLine().trim().toUpperCase();
            for (String v : valid)
            {
                if (input.equals(v))
                {
                    return input;
                }
            }
            System.out.println("Invalid input. Enter A, B, C, D, or Q to quit");
        }
    }

    /*
    * Method that is intended to delay the output using thread.sleep(number of miliseconds to delay)
    * @Param int ms --> number of miliseconds to delay
    */
    public static void sleep(int ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*
    * Method that adds the player's score to the leaderboard if it qualifies. Keeps the top 5 scores sorted from highest to lowest
    * @Param String namr --> the player's name
    * @Param int score --> the player's score
    * @Param int total --> the total number of questions
    */
    public static void updateLeaderboard(String name, int score, int total)
    {
        if (leaderboardCount < 5)
        {
            leaderboard[leaderboardCount][0] = name;
            leaderboard[leaderboardCount][1] = score + "/" + total;
            leaderboardCount++;
        }
        else{
            // finds the lowest score and replaces if the new score is higher
            int lowestIndex = 0;
            int lowestScore = Integer.parseInt(leaderboard[0][1].split("/")[0]);
            for (int i = 1; i < 5; i++)
            {
                int s = Integer.parseInt(leaderboard[i][1].split("/")[0]);
                if (s < lowestScore)
                {
                    lowestScore = s;
                    lowestIndex = i;
                }
            }
            if (score > lowestScore)
            {
                leaderboard[lowestIndex][0] = name;
                leaderboard[lowestIndex][1] = score + "/" + total;
            }
        }
        for (int i = 0; i < leaderboardCount - 1; i++)
        {
            for (int j = 0; j < leaderboardCount - i - 1; j++)
            {
                int a = Integer.parseInt(leaderboard[j][1].split("/")[0]);
                int b = Integer.parseInt(leaderboard[j+1][1].split("/")[0]);
                if (a < b)
                {
                    String[] temp = leaderboard[j];
                    leaderboard[j] = leaderboard[j+1];
                    leaderboard[j+1] = temp;
                }
            }
        }
    }

    public static void displayLeaderboard()
    {
        sleep(300);
        System.out.println("\n=========================================");
        System.out.println("      Leaderboard      ");
        System.out.println("=========================================");

        if (leaderboardCount == 0)
        {
            System.out.println(" No scores yet!");
        }
        else
        {
            String[] medals = {"1st", "2nd", "3rd", "4th", "5th"};
            for (int i = 0; i < leaderboardCount; i++)
            {
                sleep(150);
                System.out.println(" " + medals[i] + " " + leaderboard[1][0] + " - " + leaderboard[i][1]);
            }
        }
        System.out.println("===================================");
    }
}
