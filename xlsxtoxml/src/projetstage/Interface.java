package projetstage;

import java.io.IOException;
import java.util.logging.Logger;

public class Interface {

   private static final Logger LOG = Logger.getLogger(Interface.class
         .getName());

   private Interface() {
   }

   public static void main(String[] args) throws IOException {
         String xlsxfile1 = "C:/Users/elhaddad/Documents/2014-07-24-01-Export.xlsx";
         String xmlfile = "C:/Users/elhaddad/Documents/Fiche Techneo.xml";
         String[][] res1;
         res1 = EnhancedXSSFSheet.tomatrix(xlsxfile1);
         int numRows = res1.length;
         int numCols = res1[Item.ZERO].length;
         String[][] resRegroupe = new String[Item.XII
               + Item.COMPETANCE.length][numCols];
         resRegroupe = Algo.initialiser(numCols);
         resRegroupe = Algo.traiter(numRows, res1, resRegroupe);
         Algo.remplir(resRegroupe, xmlfile);
         LOG.info("'Techneo Fiche' file has been generated.");
   }
}