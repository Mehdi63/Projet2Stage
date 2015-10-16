package fichetechneo.xlsxtoxlsx;

import java.io.IOException;
import java.util.logging.Logger;

public class Interface {

   private static final Logger LOG = Logger.getLogger(Interface.class
         .getName());

   private Interface() {
   }

   public static void main(String[] args) throws IOException {
         
         String[][] res;
         res = ReadWriteExcelFile.readXlsxFile(Config.XLSXFILE);
         int numRows = res.length;
         int numCols = res[Config.O].length;
         String[][] resRegroupe = new String[Config.XII
               + Config.COMPETENCES.length][numCols];
         resRegroupe = Algo1.initialiser(numCols);
         resRegroupe = Algo1.traiter(numRows, res, resRegroupe);
         Algo2.remplir(resRegroupe);
         LOG.info("Les fiches de competences (.xlsx) ont été générées!");
   }
}