package bubblebubble.test.ex02;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable{
	
	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		while(true) {
			
			// ���� Ȯ��
			Color leftColor = new Color(image.getRGB(player.getX() - 1, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			int bottomColor = image.getRGB(player.getX() + 25, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 35, player.getY() + 50 + 5);
			
			// �ٴ� �浹 Ȯ��
			if(bottomColor != -2) {
				player.setDown(false);
			}
			
			// �ܺ� �浹 Ȯ��
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
			}else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
