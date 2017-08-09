<%--
  Created by IntelliJ IDEA.
  User: travi
  Date: 8/7/2017
  Time: 11:46 AM
  Description:  Page to allow users to add financial info (will first import regional averages for the different fields)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Financial Info</title>
</head>
<body>
<div>
    <h1>Enter Your Financial Information</h1>
</div>
<br>
<br>
<form action="/userhome">
    <FIELDSET>
        <LEGEND>Your Assets and Monthly Income</LEGEND>
        <label>
            Total Household Savings:
            <input type="text" name="th_savings" size="30" maxlength="100" required>
        </label>
         <br>
        <label>
            Monthly Household Income:
            <input type="text" name="th_income" size="30" maxlength="100" required>
        </label>
        <br>
    </FIELDSET>
    <br>
    <fieldset>
        <legend>
            Your Household Expenses
        </legend>
        <label>
            Mortgage/Rent:
            <input type="text" name="rent" size="30" maxlength="100" required>
        </label>
        <br>
        <label>
            Utilities:
            <input type="text" name="utils" size="30" maxlength="100" required>
        </label>
        <br>
    </fieldset>
    <br>
    <fieldset>
        <legend>
            Your Transportation Expenses:
        </legend>
        <label>
            Gasoline:
            <input type="text" name="gas" size="30" maxlength="100">
        </label>
        <br>
        <label>
            Insurance:
            <input type="text" name="c_insurance" size="30" maxlength="100">
        </label>
        <br>
        <label>
            Car note:
            <input type="text" name="c_bill" size="30" maxlength="100">
        </label>
    </fieldset>
    <br>
    <fieldset>
        <legend>
            Your Food Expenses:
        </legend>
        <label>
            Groceries:
            <input type="text" name="groceries" size="30" maxlength="100">
        </label>
        <br>
        <label>
            Restaurants:
            <input type="text" name="restaurant" size="30" maxlength="100">
        </label>
        <br>
    </fieldset>
    <br>
    <fieldset>
        <legend>
           Recurring Debt Payments
        </legend>
        <label>
            Credit Cards:
            <input type="text" name="creditCard" size="30" maxlength="100">
        </label>
        <br>
        <label>
            Student Loans:
            <input type="text" name="s_loans" size="30" maxlength="100">
        </label>
        <br>
        <label>
            Other Debt:
            <input type="text" name="o_debt" size="30" maxlength="100">
        </label>
    </fieldset>
    <br>
    <fieldset>
        <legend>
          Extra Expenses
        </legend>
        <label>
            Medicine:
            <input type="text" name="meds" size="30" maxlength="100">
        </label>
        <br>
        <label>
            Other Expenses
            <input type="text" name="o_expense" size="30" maxlength="100">
        </label>
    </fieldset>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
