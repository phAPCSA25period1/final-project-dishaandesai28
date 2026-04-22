import java.util.ArrayList;
import java.util.Scanner;

public class QuizRunner
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
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
        scanner.close();

    }

    /*
    * Method that simulates the quiz to the user
    * @Param questions --> the list of quiz questions that will be displayed to the user
    * @Param scanner --> the scanner allows the user to put input to ensure the quiz works as intended
    */
    public static void runQuiz(ArrayList<Question> questions, Scanner scanner)
    {
        int score = 0;

        for (int i = 0; i < questions.size(); i++)
        {
            System.out.println("\nQuestion " + (i+1) + " of " + questions.size());
            questions.get(i).displayQuestion();
            System.out.print("Enter the number of your answer: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clears the leftover newLine

            String guess = questions.get(i).getChoice(choice);

            if (questions.get(i).isCorrect(guess))
            {
                System.out.println("Correct!");
                score++;
            }
            else
            {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n--- Quiz Complete ---");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    /*
    * Method that displays the user an introductory menu to the quiz
    */
    public static void showMenu()
    {
        System.out.println("\n--- Welcome to the Quiz Program ---");
        System.out.println("Select a subject you wish to study: ");
        System.out.println("1. History");
        System.out.println("2. Math");
        System.out.println("3. Chemistry");
        System.out.println("Enter your choice (number): ");
    }
}
