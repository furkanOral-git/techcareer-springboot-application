using System;
using System.Collections.Generic;
using System.Text;
using Core.DataAccess.EntityFramework;
using DataAccessLayer.Abstract;
using EntityLayer.Concrete;

namespace DataAccessLayer.Concrete.EntityFramework
{
    public class EfColorDal : EfEntityRepositoryBase<Color,RentACarContext>,IColorDal
    {
        
    }
}
