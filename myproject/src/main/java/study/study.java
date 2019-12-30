package study;
 public class study {
  public static void main(String[] args) {
  
    Bank bank = new Bank(10);
    Client client = new Client(2);
    
 System.out.println(bank);
 System.out.println(client);
    client.borrowMoney(bank, 1);
    System.out.println(bank);
    System.out.println(client);
    
  
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