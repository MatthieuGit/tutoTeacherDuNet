package main.java.com;

import java.io.IOException;

public class DriverQuiz {

  public static void main(String[] args) throws IOException {
      Quiz quiz = new ConsoleQuiz(new CapitalCityQuestionsGenerator(10));
      quiz.start();
      quiz.displayResult();
  }
}
