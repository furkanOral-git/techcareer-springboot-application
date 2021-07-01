using System;

namespace EnumProject
{
    class Program
    {

        int gun;
        static void Main(string[] args)
        {
            int[] haftasonu = new int[2] { (int)Days.Cumartesi, (int)Days.Pazar };
            foreach (int i in haftasonu)
            {
                Console.WriteLine(i);
            }

            
            Days myVar = Days.Cuma;
            
            switch (myVar)
            {
                case Days.Pazartesi:
                    Console.WriteLine("Bugün Pazartesi");
                    break;
                case Days.Salı:
                    Console.WriteLine("Bugün Salı");
                    break;
                case Days.Çarşamba:
                    Console.WriteLine("Bugün Çarşamba");
                    break;
                case Days.Perşembe:
                    Console.WriteLine("Bugün Perşembe");
                    break;
                case Days.Cuma:
                    Console.WriteLine("Bugün Cuma");
                    break;
                case Days.Cumartesi:
                    Console.WriteLine("Bugün Cumatesi");
                    break;
                case Days.Pazar:
                    Console.WriteLine("Bugün Pazar");
                    break;
               
            }



        }
        enum Days
        {
            Pazartesi,
            Salı,
            Çarşamba,
            Perşembe,
            Cuma,
            Cumartesi,
            Pazar,
        }
        public int GunAtla(int[] days)
        {
            foreach (int day in days)
            {
              return   
            }
            
        }


    }
}



