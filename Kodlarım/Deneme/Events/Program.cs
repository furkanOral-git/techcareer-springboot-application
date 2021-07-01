using System;

namespace Events
{
    class Program
    {
        static void Main(string[] args)
        {
            Product hardDisk = new Product(50);
            hardDisk.ProductName = "Hard Disk";

            Product gsm = new Product(50);
            gsm.ProductName = "Gsm";
            gsm.StockControlEvent += Gsm_StockControlEvent;

            for (int i = 0; i <= 10; i++)
            {
                gsm.Sell(10);
                hardDisk.Sell(10);
                Console.ReadLine();

            }
            Console.ReadLine();


        }

        private static void Gsm_StockControlEvent()
        {
            Console.WriteLine("Gsm about the finish!");
        }
    }
}
