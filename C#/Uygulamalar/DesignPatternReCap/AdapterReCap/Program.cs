using System;

namespace AdapterReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            ProductManager productManager = new ProductManager(new Log4NetAdabter());
            productManager.Save();
            Console.ReadLine();
        }
    }
    class ProductManager
    {
        ILogger _logger;
        public ProductManager(ILogger logger)
        {
            _logger = logger;
        }
        public void Save()
        {
            _logger.Log("Data Base");
            Console.WriteLine("Saved...");
        }
    }
    interface ILogger
    {
        void Log(string message);
    }
    //Kendi Projemizde kullandığımız nesnemiz
    public class EdLogger : ILogger
    {
        public void Log(string message)
        {
            Console.WriteLine("EdLogger Logged ,{0}",message);
        }
    }
    //dışardan aldığımız ve projemize adapte edeceğimiz nesne
    public class Log4Net 
    {
        public void LogMessage(string message)
        {
            Console.WriteLine("Log4Net Logged ,{0}",message);
        }
    }
    public class Log4NetAdabter : ILogger
    {
        public void Log(string message)
        {
            Log4Net log4Net = new Log4Net();
            log4Net.LogMessage(message);
        }
    }
}
