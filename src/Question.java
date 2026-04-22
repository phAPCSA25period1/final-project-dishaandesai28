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

    /*
     * Method that displays the question to the user
     */
    public void displayQuestion() {
        System.out.println(prompt);
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + "." + choices[i]);
        }
    }

    /*
    * Method that gets the user's choice as a numer
    * @Param int index --> the number the user enters as their answer to the question
    * @Return --> returns their choice that is adjusted by 1 since arrays start at 0 instead of 1
    */
    public String getChoice(int index)
    {
        return choices[index - 1]; // -1 because choices array starts at 0
    }

}
