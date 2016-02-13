package ua.org.oa.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdev on 08.02.2016.
 */
public class IOMyClass {
    public static List<String> getListFiles(String folder) {
        List<String> fileNames = new ArrayList();
        for (File file : new File(folder).listFiles()) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }
}