package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Objects;

@Aspect
public class MyAspect {

  @Before("execution(* org.example.services.PaymentServiceImpl.makePayment())")
  void logStartPayment() {
    System.out.println("Payment Starting...");
  }

  @After("execution(* org.example.services.PaymentServiceImpl.makePayment())")
  void logEndPayment() {
    System.out.println("Payment Ending...");
  }

  @Before("execution(* org.example.services.PaymentServiceImpl.incrementPayment(..))")
  void logBeforeIncrement() {
    System.out.println("-----------------------------------");
    System.out.println("Before incrementing");
  }

  @After("execution(* org.example.services.PaymentServiceImpl.incrementPayment(..))")
  void logAfterIncrement() {
    System.out.println("After Incrementing...");
    System.out.println("-----------------------------------");
  }

  @Around("execution(* org.example.services.PaymentServiceImpl.incrementPayment(..))")
  Object logAroundIncrement(ProceedingJoinPoint pointCut) throws Throwable{
    System.out.println("Start around Incrementing...");
    Object result = pointCut.proceed();
    System.out.println("End around Incrementing...");
    return result;
  }

  @AfterThrowing(pointcut = "execution(* org.example.services.PaymentServiceImpl.throwsException" +
          "())",
          throwing="exception")
  void logException(Throwable exception) {
    System.out.println("Exception caught: " + exception.getMessage());
  }





}
