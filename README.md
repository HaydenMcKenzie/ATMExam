# ATMExam 

ATMExam is project where you interact with an ATM. 

# Tutorial
  1. You are prompted for a user ID - 001, 002 or 003.
  2. Then it displays options including: 1. for Deposit, 2. for Withdraw, 3. for Balance or q for Quit.
  3. You are given the accounts related to the user ID from before and you need to choose which account to interact with - Accounts have a number you need to enter to interact with it.
  4. If you chose Deposit or Withdraw, you are prompted to enter amount you want to add/minus from the account. If you chose Balance, then it displays the accounts balance.
  5. If then updates to the new balance and then you repeat from 1. until user enters q.
  6. When you enter q, it prints all the accounts and their new balances.

# Error Handling

  - For all incorrect inputs, it displays an Error message and takes you back to the start. 
  - If you chose Withdraw and enter an amount that is greater than your balance, it brings up an Withdrawal Error and takes you to the start again. 

# Other Information

  - I use a .txt file as a pseudo database.
