import java.util.*;

public class Question
{
    // instance variables
    private String prompt;
    private String[] choices;
    private String answer;

    // constructor that initializes the instance variables
    public Question(String prompt, String[] choices, String answer)
    {
        this.prompt = prompt;
        this.choices = choices;
        this.answer = answer;
    }

    /*
    * Method that checks if the user's answer is correct
    *@Param String guess --> the user's answer to the question
    *@Return --> returns true if the answer = the user's guess; returns false otherwise
    */
    public boolean isCorrect(String guess)
    {
        return answer.equalsIgnoreCase(guess);
    }

}
