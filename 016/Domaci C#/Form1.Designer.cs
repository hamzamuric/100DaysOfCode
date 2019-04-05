namespace Domaci
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.lblBrojIzdatihKjiga = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.txtClanarina = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.lbClanovi = new System.Windows.Forms.ListBox();
            this.btnNaplati = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.txtImeIPrezime = new System.Windows.Forms.TextBox();
            this.txtStanje = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.cbPocasni = new System.Windows.Forms.ComboBox();
            this.label8 = new System.Windows.Forms.Label();
            this.btnSnimiNovogClana = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(83, 36);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(92, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Broj izdatih knjiga:";
            // 
            // lblBrojIzdatihKjiga
            // 
            this.lblBrojIzdatihKjiga.AutoSize = true;
            this.lblBrojIzdatihKjiga.Location = new System.Drawing.Point(182, 35);
            this.lblBrojIzdatihKjiga.Name = "lblBrojIzdatihKjiga";
            this.lblBrojIzdatihKjiga.Size = new System.Drawing.Size(13, 13);
            this.lblBrojIzdatihKjiga.TabIndex = 1;
            this.lblBrojIzdatihKjiga.Text = "0";
            // 
            // label3
            // 
            this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(410, 36);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(54, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Clanarina:";
            // 
            // txtClanarina
            // 
            this.txtClanarina.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.txtClanarina.Location = new System.Drawing.Point(470, 32);
            this.txtClanarina.Name = "txtClanarina";
            this.txtClanarina.Size = new System.Drawing.Size(90, 20);
            this.txtClanarina.TabIndex = 3;
            this.txtClanarina.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TxtClanarina_KeyPress);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(35, 99);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(90, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Clanovi biblioteke";
            // 
            // lbClanovi
            // 
            this.lbClanovi.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lbClanovi.FormattingEnabled = true;
            this.lbClanovi.Location = new System.Drawing.Point(38, 124);
            this.lbClanovi.Name = "lbClanovi";
            this.lbClanovi.Size = new System.Drawing.Size(522, 173);
            this.lbClanovi.TabIndex = 6;
            this.lbClanovi.SelectedIndexChanged += new System.EventHandler(this.LbClanovi_SelectedIndexChanged);
            // 
            // btnNaplati
            // 
            this.btnNaplati.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.btnNaplati.Location = new System.Drawing.Point(38, 315);
            this.btnNaplati.Name = "btnNaplati";
            this.btnNaplati.Size = new System.Drawing.Size(137, 36);
            this.btnNaplati.TabIndex = 7;
            this.btnNaplati.Text = "Naplati";
            this.btnNaplati.UseVisualStyleBackColor = true;
            this.btnNaplati.Click += new System.EventHandler(this.BtnNaplati_Click);
            // 
            // label5
            // 
            this.label5.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(306, 336);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(108, 26);
            this.label5.TabIndex = 8;
            this.label5.Text = "Novi clan:";
            // 
            // txtImeIPrezime
            // 
            this.txtImeIPrezime.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.txtImeIPrezime.Location = new System.Drawing.Point(225, 402);
            this.txtImeIPrezime.Name = "txtImeIPrezime";
            this.txtImeIPrezime.Size = new System.Drawing.Size(149, 20);
            this.txtImeIPrezime.TabIndex = 9;
            // 
            // txtStanje
            // 
            this.txtStanje.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.txtStanje.Location = new System.Drawing.Point(380, 402);
            this.txtStanje.Name = "txtStanje";
            this.txtStanje.Size = new System.Drawing.Size(100, 20);
            this.txtStanje.TabIndex = 9;
            // 
            // label6
            // 
            this.label6.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(222, 386);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(68, 13);
            this.label6.TabIndex = 4;
            this.label6.Text = "Ime i prezime";
            // 
            // label7
            // 
            this.label7.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(377, 386);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(37, 13);
            this.label7.TabIndex = 4;
            this.label7.Text = "Stanje";
            // 
            // cbPocasni
            // 
            this.cbPocasni.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.cbPocasni.FormattingEnabled = true;
            this.cbPocasni.Items.AddRange(new object[] {
            "true",
            "false"});
            this.cbPocasni.Location = new System.Drawing.Point(487, 402);
            this.cbPocasni.Name = "cbPocasni";
            this.cbPocasni.Size = new System.Drawing.Size(73, 21);
            this.cbPocasni.TabIndex = 10;
            // 
            // label8
            // 
            this.label8.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(484, 386);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(45, 13);
            this.label8.TabIndex = 4;
            this.label8.Text = "Pocasni";
            // 
            // btnSnimiNovogClana
            // 
            this.btnSnimiNovogClana.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnSnimiNovogClana.Location = new System.Drawing.Point(380, 429);
            this.btnSnimiNovogClana.Name = "btnSnimiNovogClana";
            this.btnSnimiNovogClana.Size = new System.Drawing.Size(180, 26);
            this.btnSnimiNovogClana.TabIndex = 7;
            this.btnSnimiNovogClana.Text = "Snimi novog clana";
            this.btnSnimiNovogClana.UseVisualStyleBackColor = true;
            this.btnSnimiNovogClana.Click += new System.EventHandler(this.BtnSnimiNovogClana_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(599, 483);
            this.Controls.Add(this.cbPocasni);
            this.Controls.Add(this.txtStanje);
            this.Controls.Add(this.txtImeIPrezime);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.btnSnimiNovogClana);
            this.Controls.Add(this.btnNaplati);
            this.Controls.Add(this.lbClanovi);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txtClanarina);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblBrojIzdatihKjiga);
            this.Controls.Add(this.label1);
            this.MinimumSize = new System.Drawing.Size(615, 522);
            this.Name = "Form1";
            this.Text = "Form1";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblBrojIzdatihKjiga;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtClanarina;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ListBox lbClanovi;
        private System.Windows.Forms.Button btnNaplati;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtImeIPrezime;
        private System.Windows.Forms.TextBox txtStanje;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.ComboBox cbPocasni;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button btnSnimiNovogClana;
    }
}

