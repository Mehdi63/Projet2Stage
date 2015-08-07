package fichetechneo.xlsxtoxml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DiskFileExplorer {
 
    private String initialpath = "";
    private Boolean recursivePath = false;
    @SuppressWarnings("unused")
    private int filecount = 0;
    @SuppressWarnings("unused")
    private int dircount = 0;

    public DiskFileExplorer(String path, Boolean subFolder) {
        super();
        this.initialpath = path;
        this.recursivePath = subFolder;
    }
 
    public List<String> list() {
        return this.listDirectory(this.initialpath);
    }

    private List<String> listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        List<String> xlsxFile = new ArrayList<String>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    this.dircount++;
                } else {
                    xlsxFile.add(files[i].getName());
                    this.filecount++;
                }
                if (files[i].isDirectory() && this.recursivePath) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
        return xlsxFile;
    }    
}