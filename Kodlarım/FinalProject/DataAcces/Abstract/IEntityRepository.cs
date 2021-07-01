using Entities.Abstract;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Text;


namespace DataAcces.Abstract
{
    //Generic Constraint = Cenerik Kısıt = where T:class 
    //dediğimizde T nin refarans tip olma zorunluluğu getirmiş oluyoruz
    //IEntity: IEntity olabilir veya IEntity'i implement eden bir nesne olabilir.
    //new(): new'lenebilir olmalı kuralı getiriyoruz ve IEntity interface'ini dışta bırakıyoruz.
    public interface IEntityRepository<T> where T:class,IEntity, new()
    {
        List<T> GetAll(Expression<Func<T,bool>> filter=null);
        T Get(Expression<Func<T, bool>> filter);
        void Add(T entity);
        void Update(T entity);
        void Delete(T entity);
        

    }
}
