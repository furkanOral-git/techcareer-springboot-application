using System;

namespace VirtualMethods
{
    class Program
    {
        static void Main(string[] args)
        {
            //VirtualMethodTest();
            //Abstract classlar ise virtual metodlarla interfacelerin birleşimi şeklinde oluyor.
            //Abstract classlar new() lenemez.
            SqlServerDataBase1 sqlServerDataBase1 = new SqlServerDataBase1();
            sqlServerDataBase1.Add();
            sqlServerDataBase1.Delete();
            OracleServerDataBase1 oracleServerDataBase1 = new OracleServerDataBase1();
            oracleServerDataBase1.Add();
            oracleServerDataBase1.Delete(); 
        }

        private static void VirtualMethodTest()
        {
            SqlDataBase sqlDataBase = new SqlDataBase();
            sqlDataBase.Add();
            sqlDataBase.Delete();
            OracleDataBase oracleDataBase = new OracleDataBase();
            oracleDataBase.Add();
            oracleDataBase.Delete();
            Console.ReadLine();
        }
    }
    class Database 
    {
        // virtual yaparak ayrı ayrı derived classlarda metodu ezmiş olduk.
        public virtual void Add()
        {
            Console.WriteLine("Added By Default");
        }

        public void Delete()
        {
            Console.WriteLine("Deleted By Default");
        }
    }
    class SqlDataBase : Database
    {
        public override void Add()
        {
            Console.WriteLine("Added By SqlDataBase Code");
            //base.Add();
        }
    }
    class OracleDataBase : Database
    {
        public override void Add()
        {
            Console.WriteLine("Added By OracleDataBase Code");
            //base.Add();
        }
    }
    abstract class DataBase1
    {
        // Add metodu her Derived Classda farklı olduğu için abstract tanımladık ve diğer Oracle ve Sql Databaselerin 
        // bu abstract metodu override etmesini zorunlu kıldık çünkü işlemleri farklı.
        // Ezilecek Kod abstract olarak tanımlanır.
        
        //Tamamlanmamış metod abstract metod.
        public abstract void Add();
        // Delete metodunda ise hepsi ortak bu yüzden abstract olarak tanımlamadık ve dafault kodlarımızı yazdık.
        //Tamamlanmış metod ise normal içini doldurduğumuz metod.
        public void Delete()
        {
            Console.WriteLine("Deleted By Default");
        }
        
    }
    class OracleServerDataBase1 : DataBase1
    {
        public override void Add()
        {
            Console.WriteLine("Added By OracleServer Code");
        }
    }
    class SqlServerDataBase1 : DataBase1
    {
        public override void Add()
        {
            Console.WriteLine("Added By SqlServer Code");
        }
    }
}
