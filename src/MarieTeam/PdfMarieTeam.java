package MarieTeam;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
* Classe PdfMarieTeam. Elle permet de :
* <ul>
* <li>Permet de générer une brochure au format pdf
* <li>elle se sert de la libraire apache pdfbox
* <li>DOSSIER indique l'endroit ou est mis le PDF
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class PdfMarieTeam {
	/**
	 * Generation d'une brochure au format pdf
	 * le texte de la brochure est aussi imprimé
	 * @param listeBateaux : Liste des bateaux
	 * @param txtBrochure : Texte ajouté dans la brochure
	 */
    public void genereBrochure(ArrayList<BateauVoyageur> listeBateaux, String txtBrochure)
    {
        try {
            // Créer un nouveau document PDF
            PDDocument document = new PDDocument();
            
            // Ajouter une nouvelle page
            PDPage page = new PDPage();
            document.addPage(page);
            
            // Définir la police et la taille de la police
            PDType1Font font = PDType1Font.HELVETICA_BOLD;
            int fontSize = 18;
                   
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.setLeading(15); // Espaces entre les lignes
            contentStream.newLineAtOffset(50,700); // Premier positionnement dans la page
            
            // TITRE
            fontSize = 30;
            contentStream.setFont(font, fontSize);
            contentStream.showText("MARIETEAM");
            contentStream.newLine();
            contentStream.newLine();
            fontSize = 18;
            contentStream.setFont(font, fontSize);
            contentStream.showText("LISTE DES BATEAUX");
            contentStream.newLine();            
            // EXEMPLE D'IMAGES (PAS fini)
            // Charger l'image depuis un fichier
            contentStream.endText();
            File file = new File(Parametres.DOSSIER_IMAGES+Parametres.EXAMPLE_IMAGE);
            PDImageXObject image = PDImageXObject.createFromFileByContent(file, document); 
            // Dessiner l'image sur la page
            contentStream.drawImage(image, 300, 450);
 
            // FIN IMAGE
            
            // TEXTE ADDITIONNEL
            contentStream.beginText();
            contentStream.newLineAtOffset(50,650); // Premier positionnement dans la page

            contentStream.showText(txtBrochure);
            contentStream.newLine();
            contentStream.endText();
            contentStream.close();
            /// FIN TEXTE ADDITIONNEL
            
    		for (BateauVoyageur bat : listeBateaux) {
                page = new PDPage(); // On change de page pour chaque bateau
                contentStream = new PDPageContentStream(document, page);
                font = PDType1Font.HELVETICA;
                fontSize = 12;
                contentStream.setFont(font, fontSize);
                contentStream.setLeading(15); // Espaces entre les lignes
                document.addPage(page);
                contentStream.beginText();
                double pageWidth = page.getMediaBox().getWidth();
                double widthCenter = pageWidth / 2;
                contentStream.newLineAtOffset(50,700); // Premier positionnement de la page
                
                // ENTETE
                // Charger l'image depuis un fichier
                contentStream.endText();
                file = new File(Parametres.DOSSIER_IMAGES+bat.getNomImage());
                image = PDImageXObject.createFromFileByContent(file, document); 
                // Dessiner l'image sur la page
                contentStream.drawImage(image, 300, 450);
                // FIN IMAGE
                
                contentStream.beginText();
                contentStream.newLineAtOffset(50,650); // Premier positionnement dans la page
                //contentStream.setFont(PDType1Font.HELVETICA_BOLD, 13);
    			//contentStream.showText("Nom du bateau : ");
                contentStream.setFont(PDType1Font.HELVETICA_BOLD_OBLIQUE, fontSize*3);
    			contentStream.showText(bat.getNomBateau());
    			contentStream.newLine();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
    			contentStream.showText("Longueur : ");
                contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    			contentStream.showText(""+bat.getLongueur());
    			contentStream.newLine();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
    			contentStream.showText("Largeur : ");
                contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    			contentStream.showText(""+bat.getLargeur());
    			contentStream.newLine();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
    			contentStream.showText("Vitesse : ");
                contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    			contentStream.showText(""+bat.getVitesse());
    			contentStream.newLine();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
    			contentStream.showText("Liste des équipements du bateau : ");
    			contentStream.newLine();
    			contentStream.setFont(PDType1Font.COURIER, fontSize);
    			for (Equipement equipe : bat.getListeEquipements()) {
        			contentStream.showText("  - "+equipe.getEquipement());  
        			contentStream.newLine();
    			}
    			contentStream.newLine();
    			contentStream.endText();
    			contentStream.close();
    		}

            // Enregistrer le document PDF
            document.save(Parametres.DOSSIER_PDF  +Parametres.FICHIER_PDF);
            document.close();
            
            System.out.println("Le document PDF a eté créé avec succes !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du document PDF : " + e.getMessage());
        }
    }
}