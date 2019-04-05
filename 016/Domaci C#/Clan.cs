using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domaci
{
    class Clan
    {
        public static int BrojIzdatihKnjiga { get; set; } = 0;
        public int ClanskiBroj { get; set; }
        public string ImeIPrezime { get; set; }
        public double Stanje { get; set; }
        public bool Pocasni { get; set; }

        public Clan(int clanskiBroj, string imeIPrezime, double stanje, bool pocasni)
        {
            ClanskiBroj = clanskiBroj;
            ImeIPrezime = imeIPrezime;
            Stanje = stanje;
            Pocasni = pocasni;
            BrojIzdatihKnjiga++;
        }

        /*
         * Naplacivanje clanarine clanovima
         * u zavisnosti od toga jesu li pocasni
         * ili nisu.
         * Vraca true ukoliko je naplacivanje uspesno
         * i false ukoliko je doslo do problema
         * (clan nema dovoljno novca, itd.).
         */
        public bool Naplati(double iznos)
        {
            // Naplacivanje pocasnim clanovima
            if (Pocasni)
            {
                BrojIzdatihKnjiga++;
                return true; // Uspesno naplacivanje
            }

            // Naplacivanje clanovima koji nisu pocasni
            if (Stanje < iznos)
                return false; // Nije moguce naplacivanje
            
            Stanje -= iznos;
            BrojIzdatihKnjiga++;
            return true; // Uspesno naplacivanje
        }

        public override String ToString()
        {
            return ClanskiBroj + ". " + ImeIPrezime + ", " + Stanje + ", " + Pocasni;
        }
    }
}
