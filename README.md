# Java Quiz App
### APCSA Final Project

A console-based multiple choice quiz application built entirely in Java. Users select a subject, answer shuffled questions using lettered choices, and compete for a spot on the leaderboard.


---

## Overview

The Java Quiz App solves a common student problem: making self-study more engaging than reading static flashcards. The program quizzes users on History, Math, or Chemistry with 10 shuffled multiple choice questions per subject. At the end, users see their score, a percentage rating, a review of missed questions with correct answers, and a live leaderboard tracking the top 5 scores across all sessions.

---

## Features

| Feature | Description |
|---|---|
| 3 Subject Categories | History, Math, and Chemistry — each with 10 unique questions |
| Shuffled Questions | Randomized each run using `Collections.shuffle()` |
| A–D Lettered Choices | Answers selected by letter, not number |
| Top 5 Leaderboard | Stored in a `String[][]` 2D array, sorted with bubble sort |
| Input Validation | All input validated — invalid entries re-prompt without crashing |
| Timed Feedback | `Thread.sleep()` adds pacing between questions and results |
| Quit Mid-Quiz | Press `Q` at any time — partial score still counts toward leaderboard |
| Play Again Loop | Replay any subject without restarting the program |
| Missed Question Review | Incorrect questions shown at the end with correct letter and answer |
| Javadoc Comments | Every class and method fully documented |

---

## File Structure

```
QuizApp/
├── QuizRunner.java       # main class — runs the entire program
├── Question.java         # data class — stores each question's data
├── HistoryQuiz.java      # loads 10 history questions
├── MathQuiz.java         # loads 10 math questions
└── ChemistryQuiz.java    # loads 10 chemistry questions
```

---

## How to Run

1. Open all five `.java` files in your IDE (BlueJ, IntelliJ, or VS Code)
2. Compile all classes — make sure they are all in the **same project or package**
3. Run `QuizRunner.java` — it contains the `main()` method and is the entry point
4. Follow the on-screen prompts:
   - Enter your name
   - Pick a subject (`1`, `2`, or `3`)
   - Answer each question with `A`, `B`, `C`, or `D`
   - Enter `Q` at any time to quit early

---

## APCSA Concepts Demonstrated

| Concept | Where It's Used |
|---|---|
| Classes & Objects | `Question` objects created in each subject class and passed to `QuizRunner` |
| 2D Arrays | `String[][] leaderboard` stores name, score, and subject for top 5 players |
| ArrayList | `ArrayList<Question>` holds all questions and wrong answers dynamically |
| Methods & Parameters | Every feature broken into focused, reusable static methods |
| Loops | `for` loops iterate questions; `while` loops handle validation and play again |
| Conditionals | `if/else` for scoring feedback; `switch` for subject selection |
| String Methods | `equalsIgnoreCase()`, `toUpperCase()`, `trim()`, `split()` used throughout |
| Exception Handling | `try/catch` in `getValidInput()` and `sleep()` for robust error handling |
| Bubble Sort | Leaderboard sorted highest to lowest using a nested loop bubble sort |
| Javadoc Comments | Every class and method documented with `@param` and `@return` tags |

---

## UML Class Diagram

```
                    ┌─────────────────────────────────────────────────┐
                    │                  QuizRunner                     │
                    │                  [main]                         │
                    ├─────────────────────────────────────────────────┤
                    │ - leaderboard : String[][]                      │
                    │ - leaderboardCount : int                        │
                    ├─────────────────────────────────────────────────┤
                    │ + main(args : String[]) : void                  │
                    │ + showMenu() : void                             │
                    │ + runQuiz(questions, scanner) : int[]           │
                    │ + showResults(score, total, wrong) : void       │
                    │ + getValidInput(scanner) : String               │
                    │ + updateLeaderboard(name, score, total,         │
                    │                     subject) : void             │
                    │ + displayLeaderboard() : void                   │
                    │ + sleep(ms : int) : void                        │
                    └────────────────────┬────────────────────────────┘
                                         │
                                       uses
                                         │
                                         ▼
                    ┌─────────────────────────────────────────────────┐
                    │                   Question                      │
                    ├─────────────────────────────────────────────────┤
                    │ - prompt  : String                              │
                    │ - choices : String[]                            │
                    │ - answer  : String                              │
                    ├─────────────────────────────────────────────────┤
                    │ + Question(prompt, choices, answer)             │
                    │ + isCorrect(guess : String) : boolean           │
                    │ + displayQuestion() : void                      │
                    │ + getChoice(letter : String) : String           │
                    │ + getAnswer() : String                          │
                    │ + getAnswerLetter() : String                    │
                    └────────────────────┬────────────────────────────┘
                                         │
                               creates instances of
                          ┌──────────────┼──────────────┐
                          │              │              │
                          ▼              ▼              ▼
              ┌───────────────┐  ┌───────────────┐  ┌───────────────┐
              │ HistoryQuiz   │  │   MathQuiz    │  │ ChemistryQuiz │
              ├───────────────┤  ├───────────────┤  ├───────────────┤
              │ + loadQues-   │  │ + loadQues-   │  │ + loadQues-   │
              │   tions() :   │  │   tions() :   │  │   tions() :   │
              │ ArrayList     │  │ ArrayList     │  │ ArrayList     │
              │ <Question>    │  │ <Question>    │  │ <Question>    │
              └───────────────┘  └───────────────┘  └───────────────┘

  Visibility:  + public   - private
```

---

## Sample Output

```
===============================
       JAVA QUIZ APP
===============================

Select a subject you wish to study:
  1. History
  2. Math
  3. Chemistry
-----------------------------
Enter your choice (number): 1

Enter your name: Alex

-------------------------------
   Quiz starting! Good Luck!
-------------------------------

Question 1 of 10
(Enter 'Q' at any time to quit)

Who was the first US president?
  A. John Adams
  B. George Washington
  C. Thomas Jefferson
  D. Benjamin Franklin

Your answer: B
   >> Correct!

...

===============================
         QUIZ RESULTS
===============================
  Score:       9 / 10
  Percentage:  90%
  Result:      Good work, keep it up!
------------------------------

===============================
         LEADERBOARD
===============================
  1st  Alex - 9/10 (History)
  2nd  Jordan - 7/10 (Math)
  3rd  Sam - 6/10 (Chemistry)
===============================
```

---

*Java Quiz App · APCSA Final Project · Built with Java*
