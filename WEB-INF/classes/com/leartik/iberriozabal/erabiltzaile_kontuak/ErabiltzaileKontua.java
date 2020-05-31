package com.leartik.iberriozabal.erabiltzaile_kontuak;

public class ErabiltzaileKontua
{
        int id;
        String gunea;
        String erabiltzaileIzena;
        String pasahitza;

        public ErabiltzaileKontua()
        {
            gunea = "";
            erabiltzaileIzena = "";
            pasahitza = "";
        }

        public ErabiltzaileKontua(int id, String gunea, String erabiltzaileIzena, String pasahitza)
        {
            this.id = id;
            this.gunea = gunea;
            this.erabiltzaileIzena = erabiltzaileIzena;
            this.pasahitza = pasahitza;
        }

        public ErabiltzaileKontua(String gunea, String erabiltzaileIzena, String pasahitza)
        {
            this.gunea = gunea;
            this.erabiltzaileIzena = erabiltzaileIzena;
            this.pasahitza = pasahitza;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public int getId()
        {
            return id;
        }

        public void setGunea(String gunea)
        {
            this.gunea = gunea;
        }

        public String getGunea()
        {
            return gunea;
        }

        public void setErabiltzaileIzena(String erabiltzaileIzena)
        {
            this.erabiltzaileIzena = erabiltzaileIzena;
        }

        public String getErabiltzaileIzena()
        {
            return erabiltzaileIzena;
        }

        public void setPasahitza(String pasahitza)
        {
            this.pasahitza = pasahitza;
        }

        public String getPasahitza()
        {
            return pasahitza;
        }

}
