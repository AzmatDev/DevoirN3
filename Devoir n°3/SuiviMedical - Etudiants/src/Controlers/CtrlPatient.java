package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPatient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPatient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllPatients()
    {
        ArrayList<String> lesPatients = new ArrayList<>();

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT nomPatient\n" +
                    "FROM patient");
            rs = ps.executeQuery();

            while(rs.next()) {
                String unPatient = rs.getString(1);
                lesPatients.add(unPatient);
            }

        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }


        return lesPatients;
    }
    public int getIdPatientByName(String nomPat)
    {
        int numPat = 0;

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("select idPatient from patient where nomPat = ?");
            ps.setString(1, nomPat);
            rs = ps.executeQuery();
            rs.next();
            numPat = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return numPat;
    }
}
