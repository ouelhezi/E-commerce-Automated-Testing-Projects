# 🧪 SauceDemo - Automated Testing Projects

This repository contains three small automated testing projects developed to practice and compare different approaches and tools for web application testing.

The tests are performed on **Swag Labs (SauceDemo)**, an e-commerce web application used for practicing test automation.

🌐 **Application under test:** https://www.saucedemo.com/

---

## 📌 Project Overview

The repository is divided into three independent projects. Each project focuses on a different testing approach or framework:

| Project              | Technology             | Main Purpose                                   |
| -------------------- | ---------------------- | ---------------------------------------------- |
| 🥒 TestCucumber    | Cucumber + Selenium    | Behavior-Driven Development (BDD)              |
| 🔎 SeleniumProject    | Selenium WebDriver     | Web UI automation                              |
| 🏭 TestFactory | Selenium + PageFactory | Page Object Model and maintainable test design |

The objective is to automate common e-commerce user scenarios such as login, product selection, cart management and checkout.

---

# 🥒 1. Cucumber Tests (TestCucumber)

The first project uses **Cucumber** to implement automated tests following the **BDD (Behavior-Driven Development)** approach.

### Technologies

* Java
* Selenium WebDriver
* Cucumber
* Maven
* JUnit / TestNG

### Approach

The test scenarios are written using **Gherkin** syntax:

```gherkin
Feature: SauceDemo Login

  Scenario: Successful login
    Given the user is on the SauceDemo login page
    When the user enters valid credentials
    And clicks on the login button
    Then the products page should be displayed
```

This approach makes test scenarios easier to understand for both technical and non-technical team members.

---

# 🔎 2. Selenium Tests (SeleniumProject)

The second project focuses on **Selenium WebDriver** for browser automation.

### Technologies

* Java
* Selenium WebDriver
* Maven
* JUnit / TestNG

### Example scenarios

The automated tests can cover:

* User login
* Invalid login
* Product selection
* Add product to cart
* Remove product from cart
* Checkout
* Logout

Example:

```java
driver.get("https://www.saucedemo.com/");

driver.findElement(By.id("user-name"))
      .sendKeys("standard_user");

driver.findElement(By.id("password"))
      .sendKeys("secret_sauce");

driver.findElement(By.id("login-button"))
      .click();
```

---

# 🏭 3. PageFactory Tests (TestFactory)

The third project uses **PageFactory** together with Selenium to organize the automation framework using the **Page Object Model (POM)** design pattern.

The goal is to separate:

* Test logic
* Page elements
* Page interactions

For example:

```text
pages/
│
├── LoginPage.java
├── ProductsPage.java
├── CartPage.java
└── CheckoutPage.java

tests/
│
├── LoginTest.java
├── ProductTest.java
└── CheckoutTest.java
```

This architecture improves:

* ♻️ Code reusability
* 🧹 Code maintainability
* 📖 Test readability
* 🔧 Test scalability

---

# 🧪 Main Test Scenarios

The projects can be used to automate the following SauceDemo scenarios:

### Authentication

* ✅ Login with valid credentials
* ❌ Login with invalid credentials
* ❌ Login with locked-out user
* 🚪 Logout

### Products

* ✅ Display products
* ✅ Select a product
* ✅ Add product to cart
* ✅ Remove product from cart
* ✅ Sort products

### Shopping Cart

* ✅ Verify cart contents
* ✅ Add multiple products
* ✅ Remove products

### Checkout

* ✅ Enter customer information
* ✅ Verify order summary
* ✅ Complete checkout
* ✅ Verify successful order

---

# 🔑 Test Credentials

SauceDemo provides test users that can be used for automation practice.

Example:

```text
Username: standard_user
Password: secret_sauce
```

The credentials should preferably be stored in configuration files or environment variables in a real-world automation project.

---

# ⚙️ Prerequisites

Before running the projects, make sure the following are installed:

* Java JDK
* Maven
* Git
* Chrome / Firefox / another supported browser
* An IDE such as IntelliJ IDEA or Eclipse

Verify the installations:

```bash
java -version
mvn -version
git --version
```

---

# ▶️ Running the Tests

Clone the repository:

```bash
git clone https://github.com/ouelhezi/E-commerce-Automated-Testing-Projects.git
```

Navigate to the desired project:

```bash
cd TestCucumber
```

Run the tests with Maven:

```bash
mvn test
```

The same process can be used for the other projects:

---

# 📊 Comparison

| Feature                     | Cucumber | Selenium | PageFactory |
| --------------------------- | -------: | -------: | ----------: |
| Browser automation          |        ✅ |        ✅ |           ✅ |
| BDD / Gherkin               |        ✅ |        ❌ |           ❌ |
| Page Object Model           | Possible | Optional |           ✅ |
| Readable scenarios          |      ⭐⭐⭐ |       ⭐⭐ |          ⭐⭐ |
| Maintainability             |      ⭐⭐⭐ |       ⭐⭐ |         ⭐⭐⭐ |
| Suitable for large projects |        ✅ |        ✅ |           ✅ |

> Note: Cucumber, Selenium and PageFactory are not exactly competing technologies. Selenium is the browser automation engine, Cucumber provides a BDD layer, and PageFactory is a way of structuring page objects. This repository demonstrates these different approaches in separate projects.

---

# 🎯 Learning Objectives

This repository was created to practice:

* Web application test automation
* Selenium WebDriver
* Cucumber and BDD
* Gherkin syntax
* Page Object Model
* PageFactory
* Maven project management
* Automated functional testing
* Test organization and maintainability
* Git and GitHub

---
