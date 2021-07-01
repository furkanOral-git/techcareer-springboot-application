using System;

namespace AbstractFactoryReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomerManager customerManager = new CustomerManager(new Factory1());
            customerManager.GetAll();
            Console.WriteLine("--------------------------------");
            CustomerManager customerManeger2 = new CustomerManager(new Factory2());
            customerManeger2.GetAll();
            Console.ReadLine();

        }
    }

    //Bu design patternda Cross cutting concerns kavramı ilgili çapraz kesim manasındaki ilgililer Logger,Cacher,Security..vb gibi şeylerdir
    //bunlar Concerns kapsamındadır.
    public abstract class Logger
    {
        public abstract void Log(string message);
    }
    public class Log4NetLogger : Logger
    {
        string _message = "Logging with Log4Net";
        public override void Log(string message)
        {
            message = _message;
            Console.WriteLine(message);
        }
    }
    public class NLogger : Logger
    {
        string _message = "Logged with Nlogger";
        public override void Log(string message)
        {
            message = _message;
            Console.WriteLine(message);
        }
    }
    //Bu design patternda Cross cutting concerns kavramı ilgili çapraz kesim manasındaki ilgililer Logger,Cacher,Security..vb gibi şeylerdir
    //bunlar Concerns kapsamındadır.
    public abstract class Cacher
    {
        public abstract void Cache();
    }
    public class RedisCacher : Cacher
    {
        public override void Cache()
        {
            Console.WriteLine("Caching by RedisCacher");
        }
    }
    public class InMemoryCacher : Cacher
    {
        public override void Cache()
        {
            Console.WriteLine("Caching by InMemoryCacher");
        }
    }
    public abstract class CrossCutingConcernsFactory
    {
        public abstract Logger CreateLogger();
        public abstract Cacher CreateCacher();
    }
    public class Factory1 : CrossCutingConcernsFactory
    {
        public override Cacher CreateCacher()
        {
            return new RedisCacher();
        }

        public override Logger CreateLogger()
        {
            return new Log4NetLogger();
        }
    }
    public class Factory2 : CrossCutingConcernsFactory
    {
        public override Cacher CreateCacher()
        {
            return new InMemoryCacher();
        }

        public override Logger CreateLogger()
        {
            return new NLogger();
        }
    }
    public class CustomerManager
    {
        CrossCutingConcernsFactory _crossCutingConcernsFactory;
        Logger _logger;
        Cacher _cacher;
        public CustomerManager(CrossCutingConcernsFactory crossCutingConcernsFactory)
        {
            _crossCutingConcernsFactory=crossCutingConcernsFactory;
            _logger = _crossCutingConcernsFactory.CreateLogger();
            _cacher = _crossCutingConcernsFactory.CreateCacher();
        }
        public void GetAll()
        {
            _logger.Log("Log");
            _cacher.Cache();
            Console.WriteLine("Customers is Displayed");
            
        }
    }

}

