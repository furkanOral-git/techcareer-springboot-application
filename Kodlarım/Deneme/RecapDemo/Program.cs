using System;

namespace RecapDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomerManager customerManager = new CustomerManager();
            customerManager.logger = new SmsLogger();
            customerManager.Add();
            customerManager.logger = new DataBaseLogger();
            customerManager.Add();
            customerManager.logger = new FileLogger();
            customerManager.Add();



            Console.ReadLine();

        }
    }
    class CustomerManager
    {
        public ILogger logger { get; set; }
        public void Add()
        {
            logger.Log();
            Console.WriteLine("Customer is Added!");
        }
    }
    class DataBaseLogger:ILogger
    {
        public void Log()
        {
            Console.WriteLine("Customer is Logged to DataBase!");
        }
    }
    interface ILogger
    {
        void Log();
    }
    class FileLogger : ILogger
    {
        public void Log()
        {
            Console.WriteLine("Logged To File!");
        }
    }
    class SmsLogger : ILogger
    {
        public void Log()
        {
            Console.WriteLine("Logged by Sms!");
        }
    }

}
