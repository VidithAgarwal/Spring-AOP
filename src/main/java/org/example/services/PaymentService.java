package org.example.services;

public interface PaymentService {
  void makePayment();

  void incrementPayment(int amount);

  void throwsException() throws Throwable;
}
