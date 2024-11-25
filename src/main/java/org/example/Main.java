package org.example;

import org.example.services.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

    PaymentService paymentObject = context.getBean("payment" , PaymentService.class);

    paymentObject.makePayment();
  }
}