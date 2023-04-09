package MarieTeam;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
/**
* Classe principale d'affichage du client lourd. Il permet de :
* <ul>
* <li>Lister les bateaux
* <li>Selectionner les bateaux
* <li>G�n�rer un fichier pdf sous forme de brochure
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class ApplicationGestionnaire {

	private JFrame frame;
	private JTextField txtImpressionBrochureDes;
	private JTextField txtCommentaireBrochure;
	private JTextField txtListeDesBateaux;
	private Passerelle passerelle;
	private PdfMarieTeam generePDF;

/**	
 * Fonction principale de l'applciation
 * @param args : Pas utilis�
 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationGestionnaire window = new ApplicationGestionnaire();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructeur simple - configur²e la fenetre principale
	 * cr�� tous les �lements de la fenetre
	 */
	public ApplicationGestionnaire() {
		initialize();
	}

	/**
	 * initialize configure la fenetre principale
	 * cr�� tous les �lements de la fenetre
	 * Contient tous les �l�ments imposants de la fenetre applicative
	 * Le care principal est une Frame
	 * La mise en page Layout est absolue pour pouvoir mettre les elemnents ou on veut
	 */
	private void initialize() {
		// Cr�ation de la passerelle
		//passerelle = new Passerelle(true); // Test unitaire
		passerelle = new Passerelle(); // Cr�ation de la passerrelle pour charger les donn�es
		generePDF = new PdfMarieTeam(); // Cr�ation du g�n�rateur PDF
		
		frame = new JFrame();
        // Configure la fen�tre principale
		frame.setTitle("IHM Gestionnaire");
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("G\u00E9n\u00E9rer Brochure de tous les bateaux");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(112, 480, 237, 60);
		frame.getContentPane().add(btnNewButton);
		
		txtImpressionBrochureDes = new JTextField();
		txtImpressionBrochureDes.setHorizontalAlignment(SwingConstants.CENTER);
		txtImpressionBrochureDes.setEditable(false);
		txtImpressionBrochureDes.setForeground(Color.RED);
		txtImpressionBrochureDes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtImpressionBrochureDes.setText("Impression brochure des bateaux voyageurs");
		txtImpressionBrochureDes.setBounds(220, 26, 308, 37);
		frame.getContentPane().add(txtImpressionBrochureDes);
		txtImpressionBrochureDes.setColumns(10);

		// Construction d'une JList avec des bateaux
		// La liste qui apparait contient des Bateaux
		DefaultListModel<BateauVoyageur> myListModel = new DefaultListModel<BateauVoyageur>();
		for (BateauVoyageur element : passerelle.getListeBateaux()) {
			myListModel.addElement(element);
		}
		JList<BateauVoyageur> list = new JList<BateauVoyageur>(myListModel);
		
		JButton btnNewButton_1 = new JButton("G\u00E9n\u00E9rer Brochure des bateaux s\u00E9lectionn\u00E9s");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(370, 480, 244, 60);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnPourVous = new JTextPane();
		txtpnPourVous.setText("Pour vous...");
		txtpnPourVous.setBounds(424, 167, 301, 198);
		frame.getContentPane().add(txtpnPourVous);
		
		txtCommentaireBrochure = new JTextField();
		txtCommentaireBrochure.setEditable(false);
		txtCommentaireBrochure.setText("Commentaire brochure");
		txtCommentaireBrochure.setHorizontalAlignment(SwingConstants.CENTER);
		txtCommentaireBrochure.setBounds(424, 138, 301, 19);
		frame.getContentPane().add(txtCommentaireBrochure);
		txtCommentaireBrochure.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(89, 167, 308, 198);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);
		
		txtListeDesBateaux = new JTextField();
		txtListeDesBateaux.setText("Liste des bateaux");
		txtListeDesBateaux.setHorizontalAlignment(SwingConstants.CENTER);
		txtListeDesBateaux.setEditable(false);
		txtListeDesBateaux.setColumns(10);
		txtListeDesBateaux.setBounds(89, 138, 301, 19);
		frame.getContentPane().add(txtListeDesBateaux);

		frame.setVisible(true);

		// Les listeners pour recuperer les actions sur les boutons
		// On veut generer une brochure avec les bateaux selectionnes
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BateauVoyageur> listeBateaux = new ArrayList<BateauVoyageur>();
				for(int index : list.getSelectedIndices()) {
				    System.out.println(list.getModel().getElementAt(index));
				    listeBateaux.add(list.getModel().getElementAt(index));  
				}
				generePDF.genereBrochure(listeBateaux,txtpnPourVous.getText());
			}
		});
		// On veut une brocuhe avec tout
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generePDF.genereBrochure(passerelle.getListeBateaux(),txtpnPourVous.getText());
			}
		});		
	}
}
