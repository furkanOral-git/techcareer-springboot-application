﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EntityFrameworkDemo
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        EfProductDal _EfProductDal = new EfProductDal();

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadProducts();
        }

        private void LoadProducts()
        {
            dgwProducts.DataSource = _EfProductDal.GetAll();
        }
        private void SearchProducts(string key)
        {
            var result = _EfProductDal.GetAll().Where(p=>p.Name.ToLower().Contains(key.ToLower())).ToList();
            dgwProducts.DataSource = result;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            _EfProductDal.Add(new Product
            {
                Name = tbxName.Text,
                UnitPrice = Convert.ToDecimal(tbxUnitPrice.Text),
                StockAmount = Convert.ToInt32(tbxStockAmount.Text)

            });
            LoadProducts();
            MessageBox.Show("Ürün Eklendi!");

        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            _EfProductDal.Update(new Product
            {
                 Id = Convert.ToInt32(dgwProducts.CurrentRow.Cells[0].Value),
                 Name = tbxNameUpdate.Text,
                 UnitPrice = Convert.ToDecimal(tbxUnitPriceUpdate.Text),
                 StockAmount=Convert.ToInt32(tbxStockAmountUpdate.Text)
            });
            LoadProducts();
            MessageBox.Show("Ürün Güncellendi!");
        }

        private void dgwProducts_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            tbxNameUpdate.Text = dgwProducts.CurrentRow.Cells[1].Value.ToString();
            tbxUnitPriceUpdate.Text = dgwProducts.CurrentRow.Cells[2].Value.ToString();
            tbxStockAmountUpdate.Text = dgwProducts.CurrentRow.Cells[3].Value.ToString();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            _EfProductDal.Delete(new Product 
            { 
                Id = Convert.ToInt32(dgwProducts.CurrentRow.Cells[0].Value)
            });
            LoadProducts();
        }

        private void tbxSearch_TextChanged(object sender, EventArgs e)
        {
            SearchProducts(tbxSearch.Text);
            
        }

        private void btnGetById_Click(object sender, EventArgs e)
        {
            _EfProductDal.GetById();
        }
    }
}
