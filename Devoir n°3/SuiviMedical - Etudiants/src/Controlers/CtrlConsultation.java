package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getLastNumberOfConsultation(String text)
    {
        int maxNumero = 0;
        // A vous de jouer
        try {
            ps = cnx.prepareStatement(" SELECT MAX(idConsult) \n" +
                    "FROM consultation");
            rs = ps.executeQuery();
            rs.next();
            maxNumero =rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return maxNumero;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {
        // A vous de jouer
        try {
            ps = cnx.prepareStatement("insert into lignescommandes  values (?,?,?,?)");
            ps.setInt(1, idConsult);
            ps.setString(2, dateConsultation);
            ps.setInt(3, numPatient);
            ps.setInt(4, numMedecin);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
