import java.util.ArrayList;

public class MathQuiz {

    public ArrayList<Question> loadQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "If f(x) = x^2, which function represents a reflection over the x-axis and a shift up 3 units?",
            new String[]{"-x^2 + 3", "-(x-3)^2", "(x+3)^2", "-x^2 - 3"},
            "-x^2 + 3"
        ));

        questions.add(new Question(
            "Which of the following functions shows exponential decay?",
            new String[]{"y = 3(1.2)^x", "y = 5(0.8)^x", "y = 2x^3", "y = ln(x)"},
            "y = 5(0.8)^x"
        ));

        questions.add(new Question(
            "Solve for x: \n log base 2 (x-1) = 3",
            new String[]{"7", "8", "9", "10"},
            "9"
        ));

        questions.add(new Question(
            "What is the value of sin(5pi / 6)?",
            new String[]{"-0.5", "0.5", "- sqrt(3) / 2", "sqrt(3) / 2"},
            "0.5"
        ));

        questions.add(new Question(
            "What is the end behavior of f(x) = -2x^3 + x^2 - 4?",
            new String[]{"Up on both ends", "Down on both ends", "Left up, right down", "left down, right up"},
            "Left up, right down"
        ));

        return questions;
    }

}
