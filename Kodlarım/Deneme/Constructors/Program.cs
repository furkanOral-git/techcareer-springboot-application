using System;

namespace Constructors
{
    class Program
    {
        static void Main(string[] args)
        {
            PersonManager personManager = new PersonManager("Person");
            Console.ReadLine();
        }
    }
  
    class BaseClass
    {
        string _entity;
        public BaseClass(string entity)
        {
            _entity = entity;
        }
        public void Massage()
        {
            
            Console.WriteLine("Eklendi {0}",_entity);
        }
    }
    class PersonManager:BaseClass
    {
        public PersonManager(string entity):base(entity)
        {
            Massage();
        }
    }
}
