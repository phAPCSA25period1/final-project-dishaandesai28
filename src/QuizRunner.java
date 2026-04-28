import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizRunner
{
    /*
    * Main method that simulates the quiz game
    */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain)
        {
            ArrayList<Question> questions = new ArrayList<>();

            showMenu();
            int subject = scanner.nextInt();
            scanner.nextLine();

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

            runQuiz(questions, scanner);

            System.out.println("Would you like to play again?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int again = getValidInput(scanner);
            playAgain = (again == 1);
        }

        System.out.println("\nThanks for playing. Goodbye!");
        scanner.close();
    }

    /*
    * Method that simulates the quiz to the user
    * @Param questions --> the list of quiz questions that will be displayed to the user
    * @Param scanner --> the scanner allows the user to put input to ensure the quiz works as intended
    */
    public static void runQuiz(ArrayList<Question> questions, Scanner scanner)
    {
        Collections.shuffle(questions); // randomizes the order of the questions for each quiz
        int score = 0;
        ArrayList<Question> wrong = new ArrayList<>(); // keeps track of the questions the user got wrong to review at the end of the quiz

        for (int i = 0; i < questions.size(); i++)
        {
            System.out.println("\nQuestion " + (i+1) + " of " + questions.size());
            questions.get(i).displayQuestion();
            System.out.print("Enter the letter of your answer: ");
            String answer = getValidInput(scanner);

            String guess = questions.get(i).getChoice(answer);

            if (questions.get(i).isCorrect(guess))
            {
                System.out.println("Correct!");
                score++;
            }
            else
            {
                System.out.println("Wrong!");
                wrong.add(questions.get(i));
            }
        }

        showResults(score, questions.size(), wrong);
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
        System.out.println("Enter your choice: ");
    }

    /*
    * Method that displays the user's results at the end of the quiz
    * @Param int score --> how many questions the user got correct out of 10
    * @Param int total --> how many questinos the user was quized on
    * @Param wrong --> an arrayList of the questions the user got incorrect
    */
    public static void showResults(int score, int total, ArrayList<Question> wrong)
    {
        System.out.println("\n--- Quiz Complete ---");
        System.out.println("Your score: " + score + "/" + total);

        int percentage = (int) ((double) score / total * 100);
        System.out.println("Percentage: " + percentage + "%");

        if (percentage == 100)
        {
            System.out.println("Excellent work! You got a perfect score!");
        }
        else if (percentage >= 70)
        {
            System.out.println("Good Work! You passed the quiz!");
        }
        else
        {
            System.out.println("Keep practicing! You'll get better with more practice!");
        }

        if (wrong.size() > 0)
        {
            System.out.println("\nReview the questions you got wrong:");
            for (Question q : wrong)
            {
                q.displayQuestion();
                System.out.println("Correct answer: " + q.getAnswer());
                System.out.println();
            }
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
}
