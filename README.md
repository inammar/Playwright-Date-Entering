
[![Playwright Tests](https://github.com/inammar/Playwright-Date-Entering/actions/workflows/main.yml/badge.svg)](https://github.com/inammar/Playwright-Date-Entering/actions/workflows/main.yml)

# 📅 Date Picker Automation Project (Playwright + Java)

This project demonstrates automated UI testing of a date picker component using **Java** and **Playwright**.
It is designed as a beginner-friendly QA automation example with CI integration.

## 🚀 Tech Stack

* Java
* Playwright
* IntelliJ IDEA
* GitHub Actions (CI/CD)

## ⚙️ CI/CD

GitHub Actions workflows are configured to:

* Run automated tests on push
* Validate test execution in a CI environment

## 🧪 Test Case: Date Picker 1 – Valid Date Selection

**Test Case ID:** TC_001
**Priority:** Medium
**Type:** UI / Functional / Automated

### 📌 Description

Verify that a user can successfully select a valid date using the Date Picker 1 component.


## ✅ Preconditions

* User has access to the test page

## 📊 Test Data

* Date: `07/17/2026`

## 🔄 Test Steps

1. Navigate to the test page
2. Locate the **"Date Picker 1"** input field
3. Click on the input field
4. Wait for the calendar widget to appear
5. Navigate to **July 2026** (if not already visible)
6. Select day **17**

## 🎯 Expected Results

* Calendar widget is displayed after clicking the input field
* User can navigate between months
* Selected date is inserted into the input field
* Date is displayed in correct format: `MM/DD/YYYY (07/17/2026)`

## 📌 Postconditions

* The selected date remains visible in the input field.

## 🔍 Validation

* Assertion is performed on the input field value to verify correct date selection.

## 📝 Notes

* Test is fully automated using Playwright with Java.


