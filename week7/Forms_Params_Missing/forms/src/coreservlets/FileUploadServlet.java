package coreservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/FileUploadServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100,
        location = "/")   	// 100 MB

public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;

    /**
     * Directory where uploaded files will be saved, its relative to the web
     * application directory.
     */
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // gets absolute path of the web application
        String appPath = System.getProperty("user.dir");

        // constructs path of the directory to save uploaded file
        String uploadFilePath = appPath + File.separator + UPLOAD_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        Part part = request.getPart("filename");
        // If it has a filename, then this is the part related to the file upload
        System.out.println(part.getName());
        if (part.getSubmittedFileName() != null) {
            System.out.println("Filename= " + getFileName(part));
            fileName = getFileName(part);
            String path = uploadFilePath + File.separator + fileName;
            System.out.println();
            part.write(path);
        }

        out.print(fileName + " File uploaded successfully!");

    }

    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        return part.getSubmittedFileName(); // This is supported by servlet 3.1, so just use this
    }
}
