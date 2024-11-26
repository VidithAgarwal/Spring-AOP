package org.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

  @Before("execution(* org.example.services.PaymentServiceImpl.makePayment())")
  void logStartPayment() {
    System.out.println("Payment Starting...");
  }
}
