using EntityLayer.Substract;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityLayer.Concrete
{
    public class Car:IEntity
    {
        public int CarId { get; set; }
        public DateTime Model { get; set; }
        public int MyProperty { get; set; }
        public decimal HirePrice { get; set; }







        public int BrandId { get; set; }
        public int ColorId { get; set; }
    }
}
