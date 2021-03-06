public class study {
  public static void main(String[] args) {    
    Bank bank = new Bank(10);
    Client c1 = new Client(0);
    Client c2 = new Client(0);
    System.out.println("----- 대출 전 -----");
    System.out.println("----- 은행 -----");
    System.out.println(bank);
    
    System.out.println("----- 고객 1 -----");
    System.out.println(c1);
    System.out.println("----- 고객 2 -----");
    System.out.println(c2);
    
    // 대출 과정
    c1.borrowMoney(bank, 2);
    c2.borrowMoney(bank, 4);
    System.out.println("----- 대출 후 -----");
    System.out.println("----- 은행 -----");
    System.out.println(bank);
    
    System.out.println("----- 고객 1 -----");
    System.out.println(c1);
    System.out.println("----- 고객 2 -----");
    System.out.println(c2);
  }
}
class Bank {
  private int money;
  public Bank(int money) {
    this.money = money;
  }
  public int loan(int wantMoney) {
    this.money -= wantMoney;
    return wantMoney;
  }
  public String toString() {
    String res = "";
    res += String.format("보유 돈 : %d\n", this.money);
    return res;
  }
}
class Client {
  private int money;
  public Client(int money) {
    this.money = money;
  }
  public void borrowMoney(Bank bank, int wantMoney) {
    this.money += bank.loan(wantMoney);
  }
  public String toString() {
    String res = "";
    res += String.format("보유 돈 : %d\n", this.money);
    return res;
  }  
}