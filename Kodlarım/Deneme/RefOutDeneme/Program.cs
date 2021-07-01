using System;

namespace RefOutDeneme
{
    class Program
    {
        static void Main(string[] args)
        {

            int a;
            Topla2(out a);
            Console.WriteLine(a);

            //RefTest();
            // OutTest();
            //Console.WriteLine(Topla1(out a, out b));
            //Console.WriteLine(Topla1(out a, out b));
            //Console.WriteLine(Topla1(out a, out b));
            //Console.WriteLine(Topla1(out a, out b));



        }

        private static void OutTest()
        {
            int a;
            int b;
            Console.WriteLine(Topla1(out a, out b));
            Console.WriteLine(a);
        }

        private static void RefTest()
        {
            int a = 9;
            int b = 10;
            
            Console.WriteLine(Topla(ref a, ref b));
            Console.WriteLine(Topla(ref a, ref b));
            Console.WriteLine(Topla(ref a, ref b));
            Console.WriteLine(Topla(ref a, ref b));
            Console.WriteLine(Topla(ref a, ref b));
            Console.WriteLine(Topla(ref a, ref b));
            
        }

        public static int Topla(ref int sayi, ref int sayi1)
        {
            int toplam = sayi + sayi1;
            sayi++;
            sayi1++;
            return toplam;

           
            
        }
        public static  int  Topla1(out int sayi,out int sayi1)
        {
            sayi = 9;
            sayi1 = 10;
            int toplam = sayi + sayi1;
            sayi++;
            sayi1++;
            return toplam;

        }
        public static int Topla2(out int sayi)
        {
            sayi = 30;
            return sayi;
        }
    }
    
}
