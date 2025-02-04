# Spring AOP (Aspect-Oriented Programming)

## Table of Contents
1. [What is AOP?](#what-is-aop)
2. [Why Use AOP?](#why-use-aop)
3. [Key Concepts and Terminology](#key-concepts-and-terminology)
4. [Common Annotations and Their Meaning](#common-annotations-and-their-meaning)
5. [Other Useful Annotations and Their Usage](#other-useful-annotations-and-their-usage)
6. [What is Weaving and its Relation to Spring AOP?](#what-is-weaving-and-its-relation-to-spring-aop)
7. [How to Use Spring AOP](#how-to-use-spring-aop)

---

## What is AOP?

**Aspect-Oriented Programming (AOP)** is a programming paradigm that allows you to modularize cross-cutting concerns in your application.

- **Cross-cutting concerns** are functionalities that affect multiple parts of an application, such as logging, security, transaction management, and performance monitoring.
- AOP enables separation of these concerns into reusable and maintainable **aspects**, rather than scattering them across the entire codebase.
- It is like a proxy but gives more abilities

For e.g. we use an external API and call its methods. But we want to perform certain actions before or after calling method. Since its a JAR, the methods cannot be injected. So here we use AOP concepts. Before calling the library. I can say call this method M() . We can also provide conditions here. These all things happen on Runtime.

![Spring AOP Diagram](https://private-user-images.githubusercontent.com/72097117/326276785-e5d95ac5-fcd8-4749-8f22-8b82a90f5743.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzI2MDQ2NTgsIm5iZiI6MTczMjYwNDM1OCwicGF0aCI6Ii83MjA5NzExNy8zMjYyNzY3ODUtZTVkOTVhYzUtZmNkOC00NzQ5LThmMjItOGI4MmE5MGY1NzQzLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDExMjYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQxMTI2VDA2NTkxOFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWI1MTE4ZjJiMzJkNGM1ZTFiZDM5ZmVmYTQ4NzNkMjAzYjQwYzljZDNmYTFmMTZhZmNiOWUyMTJjZGQ0NDNiZDImWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.Ch7ACE1WuIMBq8rGnkZ4gmQ-v5xSaLjVfwe1a6UfPXM)



---

## Why Use AOP?

1. **Separation of Concerns**: Simplifies the core logic of your application by isolating cross-cutting concerns.
2. **Reusability**: Define aspects once and reuse them across multiple modules or components.
3. **Maintainability**: Centralized management of concerns like logging, making code easier to maintain.
4. **Decoupling**: Reduces coupling between components by removing boilerplate logic.

---

## Key Concepts and Terminology

### 1. **Aspect**
   - A modularized implementation of a cross-cutting concern.
   - Example: LoggingAspect for handling logging across the application.

### 2. **Join Point**
   - A point during the execution of a program, such as the execution of a method or the handling of an exception, where an aspect can be applied.

### 3. **Advice**
   - The action taken by an aspect at a specific join point.
   - Types of advice:
     - **Before**: Runs before a method execution.
     - **After**: Runs after a method execution.
     - **After Returning**: Runs after a method successfully returns.
     - **After Throwing**: Runs after a method throws an exception.
     - **Around**: Runs before and after a method execution.

### 4. **Pointcut**
   - A predicate or expression that matches join points and determines where advice should be applied.

### 5. **Weaving**
   - The process of linking aspects with the main application code.
   - Happens at compile time, load time, or runtime.

---

## Common Annotations and Their Meaning

### 1. `@Aspect`
   - Marks a class as an aspect.

### 2. `@Pointcut`
   - Defines a reusable expression that matches join points.
   - Example:
     ```java
     @Pointcut("execution(* com.example.service.*.*(..))")
     public void serviceLayer() {}
     ```

### 3. `@Before`
   - Executes before the matched join point.
   - Example:
     ```java
     @Before("execution(* com.example.service.*.*(..))")
     public void logBefore() {
         System.out.println("Executing before service method");
     }
     ```

### 4. `@After`
   - Executes after the matched join point (regardless of its outcome).
   - Example:
     ```java
     @After("execution(* com.example.service.*.*(..))")
     public void logAfter() {
         System.out.println("Executing after service method");
     }
     ```

### 5. `@AfterReturning`
   - Executes after the method returns successfully.
   - Example:
     ```java
     @AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
     public void logAfterReturning(Object result) {
         System.out.println("Method returned: " + result);
     }
     ```

### 6. `@AfterThrowing`
   - Executes if the method throws an exception.
   - Example:
     ```java
     @AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "exception")
     public void logAfterThrowing(Exception exception) {
         System.out.println("Exception thrown: " + exception.getMessage());
     }
     ```

### 7. `@Around`
   - Wraps the method execution, allowing custom behavior both before and after the method runs.
   - Example:
     ```java
     @Around("execution(* com.example.service.*.*(..))")
     public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
         System.out.println("Before method: " + joinPoint.getSignature());
         Object result = joinPoint.proceed();
         System.out.println("After method: " + joinPoint.getSignature());
         return result;
     }
     ```

---

## Other Useful Annotations and Their Usage

### 1. `@EnableAspectJAutoProxy`
   - Enables support for processing aspects using AspectJ in Spring.
   - Example:
     ```java
     @Configuration
     @EnableAspectJAutoProxy
     public class AppConfig {}
     ```

### 2. `@Order`
   - Specifies the execution order of aspects if multiple aspects apply to the same join point.
   - Example:
     ```java
     @Aspect
     @Order(1)
     public class LoggingAspect {}
     ```

---

## What is Weaving and its Relation to Spring AOP?

**Weaving** is the process of linking aspects with the main application code. It determines how aspects are applied to the target object.

- **Compile-time Weaving**: Aspects are woven into the code at compile time (requires AspectJ compiler).
- **Load-time Weaving**: Aspects are woven during class loading.
- **Runtime Weaving (Used by Spring AOP)**: Aspects are dynamically applied at runtime using proxies.

Spring AOP uses **runtime weaving** and relies on proxies to apply aspects.

---

## How to Use Spring AOP

1. **Add Spring AOP Dependency**:
   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aspects</artifactId>
       <version>your-spring-version</version>
   </dependency>
