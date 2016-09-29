/*
 * A Test Driver for the Date class.
 */
public class TestAccount {
   public static void main(String[] args) {
      // Test constructor and toString()
      Account d1 = new Account(123, 100);
      System.out.println(d1);  // toString()
 
      // Test Setters and Getters
      d1.setBalance(1);
      d1.credit(12);
      d1.debit(2024);

      System.out.println(d1);  // run toString() to inspect the modified instance
      System.out.println("Balance is: " + d1.getBalance());
      System.out.println("Account Number is: " + d1.getAccountNumber());
      //System.out.println("Day is: " + d1.getDay());
 
      // Test setDate()
      /*d1.setDate(2988, 1, 2);
      System.out.println(d1);  // toString()*/
   }
}

