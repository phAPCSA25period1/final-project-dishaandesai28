public class Question {
    // instance variables
    private String prompt;
    private String[] choices;
    private String answer;

    // constructor that initializes the instance variables
    public Question(String prompt, String[] choices, String answer) {
        this.prompt = prompt;
        this.choices = choices;
        this.answer = answer;
    }

    /*
     * Method that checks if the user's answer is correct
     *
     * @Param String guess --> the user's answer to the question
     *
     * @Return --> returns true if the answer = the user's guess; returns false
     * otherwise
     */
    public boolean isCorrect(String guess) {
        return answer.equalsIgnoreCase(guess);
    }

    public String getAnswer() {
        return answer;
    }

    /*
     * Method that displays the question to the user
     */
    public void displayQuestion() {
        System.out.println("\n" + prompt);
        String[] letters = {"A", "B", "C", "D", "Q"};
        for (int i = 0; i < choices.length; i++) {
            System.out.println(" " + (letters[i]) + ") " + choices[i]);
        }
    }

    /*
    * Method that gets the user's choice as a numer
    * @Param int index --> the number the user enters as their answer to the question
    * @Return --> returns their choice that is adjusted by 1 since arrays start at 0 instead of 1
    */
    public String getChoice(String letter)
    {
        switch (letter.toUpperCase())
        {
            case "A": return choices[0];
            case "B": return choices[1];
            case "C": return choices[2];
            case "D": return choices[3];
            default: return "";
        }
    }

    /*
    * Method that returns the letter of the correct answer
    * @Return letters[i] --> the letter of the correct answer
    */
    public String getAnswerLetter()
    {
        String[] letters = {"A", "B", "C", "D"};
        for (int i = 0; i < choices.length; i++)
        {
            if (choices[i].equalsIgnoreCase(answer))
            {
                return (letters[i] + ") ");
            }
        }
        return "";
    }

}
