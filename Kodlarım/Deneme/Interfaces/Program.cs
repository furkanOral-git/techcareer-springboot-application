using System;

namespace Interfaces
{
    class Program
    {
        static void Main(string[] args)
        {
            //ProductManager productManager = new ProductManager();
            //productManager.Add(new OracleServerProductDal());
            //productManager.Add(new SqlServerProductDal());
            IProductDal[] productDals = new IProductDal[2] { new OracleServerProductDal(), new SqlServerProductDal() };
            foreach (IProductDal productDal in productDals)
            {
                productDal.Add();
                productDal.Delete();
                productDal.Update();
            }
            Console.ReadLine();

        }
    }
    interface IProductDal
    {
        void Add();
        void Delete();
        void Update();

    }
    class SqlServerProductDal : IProductDal
    {
        public void Add()
        {
            Console.WriteLine("Sql Server Added");
        }

        public void Delete()
        {
            Console.WriteLine("Sql Server Deleted");
        }

        public void Update()
        {
            Console.WriteLine("Sql Server Updated");
        }

    }
    class OracleServerProductDal : IProductDal
    {
        public void Add()
        {
            Console.WriteLine("Oracle Server Added");
        }

        public void Delete()
        {
            Console.WriteLine("Oracle Server Deleted");
        }

        public void Update()
        {
            Console.WriteLine("Oracle Server Updated");
        }

    }
    class ProductManager
    {
        public void Add(IProductDal productDal)
        {
            productDal.Add();
        }

        public void Delete(IProductDal productDal)
        {
            productDal.Delete();
        }

        public void Update(IProductDal productDal)
        {
            productDal.Update();
        }


    }
}
