package com.eomcs.basic.ex05;

//# 비트 이동 연산자 : >>, >>>, <<
//
public class Exam4_3 {
  public static void main(String[] args) {
    // >>> 비트 이동 연산자 사용법
    // - 왼쪽 쪽 빈자리는 음수 양수 상관없이 무조건 0으로 채운다.
    // - 오른쪽 경계를 넘어간 비트를 자른다.

    int i = 0b01101001; // 105

    System.out.println(i);
    // 00000000000000000000000001101001

    System.out.println(i >>> 1);
    // x0000000000000000000000000110100|1
    // 00000000000000000000000000110100 => 52


    System.out.println(i >>> 2);
    // xx000000000000000000000000011010|01
    // 000000000000000000000000000011010 => =>26

    System.out.println(i >>> 3);
    // xxx0000000000000000000000000110100|001
    // 000000000000000000000000000001101 => 13

    System.out.println(i >>> 4);
    // xxxx0000000000000000000000000110|1001
    // 000000000000000000000000000000110 => 6


    // 음수를 이동
    // - 왼쪽 빈자리는 숫자의 부호비트로 채운다.
    // 음수니까 1로 채운다.
    // - 2로 나눈 후에 소수점이 있으면
    // 그 수보다 더 작은 정수값이 되는 결과가 나온다.

    i = 0b11111111_11111111_11111111_10101001; // -87
    System.out.println(i);
    
    
    System.out.println(i >>> 1);
    // 11111111111111111111111110101001;
    // x111111111111111111111111010100|1;
    // 0111111111111111111111111010100;
    // 0111111111111111111111111010011; => 2147483604

    System.out.println(i >>> 2);
    // xx11111111111111111111111101010|01;
    // 0011111111111111111111111101010; => 1073741802


    System.out.println(i >>> 3);
    // xxx1111111111111111111111110101|001;
    // 0001111111111111111111111110101; => 536870901

    System.out.println(i >>> 4);
    // xxxx111111111111111111111111010|1001;
    // 0000111111111111111111111111010; => 268435450
  }
}

// 오른쪽 이동
// - 1비트 이동은 나누기 2 한 것과 같은 효과를 준다.
// - 소수점이 있는 경우 그 수 보다 작은 바로 밑 정수 값이 된다.
// 실무에서는 나눗셈 연산이 비용(시간과 CPU 사용량)이 많이 들기 때문에
// 소수점 이하까지 정확하게 계산할게 아니라면
// 오른쪽 비트 이동 연산자를 사용하여 주로 처리한다.

