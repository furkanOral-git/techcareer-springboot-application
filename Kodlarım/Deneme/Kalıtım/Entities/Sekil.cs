using System;
using System.Collections.Generic;
using System.Text;

namespace Kalıtım
{
    class Sekil
    {
        public int x;
        public int y;
        public int taban;
        public int alan;
        public int cevre;
        public int yükseklik;

        public int X
        {
            get { return x; }
            set { x = value; }
        }
        public int Y
        {
            get { return y; } 
            set { y = value; }
        }
        public int Alan
        {
            get { return alan; } 
        }
        public int Cevre
        {
            get { return cevre; } 
        }
        public int Yükseklik
        {
            get { return yükseklik; }
            set { yükseklik = value; }
        }
        public int Taban
        {
            get { return taban; }
            set { taban = value; }
        }


    }
}
