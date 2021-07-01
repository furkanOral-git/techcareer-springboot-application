using EntityLayer.Concrete;
using Core.Utilities.Results;
using System;
using System.Collections.Generic;
using System.Text;

namespace BusinessLayer.Abstract
{
    public interface ICarServiceBll
    {
        IResult Add(Car car);
        IResult Delete(int id);
        IResult Update(int id);
        IDataResult<List<Car>> GetAllByBrandId(int id);
        IDataResult<List<Car>> GetAllByColorId(int id);
        IDataResult<List<Car>> GetAllByDailyPrice(decimal min, decimal max);
        IDataResult<List<Car>> GetAll();
        IDataResult<Car> GetCar(int id);



    }
}
