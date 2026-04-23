import java.util.ArrayList;

public class ChemistryQuiz {

    public ArrayList<Question> loadQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "Which of the following has the largest atomic radius?",
            new String[]{"Na", "Cl", "K", "Mg"},
            "K"
        ));

        questions.add(new Question(
            "Which bond is the most polar?",
            new String[]{"C-H", "O-H", "N-N", "Cl-Cl"},
            "O-H"
        ));

        questions.add(new Question(
            "If delta H for a reaction is negative, the reaction is: ",
            new String[]{"Endothermic", "Exothermic", "At equilibrium", "Nonspontaneous"},
            "Exothermic"
        ));

        questions.add(new Question(
            "If the temperature of a gas increases while pressure is constant, what happens to the volume?",
            new String[]{"Decreases", "Stays the same", "Increases", "Becomes zero"},
            "Increases"
        ));

        questions.add(new Question(
            "For a reaction at equilibrium, which statement is true?",
            new String[]{"Reactants are completely used up", "Forward and reverse reaction rates are equal", "The reaction has stopped", "Only products are present"},
            "Forward and reverse reaction rates are equal"
        ));

        questions.add(new Question(
            "How many moles of O₂ are required to completely react with 2 moles of C₂H₆ according to the balanced equation? \n 2C2​H6​+7O2​→4CO2​+6H2​O",
            new String[]{"2", "3.5", "5", "7"},
            "7"
        ));

        questions.add(new Question(
            "Which compound is most soluble in water?",
            new String[]{"CH₄", "NaCl", "CO₂", "I₂"},
            "NaCl"
        ));

        questions.add(new Question(
            "Which change will increase the rate of a reaction?",
            new String[]{"Lowering temperature", "Decreasing concentration", "Adding a catalyst", "Increasing activation energy"},
            "Adding a catalyst"
        ));

        questions.add(new Question(
            "Which is the strongest acid?",
            new String[]{"HCl", "HF", "NH₃", "H₂O"},
            "HCl"
        ));

        questions.add(new Question(
            "In a galvanic (voltaic) cell, electrons flow:",
            new String[]{"From cathode to anode", "From anode to cathode", "Through the salt bridge", "From positive to positive terminal"},
            "From anode to cathode"
        ));

        return questions;
    }

}
