package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import test.Test;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SongGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	public static JTextArea textAreaSong;
	private JPanel panel;
	private JButton btnStart;
	private JButton btnStop;
	public Test t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SongGUI frame = new SongGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SongGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		t = new Test();
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaSong());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaSong() {
		if (textAreaSong == null) {
			textAreaSong = new JTextArea();
		}
		return textAreaSong;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new MigLayout("", "[]", "[][][]"));
			panel.add(getBtnStart(), "cell 0 1");
			panel.add(getBtnStop(), "cell 0 2");
		}
		return panel;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					t.testSingWithThreads();
				}
			});
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					t.stop();
				}
			});
		}
		return btnStop;
	}
}
