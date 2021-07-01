using System;
using System.Collections.Generic;
using System.Linq;

namespace LinqProject
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Category> categories = new List<Category>
            {
                new Category{CategoryId=1,CategoryName="Bilgisayar"},
                new Category{CategoryId=2,CategoryName="Telefon"}
            };
            List<Product> products = new List<Product> 
            { 
                new Product{ProductId=1,CategoryId=1,ProductName="Msi Laptop",QuantityPerUnit="32 GB Ram",UnitPrice=10000,UnitsInStock=10},
                new Product{ProductId=2,CategoryId=1,ProductName="Asus Laptop",QuantityPerUnit="16 GB Ram",UnitPrice=8000,UnitsInStock=4},
                new Product{ProductId=3,CategoryId=1,ProductName="Acer Laptop",QuantityPerUnit="8 GB Ram",UnitPrice=5000,UnitsInStock=8},
                new Product{ProductId=4,CategoryId=2,ProductName="Apple Phone",QuantityPerUnit="4 GB Ram",UnitPrice=2000,UnitsInStock=9},
                new Product{ProductId=5,CategoryId=2,ProductName="Samsung Phone",QuantityPerUnit="8 GB Ram",UnitPrice=7000,UnitsInStock=100},
                new Product{ProductId=6,CategoryId=2,ProductName="Huawai Phone",QuantityPerUnit="3 GB Ram",UnitPrice=3000,UnitsInStock=20},

            };

            Console.WriteLine("Linq----------------------------");
            //where bir şart bloğudur.
            var result = products.Where(p => p.UnitPrice > 4000 || p.UnitsInStock > 10);
            // tipi var olarak belirttik ve resultun tipi bir liste oldu çünkü içerisinde ürünler var. o yüzden foreach kullanacağız.
            foreach (var product in result)
            {
                Console.WriteLine(product.ProductName);
            }
                

        }
    }
    class Product
    {
        public int ProductId { get; set; }
        public int CategoryId { get; set; }
        public string ProductName { get; set; }
        public string QuantityPerUnit { get; set; }
        public decimal UnitPrice { get; set; }
        public int UnitsInStock { get; set; }
    }
    class Category
    {
        public int CategoryId { get; set; }
        public string CategoryName { get; set; }
    }
}
