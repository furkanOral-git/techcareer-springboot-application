using System;

namespace Delegates
{
    public delegate void MyDelegate();
    public delegate void MyDelegate2(string text);
    public delegate int MyDelegate3(int number1, int number2);
    class Program
    {
        static void Main(string[] args)
        {
            CustomerManager customerManager = new CustomerManager();
            MyDelegate myDelegate = customerManager.SendMessage;
            myDelegate += customerManager.ShowAlert;
            myDelegate -= customerManager.SendMessage;//işlemi delegeden çıkartıyoruz artık delege çağrıldığında bu işlemi yapmıcak.
            myDelegate();
            Console.WriteLine("--------------------------");
            MyDelegate2 myDelegate2 = customerManager.SendMessage2;
            myDelegate2 += customerManager.ShowAlert2;
            myDelegate2("Hello");
            Console.WriteLine("---------------------------");
            Matematik matematik = new Matematik();
            MyDelegate3 myDelegate3 = matematik.Topla;
            myDelegate3 += matematik.Carp;
            // geri dönüş tipi olan delegelerde en son eklenen işlem uygulanır. Yani ilk başta verdiğimiz toplayı yapmıcaktır.
            var result = myDelegate3(3, 4);
            Console.WriteLine(result);
            //ActionDemo();
            Console.WriteLine("Normal Method Çağırarak ---------------------------");
            Console.WriteLine(FuncDemo.Topla(2, 5));//normalde böyle fakat func ile?
            Console.WriteLine("Func ile -----------------------------------");
            Func<int, int, int> add = FuncDemo.Topla;
            Func<int> GetRandomNumber = delegate () 
            {
                Random random = new Random();
                int Sayi;
                Sayi = random.Next(1, 100);
                return Sayi;
            };
            Console.WriteLine(GetRandomNumber);
            Console.WriteLine("-----------------------------------");
            Console.WriteLine(add(4, 6));


            Console.ReadLine();
        }

        private static void ActionDemo()
        {
            Console.WriteLine("---------------------------");
            ExceptionDelegates.HandleException(() => { ExceptionDelegates.Find(); });
        }
    }
    public class Matematik
    {
        public int Topla(int sayi1, int sayi2)
        {
            return sayi1 + sayi2;
        }

        public int Carp(int sayi1, int sayi2)
        {
            return sayi1 * sayi2;
        }


    }
    public class CustomerManager
    {
        public void SendMessage()
        {
            Console.WriteLine("Hello");
        }
        public void ShowAlert()
        {
            Console.WriteLine("Be Carefull!");
        }
        public void SendMessage2(string message)
        {
            Console.WriteLine(message);
        }
        public void ShowAlert2(string alert)
        {
            Console.WriteLine(alert);
        }

    }
    class ExceptionDelegates
    {
        public static void HandleException(Action action)
        {
            try
            {
                action.Invoke();
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception.Message);
            }
        }
        public static void Find()
        {
            Console.WriteLine("Aranıyor...Buldu!");
        }
    }
    public class FuncDemo
    {
        public static int Topla(int x, int y)
        {
            return x + y;

        }
    }
}
