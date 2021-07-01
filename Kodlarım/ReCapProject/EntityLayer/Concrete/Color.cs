using Core.Entities;
using System;
using System.Collections.Generic;
using System.Text;


namespace EntityLayer.Concrete
{
    
    public class Color : IEntity
    {
        public int ColorId { get; set; }
        public string Name { get; set; }
        public bool IsActive { get; set; }

        

    }
}
