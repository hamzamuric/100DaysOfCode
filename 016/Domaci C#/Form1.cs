using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Domaci
{
    public partial class Form1 : Form
    {
        private List<Clan> clanovi;
        private int trenutnoIzabrani; // indeks izabranog clana u ListBox-u
        private double clanarina;
        private bool dodatiClanovi;

        public Form1()
        {
            InitializeComponent();
            clanovi = new List<Clan>();
            trenutnoIzabrani = -1;
            dodatiClanovi = false;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            FileStream fs = new FileStream("clanovi.txt", FileMode.Open, FileAccess.Read);
            StreamReader sr = new StreamReader(fs, Encoding.UTF8);
            List<String> lines = new List<string>(); // Linije datoteke

            try
            {
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    // Dodaje svaku procitanu liniju kao string u listu lines
                    lines.Add(line);
                }
            }
            catch
            {
                MessageBox.Show("Problem prilikom citanja datoteke.");
                return;
            }
            finally
            {
                sr.Close();
                fs.Close();
            }

            foreach (string line in lines)
            {
                // Razdvaja liniju na zasebne stringove odvajajuci ih na tacki i zarezu
                string[] data = line.Split(new char[] {'.', ','});

                // Uzima podatke dobijene razdvajanjem linije
                int clanskiBroj = int.Parse(data[0].Trim());
                string imeIPrezime = data[1].Trim();
                double stanje = double.Parse(data[2].Trim());
                bool pocasni = data[3].Trim().ToLower().Equals("true");

                // Pravi novi objekat Clan i dodaje ga u listu clanovi
                Clan clan = new Clan(clanskiBroj, imeIPrezime, stanje, pocasni);
                clanovi.Add(clan);
                lbClanovi.Items.Add(clan.ToString());
            }

            lblBrojIzdatihKjiga.Text = Clan.BrojIzdatihKnjiga.ToString();
        }

        private void LbClanovi_SelectedIndexChanged(object sender, EventArgs e)
        {
            trenutnoIzabrani = lbClanovi.SelectedIndex;
            lblBrojIzdatihKjiga.Text = Clan.BrojIzdatihKnjiga.ToString();
            // refreshListBox();
        }

        private void BtnNaplati_Click(object sender, EventArgs e)
        {
            string clanarinaText = txtClanarina.Text;
            if (clanarinaText.Equals(""))
            {
                MessageBox.Show("Clanarina mora biti uneta da bi bilo moguce naplacivanje.");
                return;
            }

            if (trenutnoIzabrani < 0 || trenutnoIzabrani > lbClanovi.Items.Count) return;

            bool naplaceno = clanovi[trenutnoIzabrani].Naplati(clanarina);
            if (!naplaceno) return;

            lblBrojIzdatihKjiga.Text = Clan.BrojIzdatihKnjiga.ToString();
            refreshListBox();
        }

        private void refreshListBox()
        {
            lbClanovi.Items.Clear();
            foreach (Clan clan in clanovi)
            {
                lbClanovi.Items.Add(clan.ToString());
            }
            lbClanovi.SelectedIndex = trenutnoIzabrani;
        }

        private void TxtClanarina_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                try
                {
                    clanarina = double.Parse(txtClanarina.Text);
                    txtClanarina.Enabled = false;
                }
                catch
                {
                    MessageBox.Show("Morate uneti broj.");
                }
            }
        }

        private void BtnSnimiNovogClana_Click(object sender, EventArgs e)
        {
            string imeIPrezime = txtImeIPrezime.Text;
            double stanje = 0;
            bool pocasni = cbPocasni.SelectedIndex == 0;
            int clanskiBroj = clanovi.Count + 1;

            try
            {
                stanje = double.Parse(txtStanje.Text);
            }
            catch
            {
                MessageBox.Show("Morate uneti broj za stanje.");
            }

            Clan noviClan = new Clan(clanskiBroj, imeIPrezime, stanje, pocasni);
            clanovi.Add(noviClan);

            txtImeIPrezime.Text = txtStanje.Text = cbPocasni.Text = "";
            dodatiClanovi = true;
            refreshListBox();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            // Nije potrebno dodavanje u datoteku
            if (!dodatiClanovi) return;

            FileStream fs = new FileStream("clanovi.txt", FileMode.Create, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);

            try
            {
                foreach (Clan clan in clanovi)
                {
                    sw.WriteLine(clan.ToString());
                }
            }
            finally
            {
                sw.Close();
                fs.Close();
            }
        }
    }
}
