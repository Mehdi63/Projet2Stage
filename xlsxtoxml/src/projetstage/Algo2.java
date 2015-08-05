package projetstage;

import java.io.IOException;

public class Algo2 {

   public static final String ICCF = "Institut de Chimie de Clermont-Ferrand ICCF, UMR 6296";
   public static final String LAMP = "Laboratoire de Météorologie Physique LaMP, UMR 6016";
   public static final String LM = "Laboratoire de Mathématiques LM, UMR 6620";
   @SuppressWarnings("unused")
   private static String TYPE;

   private Algo2() {
   }

   static void remplir(String[][] resRegroupe)
         throws IOException {
      for (int i = Config.O; i < Config.XII + Config.COMPETENCES.length; i++) {
         String[] fiche = new String[Config.XIX];
         fillAnArrays1(fiche, i, resRegroupe);
         fillAnArrays2(fiche, i, resRegroupe);
         fillAnArrays3(fiche, i, resRegroupe);
         fillAnArrays4(fiche, i, resRegroupe);
         fillAnArrays5(fiche, i, resRegroupe);
         toGenerate(fiche);
      }
   }

   static void toRefactor(int i, int cpt, String[] fiche, String[][] resRegroupe) {
      
      if (Test.isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Config.IX] += " -"
               + Config.EQUIPEMENTS[cpt - Config.MCCCLIII];
         if (Test.isDifferentToSpace(resRegroupe, i, cpt + Config.I)) {
            fiche[Config.IX] += "(" + resRegroupe[i][cpt + Config.I]
                  + ") ";
         }
      }
   }

   static void toRefactor(int i, String[] fiche, String[][] resRegroupe) {
      
    for (int cpt = Config.CXXXI; cpt < Config.CCXLVIII; cpt++) {
         if (Test.isEqualToYes(resRegroupe, i, cpt)) {
            fiche[Config.I] = Config.COMPETENCES[cpt - Config.CXXXI];
         }
      }
   }

   static void fillAnArrays1(String[] fiche, int i, String[][] resRegroupe) {
      
      fiche[Config.O] = resRegroupe[i][Config.CXXVI];
    if (fiche[Config.O].equals(ICCF)) {
         fiche[Config.I] = resRegroupe[i][Config.CXXVIII];
      } else if (fiche[Config.O].equals(LAMP)) {
         fiche[Config.I] = resRegroupe[i][Config.CXXIX];
      } else if (fiche[Config.O].equals(LM)) {
         fiche[Config.I] = resRegroupe[i][Config.CXXX];
      } else {
         toRefactor(i, fiche, resRegroupe);
      }
   }

   static void fillAnArrays2(String[] fiche, int i, String[][] resRegroupe) {

      int techneo = Config.O;
      fiche[Config.III]=Config.EMPTY;
      for (int cpt = Config.CCLXXXIII; cpt < Config.CCCXXXVIII; cpt++) {
         if (Test.isEqualToYes(resRegroupe, i, cpt)) {
            fiche[Config.III] += " -" +Config.DOMAINES[cpt - Config.CCLXXXIII]
                  ;
            techneo = Config.I;
         }
      }
      if (Test.isDifferentToSpace(resRegroupe, i, Config.CCCX)) {
         fiche[Config.III] += " -" +  resRegroupe[i][Config.CCCX] ;
         techneo = Config.I;
      }
      if (Test.isDifferentToSpace(resRegroupe, i, Config.CCCXXXVIII)) {
         fiche[Config.III] += " -" +  resRegroupe[i][Config.CCCXXXVIII] ;
         techneo = Config.I;
      }
      for (int cpt = Config.DCIII; cpt < Config.DCXXIX; cpt++) {
         if (resRegroupe[i][cpt].equals(Config.OUI)) {
            fiche[Config.III] += " -" +  Config.DISCIPLINES[cpt - Config.DCIII]
                  ;
         }
      }
      if (Test.isDifferentToSpace(resRegroupe, i, Config.DCXXIX)) {
         fiche[Config.III] += " -" +  resRegroupe[i][Config.DCXXIX] ;
      }
      if (techneo != Config.O) {
         TYPE = Config.TECHNOLOGIQUE;
      } else {
         TYPE = Config.SHS;
      }
   }

   static void fillAnArrays3(String[] fiche, int i, String[][] resRegroupe) {
       
      fiche[Config.IV] = Config.EMPTY;
      for (int cpt = Config.CCCXXXIX; cpt < Config.DCII; cpt++) {
         if (Test.isEqualToYes(resRegroupe, i, cpt)) {
            fiche[Config.IV] += " -" +  Config.SOUS_DOMAINES[cpt - Config.CCCXXXIX]
                  ;
         }
      }
      for (int cpt = Config.DCXXX; cpt < Config.CMXVIII; cpt++) {
         if (Test.isEqualToYes(resRegroupe, i, cpt)) {
            fiche[Config.IV] += " -" +  Config.SOUS_DISCIPLINES[cpt - Config.DCXXX]
                  ;
         }
      }

      for (Integer col : Config.TO_CLEAN) {
         if (Test.isDifferentToSpace(resRegroupe, i, col)) {
            fiche[Config.IV] += " -" +  resRegroupe[i][col] ;
         }
      }
   }

   static void fillAnArrays4(String[] fiche, int i, String[][] resRegroupe) {
      
    fiche[Config.VI]=Config.EMPTY; 
      for (int cpt = Config.CMXVIII; cpt < Config.CMLV; cpt++) {
         if (Test.isEqualToYes(resRegroupe, i, cpt)) {
            fiche[Config.VI] += " -" +  Config.SECTEURS[cpt - Config.CMXVIII] ;
         }
      }
      if (Test.isDifferentToSpace(resRegroupe, i, Config.CMLIV)) {
         fiche[Config.VI] += " -" +  resRegroupe[i][Config.CMLIV] ;
      }

      fiche[Config.VII] = Config.EMPTY;
      for (int cpt = Config.CMLV; cpt < Config.MCCCVI; cpt++) {
         if (Test.isEqualToYes(resRegroupe, i, cpt)) {
            fiche[Config.VII] += " -" + Config.SOUS_SECTEURS[cpt - Config.CMLV];
         }
      }
      for (Integer col : Config.TO_CLEAN1) {
         if (Test.isDifferentToSpace(resRegroupe, i, col)) {
            fiche[Config.VII] += " -" +  resRegroupe[i][col];
         }
      }
   }

   static void fillAnArrays5(String[] fiche, int i, String[][] resRegroupe) {
      
    fiche[Config.VIII]=Config.EMPTY;
    fiche[Config.IX]=Config.EMPTY;
    if (Test.isDifferentToSpace(resRegroupe, i, Config.MCCCVII)) {
         fiche[Config.VIII] += " -" + resRegroupe[i][Config.MCCCVII];
      }
      if (Test.isDifferentToSpace(resRegroupe, i, Config.MCCCVIII)) {
         fiche[Config.VIII] += " -" + resRegroupe[i][Config.MCCCVIII];
      }
      
      for (int cpt = Config.MCCCLIII; cpt < Config.MCDIIX; cpt += Config.II) {
         toRefactor(i, cpt, fiche, resRegroupe);
      }
      if (resRegroupe[i][Config.MCDIX].equals(Config.OUI)) {
         fiche[Config.IX] += " -" + resRegroupe[i][Config.MCDX];
      }

      fiche[Config.XI] = Config.CONTACTEXPERT[i][Config.O];
      fiche[Config.XII] = Config.CONTACTEXPERT[i][Config.I];
      fiche[Config.XIII] = Config.CONTACTEXPERT[i][Config.II];
      fiche[Config.XIV] = Config.CONTACTEXPERT[i][Config.III];
      fiche[Config.XV] = Config.URL[i];
      if (Test.isDifferentToSpace(resRegroupe, i, Config.MCDXI)) {
          fiche[Config.XVIII] = resRegroupe[i][Config.MCDXI];
       }
   }
   
   static void toGenerate(String[] fiche) throws IOException {
      if (Test.isConditionVerified(fiche)) {
         String xlsxFile = "C:/Users/elhaddad/Documents/fiche_"+fiche[Config.I]+".xlsx";
         String[][] cellule = new String [Config.XIX][Config.II];
         for(int j=Config.O; j<Config.XIX; j++){
            cellule[j][Config.O] = Config.TITLE[j];
            cellule[j][Config.I] = fiche[j];
         }
         ReadWriteExcelFile.writeXlsxFile(xlsxFile, cellule);
         WriteXMLFile.generer(fiche);
      }
    }
}