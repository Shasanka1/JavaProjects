package play;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;

	private Graphics2D g2d;
	private BufferedImage image;
	
	private Thread thread;
	private Boolean running;
	private long targetTime;

	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}
	@Override
	public void addNotify() {
		// TODO Auto-generated method stub
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}
	private void setFPS(int fps){
		targetTime = 1000/fps;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(running) return;
		long startTime;
		long elapsed;
		long wait;

		while(running){
			startTime = System.nanoTime();
			
			update();
			requestRender();
			
			elapsed = System.nanoTime();

			wait = targetTime - elapsed/1000;

			if(wait>0){
				try{
					Thread.sleep(wait);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	private void init() {
		// TODO Auto-generated method stub
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		running = true;
		setFPS(10);

	}
	private void requestRender() {
		// TODO Auto-generated method stub
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(image,0,0,null);
		g.dispose();
		

		
	}
	private void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics2D g2d){
		g2d.clearRect(0 ,0, WIDTH, HEIGHT);
		
	}

}
