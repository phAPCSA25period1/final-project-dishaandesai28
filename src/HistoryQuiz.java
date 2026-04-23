import java.util.ArrayList;

public class HistoryQuiz
{
    /*
    * Method that contains the history themed quiz questions, which follow the structure of the constructor created in the Question class
    */
    public ArrayList<Question> loadQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "Which factor most contributed to the growth of slavery in the Southern colonies",
            new String[]{"Religious motivations", "Demand for labor-intensive cash crops", "Decline in European immigration", "Native American alliances"},
            "Demand for labor-intensive cash crops"
        ));

        questions.add(new Question(
            "Which idea is most clearly reflected in the Declaration of independence?",
            new String[]{"Judicial review", "Popular sovereignty", "Manifest destiny", "Laissez-faire economics"},
            "Popular sovereignty"
        ));

        questions.add(new Question(
            "The Great Compromise primarly addressed conflicts over:",
            new String[]{"Slavery in new territories", "Representation in Congress", "Methods to elect the President", "Federal taxation"},
            "Representation in Congress"
        ));

        questions.add(new Question(
            "What was a major result of the Civil War during Reconstruction?",
            new String[]{"Expansion of Women's suffrage", "Increased power of state governments", "Constitutional amendments expanding civil rights", "Immediate economic recovery in the South"},
            "Constitutional amendments expanding civil rights"
        ));

        questions.add(new Question(
            "The policy of containment was designed to:",
            new String[]{"Promote free trade globally", "Prevent the spread of Communism", "End colonialism", "Reduce military spending"},
            "Prevent the spread of Communism"
        ));

        questions.add(new Question(
            "Which Supreme Court case established the principle of judicial review?",
            new String[]{"McCulloch v. Maryland", "Marbury v. Madison", "Gibbons v. Ogden", "Worcester v. Georgia"},
            "Marbury v. Madison"
        ));

        questions.add(new Question(
            "The Kansas-Nebraska Act (1854) led directly to which of the following outcomes?",
            new String[]{"The end of slavery in the territories", "Increased sectional violence known as “Bleeding Kansas”", "Strengthening of the Whig Party", "Immediate Civil War"},
            "Increased sectional violence known as “Bleeding Kansas”"
        ));

        questions.add(new Question(
            "Which of the following actions taken by the best illustrates the federal government’s expanded role in economic recovery during the Great Depression?",
            new String[]{"Reducing tariffs to encourage international trade", "Creating programs like the WPA to provide direct employment", "Eliminating regulations on banks", "Returning control of relief efforts to state governments"},
            "Creating programs like the WPA to provide direct employment"
        ));

        questions.add(new Question(
            "At the , delegates issued the Declaration of Sentiments to advocate for which of the following specific reforms?",
            new String[]{"The immediate abolition of slavery nationwide", "Equal voting rights for women", "The end of child labor in factories", "Free public education for all citizens"},
            "Equal voting rights for women"
        ));

        questions.add(new Question(
            "President Lyndon B. Johnson used reports of attacks on U.S. naval vessels in the Gulf of Tonkin to justify which of the following actions?",
            new String[]{"Requesting congressional approval to expand U.S. military involvement in Vietnam", "Ending U.S. support for South Vietnam", "Signing a peace treaty with North Vietnam", "Withdrawing all U.S. troops from Southeast Asia"},
            "Requesting congressional approval to expand U.S. military involvement in Vietnam"
        ));

        return questions;



    }

}
