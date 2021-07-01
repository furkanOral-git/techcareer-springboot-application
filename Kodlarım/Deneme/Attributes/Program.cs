using System;

namespace Attributes
{
    class Program
    {
        static void Main(string[] args)
        {
            
            CustomerDal customerDal = new CustomerDal();
            Customer customer = new Customer { FirstName = "Furkan", LastName = "Oral", Age = 21 };
            customerDal.Add(customer);
            
           
        }
    }
    //classa attribute ekledik.
    [ToTable("Customers")]
    [ToTable("tblCustomers")]

    public class Customer
    {
        //propertylere attribute ekledik
        [RequiredProperty]
        public int Id { get; set; }
        [RequiredProperty]
        public string FirstName { get; set; }
        [RequiredProperty]
        public string LastName { get; set; }
        [RequiredProperty]
        public int Age { get; set; }
    }
    public class CustomerDal
    {
        public void Add(Customer customer)
        {
            Console.WriteLine("{0} {1} {2} Added!",customer.FirstName,customer.LastName,customer.Age);
        }
    }
    //Attribute un etki edeceği yapıları AttributeUsage(AttributeTargets.) methoduyla yapabiliriz. 
    // pipe | işareti ile bu attribute u sadece propertylere ve fieldlara konulabilir hale getirdik.
    [AttributeUsage(AttributeTargets.Property | AttributeTargets.Field)]
    class RequiredPropertyAttribute : Attribute
    {
        
    }
    //allow multiple ile aynı attribute u birden fazla kez kullanabliriz. örnk ToTable attribute unda var.
    [AttributeUsage(AttributeTargets.Class,AllowMultiple =true)]
    class ToTableAttribute : Attribute
    {
        private string _TableName;
        public ToTableAttribute(string TableName)
        {
            _TableName = TableName;
        }
    }
}
