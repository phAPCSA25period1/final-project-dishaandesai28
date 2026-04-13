import java.util.ArrayList;

public class HistoryQuiz
{
    public ArrayList<Question> loadQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "Who was the first US President?"
            new String[]{"John Adams", "George Washington", "Thomas Jefferson", "Benjamin Franklin"},
            "George Washington"
        ));

    }

}
