using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleUygulaması
{
    class FHarfi
    {


        public int x = 0;
        public int y = 0;
        public int genislik;
        public int yukseklik;
        
        public FHarfi(int genislik, int yukseklik)
        {
            this.genislik = x + genislik;
            this.yukseklik = y + yukseklik;
            
        }
        public FHarfi()
        {

        }

        public void Goster(int x , int y)
        {
            this.x = x;
            this.y = y;
            
            Console.BackgroundColor = ConsoleColor.Red;
            

            Console.SetCursorPosition(this.x, this.y );

            for (int i = 0; i < this.genislik + 5 ; i++)
            {
                Console.Write(" ");
            }

            Console.SetCursorPosition(this.x, this.y + 3);
            for (int i = 0; i < this.genislik ; i++)
            {
                Console.Write(" ");
            }

            
            

            for (int j = 0; j < this.yukseklik; j++)
            {
                Console.SetCursorPosition(this.x,this.y +j);
                Console.WriteLine(" ");
            }

            


        }
    }
}
