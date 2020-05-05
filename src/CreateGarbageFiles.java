import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateGarbageFiles extends JFrame {
	private JTextField amount1;
	private JTextField name1;
	private JTextField size1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGarbageFiles frame = new CreateGarbageFiles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void initComponents() {
		
	}
	/**
	 * Create the frame.
	 */
	public CreateGarbageFiles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblHowManyFiles = new JLabel("How many files?");
		getContentPane().add(lblHowManyFiles, "cell 0 0,alignx trailing");
		
		amount1 = new JTextField();
		amount1.setText("64");
		getContentPane().add(amount1, "cell 1 0,growx");
		amount1.setColumns(10);
		
		JLabel lblHowLongName = new JLabel("How long name should be?");
		getContentPane().add(lblHowLongName, "cell 0 1,alignx trailing");
		
		name1 = new JTextField();
		name1.setText("8");
		getContentPane().add(name1, "cell 1 1,growx");
		name1.setColumns(10);
		
		JLabel lblHowBigFiles = new JLabel("How big files should be (in bytes)?");
		getContentPane().add(lblHowBigFiles, "cell 0 2,alignx trailing");
		
		size1 = new JTextField();
		size1.setText("65536");
		getContentPane().add(size1, "cell 1 2,growx");
		size1.setColumns(10);
		
		JButton btnCreateFilesthese = new JButton("Create files (these won't work)");
		btnCreateFilesthese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Files files = new Files();
				files.setAmount(Integer.valueOf(amount1.getText()));
				files.setSize(Integer.valueOf(size1.getText()));
				files.setFNLength(Integer.valueOf(name1.getText()));
				files.createFiles();
			}
		});
		getContentPane().add(btnCreateFilesthese, "cell 0 3 2 1,growx");
	}
}
