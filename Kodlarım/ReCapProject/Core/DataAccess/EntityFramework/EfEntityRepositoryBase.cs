using Core.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;

namespace Core.DataAccess.EntityFramework
{
    public class EfEntityRepositoryBase<T,TContext>:IEntityRepository<T> where T:class,IEntity,new() where TContext : DbContext,new()  
    {
        public void Add(T entity)
        {
            using (TContext Context = new TContext())
            {
                var AddedEntity = Context.Entry(entity);
                AddedEntity.State = EntityState.Added;
                Context.SaveChanges();

            }
        }

        public void Delete(T entity)
        {
            using (TContext Context = new TContext())
            {
                var DeletedEntity = Context.Entry(entity);
                DeletedEntity.State = EntityState.Deleted;
                Context.SaveChanges();
            }

        }

        public T Get(Expression<Func<T, bool>> filter)
        {
            using (TContext context = new TContext())
            {
                return context.Set<T>().SingleOrDefault(filter);
            }
        }

        public List<T> GetAll(Expression<Func<T, bool>> filter = null)
        {
            using (TContext context = new TContext())
            {
                return filter == null ? context.Set<T>().ToList() : context.Set<T>().Where(filter).ToList();
            }
        }

        public void Update(T entity)
        {
            using (TContext Context = new TContext())
            {
                var UpdatedEntity = Context.Entry(entity);
                UpdatedEntity.State = EntityState.Modified;
                Context.SaveChanges();
            }
        }
    }
}
