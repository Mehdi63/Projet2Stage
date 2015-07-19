package projetstage;

import java.io.IOException;
import java.util.logging.Logger;

public class Interface {

   private static final Logger LOG = Logger.getLogger(Interface.class
         .getName());

   private Interface() {
   }

   public static void main(String[] args) throws IOException {
         String xlsxfile = "C:/Users/elhaddad/Documents/2014-07-24-01-Export.xlsx";
         String xmlfile = "C:/Users/elhaddad/Documents/Fiche_Regroupé.xml";
         String[][] res;
         res = EnhancedXSSFSheet.tomatrix(xlsxfile);
         int numRows = res.length;
         int numCols = res[Item.ZERO].length;
         String[][] resRegroupe = new String[Item.XII
               + Item.COMPETENCES.length][numCols];
         resRegroupe = Algo1.initialiser(numCols);
         resRegroupe = Algo1.traiter(numRows, res, resRegroupe);
         Algo2.remplir(resRegroupe, xmlfile);
         LOG.info("'Techneo Fiche' file(s) has been generated.");
   }
}