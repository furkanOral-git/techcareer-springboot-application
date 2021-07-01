using System;
using System.Collections.Generic;

namespace CommandReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            //Receiver,Invoker(Yardımcı),ICommand,ConcreteCommand,Client
            StockManager stockManager = new StockManager();
            BuyStock buyStock = new BuyStock(stockManager,10,"Phone");
            SellStock sellStock = new SellStock(stockManager,12,"Laptop");

            StockController stockController = new StockController();
            stockController.TakeOrders(buyStock);
            stockController.TakeOrders(sellStock);
            stockController.PlaceOrders();
            
            Console.ReadLine();


        }
    }
    //Yardımcı Invoker sınıfımız
    public class StockController
    {
        List<IOrder> _orders = new List<IOrder>();

        public void TakeOrders(IOrder order)
        {
            _orders.Add(order);
        }
        public void PlaceOrders()
        {
            foreach (IOrder order in _orders)
            {
                order.Execute();
            }
            _orders.Clear();
        }

    }
    //ICommand nesnemiz bu
    public interface IOrder
    {
        public void Execute();
    }
    //Receiver nesnemiz de bu
    public class StockManager
    {
        protected int _quantity { get; set; }
        protected string _stockName { get; set; }
        

        public void Buy()
        {
            Console.WriteLine("{1} Ürününden {0} adet stock satın alındı...",_quantity,_stockName);
        }
        public void Sell()
        {
            Console.WriteLine("{1} ürününden {0} adet stock satıldı...",_quantity,_stockName);
        }
    }
    //ConcreteCommand nesnesi
    public class BuyStock:StockManager,IOrder
    {
        private StockManager _stockManager;
        
        public BuyStock(StockManager stockManager,int quantity,string name)
        {
            _stockManager = stockManager;
            _quantity = quantity;
            _stockName = name;
        }

        public void Execute()
        {
            _stockManager.Buy();
        }
    }
    //ConcreteCommand nesnesi
    public class SellStock:StockManager,IOrder
    {
        private StockManager _stockManager;

        public SellStock(StockManager stockManager, int quantity, string name)
        {
            _stockManager = stockManager;
            _quantity = quantity;
            _stockName = name;
        }

        public void Execute()
        {
            _stockManager.Sell();
        }
    }

}
