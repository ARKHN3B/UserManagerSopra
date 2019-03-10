package com.octest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "SendFile")
public class SendFile extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int TAILLE_TAMPON = 10240;
    private static final String FILE_PATH = "/Users/benlmsc/Documents/Programming/htdocs-v2/JAVAEE/OCR/01/uploaded/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // On récupère le champ description (name) que nous réutiliserons après
        String description = request.getParameter("description");
        request.setAttribute("description", description);

        // On récupère le champ fichier (name) dans un objet de type Part
        Part part = request.getPart("file");

        // On récupère le nom du fichier
        String fileName = getFileName(part);

        // On check si on a bien le fichier
        if (fileName != null && !fileName.isEmpty()) {
            String inputName = part.getName();
            // Corrige un bug du fonctionnement d'IE.
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1)
                               .substring(fileName.lastIndexOf("\\") + 1);
            writeFile(part, fileName, FILE_PATH);

            request.setAttribute(inputName, fileName);
        }

        request.getRequestDispatcher("/WEB-INF/send_file.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/send_file.jsp").forward(request, response);
    }

    /**
     * Get the file's name from the HTTP Header
     * @param part
     * @return
     */
    private static String getFileName(Part part) {
        // On découpe l'en-tête HTTP séparée par des points-virgules
        for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
            // On cherche la propriété filename et on en "extrait" la valeur
            if (contentDisposition.trim().startsWith("filename"))
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
        }
        return null;
    }

    private static void writeFile(Part p, String nFile, String path) throws IOException {
        BufferedInputStream  inputStream  = null;
        BufferedOutputStream outputStream = null;

        try {
            inputStream = new BufferedInputStream(p.getInputStream(), TAILLE_TAMPON);
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(path + nFile)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;

            while ( (longueur = inputStream.read(tampon)) > 0 ) {
                outputStream.write(tampon, 0, longueur);
            }
        }
        finally {
            try {
                outputStream.close();
            }
            catch (IOException ignore) {}

            try {
                inputStream.close();
            }
            catch (IOException ignore) {}
        }
    }
}
