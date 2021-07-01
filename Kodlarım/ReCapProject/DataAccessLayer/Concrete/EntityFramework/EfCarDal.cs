using Core.DataAccess.EntityFramework;
using DataAccessLayer.Abstract;
using EntityLayer.Concrete;
using EntityLayer.DTOs;
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;



namespace DataAccessLayer.Concrete.EntityFramework
{
    public class EfCarDal : EfEntityRepositoryBase<Car, RentACarContext>, ICarDal
    {
        public List<CarDetailsDto> GetCarDetails()
        {
            using (RentACarContext context = new RentACarContext())
            {
                var result = from p in context.Cars
                             join c in context.Colors on p.ColorId equals c.ColorId
                             join b in context.Brands on p.BrandId equals b.BrandId
                             select new CarDetailsDto { CarId = p.CarId, BrandName = b.Name, ColorName = c.Name, DailyPrice = p.DailyPrice, ModelYear = p.ModelYear };
                
                return result.ToList();

            }

        }
    }
}
