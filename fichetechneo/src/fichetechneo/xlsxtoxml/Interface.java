package fichetechneo.xlsxtoxml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import fichetechneo.xlsxtoxlsx.Config;
import fichetechneo.xlsxtoxlsx.ReadWriteExcelFile;

public class Interface {
    
    private static final Logger LOG = Logger.getLogger(Interface.class
             .getName());
     
    private Interface() {
    }

    public static void main(String[] args) throws IOException {
        
        List<String> nameFiles = new ArrayList<String>();
        String[][] res = new String[Config.XXIII][Config.II];
        String[] fiche = new String[Config.XXIII];
        DiskFileExplorer diskFileExplorer = new DiskFileExplorer(Config.PATHXLSXFILE,
                true);
        nameFiles = diskFileExplorer.list();
        for (String str : nameFiles) {
            res = ReadWriteExcelFile
                    .readXlsxFile(Config.PATHXLSXFILE + str);
            for (int i = 0; i < res.length; i++) {
                fiche[i] = res[i][1];
            }
            WriteXMLFile.generer(fiche, fiche[Config.XXII]);
        }
        LOG.info("Les fiches de competences (.xml) ont été générées!");
    }
}
