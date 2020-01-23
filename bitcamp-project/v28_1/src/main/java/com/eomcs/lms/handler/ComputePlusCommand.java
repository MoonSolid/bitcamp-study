package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class ComputePlusCommand implements Command {

  Prompt prompt;

  public ComputePlusCommand(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    int num1 = (prompt.inputInt("수1? "));
    int num2 = (prompt.inputInt("수2? "));
    int sum = num1 + num2;

    System.out.printf("계산결과는 %d 입니다.\n", sum);
  }
}


