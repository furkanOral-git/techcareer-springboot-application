using System;
using System.Collections;
using System.Collections.Generic;

namespace Collections
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.ReadLine();
        }

        private static void Lists()
        {
            List<string> names = new List<string>();
            names.Add("Furkan");
            names.Add("Elif");
            names.Add("Talha");
            foreach (var item in names)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("--------------------------------------------");

            List<Customer> customers = new List<Customer>
            {
                new Customer() { Id=1,Name="Furkan" },
                new Customer() { Id = 2,Name="Elif" },
                new Customer() { Id = 3,Name="Talha"},
                new Customer() { Id = 4,Name = "Aslı"},
            };
            foreach (var customer in customers)
            {
                Console.WriteLine(customer.Name);
            }
            Console.WriteLine("---------------------------------------------");

            var count = customers.Count;
            Console.WriteLine(count);
            
        }

        private static void ArrayList()
        {
            ArrayList cities = new ArrayList();
            cities.Add("İstanbul");
            cities.Add("Ankara");
            cities.Add("Burhaniye");
            cities.Add('A');
            cities.Add(10);
            cities.Add(10.9);
            foreach (var item in cities)
            {
                Console.WriteLine(item);
            }
        }
        private static void ArrayAndReferenceTypes()
        {
            string[] cities = new string[3] { "İstanbul", "Ankara", "Bilecik" };
            string[] cities2 = new string[2] { "Burhaniye", "Balıkesir" };
            cities = cities2;
            cities[0] = "Bolu";
            cities2[1] = "Konya";

            foreach (string city in cities2)
            {
                Console.WriteLine(city);

            }
        }
    }
    class Customer
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }
}

