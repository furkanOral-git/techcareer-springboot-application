using BusinessLayer.Concrete;
using DataAccessLayer.Concrete.EntityFramework;
using DataAccessLayer.Concrete.InMemory;
using EntityLayer.Concrete;
using System;

namespace ConsoleUI
{
    class Program
    {
        static void Main(string[] args)
        {
            CarManagerBll carManagerBll = new CarManagerBll(new EfCarDal());
            carManagerBll.Add(new Car { });
            
    
            Console.ReadLine();






        }
    }
}
