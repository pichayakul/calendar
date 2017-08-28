package ku.cs.calendar.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import ku.cs.calendar.controllers.MainController;
import ku.cs.calendar.models.Appointment;
import ku.cs.calendar.test.models.AppointmentTest;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

public class AppointmentView {

	private JFrame frame;
	private JPanel panel_1;
	public JButton delButton;
	public static AppointmentView window;
	public MainController controller;
	public JPanel panel_2;
	public JScrollPane scroll;
	public ArrayList<Appointment> appointmentList;
	public int index;
	public JLabel lblAppointmentList;
	public AppointmentView(MainController controller) {
		this.controller = controller;
		initialize();
	}
	public void display(boolean s)
	{
		frame.setVisible(s);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 100, 269, 300);
//		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setVisible(false);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblAppointmentList = new JLabel("Appointment List");
		lblAppointmentList.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblAppointmentList, BorderLayout.CENTER);
		
		delButton = new JButton("Edit");
		delButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (delButton.getText().equals("Edit"))
				{
					getLblAppointmentList().setText("Choose the box");
					delButton.setText("Delete");
				}
				else
				{
					getLblAppointmentList().setText("Appointment List");
					delButton.setText("Edit");
				}
			}
		});
		panel.add(delButton, BorderLayout.EAST);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout());		 
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0,0));
		this.createButton();
	}
	public JButton getDelButton()
	{
		return this.delButton;
	}
	public JLabel getLblAppointmentList()
	{
		return this.lblAppointmentList;
	}
	public void createButton()
	{
		appointmentList = controller.getCalendar().getAppointmentList();
		Appointment a;
		JButton button;
		if (appointmentList.size()<=4)
		{
			for (int i=0;i<4;i++)
			{
				if (i < appointmentList.size()) {
					a = appointmentList.get(i);
					button = new JButton(a.getTitle()+" -----"+a.getDate());
					button.setPreferredSize(new Dimension(frame.getWidth(), 40));
					panel_2.add(button);
				}
				else
				{
					button = new JButton("");
					button.setPreferredSize(new Dimension(frame.getWidth(), 40));
					button.setEnabled(false);
					panel_2.add(button);
				}
				
				
			}
		}
		else
		{
			for (int i=0;i<appointmentList.size();i++)
			{
				a = appointmentList.get(i);
				button = new JButton(a.getTitle()+" -----"+a.getDate());
				button.setPreferredSize(new Dimension(frame.getWidth(), 40));
				panel_2.add(button);
			}
		}
		scroll = new JScrollPane(panel_2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scroll);
	}
	
	public void updateUI() {
		appointmentList = controller.getCalendar().getAppointmentList();
		Appointment a;
		Component[] list = panel_2.getComponents();
		if (appointmentList.size()<=4)
		{
			for (int i=0;i<4;i++)
			{
				if (i < appointmentList.size()) {
					a = appointmentList.get(i);
					
					JButton c = (JButton) list[i];
					c.setText(a.getTitle()+" -----"+a.getDate());
					c.setEnabled(true);
					for (ActionListener n : c.getActionListeners())
					{
						c.removeActionListener(n);
					}
					c.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (getDelButton().getText().equals("Delete"))
							{
								ArrayList<Appointment> appointment = controller.getCalendar().getAppointmentList();
								
								JButton button = (JButton) e.getSource();
								
								for (int i=0;i<controller.getCalendar().getAppointmentList().size();i++)
								{
									if (controller.getCalendar().getAppointmentList().get(i).getTitle().equals(button.getText().split(" ")[0]))
									{
										appointment.remove(i);
										break;
									}
								}
								updateUI();
								
							}
							else
							{
							JButton button = (JButton) e.getSource();
							getForm(button);
							}
							
						}
					});
				}
				else
				{
					JButton c = (JButton) list[i];
					c.setText("");
					c.setEnabled(false);
				}
				
				
			}
		}
		else
		{
			for (int i=0;i<appointmentList.size();i++)
			{
				a = appointmentList.get(i);
				if (i>=list.length)
				{
					JButton button = new JButton(a.getTitle()+" -----"+a.getDate());
					button.setPreferredSize(new Dimension(frame.getWidth(), 40));
					panel_2.add(button);
				}
				list = panel_2.getComponents();
				JButton c = (JButton) list[i];
				c.setText(a.getTitle()+" -----"+a.getDate());
				c.setEnabled(true);
				for (ActionListener n : c.getActionListeners())
				{
					c.removeActionListener(n);
				}
				c.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (getDelButton().getText().equals("Delete"))
						{
							ArrayList<Appointment> appointment = controller.getCalendar().getAppointmentList();
							
							JButton button = (JButton) e.getSource();
							for (int i=0;i<controller.getCalendar().getAppointmentList().size();i++)
							{
								if (controller.getCalendar().getAppointmentList().get(i).getTitle().equals(button.getText().split(" ")[0]))
								{
									appointment.remove(i);
									break;
								}
							}
							updateUI();
							
						}
						else
						{
						JButton button = (JButton) e.getSource();
						getForm(button);
						}
					}
				});
				
			}
		}	
	}
	public void getForm(JButton button)
	{
		index=-99;
		
		for (int i=0;i<controller.getCalendar().getAppointmentList().size();i++)
		{
			if (controller.getCalendar().getAppointmentList().get(i).getTitle().equals(button.getText().split(" ")[0]))
			{
				index = i;
				break;
			}
		}
		Appointment appointment = controller.getCalendar().getAppointmentList().get(index);
		controller.getFillAppointmentView().getTitleField().setText(appointment.getTitle());
		controller.getFillAppointmentView().getDateField().setText(appointment.getDate());
		controller.getFillAppointmentView().getDetailField().setText(appointment.getDetail());
		controller.getFillAppointmentView().getHoursComboBox().setSelectedItem(appointment.getTime().split(":")[0]);
		controller.getFillAppointmentView().getMinutesComboBox().setSelectedItem(appointment.getTime().split(":")[1]);
		controller.getFillAppointmentView().showEditBtn();
		controller.getFillAppointmentView().hideOKBtn();
		controller.getFillAppointmentView().display();
		
	}
	public int getIndex()
	{
		return this.index = index;
	}

}
