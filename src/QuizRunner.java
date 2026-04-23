import java.util.ArrayList;
import java.util.Collections;
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
        Collections.shuffle(questions); // randomizes the order of the questions for each quiz
        int score = 0;
        ArrayList<Question> wrong = new ArrayList<>(); // keeps track of the questions the user got wrong to review at the end of the quiz

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
        System.out.println("Select a subject you wish to study: ");
        System.out.println("1. History");
        System.out.println("2. Math");
        System.out.println("3. Chemistry");
        System.out.println("Enter your choice (number): ");
    }

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
}
