import java.util.ArrayList;

public class HistoryQuiz
{
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

        return questions;



    }

}
