using BusinessLayer.Abstract;
using DataAccessLayer.Abstract;
using EntityLayer.Concrete;
using Core.Utilities.Results;
using System;
using System.Collections.Generic;
using System.Text;
using BusinessLayer.Constants;

namespace BusinessLayer.Concrete
{
    public class CarManagerBll : ICarServiceBll
    {
        ICarDal _repository;

        public CarManagerBll(ICarDal repository)
        {
            _repository = repository;
        }

        public IResult Add(Car car)
        {
            var AddedCar = car;
            if (AddedCar.DailyPrice > 0 && AddedCar.ModelName.Length > 2)
            {
                _repository.Add(AddedCar);
                return new SuccessResult(Messages.CarAdded);
            }
            else
            {
                return new ErrorResult(Messages.ErrorCarAdded);
            }

        }
        public IResult Delete(int id)
        {
            var DeletedCar = _repository.Get(p => p.CarId == id);
            _repository.Delete(DeletedCar);
            return new SuccessResult(Messages.CarDeleted);
        }

        public IDataResult<List<Car>> GetAll()
        {

            return new SuccessDataResult<List<Car>>(_repository.GetAll(), Messages.AllCarBrought);

        }

        public IDataResult<List<Car>> GetAllByBrandId(int id)
        {
            return new SuccessDataResult<List<Car>>(_repository.GetAll(p => p.BrandId == id), Messages.AllCarBrought);
        }

        public IDataResult<List<Car>> GetAllByColorId(int id)
        {
            return new SuccessDataResult<List<Car>>(_repository.GetAll(p => p.ColorId == id));
        }

        public IDataResult<List<Car>> GetAllByDailyPrice(decimal min, decimal max)
        {
            return new SuccessDataResult<List<Car>>(_repository.GetAll(p => p.DailyPrice >= min && p.DailyPrice <= max));
        }

        public IDataResult<Car> GetCar(int id)
        {
            return new SuccessDataResult<Car>(_repository.Get(p => p.CarId == id));
        }

        public IResult Update(int id)
        {
            var UpdatedCar = _repository.Get(p => p.CarId == id);
            _repository.Update(UpdatedCar);
            return new SuccessResult(Messages.CarUpdated);
        }





    }
}
