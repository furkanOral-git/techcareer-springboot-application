﻿using Core.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace EntityLayer.Concrete
{
    
    public class Car : IEntity
    {
        public int CarId { get; set; }
        public string ModelName { get; set; }
        public string ModelYear { get; set; }
        public decimal DailyPrice { get; set; }
        public string Description { get; set; }

        public int BrandId { get; set; }

        public int ColorId { get; set; }
       

    }
}
