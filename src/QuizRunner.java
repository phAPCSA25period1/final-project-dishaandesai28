public class QuizRunner
{
    public static void main(String[] args) {
        String[] choices = {"George Washington", "Abraham Lincoln", "Thomas Jefferson"};
        Question q = new Question("Who was the first US President?", choices, "George Washington");

        q.displayQuestion();
        System.out.println(q.isCorrect("George Washington"));
        System.out.println(q.isCorrect("Thomas Jefferson"));
    }
}
