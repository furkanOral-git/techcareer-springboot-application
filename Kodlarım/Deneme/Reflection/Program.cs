using System;
using System.Reflection;

namespace Reflection
{
    class Program
    {
        static void Main(string[] args)
        {
            //Reflection ile uygulama çalışırken işlem yaparız ve kullanımı pahalıdır sadece gerçekten yapmamız gerekliyse reflection kullanmalıyız.
            // (1)işlem numarası-kod= DortIslem dortIslem = new DortIslem(3, 4);
            //dortIslem.Carp2();
             var Type = typeof(DortIslem);
            ////Dinamik İnstance oluşturduk.
            // DortIslem dortIslem =(DortIslem)Activator.CreateInstance(Type,3,5);//(1) numaralı işlemi yapmış olduk.
            // Console.WriteLine(dortIslem.Carp(3, 4));
            // Console.WriteLine(dortIslem.Carp2());
            var instance = Activator.CreateInstance(Type, 3, 5);
            var metodlar = Type.GetMethods();
            foreach (var metod in metodlar)
            {
                Console.WriteLine(metod);
            }
            MethodInfo methodInfo = instance.GetType().GetMethod("Topla2");
            
            Console.WriteLine(instance.GetType().GetMethod("Topla2").Invoke(instance,null));
            Console.ReadLine();
        }
    }
    public class DortIslem
    {
        private int _sayi1;
        private int _sayi2;
        public DortIslem(int sayi1,int sayi2)
        {
            _sayi1 = sayi1;
            _sayi2 = sayi2;
        }
        public int Topla(int sayi1,int sayi2)
        {
            return sayi1 + sayi2;
        }
        public int Carp(int sayi1,int sayi2)
        {
            return sayi1 * sayi2;
        }
        public int Topla2()
        {
            return _sayi1 + _sayi2;
        }
        public int Carp2()
        {
            return _sayi1 * _sayi2;
        }
    }
}
