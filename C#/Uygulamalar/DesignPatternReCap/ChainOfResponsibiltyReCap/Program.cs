using System;

namespace ChainOfResponsibiltyReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            ExpenseHandler manager = new Manager();
            ExpenseHandler vicePresident = new VicePresident();
            ExpenseHandler president = new President();
            Expense expense = new Expense() { Amount = 4000,Detail="Training" };
            
            
            manager.SetSuccessor(vicePresident);
            vicePresident.SetSuccessor(president);
            manager.HandleExpense(expense);

            Console.ReadLine();
            


        }

    }

    public class Expense
    {
        public string Detail { get; set; }
        public decimal Amount { get; set; }
    }
    public abstract class ExpenseHandler
    {
        protected ExpenseHandler _successor;

        public abstract void HandleExpense(Expense expense);
        public void SetSuccessor(ExpenseHandler successor)
        {
            _successor = successor;
        }
    }
    public class Manager : ExpenseHandler
    {
        public override void HandleExpense(Expense expense)
        {
            if (expense.Amount <= 100)
            {
                Console.WriteLine("Expense is Handling by Manager");
            }
            else if(_successor != null)
            {
                _successor.HandleExpense(expense);
            }

        }

        
    }
    public class VicePresident : ExpenseHandler
    {
        public override void HandleExpense(Expense expense)
        {
            if (expense.Amount >= 100 && expense.Amount <= 1000)
            {
                Console.WriteLine("Expense is Handling by Vice President");
            }
            else if (_successor != null)
            {
                _successor.HandleExpense(expense);
            }
        }

       
    }
    public class President : ExpenseHandler
    {
        public override void HandleExpense(Expense expense)
        {
            if (expense.Amount >=1000 && expense.Amount <= 5000)
            {
                Console.WriteLine("Expense is Handling by President");
            }
            else if (_successor != null)
            {
                _successor.HandleExpense(expense);
            }
        }
    }
}


