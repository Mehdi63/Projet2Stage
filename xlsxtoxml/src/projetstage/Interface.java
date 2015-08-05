package projetstage;

import java.io.IOException;
import java.util.logging.Logger;

public class Interface {

   private static final Logger LOG = Logger.getLogger(Interface.class
         .getName());

   private Interface() {
   }

   public static void main(String[] args) throws IOException {
         String xlsxfile = "C:/Users/elhaddad/Documents/2014-07-24-01-Export_sondage.xlsx";
         String[][] res;
         res = ReadWriteExcelFile.toMatrix(xlsxfile);
         int numRows = res.length;
         int numCols = res[Config.O].length;
         String[][] resRegroupe = new String[Config.XII
               + Config.COMPETENCES.length][numCols];
         resRegroupe = Algo1.initialiser(numCols);
         resRegroupe = Algo1.traiter(numRows, res, resRegroupe);
         Algo2.remplir(resRegroupe);
         LOG.info("'Techneo Fiche' file(s) has been generated.");
   }
}