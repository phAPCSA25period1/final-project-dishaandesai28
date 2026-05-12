APCSA Final Project

JAVA QUIZ APP
-------------------
A console-based multiple choice quiz application with subject selection, a leaderboard, input validation, and timed feedback - built entirely in java.
| Java | 5 Classes | 3 Subjects | 2D Arrays |

Overview
----------------------------------------------
The Java Quiz App is an interactive console program that quizzes users on History, Math, or Chemistry using multiple choice questions. It was designed to solve a common student problem: making self-study more engaging and interactive than reading static flashcards.

The user selects a subject, enters their name, and answers up to 10 shuffled questions using lettered choices (A–D). At the end, they see their score, a percentage, a review of missed questions with correct answers, and a live leaderboard ranking the top 5 scores across all sessions.

Features
----------------------------------------------
3 Subject Categories
History, Math, and Chemistry — each with 10 unique multiple choice questions.

Shuffled Questions
Questions are randomized each run using Collections.shuffle() so no two quizzes feel the same.

Top 5 Leaderboard
Stores the top 5 scores using a 2D String array, sorted highest to lowest with bubble sort.

Input Validation
All user input is validated — invalid entries prompt the user to try again without crashing.

Timed Feedback
Thread.sleep() adds pacing between questions and results for a polished console experience.

Quit Mid-Quiz
Press Q at any time to exit early. Partial scores still count toward the leaderboard.

Play Again Loop
After each quiz, the user can replay with any subject without restarting the program.

Missed Question Review
At the end, all incorrect questions are shown again with the correct letter and answer.

File Structure
----------------------------------------------
QuizApp/
  ├── QuizRunner.java  // main class — runs the entire program
  ├── Question.java    // data class — stores each question's data
  ├── HistoryQuiz.java  // loads 10 history questions
  ├── MathQuiz.java    // loads 10 math questions
  └── ChemistryQuiz.java // loads 10 chemistry questions

How to Run
----------------------------------------------
1) Open all .java files in your IDE (BlueJ, IntelliJ, or VS Code).
2) Compile all five classes. Make sure all files are in the same project/package.
3) Run QuizRunner.java — it contains the main() method and is the entry point.
4) Follow the on-screen prompts: enter your name, pick a subject (1–3), and answer each question with A, B, C, or D. Enter Q to quit early.

APCSA Concepts Demonstrated
----------------------------------------------
Classes & Objects;	    Question objects created in each subject class and passed to QuizRunner
2D Arrays;	            String[][] leaderboard stores name, score, and subject for top 5 players
ArrayList;	            ArrayList<Question> holds all questions and wrong answers dynamically
Methods & Parameters;	Every feature is broken into focused, reusable static methods
Loops;	                for loops iterate questions; while loops handle input validation and play again
Conditionals;	        if/else for scoring feedback; switch for subject selection
String Methods;	        equalsIgnoreCase(), toUpperCase(), trim(), split() used throughout
Exception Handling;	    try/catch in getValidInput() and sleep() for robust error handling
Bubble Sort;	        Leaderboard sorted highest to lowest using a nested loop bubble sort
Javadoc Comments;	    Every class and method documented with @param and @return tags

UML Class Diagram
----------------------------------------------



