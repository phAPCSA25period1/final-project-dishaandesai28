import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent;

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

            int again = getValidInput(scanner, 1, 2);
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
            System.out.print("Enter the number of your answer: ");
            int choice = getValidInput(scanner, 1, 4);

            String guess = questions.get(i).getChoice(choice);

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
        System.out.println("\n--- Welcome to the Quiz Program ---");
        System.out.println("\nSelect a subject you wish to study: ");
        TimeUnit.SECONDS.sleep(2); 
        System.out.println("1. History");
        System.out.println("2. Math");
        System.out.println("3. Chemistry");
        System.out.println("Enter your choice (number): ");
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
    * @Param int min --> lowest option of the number of choices given (ex. type 1 to play again and type 2 to quit; option 1 = min)
    * @Param int max --> highest option of the number of choices given (ex. type 1 to play again and type 2 to quit; option 2 = max)
    * @Return input --> returns the int value input
    */
    public static int getValidInput(Scanner scanner, int min, int max)
    {
        int input = -1;

        while (input < min || input > max)
        {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input < min || input > max)
                {
                    System.out.println("Please enter a valid number between " + min + " and " + max + ".");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");

            }
        }
        return input;
    }
}
