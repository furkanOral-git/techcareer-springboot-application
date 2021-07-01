using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdoNetDemo
{
    public class ProductDal
    {
            SqlConnection _sqlConnection = new SqlConnection(@"server =(localdb)\MSSQLLocalDB;initial catalog = ETrade;integrated security=true");

        public List<Product> GetAll()
        {
            SqlConnection sqlConnection = new SqlConnection(@"server =(localdb)\MSSQLLocalDB;initial catalog = ETrade;integrated security=true");
            ConnectionControl(sqlConnection);
            SqlCommand command = new SqlCommand("Select * from Products", _sqlConnection);
            SqlDataReader sqlDataReader = command.ExecuteReader();
            List<Product> products = new List<Product>();
            while (sqlDataReader.Read())
            {
                Product product = new Product()
                {
                    Id = Convert.ToInt32(sqlDataReader["Id"]),
                    Name = sqlDataReader["Name"].ToString(),
                    StockAmount = Convert.ToInt32(sqlDataReader["StockAmount"]),
                    UnitPrice = Convert.ToDecimal(sqlDataReader["UnitPrice"])
                };
                products.Add(product);
            }
            sqlDataReader.Close();
            _sqlConnection.Close();
            return products;

        }

        private void ConnectionControl(SqlConnection sqlConnection)
        {
            if (sqlConnection.State == ConnectionState.Closed)
            {
                _sqlConnection.Open();
            }
        }

        public DataTable GetAll2()
        {
            if (_sqlConnection.State == ConnectionState.Closed)
            {
                _sqlConnection.Open();
            }
            SqlCommand command = new SqlCommand("Select * from Products", _sqlConnection);
            SqlDataReader sqlDataReader = command.ExecuteReader();
            DataTable dataTable = new DataTable();
            dataTable.Load(sqlDataReader);
            sqlDataReader.Close();
            _sqlConnection.Close();
            return dataTable;

        }
        public void Add(Product product)
        {
            ConnectionControl(_sqlConnection);
            SqlCommand command = new SqlCommand(
                "Insert into Products values(@Name,@UnitPrice,@StockAmount)", _sqlConnection);
            command.Parameters.AddWithValue("@Name", product.Name);
            command.Parameters.AddWithValue("@UnitPrice", product.UnitPrice);
            command.Parameters.AddWithValue("@StockAmount", product.StockAmount);
            command.ExecuteNonQuery();
            _sqlConnection.Close();
        }
        public void Update(Product product)
        {
            ConnectionControl(_sqlConnection);
            SqlCommand command = new SqlCommand(
                "Update Products set Name=@name,UnitPrice=@unitprice,StockAmount=@stockamount where Id =@Id", _sqlConnection);
            command.Parameters.AddWithValue("@name", product.Name);
            command.Parameters.AddWithValue("@unitprice", product.UnitPrice);
            command.Parameters.AddWithValue("@stockamount", product.StockAmount);
            command.Parameters.AddWithValue("@Id", product.Id);
            command.ExecuteNonQuery();
            _sqlConnection.Close();

        }
        public void Delete(int id)
        {
            ConnectionControl(_sqlConnection);
            SqlCommand command = new SqlCommand("Delete from Products where Id = @ıd",_sqlConnection);
            command.Parameters.AddWithValue("@ıd", id);
            command.ExecuteNonQuery();
            _sqlConnection.Close();
        }
    }
}
