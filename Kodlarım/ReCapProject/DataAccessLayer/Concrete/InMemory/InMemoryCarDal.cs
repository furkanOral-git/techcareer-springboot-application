using DataAccessLayer.Abstract;
using EntityLayer.Concrete;
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
using System.Linq.Expressions;
using EntityLayer.DTOs;

namespace DataAccessLayer.Concrete.InMemory
{
    public class InMemoryCarDal : ICarDal
    {
        List<Car> _cars;

        public InMemoryCarDal()
        {
            _cars = new List<Car>()
            {
                new Car {CarId = 1 , Description="Audi" },
                new Car {CarId = 2, Description="Mercedes" },
                new Car {CarId = 3, Description = "Suzuki"},
                new Car {CarId = 4, Description = "Wolfsvogen" },
                new Car {CarId = 5, Description = "Nissan" }


            };
        }

        public void Add(Car car)
        {

            _cars.Add(car);
            Console.WriteLine("Araç Eklendi");

        }

        public void Delete(Car car)
        {

            Car removedCar = _cars.SingleOrDefault(c => c.CarId == car.CarId);
            _cars.Remove(removedCar);
            Console.WriteLine("Araç Silindi");

        }

        public void Delete(int id)
        {
            throw new NotImplementedException();
        }

        public Car Get(Expression<Func<Car, bool>> filter)
        {
            throw new NotImplementedException();
        }

        public List<Car> GetAll()
        {
            return _cars;
        }

        public List<Car> GetAll(Expression<Func<Car, bool>> filter = null)
        {
            throw new NotImplementedException();
        }

        public Car GetById(Car car)
        {
            Car carForSearch = _cars.SingleOrDefault(p => p.CarId == car.CarId);
            return carForSearch;
        }

        public List<CarDetailsDto> GetCarDetails()
        {
            throw new NotImplementedException();
        }

        public void Update(Car car)
        {
            Car CarToUpdate = _cars.SingleOrDefault(p => p.CarId == car.CarId);
            CarToUpdate.Description = car.Description;
            CarToUpdate.DailyPrice = car.DailyPrice;
        }

        public void Update(int id)
        {
            throw new NotImplementedException();
        }
    }
}
