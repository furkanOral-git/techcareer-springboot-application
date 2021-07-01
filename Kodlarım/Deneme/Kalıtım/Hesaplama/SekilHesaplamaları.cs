using System;
using System.Collections.Generic;
using System.Text;

namespace Kalıtım
{
    class SekilHesaplamaları : Sekil, ISekilHesaplamaları 
    {
        
        

        public int AlanHesapla(Sekil sekil)
        {
            int A = x * y * yükseklik;
            return alan = A;
        }
        public int AlanHesapla(Ucgen ucgen)
        {

            alan = (taban * yükseklik) / 2;
            return alan;

        }

        public int CevreHesapla(Ucgen ucgen)
        {

            cevre = x + y + taban;
            return cevre;
        }
        public int CevreHesapla(Sekil sekil)
        {

            cevre = 2 * (x + y);
            return cevre;
        }
    }
}
