package org.example.services;

public class PaymentServiceImpl implements PaymentService {

  int money = 10000;
  @Override
  public void makePayment() {
    // Payment code

    System.out.println("Amount Debited...");


    System.out.println("Amount Credited...");


  }

  @Override
  public void incrementPayment(int amount) {
    // Payment code

    System.out.println("Previous Money:" + money);


    System.out.println("Money after debit:" + (money + amount));


  }
}
