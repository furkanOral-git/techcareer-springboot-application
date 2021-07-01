using System;
namespace Kalıtım
{
    class Program
    {
        static void Main(string[] args)
        {

            SekilHesaplamaları sekilHesaplamaları =new SekilHesaplamaları();

            Kare kare = new Kare(10);
            Ucgen ucgen = new Ucgen(4,4,6,5);

            Console.WriteLine( sekilHesaplamaları.AlanHesapla(ucgen) ); 

            
        }
    }
}
