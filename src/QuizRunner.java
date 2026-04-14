import java.util.ArrayList;
import java.util.Scanner;

public class QuizRunner
{
    public static void main(String[] args) {
        //String[] choices = {"George Washington", "Abraham Lincoln", "Thomas Jefferson"};
        //Question q = new Question("Who was the first US President?", choices, "George Washington");

        //q.displayQuestion();
        //System.out.println(q.isCorrect("George Washington"));
        //System.out.println(q.isCorrect("Thomas Jefferson"));

        //--------------------------------------------------------------------------------------------------------

        // HistoryQuiz hq = new HistoryQuiz();
        // ArrayList<Question> questions = hq.loadQuestions();

        // System.out.println("loaded " + questions.size() + " questions.");
        // questions.get(0).displayQuestion();

        //--------------------------------------------------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        HistoryQuiz hq = new HistoryQuiz();
        ArrayList<Question> questions = hq.loadQuestions();
        runQuiz(questions, scanner);
        scanner.close();

    }

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
}
