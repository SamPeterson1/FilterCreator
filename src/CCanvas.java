

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class CCanvas extends Canvas{
	private static final long serialVersionUID = -7730932406995835971L;
	MusicStaff staff;
	public CCanvas() {
		this.setBackground(Color.GRAY);
	}
	public void draw() {
		BufferedImage image;
		Graphics g;
		Image print = new ImageIcon(getClass().getResource("/assets/iu.png")).getImage();
		Image updown = new ImageIcon(getClass().getResource("/assets/Up-DownArrow.png")).getImage();
		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = image.getGraphics();	
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < staff.size; i ++) {
			for(int j = 0; j < staff.size; j ++) {
				if(staff.getNote(i, j) == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(i * 50, j * 50, 50, 50);
				} else if(staff.getNote(i, j) == 0){
					g.setColor(getBackground());
					g.fillRect(i * 50, j * 50, 50, 50);
					g.setColor(Color.BLACK);
					g.drawRect(i * 50, j * 50, 50, 50);
				} else if(staff.getNote(i, j) == 2){
					g.setColor(Color.YELLOW);
					g.fillRect(i * 50, j * 50, 50, 50);
				} else {
					g.setColor(Color.BLUE);
					g.fillRect(i * 50, j * 50, 50, 50);
				}
			}
		}
		g.setColor(Color.WHITE);
		g.fillRect(500, 600, 200, 60);
		Font font = new Font("Helvectica", Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.BLACK);
		if(staff.isRevive()) {
			g.drawString("Revive", 500,630);
		} else {
			g.drawString("Kill", 500,630);
		}
		g.drawImage(print, 200, 550, 200, 200, null);
		g.drawImage(updown, 600, 200, null);
		g.dispose();
		g = this.getGraphics();
		g.drawImage(image, 0, 0, null); 
	}
	public void setStaff(MusicStaff staff) {
		this.staff = staff;
	}
	public void addEventQueue(CEventQueue queue)  {

		this.addKeyListener(queue);
		this.addMouseListener(queue);
		this.addMouseMotionListener(queue);

		return;
	}
}
