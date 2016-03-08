package ua.org.oa.servlets;

import ua.org.oa.Utils.IOMyClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jdev on 07.02.2016.
 */
@WebServlet(name = "UploadImgServlet", urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class UploadImgServlet extends HttpServlet {

    private static final String SAVE_DIR = "uploadFiles";

    private List<String> getStrings(String savePath) {
        List<String> listFiles = IOMyClass.getListFiles(savePath);
        List<String> listForAttr = new ArrayList<>();
        for (String file : listFiles) {
            listForAttr.add(SAVE_DIR + File.separator + file);
        }
        return listForAttr;
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }

        request.setAttribute("message", "Upload has been done successfully!");
        List<String> listForAttr = getStrings(savePath);
        request.setAttribute("imgList", listForAttr);
        getServletContext().getRequestDispatcher("/resources/jsp/picdownolader.jsp").forward(
                request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        List<String> listForAttr = null;
        if (fileSaveDir.exists()){
            listForAttr = getStrings(savePath);
        }
        request.setAttribute("imgList", listForAttr);
        getServletContext().getRequestDispatcher("/resources/jsp/picdownolader.jsp").forward(
                request, response);
    }
}