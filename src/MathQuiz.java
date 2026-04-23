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

        questions.add(new Question(
            "What is the vertical asymptote of f(x) = 3 / (x-2)?",
            new String[]{"x = -2", "x = 2", "y = 2", "y = -2"},
            "x = 2"
        ));

        questions.add(new Question(
            "How many solutions does the system have? | y = x^2 | y = 2x + 3 |",
            new String[]{"0", "1", "2", "Infinitely many"},
            "2"
        ));

        questions.add(new Question(
            "What is the 5th term of the geometric sequence: |2, 6, 18, ... |",
            new String[]{"54", "162", "486", "1458"},
            "162"
        ));

        questions.add(new Question(
            "Simplify: (1 - cos^2 x) / (sinx) ",
            new String[]{"sinx", "cosx", "tanx", "cscx"},
            "sinx"
        ));

        questions.add(new Question(
            "What is the vertex of | y = (x-4)^2 + 1 |?",
            new String[]{"(4, 1)", "(-4, 1)", "(4, -1)", "(1, 4)"},
            "(4, 1)"
        ));

        return questions;
    }

}
